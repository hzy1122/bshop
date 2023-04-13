package org.hzy.bshop.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.ibatis.session.SqlSession;
import org.hzy.bshop.entity.Brand;
import org.hzy.bshop.entity.BrandExample;
import org.hzy.bshop.mapper.BrandMapper;
import org.hzy.bshop.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminBrand")
public class BrandController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String seat = "品牌管理";
        request.getSession().setAttribute("seat",seat);
        String method = request.getParameter("method");

        if(method.equals("remove")){
            remove(request, response);
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
        if(method.equals("toModify")){
            toModify(request, response);
        }
        if(method.equals("toDetail")){
            toDetail(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkedArrayList = request.getParameter("checkedList").split(",");
        if(checkedArrayList!=null){
            for(int i=0;i<checkedArrayList.length;i++){
                int id = Integer.parseInt(checkedArrayList[i]);
                Brand brand = new Brand();
                brand.setId(id);
                brand.setIsDeleted(true);
                brandMapper.updateByPrimaryKeySelective(brand);
            }
        }
        if(checkedArrayList==null){
            int id = Integer.parseInt(request.getParameter("id"));
            Brand brand = new Brand();
            brand.setId(id);
            brand.setIsDeleted(true);
            brandMapper.updateByPrimaryKeySelective(brand);
        }
        response.sendRedirect("/adminBrand?method=list");
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将所有的品牌从数据库查出来
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        //将所有品牌的数据放入请求的属性中
        request.setAttribute("brandList",brandList);
        if(request.getAttribute("brandSearch")==null){
            request.setAttribute("brandSearch",brandList);
        }
        //将页面转发到品牌列表页面
        request.getRequestDispatcher("/admin/brand_list.jsp").forward(request,response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        if(brandId!=0) {
            brandExample.createCriteria().andIsDeletedEqualTo(false).andIdEqualTo(brandId);
        }else{
            brandExample.createCriteria().andIsDeletedEqualTo(false);
        }
        List<Brand> brandSearch = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandSearch",brandSearch);
        list(request, response);
    }

    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/admin/brand_add.jsp");
    }
    private void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = brandMapper.selectByPrimaryKey(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/admin/brand_modify.jsp").forward(request,response);
    }
    private void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = brandMapper.selectByPrimaryKey(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/admin/brand_detail.jsp").forward(request,response);
    }



}
