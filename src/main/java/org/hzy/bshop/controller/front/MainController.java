package org.hzy.bshop.controller.front;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
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
import java.util.List;

@WebServlet("/frontMain")
public class MainController extends HttpServlet {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();
    private BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    private SeriesMapper seriesMapper = sqlSession.getMapper(SeriesMapper.class);
    private HandleMapper handleMapper = sqlSession.getMapper(HandleMapper.class);
    private WeightMapper weightMapper = sqlSession.getMapper(WeightMapper.class);
    private PlaceMapper placeMapper = sqlSession.getMapper(PlaceMapper.class);
    private RacketMapper racketMapper = sqlSession.getMapper(RacketMapper.class);
    private BadmintonMapper badmintonMapper = sqlSession.getMapper(BadmintonMapper.class);
    private PlumeMapper plumeMapper = sqlSession.getMapper(PlumeMapper.class);
    private SpeedMapper speedMapper = sqlSession.getMapper(SpeedMapper.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession.clearCache();
        String method = request.getParameter("method");
        if(method.equals("list")){
            list(request, response);
        }
        if(method.equals("toRacketDetail")){
            toRacketDetail(request, response);
        }
        if(method.equals("toBadmintonDetail")){
            toBadmintonDetail(request, response);
        }
        if(method.equals("toLogin")){
            toLogin(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageHelper.startPage(1, 5);

        RacketExample racketExample = new RacketExample();
        racketExample.createCriteria().andIsDeteledEqualTo(false);
        List<Racket> racketList = racketMapper.selectByExample(racketExample);
        request.setAttribute("racketList",racketList);

        BadmintonExample badmintonExample = new BadmintonExample();
        badmintonExample.createCriteria().andIsDeteledEqualTo(false);
        List<Badminton> badmintonList = badmintonMapper.selectByExample(badmintonExample);
        request.setAttribute("badmintonList",badmintonList);

        request.getRequestDispatcher("/front/main.jsp").forward(request,response);
    }

    protected void toRacketDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        request.getRequestDispatcher("/front/racket_detail.jsp").forward(request,response);
    }
    protected void toBadmintonDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Badminton badminton = badmintonMapper.selectByPrimaryKey(id);
        request.setAttribute("badminton",badminton);

        Brand brand = brandMapper.selectByPrimaryKey(badminton.getBrandId());
        request.setAttribute("brand",brand);

        Plume plume = plumeMapper.selectByPrimaryKey(badminton.getPlumeId());
        request.setAttribute("plume",plume);
        Speed speed = speedMapper.selectByPrimaryKey(badminton.getSpeedId());
        request.setAttribute("speed",speed);
        request.getRequestDispatcher("/front/badminton_detail.jsp").forward(request,response);
    }

    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/front/login.jsp");
    }
}
