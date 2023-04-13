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

                        <form class="row">
                            <div class="form-group col-md-12">
                                <label>球拍名称</label>
                                <input type="text" class="form-control" value="${requestScope.racket.name}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>图片</label>
                                <img src="/images${requestScope.racket.imagePath}">
                            </div>
                            <div class="form-group col-md-12">
                                <label >描述</label>
                                <textarea class="form-control" >${requestScope.racket.description}</textarea>
                            </div>
                            <div class="form-group col-md-12">
                                <label>评分</label>
                                <input class="form-control" rows="5"value="${requestScope.racket.appraise}" readonly="readonly">
                            </div>
                            <div class="form-group col-md-12">
                                <label>价格</label>
                                <input type="text" class="form-control"value="${requestScope.racket.price}" readonly="readonly" />
                            </div>
                            <div class="form-group col-md-12">
                                <label>库存</label>
                                <input type="text" class="form-control" value="${requestScope.racket.stock}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>品牌:</label>
                                <input type="text" class="form-control" value="${requestScope.brand.name}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>系列:</label>
                                <input type="text" class="form-control" value="${requestScope.series.name}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>球柄粗细</label>
                                <input type="text" class="form-control" value="${requestScope.handle.value}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>重量</label>
                                <input type="text" class="form-control" value="${requestScope.weight.value}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
                                <label>产地</label>
                                <input type="text" class="form-control" value="${requestScope.place.value}" readonly="readonly"/>
                            </div>
                            <div class="form-group col-md-12">
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
<script>
    $('#brandId').change(function(){
        let brandId = parseInt($(this).val())
        $.get('/adminSeries',{'method':'queryByBrandId','brandId':brandId},function(data){
            console.log(data)
            $('.seriesItem').remove()
            $.each(data,function(index,series){
                $('#seriesId').append('<option class="seriesItem" value="'+series.id+'">'+series.name+'</option>')
            })
        },'json')
    })

</script>

</body>
</html>
