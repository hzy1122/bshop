package org.hzy.bshop.controller.front;


import org.hzy.bshop.entity.*;
import org.hzy.bshop.mapper.*;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/frontUser")
public class UserController extends HttpServlet {

    private UserMapper userMapper;
    private CartMapper cartMapper;

    {
        userMapper = MyBatisUtil.getSqlSession().getMapper(UserMapper.class);
        cartMapper = MyBatisUtil.getSqlSession().getMapper(CartMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if (method.equals("toRegister")){
            toRegister(request,response);
        }
        if (method.equals("login")){
            login(request,response);
        }
        if (method.equals("logout")){
            logout(request,response);
        }
        if (method.equals("register")){
            register(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    private void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/front/user_register.jsp");
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        //登陆失败
        if (userList.size()==0){
            response.sendRedirect("/front/login_fail.jsp");
        }
        //登陆成功
        else{
            User user = userList.get(0);
            CartExample cartExample = new CartExample();
            cartExample.createCriteria().andUserIdEqualTo(user.getId());

            List<Cart> cartList = cartMapper.selectByExample(cartExample);
            Cart cart = new Cart();
            if (cartList!=null&&cartList.size()==0){
                cart.setUserId(user.getId());
                cartMapper.insertSelective(cart);

            }else {
                cart=cartList.get(0);
            }
            user.setCart(cart);
            //将当前登陆成功的用户放在会话中
            request.getSession().setAttribute("user",userList.get(0));
            response.sendRedirect("/frontMain?method=list");
        }


    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //注销会话
        request.getSession().invalidate();
        response.sendRedirect("/front/login.jsp");

    }
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
       /* String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        String info = request.getParameter("info");
        String receiver = request.getParameter("receiver");
        String receiverPhone = request.getParameter("receiverPhone");
        Boolean status = Boolean.valueOf(request.getParameter("status"));
        Address address1 = new Address();
        address1.setProvince(province);
        address1.setCity(city);
        address1.setArea(area);
        address1.setInformation(info);
        address1.setReceiver(receiver);
        address1.setReceiverPhone(receiverPhone);
        address1.setStatus(status);*/

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        /*user.setAddress(address1);*/

        if (password==password1){
            userMapper.insertSelective(user);
            response.sendRedirect("/front/login.jsp");
        }else {
            response.sendRedirect("/front/login_fail.jsp");
        }

    }
}
