<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/cart.css">
    <link rel="stylesheet" href="/css/layout.css">
</head>
<script src="/js/jquery-3.6.0.js"></script>
<script src="/js/bootstrap.js"></script>
<style type="text/css" >
    #cart-table {
        width: 100%;
        padding-left: 20px;
    }
    #cart-footer{
        background: #eee;

    }
</style>
<body>
<jsp:include page="/front/nav.jsp"></jsp:include>
<!--header-->
<div class="header">
    <div class="w">
        <a class="logo" href="/frontMain?method=list">MMall</a>
        <div class="search-con">
            <input class="search-input" id="search-input" placeholder="请输入商品名称"/>
            <button class="btn search-btn" id="search-btn">搜索</button>
        </div>
    </div>
</div>
<!--header-->
<div class="crumb">
    <div class="w">
        <div class="crumb-con">
            <span>我的购物车</span>
            <span class="link-text"></span>
        </div>
    </div>
</div>
<div class="cart-wrap w">
    <div class="cart-header">
        <table calss="cart-table" id="cart-table">
            <thead>
            <tr>
                <th class="cart-cell cell-check">
                    <label>
                        <input type="checkbox" class="cart-select-all" <%--checked="checked"--%>>
                        <span>全选</span>
                    </label>
                </th>
                <th class="cart-cell cell-info">商品信息</th>
                <th class="cart-cell cell-price">单价</th>
                <th class="cart-cell cell-count">数量</th>
                <th class="cart-cell cell-total">合计</th>
                <th class="cart-cell cell-opera">操作</th>
            </tr>
            </thead>
            <tbody class="cart-table" data-product-id="26" data-checked="1">
            <c:forEach var="cartItem" items="${requestScope.cartItemList}">
                <tr>
                    <td class="cart-cell cell-check">
                        <input type="checkbox" class="cart-select cartItem" id="cartItemId${cartItem.id}" value="${cartItem.id}" <%--checked="checked"--%>>
                    </td>
                    <td class="cart-cell cell-img">
                        <img class="p-img" src="/images${cartItem.racket.imagePath}" style="height: 50px;width: 50px" ></a>
                        <a class="link p-name" href="">${cartItem.racket.name}</a>
                    </td>
                    <td class="cart-cell cell-price">
                            ¥${cartItem.racket.price}
                        <input type="hidden" class="price">
                    </td>
                    <td class="cart-cell cell-count">
                        <span class="count-btn down" data-opera-type="minus">-</span>
                        <input class="count-input" cartItemId="${cartItem.id}" price="${cartItem.racket.price}" data-max="118176"  value="${cartItem.count}">
                        <span class="count-btn up" data-opera-type="plus" >+</span>
                    </td>
                    <td class="cart-cell cell-total total" id="IP${cartItem.id}">￥${cartItem.itemPrice}</td>
                    <td class="cart-cell cell-opera"><a class="link cart-delete">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="cart-footer clear" id="cart-footer">
        <div class="select-con">
            <label >

                <input type="checkbox" class="cart-select-all" <%--checked="checked"--%>>
                <span>全选</span>

            </label>
        </div>
        <div class="delete-con">
            <a class="cart-delete-seleced link">
                <i class="fa fa-trash-o" aria-hidden="true"></i>
                <span>删除选中</span>
            </a>
        </div>
        <div class="submit-con">
            <span>总价：</span>
            <span class="submit-total" id="totalPrice"></span>
            <span id="buyBtn" class="btn submit-btn">去结算</span>
        </div>
        &nbsp
    </div>
</div>
<script>
    $('.count').change(function (){
        let count = parseInt($(this).val())
        let price = $(".price").val()
        $('.total').each(function (index){
            $(this).append(count*price)
        })
    })

    $('.up').click(function (){
        let count = +($(this).prev().val()) + 1;
        console.log("==============>",count)
        $(this).prev().val(count)
        // 获取单价
        let price = +$(this).prev().attr('price')
        console.log("price=",price)
        // 修改后的数量
        count = +$(this).prev().val()
        console.log("count=",count)
        let currentCartItemId = $(this).prev().attr('cartItemId')
        let itemPriceSpanTag = $('#IP'+currentCartItemId)
        itemPriceSpanTag.text("￥"+(price*count))
        // 更新总价格
        let totalPrice = 0
        $('.cart-select:checked').each(function(index,obj){
            let itemPrice = +($(obj).parent().next().next().next().next().text()).substring(1)
            console.log("itemPrice=",itemPrice)
            totalPrice += itemPrice
        })

        $('#totalPrice').text(totalPrice)
        console.log("totalPrice=",totalPrice)

    })
    $('.down').click(function (){
        let count =+($(this).next().val())
        if (count==0){
            return;
        }else {
            count =  count - 1;
            console.log("==============>",count)
            $(this).next().val(count)
            // 获取单价
            let price = +$(this).next().attr('price')
            console.log("price=",price)
            // 修改后的数量
            count = +$(this).next().val()
            console.log("count=",count)
            let currentCartItemId = $(this).next().attr('cartItemId')
            let itemPriceSpanTag = $('#IP'+currentCartItemId)
            itemPriceSpanTag.text("￥"+(price*count))
            // 更新总价格
            let totalPrice = 0
            $('.cart-select:checked').each(function(index,obj){
                let itemPrice = +($(obj).parent().next().next().next().next().text()).substring(1)
                console.log("itemPrice=",itemPrice)
                totalPrice += itemPrice
            })

            $('#totalPrice').text(totalPrice)
            console.log("totalPrice=",totalPrice)

        }

    })

    $('.count-input').change(function(){
        // 获取单价
        let price = +$(this).attr('price')
        console.log("price=",price)
        // 修改后的数量
        let count = +$(this).val()
        console.log("count=",count)
        let currentCartItemId = $(this).attr('cartItemId')
        let itemPriceSpanTag = $('#IP'+currentCartItemId)
        itemPriceSpanTag.text("￥"+(price*count))
        // 更新总价格
        let totalPrice = 0
        $('.cart-select:checked').each(function(index,obj){
            let itemPrice = +($(obj).parent().next().next().next().next().text()).substring(1)
            console.log("itemPrice=",itemPrice)
            totalPrice += itemPrice
        })

        $('#totalPrice').text(totalPrice)
        console.log("totalPrice=",totalPrice)

    })

    // 购买
    /*$('#buyBtn').click(()=>{
        if($('.cartItem:checked').length==0){
            alert('请选择需要购买的商品')
            return
        }
        console.log($('.cartItem:checked').length)
    })*/
    $('#buyBtn').click(function (){
        let checkIds = ''
        let checkCounts = ''
        $('.cartItem:checked').each(function (index,item){
            checkIds += $(item).val()+','
            checkCounts += $(item).parent().next().next().next().children().get(1).value+','

        })
        if(checkIds==null){
            alert('订单添加失败')
        }
        console.log('checkIds =>',checkIds)
        console.log('checkCounts =>',checkCounts)
        let json = {}
        json.method = 'toAddOrder'
        json.checkIdsString = checkIds
        json.checkCountsString = checkCounts
        console.log('json =>',json)
        $.post('/frontOrder',json,function (data) {
            if (data.message == 'ok') {
                window.location = '/front/order.jsp'
            } else {
                alert('订单添加失败')
            }
        },'json')
    })
</script>
</body>
</html>