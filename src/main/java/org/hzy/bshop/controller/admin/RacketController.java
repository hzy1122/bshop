package org.hzy.bshop.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

@WebServlet("/adminRacket")
public class RacketController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    private SeriesMapper seriesMapper = sqlSession.getMapper(SeriesMapper.class);
    private HandleMapper handleMapper = sqlSession.getMapper(HandleMapper.class);
    private WeightMapper weightMapper = sqlSession.getMapper(WeightMapper.class);
    private PlaceMapper placeMapper = sqlSession.getMapper(PlaceMapper.class);
    private RacketMapper racketMapper = sqlSession.getMapper(RacketMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String seat = "球拍管理";
        request.getSession().setAttribute("seat",seat);
        String method = request.getParameter("method");
        if(method.equals("remove")){
            remove(request, response);
        }
        if(method.equals("page")){
            page(request, response);
        }
        if(method.equals("list")){
            list(request, response);
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
        Racket racket = new Racket();
        racket.setId(id);
        racket.setIsDeteled(true);
        racketMapper.updateByPrimaryKeySelective(racket);

        response.sendRedirect("/adminRacket?method=list");
    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         查询品牌
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);
//         设置为请求的属性
        request.getRequestDispatcher("/admin/racket_list.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int countPrePage = 5;
        PageHelper.startPage(currentPage, countPrePage);
        RacketExample racketExample = new RacketExample();
        RacketExample.Criteria criteria = racketExample.createCriteria();
        criteria.andIsDeteledEqualTo(false);
        String brandId = request.getParameter("brandId");
        if(brandId!=null){
            criteria.andBrandIdEqualTo(Integer.parseInt(brandId));
        }
        String seriesId = request.getParameter("seriesId");
        if(seriesId!=null){
            criteria.andSeriesIdEqualTo(Integer.parseInt(seriesId));
        }
        System.out.println(brandId);
        System.out.println(seriesId);
        List<Racket> racketList = racketMapper.selectByExample(racketExample);
        for (Racket racket:racketList) {
            racket.setHandle(handleMapper.selectByPrimaryKey(racket.getHandleId()));
            racket.setWeight(weightMapper.selectByPrimaryKey(racket.getWeightId()));
            racket.setPlace(placeMapper.selectByPrimaryKey(racket.getPlaceId()));
            racket.setBrand(brandMapper.selectByPrimaryKey(racket.getBrandId()));
        }
        System.out.println(racketList);
        racketExample.setOrderByClause("id desc");
        PageInfo pageInfo = new PageInfo(racketList,5);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String json1 = objectMapper.writeValueAsString(pageInfo);
//        System.out.println("pageInfo : "+pageInfo);
//        System.out.println("pageInfo json : "+json1);
        out.write(json1);
        out.close();
    }

    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);

        SeriesExample seriesExample = new SeriesExample();
        seriesExample.createCriteria().andIsDeletedEqualTo(false);
        List<Series> seriesList = seriesMapper.selectByExample(seriesExample);
        request.setAttribute("seriesList",seriesList);

        List<Handle> handleList = handleMapper.selectByExample(null);
        request.setAttribute("handleList",handleList);
        List<Weight> weightList = weightMapper.selectByExample(null);
        request.setAttribute("weightList",weightList);
        List<Place> placeList = placeMapper.selectByExample(null);
        request.setAttribute("placeList",placeList);

        RacketExample racketExample = new RacketExample();
        racketExample.createCriteria().andIsDeteledEqualTo(false);
        List<Racket> racketList = racketMapper.selectByExample(racketExample);
        request.setAttribute("racketList",racketList);
        request.getRequestDispatcher("/admin/racket_add.jsp").forward(request,response);
    }
    protected void toModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Racket racket = racketMapper.selectByPrimaryKey(id);
        request.setAttribute("racket",racket);
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIsDeletedEqualTo(false);
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        request.setAttribute("brandList",brandList);

        SeriesExample seriesExample = new SeriesExample();
        seriesExample.createCriteria().andIsDeletedEqualTo(false);
        List<Series> seriesList = seriesMapper.selectByExample(seriesExample);
        request.setAttribute("seriesList",seriesList);

        List<Handle> handleList = handleMapper.selectByExample(null);
        request.setAttribute("handleList",handleList);
        List<Weight> weightList = weightMapper.selectByExample(null);
        request.setAttribute("weightList",weightList);
        List<Place> placeList = placeMapper.selectByExample(null);
        request.setAttribute("placeList",placeList);

        request.getRequestDispatcher("/admin/racket_modify.jsp").forward(request,response);
    }
    protected void toDetailR(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Racket racket = racketMapper.selectByPrimaryKey(id);
        request.setAttribute("racket",racket);

        Brand brand = brandMapper.selectByPrimaryKey(racket.getBrandId());
        request.setAttribute("brand",brand);

        Series series = seriesMapper.selectByPrimaryKey(racket.getSeriesId());
        request.setAttribute("series",series);

        Handle handle = handleMapper.selectByPrimaryKey(racket.getHandleId());
        request.setAttribute("handle",handle);
        Weight weight = weightMapper.selectByPrimaryKey(racket.getWeightId());
        request.setAttribute("weight",weight);
        Place place = placeMapper.selectByPrimaryKey(racket.getPlaceId());
        request.setAttribute("place",place);

        request.getRequestDispatcher("/admin/racket_detail.jsp").forward(request,response);
    }protected void toDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Racket racket = racketMapper.selectByPrimaryKey(id);
        request.setAttribute("racket",racket);

        Brand brand = brandMapper.selectByPrimaryKey(racket.getBrandId());
        request.setAttribute("brand",brand);

        Series series = seriesMapper.selectByPrimaryKey(racket.getSeriesId());
        request.setAttribute("series",series);

        Handle handle = handleMapper.selectByPrimaryKey(racket.getHandleId());
        request.setAttribute("handle",handle);
        Weight weight = weightMapper.selectByPrimaryKey(racket.getWeightId());
        request.setAttribute("weight",weight);
        Place place = placeMapper.selectByPrimaryKey(racket.getPlaceId());
        request.setAttribute("place",place);

        request.getRequestDispatcher("/admin/racket_detail.jsp").forward(request,response);
    }
}
