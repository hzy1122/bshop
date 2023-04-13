<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
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

                        <form action="/adminBadmintonAdd" method="post" class="row" enctype="multipart/form-data">
                            <div class="form-group col-md-12">
                                <label for="name">羽毛球名称</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="请输入羽毛球名称" />
                            </div>
                            <div class="form-group col-md-12">
                                <label>图片</label>
                                <div class="form-controls">
                                    <ul class="list-inline clearfix lyear-uploads-pic">
                                        <li class="col-xs-4 col-sm-3 col-md-2">
                                            <input type="file" class="pic-add" id="imagePath" name="imagePath">
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="description">描述</label>
                                <textarea class="form-control" id="description" name="description" rows="5"placeholder="描述"></textarea>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="price">价格</label>
                                <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格" />
                            </div>
                            <div class="form-group col-md-12">
                                <label for="stock">库存</label>
                                <input type="text" class="form-control" id="stock" name="stock" placeholder="请输入羽毛球库存" />
                            </div>
                            <div class="form-group col-md-12">
                                <label>品牌</label>
                                <select class="form-control" name="brandId">
                                    <option value="0">=请选择=</option>
                                    <c:forEach var="brand" items="${requestScope.brandList}">
                                        <option value="${brand.id}" }>${brand.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-12">
                                <label>羽毛种类</label>
                                <select class="form-control" name="plumeId">
                                    <option value="0">=请选择=</option>
                                    <c:forEach var="plume" items="${requestScope.plumeList}">
                                        <option value="${plume.id}" }>${plume.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-12">
                                <label>羽毛球球速</label>
                                <select class="form-control" name="speedId">
                                    <option value="0">=请选择=</option>
                                    <c:forEach var="speed" items="${requestScope.speedList}">
                                        <option value="${speed.id}" }>${speed.value}</option>
                                    </c:forEach>
                                </select>
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
