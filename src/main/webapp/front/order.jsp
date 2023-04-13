<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>填写订单信息</title>
<script src="../static/js/jquery.min.js" th:src="@{/js/jquery.min.js}"></script>
<link rel="stylesheet" href="../static/bootstrap/css/bootstrap.min.css" th:href="@{/bootstrap/css/bootstrap.min.css}">
<script src="../static/bootstrap/js/bootstrap.min.js"  th:src="@{/bootstrap/js/bootstrap.min.js}"></script>
<link rel="stylesheet" href="../static/css/main.css" th:href="@{/css/main.css}">
<link rel="stylesheet" href="../static/css/checkout.css"  th:href="@{/css/checkout.css}">
<script src="../static/js/checkout.js" th:src="@{/js/checkout.js}"></script>
<script th:src="@{/js/jquery-3.4.1.min.js}"></script>
<script src="/js/ssq.js"></script>
<script src="/js/bootstrap.js"></script>
</head>
<body>
<!--顶部导航栏-->
<div class="topBar">
    <div class="container">
            <jsp:include page="/front/nav.jsp"></jsp:include>
</div>
</div>
<!--主要界面-->
<div class="pageMain">
    <div class="container">
        <div class="sectionAddress">
            <div class="sectionHeader">
                <h4>收货地址</h4>
                <span class="separator">|</span>
                大型商品下单后，收货地址将无法修改。 快递公司会电话联系您确认送货时间，收货时需核对身份证信息。
            </div>
            <div id="addressList">
                <ul>
                            <div>
                                <table>
                                    <tr>
                                        <td>省:</td>
                                        <td>
                                            <select id="province" name="addressProvince">
                                                <option value="-1">=请选择=</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>市:</td>
                                        <td>
                                            <select id="city" name="addressCity">
                                                <option value="-1">=请选择=</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>区:</td>
                                        <td>
                                            <select id="area" name="addressArea">
                                                <option value="-1">=请选择=</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>详情:</td>
                                        <td>
                                            <textarea id="info" name="addressInfo" style="resize: none" cols="30" rows="3" placeholder="留下点什么吧..."></textarea>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                    <!--//新增收货地址模态框-->
                </ul>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div class="cart-wrap w">
            <div class="cart-header">
                <table calss="cart-table" id="cart-table">
                    <thead>
                    <tr>
                        <th class="cart-cell cell-info">商品信息</th>
                        <th class="cart-cell cell-price">单价</th>
                        <th class="cart-cell cell-count">数量</th>
                        <th class="cart-cell cell-total">合计</th>
                    </tr>
                    </thead>
                    <tbody class="cart-table" data-product-id="26" data-checked="1">
                    <c:forEach var="orderItem" items="${sessionScope.orderItemList}">
                        <tr>
                            <td class="cart-cell cell-img">
                                <img class="p-img" src="/images${orderItem.racket.imagePath}" style="height: 50px;width: 50px" ></a>
                                <a class="link p-name" href="">${orderItem.racket.name}</a>
                            </td>
                            <td class="cart-cell cell-price">
                                ¥${orderItem.racket.price}
                            </td>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <td class="cart-cell cell-count">
                                    ${orderItem.count}
                            </td>
                            <td class="cart-cell cell-total total" id="IP${orderItem.id}">￥${orderItem.itemPrice}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="moneyBox">
        <ul>
            <li><label>应付总额</label><h2 <%--th:text="${totalPrice}"--%>>${sessionScope.totalPrice}元</h2></li>
           <%-- <input type="hidden" name="totalPrice" value="${sessionScope.totalPrice}">--%>
        </ul>
    </div>
    </div>
    <div class="container">
        <div class="pullOrder">
            <a type="button" class="btn btn-success"  href="/frontOrder?method=add&id=${sessionScope.orderId}">去付款</a>
        </div>

    </div>
</div>
<%--<script>
    $('#buy').click(()=>{
        let idid = $(this).val()
            alert('idid')
            return

    })
</script>--%>
<script>

    // 获取省、市、区三个select标签
    let provinceSelectTag = document.getElementById('province');
    let citySelectTag = document.getElementById('city');
    let areaSelectTag = document.getElementById('area');
    // 定义省、市、区三个索引
    let provinceIndex = 0;
    let cityIndex = -1;
    let areaIndex = -1;

    // 网页首次渲染就需要填充省的下拉列表
    address.forEach((province,index)=>{
        let provinceOptionTag = document.createElement('option');
        provinceOptionTag.value = index;
        provinceOptionTag.innerText = province.Name;
        provinceSelectTag.appendChild(provinceOptionTag);
    })

    // 选择省的下拉选项,级联改变市的下拉选项值
    provinceSelectTag.onchange = function() {
        // 清除原来的下拉选项
        citySelectTag.options.length = 0;
        areaSelectTag.options.length = 0;

        let cityDefaultTag = document.createElement('option');
        cityDefaultTag.value = -1;
        cityDefaultTag.innerText = '=请选择=';
        citySelectTag.appendChild(cityDefaultTag);

        let areaDefaultTag = document.createElement('option');
        areaDefaultTag.value = -1;
        areaDefaultTag.innerText = '=请选择=';
        areaSelectTag.appendChild(areaDefaultTag);

        // 获得新的省的下标
        provinceIndex = this.value;
        // 填充新的市的下拉
        address[provinceIndex].Cities.forEach((city,index)=>{
            let cityOptionTag = document.createElement('option');
            cityOptionTag.value = index;
            cityOptionTag.innerText = city.Name;
            citySelectTag.appendChild(cityOptionTag);
        })
    }

    // 选择市的下拉选项,级联改变区的下拉选项值
    citySelectTag.onchange = function(){
        // 清除原来的下拉选项
        areaSelectTag.options.length = 0;
        let defaultTag = document.createElement('option');
        defaultTag.value = -1;
        defaultTag.innerText = '=请选择=';
        areaSelectTag.appendChild(defaultTag);

        // 获得新的市的下标
        cityIndex = this.value;
        // 填充新的区的下拉
        address[provinceIndex].Cities[cityIndex].Districts.forEach((area,index)=>{
            let areaOptionTag = document.createElement('option');
            areaOptionTag.value = index;
            areaOptionTag.innerText = area.Name;
            areaSelectTag.appendChild(areaOptionTag);
        })
    }

    areaSelectTag.onchange = function () {
        areaIndex = this.value;
    }
</script>
</body>
</html>