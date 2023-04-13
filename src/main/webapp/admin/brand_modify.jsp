<%--
  Created by IntelliJ IDEA.
  User: 86179
  Date: 2023/3/27
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/materialdesignicons.min.css" rel="stylesheet">
<link href="/css/style.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<head>
    <title>品牌修改</title>
</head>
<body>
<div class="lyear-layout-container">
    <jsp:include page="/admin/top.jsp"></jsp:include>
    <jsp:include page="/admin/menu.jsp"></jsp:include>
<!--页面主要内容-->
<main class="lyear-layout-content">

    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">

                        <form action="/adminBrandModify" method="post" class="row" enctype="multipart/form-data">
                            <div class="form-group col-md-12">
                                <label for="name">品牌</label>
                                <input type="text" class="form-control" id="name" name="name" value="${requestScope.brand.name}"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>品牌商标</label>
                                <div class="form-controls">
                                    <ul class="list-inline clearfix lyear-uploads-pic">
                                        <li class="col-xs-4 col-sm-3 col-md-2">
                                            <img src="/images${requestScope.brand.tmPath}">
                                            <input type="file" class="pic-add" id="imagePath" name="imagePath">
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="description">描述</label>
                                <textarea class="form-control" id="description" name="description" rows="5">${requestScope.brand.description}</textarea>
                            </div>
                            <div class="form-group col-md-12">
                                <button type="submit" class="btn btn-primary ajax-post" >确 定</button>
                                <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>

    </div>
</main>
</div>
</main>
<!--End 页面主要内容-->

</body>
</html>
