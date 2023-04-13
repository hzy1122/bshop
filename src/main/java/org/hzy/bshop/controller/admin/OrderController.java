package org.hzy.bshop.controller.admin;

import org.apache.ibatis.session.SqlSession;
import org.hzy.bshop.entity.*;
import org.hzy.bshop.mapper.BrandMapper;
import org.hzy.bshop.mapper.OrderMapper;
import org.hzy.bshop.mapper.UserMapper;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminOrder")
public class OrderController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String seat = "订单管理";
        request.getSession().setAttribute("seat",seat);
        String method = request.getParameter("method");
        if(method.equals("list")){
            list(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orderList = orderMapper.selectAll();
        for(Order order:orderList){
            System.out.println(order);

        }
        request.setAttribute("orderList",orderList);

        request.getRequestDispatcher("/admin/order_list.jsp").forward(request,response);
    }
}
