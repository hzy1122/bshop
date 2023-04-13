<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/cart.css">
    <link rel="stylesheet" href="/css/layout.css">
</head>
<script src="/js/jquery-3.6.0.js"></script>
<script src="/js/bootstrap.js"></script>
<style type="text/css" >
    #cart-table {
        width: 100%;
        padding-left: 20px;
    }
    #cart-footer{
        background: #eee;

    }
</style>
<body>
<jsp:include page="/front/nav.jsp"></jsp:include>
<!--header-->
<div class="header">
    <div class="w">
        <a class="logo" href="/frontMain?method=list">MMall</a>
        <div class="search-con">
            <input class="search-input" id="search-input" placeholder="请输入商品名称"/>
            <button class="btn search-btn" id="search-btn">搜索</button>
        </div>
    </div>
</div>
<!--header-->
<div class="crumb">
    <div class="w">
        <div class="crumb-con">
            <span>我的订单</span>
            <span class="link-text"></span>
        </div>
    </div>
</div>
<div class="cart-wrap w">
    <div class="cart-header">
        <table calss="cart-table" id="cart-table">
            <thead>
            <tr>
                <th class="cart-cell cell-check">
                    <label>
                        <input type="checkbox" class="cart-select-all" <%--checked="checked"--%>>
                        <span>全选</span>
                    </label>
                </th>
                <th class="cart-cell cell-info">订单号</th>
                <th class="cart-cell cell-price">创建时间</th>
                <th class="cart-cell cell-count">总价</th>
                <th class="cart-cell cell-total">状态</th>
                <th class="cart-cell cell-opera">操作</th>
            </tr>
            </thead>
            <tbody class="cart-table" data-product-id="26" data-checked="1">
            <c:forEach var="order" items="${requestScope.orderList}">
                <tr>
                    <td class="cart-cell cell-check">
                        <input type="checkbox" class="cart-select cartItem" id="orderId${order.id}" value="${order.id}" <%--checked="checked"--%>>
                    </td>
                    <td class="cart-cell ">
                       ${order.orderNumber}
                    </td>
                    <td class="cart-cell">
                        <fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td class="cart-cell">
                            ¥${order.totalPrice}
                    </td>
                    <td class="cart-cell">
                        <c:if test="${order.status==1}">下单</c:if>
                        <c:if test="${order.status==2}">运送中</c:if>
                        <c:if test="${order.status==3}">结单</c:if>
                        <c:if test="${order.status==4}">退回</c:if>
                    </td>
                    <td class="cart-cell">
                        <a class="link cart-delete">明细</a>
                        <a class="link cart-delete">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="cart-footer clear" id="cart-footer">
        <div class="select-con">
            <label >

                <input type="checkbox" class="cart-select-all" <%--checked="checked"--%>>
                <span>全选</span>

            </label>
        </div>
        <div class="delete-con">
            <a class="cart-delete-seleced link">
                <i class="fa fa-trash-o" aria-hidden="true"></i>
                <span>删除选中</span>
            </a>
        </div>
        <div class="submit-con">
            <span id="buyBtn" class="btn submit-btn" onclick="javascript:history.back(-1);return false;">返回</span>
        </div>
        &nbsp
    </div>
</div>
</body>
</html>