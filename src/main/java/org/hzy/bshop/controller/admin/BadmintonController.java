package org.hzy.bshop.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.hzy.bshop.entity.*;
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

@WebServlet("/adminBadminton")
public class BadmintonController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    private BadmintonMapper badmintonMapper = sqlSession.getMapper(BadmintonMapper.class);
    private SeriesMapper seriesMapper = sqlSession.getMapper(SeriesMapper.class);
    private PlumeMapper plumeMapper = sqlSession.getMapper(PlumeMapper.class);
    private SpeedMapper speedMapper = sqlSession.getMapper(SpeedMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String seat = "羽毛球管理";
        request.getSession().setAttribute("seat",seat);
        String method = request.getParameter("method");

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
            int id = Integer.parseInt(request.getParameter("id"));
            Badminton badminton = new Badminton();
            badminton.setId(id);
            badminton.setIsDeteled(true);
            badmintonMapper.updateByPrimaryKeySelective(badminton);

        response.sendRedirect("/adminBadminton?method=list");
    }
    protected void removes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkedArrayList = request.getParameter("checkedList").split(",");
            for(int i=0;i<checkedArrayList.length;i++){
                int id = Integer.parseInt(checkedArrayList[i]);
                Badminton badminton = new Badminton();
                badminton.setId(id);
                badminton.setIsDeteled(true);
                badmintonMapper.updateByPrimaryKeySelective(badminton);
        }
        response.sendRedirect("/adminBadminton?method=list");
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);
        //将所有的品牌从数据库查出来
        BadmintonExample badmintonExample = new BadmintonExample();
        badmintonExample.createCriteria().andIsDeteledEqualTo(false);
        List<Badminton> badmintonList = badmintonMapper.selectByExample(badmintonExample);
        //将所有品牌的数据放入请求的属性中
        request.setAttribute("badmintonList",badmintonList);
        //将页面转发到品牌列表页面
        request.getRequestDispatcher("/admin/badminton_list.jsp").forward(request,response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);

        int brandId = Integer.parseInt(request.getParameter("brandId"));
        BadmintonExample badmintonExample = new BadmintonExample();
        if(brandId!=0) {
            badmintonExample.createCriteria().andIsDeteledEqualTo(false).andBrandIdEqualTo(brandId);
        }else{
            badmintonExample.createCriteria().andIsDeteledEqualTo(false);
        }
        List<Badminton> badmintonList = badmintonMapper.selectByExample(badmintonExample);
        request.setAttribute("badmintonList",badmintonList);
        request.getRequestDispatcher("/admin/badminton_list.jsp").forward(request,response);
    }

    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);

        List<Plume> plumeList = plumeMapper.selectByExample(null);
        request.setAttribute("plumeList",plumeList);
        List<Speed> speedList = speedMapper.selectByExample(null);
        request.setAttribute("speedList",speedList);

        BadmintonExample badmintonExample = new BadmintonExample();
        badmintonExample.createCriteria().andIsDeteledEqualTo(false);
        List<Badminton> badmintonList = badmintonMapper.selectByExample(badmintonExample);
        request.setAttribute("badmintonList",badmintonList);
        request.getRequestDispatcher("/admin/badminton_add.jsp").forward(request,response);
    }
    private void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Badminton badminton = badmintonMapper.selectByPrimaryKey(id);
        request.setAttribute("badminton",badminton);

        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);

        List<Plume> plumeList = plumeMapper.selectByExample(null);
        request.setAttribute("plumeList",plumeList);
        List<Speed> speedList = speedMapper.selectByExample(null);
        request.setAttribute("speedList",speedList);
        request.getRequestDispatcher("/admin/badminton_modify.jsp").forward(request,response);
    }
    private void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Badminton badminton = badmintonMapper.selectByPrimaryKey(id);
        request.setAttribute("badminton",badminton);

        Brand brand = brandMapper.selectByPrimaryKey(badminton.getBrandId());
        request.setAttribute("brand",brand);

        Plume plume = plumeMapper.selectByPrimaryKey(badminton.getPlumeId());
        request.setAttribute("plume",plume);
        Speed speed = speedMapper.selectByPrimaryKey(badminton.getSpeedId());
        request.setAttribute("speed",speed);
        request.getRequestDispatcher("/admin/badminton_detail.jsp").forward(request,response);
    }



}
