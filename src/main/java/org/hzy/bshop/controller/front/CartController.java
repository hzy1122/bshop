package org.hzy.bshop.controller.front;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzy.bshop.bean.CommonResult;
import org.hzy.bshop.entity.*;
import org.hzy.bshop.mapper.CartItemMapper;
import org.hzy.bshop.mapper.CartMapper;
import org.hzy.bshop.mapper.RacketMapper;
import org.hzy.bshop.mapper.UserMapper;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/frontCart")
public class CartController extends HttpServlet {

    private UserMapper userMapper= MyBatisUtil.getSqlSession().getMapper(UserMapper.class);
    private CartMapper cartMapper= MyBatisUtil.getSqlSession().getMapper(CartMapper.class);
    private CartItemMapper cartItemMapper = MyBatisUtil.getSqlSession().getMapper(CartItemMapper.class);
    private RacketMapper racketMapper= MyBatisUtil.getSqlSession().getMapper(RacketMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if (method.equals("rlist")){
            rList(request,response);
        }
        if (method.equals("addToCart")){
            addToCart(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int racketId = Integer.parseInt(request.getParameter("id"));
        int count = Integer.parseInt(request.getParameter("count"));
        Racket racket = racketMapper.selectByPrimaryKey(racketId);


        User user = (User)request.getSession().getAttribute("user");
        Cart cart = user.getCart();

        // 如果是第一次添加到购物车
        CartItem cartItem = new CartItem();
        cartItem.setRacketId(racketId);
        cartItem.setCount(count);
        cartItem.setItemPrice(racket.getPrice()*count);
        cartItem.setCartId(cart.getId());

        int result = cartItemMapper.insertSelective(cartItem);
        System.out.println(result);

        // 更新购物车总价格
        cart.setTotalPrice(cart.getTotalPrice()+cartItem.getItemPrice());
        cartMapper.updateByPrimaryKeySelective(cart);

        CommonResult commonResult = null;
        if(result>0){
            commonResult = new CommonResult(200,"添加到购物车成功!");
        }else{
            commonResult = new CommonResult(555,"添加到购物车失败!");
        }

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String json = objectMapper.writeValueAsString(commonResult);
        out.write(json);
        out.close();

        // 如果是第二次添加到购物车?
    }

    protected void rList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = ((User)request.getSession().getAttribute("user")).getCart();
        CartItemExample cartItemExample = new CartItemExample();
        cartItemExample.createCriteria().andCartIdEqualTo(cart.getId());
        List<CartItem> cartItemList = cartItemMapper.selectByExample(cartItemExample);
        for(CartItem cartItem:cartItemList){
            cartItem.setRacket(racketMapper.selectByPrimaryKey(cartItem.getRacketId()));
        }
        request.setAttribute("cartItemList",cartItemList);
        request.getRequestDispatcher("/front/cart.jsp").forward(request,response);
    }
}
