<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/detail.css">
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
<style type="text/css">
    .crumb .crumb-item {
        color: #888;
        text-decoration: none;
        cursor: pointer;
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
<div class="crumb">
    <div class="w">
        <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>

    </div>
</div>
<div class="page-container w">
    <div class="intro-wrap clear">
        <div class="p-img-wrap">
            <div class="main-img-con">
                <img class="main-img" src="/images${racket.imagePath}" >
                <input type="hidden" id="id" name="id" value="${racket.id}"/>
            </div>
        </div>
        <div class="p-info-wrap">
            <p class="p-name">${racket.name}</p>
            <div class="info-item p-price-con">
                <span class="label">价格：</span>
                <span class="p-price">¥${racket.price}</span>
            </div>
            <div class="info-item p-quantity-con">
                <span class="label">库存</span>
                <span class="p-price">${racket.stock}</span>
            </div>
            <div class="info-item">
                <span class="label">数量 </span>
                <input class="p-count" id="count" value="1" readonly="readonly">
                <span class="p-count-btn plus" id="add" data-opera-type="plus">+</span>
                <span class="p-count-btn minus" id="subtract" data-opera-type="mius">-</span>
            </div>
            <div class="info-item">
                <input type="button" class="btn cart-add" <%--href="/frontCart?method=list"--%> id="addToCartBtn" value="加入购物车"/>
                <a class="btn cart-add">购买</a>
            </div>
        </div>
    </div>
    <div class="detail-wrap">
        <div class="detail-tab-con">
            <ul class="tab-list">
                <li class="tab-item active">商品详情</li>
            </ul>
            <div class="info-item p-quantity-con">
                <label>描述:</label>
                <span class="p-price">${racket.description}</span>
            </div>
        </div>
        <div class="form-group col-md-12">
            <label>品牌:</label>
            <span class="p-price">${brand.name}</span>
        </div>
        <div class="form-group col-md-12">
            <label>系列:</label>
            <span class="p-price">${series.name}</span>
        </div>
        <div class="form-group col-md-12">
            <label>球柄粗细:</label>
            <span class="p-price">${handle.value}</span>
        </div>
        <div class="form-group col-md-12">
            <label>重量:</label>
            <span class="p-price">${weight.value}</span>
        </div>
        <div class="form-group col-md-12">
            <label>产地:</label>
            <span class="p-price">${place.value}</span>
        </div>
    </div>
</div>
<script>
    $('#addToCartBtn').click(function(){
        console.log(111)
        $.post(
            '/frontCart',
            {'method':'addToCart','id':$('#id').val(),'count':$('#count').val()},
            function(data){
                console.log('data =>',data)
                alert(data.message)
            },
            'json'
        )})
</script>
</body>
</html>
