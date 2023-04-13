<%--
  Created by IntelliJ IDEA.
  User: 86179
  Date: 2023/3/17
  Time: 14:09
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
    <title></title>
</head>

<body>
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">

        <!-- logo -->
        <div style="height: 65px" class="sidebar-header">
        </div>
        <div class="lyear-layout-sidebar-scroll">

            <nav class="sidebar-main">
                <ul class="nav nav-drawer">
                    <li class="nav-item nav-item-has-subnav">
                        <a href="/adminBrand?method=list"><i class="mdi mdi-format-align-justify"></i> 品牌管理</a>
                    </li>
                    <li class="nav-item nav-item-has-subnav">
                        <a href="/adminSeries?method=list"><i class="mdi mdi-format-align-justify"></i>系列管理</a>
                    </li>
                    <li class="nav-item nav-item-has-subnav">
                        <a href="/adminRacket?method=list"><i class="mdi mdi-format-align-justify"></i> 球拍管理</a>
                    </li>
                    <li class="nav-item nav-item-has-subnav">
                        <a href="/adminBadminton?method=list"><i class="mdi mdi-format-align-justify"></i> 羽毛球管理</a>
                    </li>
                    <li class="nav-item nav-item-has-subnav">
                        <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 用户管理</a>
                    </li>
                    <li class="nav-item nav-item-has-subnav">
                        <a href="/adminOrder?method=list"><i class="mdi mdi-format-align-justify"></i> 订单管理</a>
                    </li>
                </ul>
            </nav>
        </div>

    </aside>
    <!--End 左侧导航-->

</body>
</html>
