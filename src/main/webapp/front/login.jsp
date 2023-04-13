<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>前台登录</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/nav-simple.css">
    <link rel="stylesheet" href="/css/layout.css">
</head>
<style type="text/css" >
    .w{
        width: 1080px;
        margin: 0 auto;
        position: relative;
        overflow: hidden;
    }
</style>
<body>

<div class="nav-simple">

</div>
<div class="page-wrap">
    <div class="w">
        <div class="user-con">
            <div class="user-title">用户登录</div>
            <form class="form-horizontal" action="/frontUser" method="post">
            <div class="user-box">
                <div class="error-item">
                    <i class="fa fa-minus-circle error-icon"></i>
                    <p class="err-msg">Error</p>
                </div>
                <div class="user-item">
                    <label class="user-label">
                        <i class="fa fa-user"></i>
                    </label>
                    <input class="user-content" name="account" id="account" value="zhangwuji" placeholder="请输入用户名" autocomplete="off">
                    <input type="hidden" name="method" value="login">
                </div>
                <div class="user-item">
                    <label class="user-label" for="password">
                        <i class="fa fa-lock"></i>
                    </label>
                    <input type="password" class="user-content" name="password" id="password" value="123456" placeholder="请输入密码" autocomplete="off">
                </div>
                <button type="submit" class="btn btn-submit" id="submit">登录</button>
                <div class="link-item">
                    <a class="link" href="./user-pass-reset.html" target="_blank">忘记密码</a>
                    <a class="link" href="./user-register.html" target="_blank">免费注册</a>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
