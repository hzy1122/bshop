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
    <title>羽毛球管理</title>
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
                                <form class="form-inline" action="/adminBadminton" method="post">
                                    品牌<span class="caret"></span>
                                    <select class="form-control" name="brandId">
                                        <option value="0">=请选择=</option>
                                        <c:forEach var="brand" items="${requestScope.brandList}">
                                            <option value="${brand.id}" }>${brand.name}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" name="method" value="search">
                                    <input type="submit" class="btn btn-primary" value="查询">
                                </form>
                            </div>
                            <div class="toolbar-btn-action">
                                <a class="btn btn-primary m-r-5" href="/adminBadminton?method=toAdd"><i class="mdi mdi-plus"></i> 新增</a>
                                <a class="btn btn-danger" id="removes" href="/adminBadminton?method=list"><i class="mdi mdi-window-close"></i> 删除</a>
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
                                        <th>编号</th>
                                        <th>羽毛球名称</th>
                                        <th>图片</th>
                                        <th>描述</th>
                                        <th>价格</th>
                                        <th>库存</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="badminton" items="${requestScope.badmintonList}" varStatus="status">
                                            <tr>
                                            <td>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" class="badItem" value="${status.count}"><span></span>
                                                    <input class="hidden" value="${badminton.id}">
                                                </label>
                                            </td>
                                                <td>${status.count}</td>
                                                <td>${badminton.name}</td>
                                                <td><img style="height:40px ;weight:80" src="/images${badminton.imagePath}"></td>
                                                <td>${badminton.description}</td>
                                                <td>${badminton.price}</td>
                                                <td>${badminton.stock}</td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a class="btn btn-xs btn-default" href="/adminBadminton?method=toModify&id=${badminton.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                        <a class="btn btn-xs btn-default" href="/adminBadminton?method=toDetail&id=${badminton.id}" title="查看" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>
                                                        <a class="btn btn-xs btn-default" onclick="return confirm('确定删除吗?')" href="/adminBadminton?method=remove&id=${badminton.id}" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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
    $("#removes").on("click", function() {
        var checkedNum = $(".badItem:checked").length;
        if (checkedNum == 0) {
            alert("请至少选择一项!");
            return false;
        }
        let checkedList = ''
        $(".badItem:checked").each(function (index,obj) {
            checkedList += ($(obj).parent().get(0).children[2].value)+','
        });
        console.log(checkedList)
        let checkedArrayList = checkedList.split(",")
        let flag=confirm("确认要删除这"+(checkedArrayList.length-1)+"条数据吗?")
        if(flag) {
            let json = {}
            json.method = 'removes'
            json.checkedList = checkedList
            console.log('json =>', json)
            $.post('/adminBadminton', json)
        }
    })
</script>
</body>
</html>
