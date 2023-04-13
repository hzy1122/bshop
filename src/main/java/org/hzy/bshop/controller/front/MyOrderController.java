package org.hzy.bshop.controller.front;

import org.hzy.bshop.entity.Order;
import org.hzy.bshop.entity.OrderExample;
import org.hzy.bshop.entity.User;
import org.hzy.bshop.mapper.OrderItemMapper;
import org.hzy.bshop.mapper.OrderMapper;
import org.hzy.bshop.mapper.RacketMapper;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/frontMyOrder")
public class MyOrderController extends HttpServlet {

    private OrderMapper orderMapper = MyBatisUtil.getSqlSession().getMapper(OrderMapper.class);
    private OrderItemMapper orderItemMapper = MyBatisUtil.getSqlSession().getMapper(OrderItemMapper.class);
    private RacketMapper racketMapper = MyBatisUtil.getSqlSession().getMapper(RacketMapper.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("toList")){
            toList(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void toList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(user.getId()).andIsDeletedEqualTo(false);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        request.setAttribute("orderList",orderList);

        request.getRequestDispatcher("/front/my_order.jsp").forward(request,response);
    }
}
