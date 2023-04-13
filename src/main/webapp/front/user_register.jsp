<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/ssq.js"></script>
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
    <div class="w">
    </div>
</div>
<div class="page-wrap">
    <div class="w">
        <div class="user-con">
            <div class="user-title">用户注册</div>
            <div class="user-box">
                <div class="error-item">
                    <i class="fa fa-minus-circle error-icon"></i>
                    <p class="err-msg">Error</p>
                </div>
                <div class="container">
                <div class="mainRegister">
                <form class="form-horizontal" action="/frontUser" method="post">
                    <div class="user-item">
                        <label class="user-label" >
                            <i class="fa fa-user"></i>
                        </label>
                        <input type="hidden" name="method" value="register">
                        <input class="user-content" id="account" name="account" placeholder="请输入用户名" autocomplete="off">
                    </div>


                    <div class="user-item">
                        <label class="user-label" for="password">
                            <i class="fa fa-lock"></i>
                        </label>
                        <input onblur="verification()" type="password" class="user-content" id="password" name="password" placeholder="请输入密码" autocomplete="off">
                    </div>
                    <div class="user-item">
                        <label class="user-label" for="password1">
                            <i class="fa fa-lock"></i>
                        </label>
                        <input onblur="verification()" type="password" class="user-content" id="password1" name="password1" placeholder="请再次确认密码" autocomplete="off">
                    </div >
                    <div class="user-item">
                        <p id="tishi" style="color: red" autocomplete="off"></p>
                    </div>
                    <a class="btn btn-submit" id="submit">注册</a>
                </form>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    function verification() {
        var pw1 = document.getElementById("password").value;
        var pw2 = document.getElementById("password1").value;
        if(pw1 == pw2) {
            document.getElementById("tishi").innerHTML="两次密码相同";
        }
        else {
            document.getElementById("tishi").innerHTML="两次密码不相同";
        }
    }
</script>
</body>
</html>



