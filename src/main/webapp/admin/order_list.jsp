<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>订单</title>
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
                        <div class="card-toolbar clearfix">
                            <div>
                                <form class="form-inline" action="/adminSeries" method="post">
                                    品牌<span class="caret"></span>
                                    <select class="form-control" name="brandId">
                                        <option value="0">=请选择=</option>
                                        <c:forEach var="brand" items="${requestScope.brandList}">
                                            <option value="${brand.id}" }>${brand.name}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" name="method" value="search">
                                    <input type="submit" class="btn btn-primary" value="查询"></input>
                                </form>
                            </div>
                            <div class="toolbar-btn-action">
                                <a class="btn btn-primary m-r-5" href="/adminSeries?method=toAdd"><i class="mdi mdi-plus"></i> 新增</a>
                                <a class="btn btn-danger" id="seriesRemove" href="/adminSeries?method=list"><i class="mdi mdi-window-close"></i> 删除</a>
                            </div>
                        </div>
                        <div class="card-body">

                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>
                                            <label class="lyear-checkbox checkbox-primary">
                                                <input type="checkbox" id="check-all"><span></span>
                                            </label>
                                        </th>
                                        <th>订单号</th>
                                        <th>用户</th>
                                        <th>创建时间</th>
                                        <th>总价</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dd" items="${orderList}" varStatus="status">
                                            <tr>
                                                <td>
                                                    <label class="lyear-checkbox checkbox-primary">
                                                        <input type="checkbox" class="seriesItem" value="${status.count}"><span></span>
                                                        <input class="hidden" value="${dd.id}">
                                                    </label>
                                                </td>
                                                <td>${dd.orderNumber}</td>
                                                <td>${dd.nickName}</td>
                                                <td><fmt:formatDate value="${dd.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                                                <td>¥${dd.totalPrice}</td>
                                                <td>
                                                    <c:if test="${dd.status==1}">下单</c:if>
                                                    <c:if test="${dd.status==2}">运送中</c:if>
                                                    <c:if test="${dd.status==3}">结单</c:if>
                                                    <c:if test="${dd.status==4}">退回</c:if>
                                                </td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a class="btn btn-xs btn-default" onclick="return confirm('确定删除吗?')" href="/adminSeries?method=remove&id=${dd.id}" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </main>
    <!--End 页面主要内容-->
</div>
<script>
    $("#seriesRemove").on("click", function() {
        let checkedNum = $(".seriesItem:checked").length;
        if (checkedNum == 0) {
            alert("请至少选择一项!");
            return false;
        }
        let checkedList = ''
        $(".seriesItem:checked").each(function (index,obj) {
            checkedList += ($(obj).parent().get(0).children[2].value)+','
        });
        console.log(checkedList)
        let checkedArrayList = checkedList.split(",")
        let flag=confirm("确认要删除这"+(checkedArrayList.length-1)+"条数据吗?")
        console.log(flag)
        if(flag){
            let json = {}
            json.method = 'removes'
            json.checkedList = checkedList
            console.log('json =>',json)
            $.post('/adminSeries',json)
        }
    })
</script>
</body>
</html>
