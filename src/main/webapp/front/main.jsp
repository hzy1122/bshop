<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/layout.css">
</head>
<style type="text/css">
    .banner-con .banner-img{
        width: 100%;
        height: 370px;
    }
</style>
<body>
<jsp:include page="/front/nav.jsp"></jsp:include>
<!--header-->
<div class="header">
    <div class="w">
        <div class="search-con">
            <input class="search-input" id="search-input" placeholder="请输入商品名称"/>
            <button class="btn search-btn" id="search-btn">搜索</button>
        </div>
    </div>
</div>
<!--header-->
<!--index-->
<div class="w">
    <div class="banner-con" style="margin:auto">
        <!--<div class="loading"></div>-->
        <ul>
            <li><img class="banner-img" src="/images/xjbn.webp"></li>
        </ul>
    </div>
</div>
<div class="w">
    <div class="floor-wrap">
        <h1 class="floor-title">F1 球拍</h1>
        <ul class="floor-list">
            <c:forEach var="racket" items="${requestScope.racketList}" varStatus="status">
                <li class="floor-item">
                    <a href="frontMain?method=toRacketDetail&id=${racket.id}">
                        <span class="floor-text">${racket.name}</span>
                        <img class="floor-img" src="/images${racket.imagePath}"/>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="floor-wrap">
        <h1 class="floor-title">F2 羽毛球</h1>
        <ul class="floor-list">
            <c:forEach var="badminton" items="${requestScope.badmintonList}" varStatus="status">
                <li class="floor-item">
                    <a href="frontMain?method=toBadmintonDetail&id=${badminton.id}">
                        <span class="floor-text">${badminton.name}</span>
                        <img class="floor-img" src="/images${badminton.imagePath}"/>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

        </ul>
    </div>
</div>
</body>
</body>
</html>
