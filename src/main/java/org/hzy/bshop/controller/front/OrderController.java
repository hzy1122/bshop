package org.hzy.bshop.controller.front;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzy.bshop.entity.*;
import org.hzy.bshop.mapper.*;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/frontOrder")
public class OrderController extends HttpServlet {
    private AddressMapper addressMapper = MyBatisUtil.getSqlSession().getMapper(AddressMapper.class);
    private OrderMapper orderMapper = MyBatisUtil.getSqlSession().getMapper(OrderMapper.class);
    private CartItemMapper cartItemMapper = MyBatisUtil.getSqlSession().getMapper(CartItemMapper.class);
    private OrderItemMapper orderItemMapper = MyBatisUtil.getSqlSession().getMapper(OrderItemMapper.class);
    private RacketMapper racketMapper = MyBatisUtil.getSqlSession().getMapper(RacketMapper.class);
    private UserMapper userMapper = MyBatisUtil.getSqlSession().getMapper(UserMapper.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("toAddOrder")){
            toAddOrder(request,response);
        }
        if(method.equals("add")){
            add(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void toAddOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        Order order = new Order();
        order.setUserId(user.getId());
        order.setIsDeleted(true);
        orderMapper.insertSelective(order);

        String[] cartItemIdArray = request.getParameter("checkIdsString").split((","));
        String[] cartItemCountArray = request.getParameter("checkCountsString").split((","));
        int orderId = order.getId();
        double orderPrice = 0.0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for(int i=0;i<cartItemIdArray.length;i++){
            CartItem cartItem = cartItemMapper.selectByPrimaryKey(Integer.parseInt(cartItemIdArray[i]));
            OrderItem orderItem =new OrderItem();
            orderItem.setRacketId(cartItem.getRacketId());
            orderItem.setCount(Integer.parseInt(cartItemCountArray[i]));
            Racket racket = racketMapper.selectByPrimaryKey(cartItem.getRacketId());
            double racketPrice = racket.getPrice();
            double count = Integer.parseInt(cartItemCountArray[i]);
            orderItem.setItemPrice(racketPrice*count);
            orderItem.setOrderId(order.getId());
            orderItemList.add(orderItem);
            orderPrice += racketPrice*count;
            orderItem.setRacket(racket);
            orderItemMapper.insertSelective(orderItem);
        }

//        order.setTotalPrice(orderPrice);

        request.getSession().setAttribute("cartItemIdArray",cartItemIdArray);
        request.getSession().setAttribute("cartItemCountArray",cartItemCountArray);

        request.getSession().setAttribute("orderId",orderId);
        request.getSession().setAttribute("totalPrice",orderPrice);
        request.getSession().setAttribute("orderItemList",orderItemList);
        response.setContentType( "application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<String,Object> map = new HashMap<>();
        map.put( "message" , "ok");
        out.write(new ObjectMapper().writeValueAsString(map));
        out.close();

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        System.out.println(orderId);

       System.out.println("111");
        User user = (User)request.getSession().getAttribute("user");
        String addressProvince = request.getParameter("addressProvince");
        String addressCity = request.getParameter("addressCity");
        String addressArea = request.getParameter("addressArea");
        String addressInfo = request.getParameter("addressInfo");

        // 地址
        Address address = new Address();
        address.setProvince(addressProvince);
        address.setCity(addressCity);
        address.setArea(addressArea);
        address.setInformation(addressInfo);
        address.setStatus(true);
        address.setUserId(user.getId());
        addressMapper.insertSelective(address);

        // 订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setCreateTime(new Date());
        // 总价格
        double totalPrice = (double)(request.getSession().getAttribute("totalPrice"));
        order.setTotalPrice(totalPrice);

        order.setStatus(1);
        order.setIsDeleted(false);
        order.setAddressId(address.getId());

        orderMapper.updateByPrimaryKeySelective(order);
        String[] cartItemIdArray = (String[])(request.getSession().getAttribute("cartItemIdArray"));
        String[] cartItemCountArray = (String[])(request.getSession().getAttribute("cartItemCountArray"));
        /*for(int i=0;i<cartItemIdArray.length;i++){
            System.out.println(cartItemIdArray[i]);

            CartItem cartItem = cartItemMapper.selectByPrimaryKey(Integer.parseInt(cartItemIdArray[i]));
            Racket racket = racketMapper.selectByPrimaryKey(cartItem.getRacketId());
            System.out.println("cartItem====="+cartItem);
            System.out.println("racket====="+racket);

        }*/

        for(int i=0;i<cartItemIdArray.length;i++){
            System.out.println(cartItemIdArray[i]);
            // 修改产品的库存
            CartItem cartItem = cartItemMapper.selectByPrimaryKey(Integer.parseInt(cartItemIdArray[i]));
            Racket racket = racketMapper.selectByPrimaryKey(cartItem.getRacketId());
            racket.setStock(racket.getStock()-Integer.parseInt(cartItemCountArray[i]));
            racketMapper.updateByPrimaryKey(racket);
            // 删除购物车中的条目
            cartItemMapper.deleteByPrimaryKey(Integer.parseInt(cartItemIdArray[i]));
        }
        // 修改用户余额
        user.setBalance(user.getBalance()-totalPrice);
        userMapper.updateByPrimaryKey(user);

        response.sendRedirect("/front/buy_success.jsp");
    }
}
