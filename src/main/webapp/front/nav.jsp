<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<body>
<!--nav-->
<div class="nav">
    <div class="w">
        <div class="user-info">
            <c:if test="${sessionScope.user==null}">
                <span class="user not-login">
                    <a  href="/frontMain?method=toLogin" class="link js-login">登录</a>
                    <a href="/frontUser?method=toRegister" class="link js-register">注册</a>
                </span>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <span class="user">
                    <span class="link-text">
                        欢迎，<span class="username">${sessionScope.user.nickName}</span>
                    </span>
                    <a class="link js-logout" href="/frontUser?method=logout">注销</a>
                </span>
            </c:if>
        </div>
        <ul class="nav-list">
            <li class="nav-item">
                <a class="link" href="/frontCart?method=rlist">
                    <i class="fa fa-shopping-cart"></i>
                    购物车(<span class="cart-count">0</span>)
                </a>
            </li>
            <li class="nav-item">
                <a class="link" href="/frontMyOrder?method=toList">我的订单</a>
            </li>
        </ul>
    </div>
</div>
<!--nav-->
</body>
</html>
