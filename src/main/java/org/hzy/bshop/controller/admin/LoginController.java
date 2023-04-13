package org.hzy.bshop.controller.admin;

import org.hzy.bshop.entity.Admin;
import org.hzy.bshop.entity.AdminExample;
import org.hzy.bshop.mapper.AdminMapper;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminLogin")
public class LoginController extends HttpServlet {

    private AdminMapper adminMapper = MyBatisUtil.getSqlSession().getMapper(AdminMapper.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if(method.equals("login")){
            login(request, response);
        }
        if(method.equals("logout")){
            logout(request, response);
        }
        if(method.equals("out")){
            out(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size()==0){
            response.sendRedirect("/admin/login_fail.jsp");
        }else{
            //将当前登录成功的对象放入当前属性中
            request.getSession().setAttribute("admin",adminList.get(0));
            response.sendRedirect("/adminBrand?method=list");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //注销当前会话
        request.getSession().invalidate();
        //将页面跳转到登录页面
        response.sendRedirect("/admin/login.jsp");
    }
    private void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/admin/login.jsp");
    }
}
