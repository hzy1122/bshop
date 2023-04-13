package org.hzy.bshop.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
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
import java.util.List;

@WebServlet("/adminSeries")
public class SeriesController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    private SeriesMapper seriesMapper = sqlSession.getMapper(SeriesMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String seat = "系列管理";
        request.getSession().setAttribute("seat",seat);
        String method = request.getParameter("method");

        if(method.equals("add")){
            add(request, response);
        }
        if(method.equals("remove")){
            remove(request, response);
        }
        if(method.equals("removes")){
            removes(request, response);
        }
        if(method.equals("list")){
            list(request, response);
        }
        if(method.equals("search")){
            search(request, response);
        }
        if(method.equals("toAdd")){
            toAdd(request, response);
        }
        if(method.equals("queryByBrandId")){
            queryByBrandId(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Series series = new Series();
        series.setName(name);
        series.setBrandId(brandId);
        seriesMapper.insertSelective(series);
        response.sendRedirect("/adminSeries?method=list");
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Series series = new Series();
            series.setId(id);
            series.setIsDeleted(true);
            seriesMapper.updateByPrimaryKeySelective(series);
        response.sendRedirect("/adminSeries?method=list");
    }
    protected void removes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkedArrayList = request.getParameter("checkedList").split(",");
        System.out.println(checkedArrayList);
        for(int i=0;i<checkedArrayList.length;i++){
                int id = Integer.parseInt(checkedArrayList[i]);
                Series series = new Series();
                series.setId(id);
                series.setIsDeleted(true);
                seriesMapper.updateByPrimaryKeySelective(series);
            }
        response.sendRedirect("/adminSeries?method=list");
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);
        List<Series> seriesList = seriesMapper.selectAll();
        request.setAttribute("seriesList",seriesList);

        request.getRequestDispatcher("/admin/series_list.jsp").forward(request,response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        List<Series> seriesList = seriesMapper.selectByBrandId(brandId);
        request.setAttribute("seriesList",seriesList);
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);
        request.getRequestDispatcher("/admin/series_list.jsp").forward(request,response);
    }

    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);
        for (Brand brand:brandList
             ) {
            System.out.println(brand.getName());
        }
        request.getRequestDispatcher("/admin/series_add.jsp").forward(request,response);
    }

    private void queryByBrandId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        SeriesExample seriesExample = new SeriesExample();
        seriesExample.createCriteria().andBrandIdEqualTo(brandId).andIsDeletedEqualTo(false);
        List<Series> seriesList = seriesMapper.selectByExample(seriesExample);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String json = objectMapper.writeValueAsString(seriesList);
        out.write(json);
        out.close();
    }
}
