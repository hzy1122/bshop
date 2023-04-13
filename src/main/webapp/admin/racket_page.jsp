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
    <body>
        <div style="text-align: center">
            <div class="row">
                <div class="col-md-2">
                    第 <span id="currentPage"></span>/<span id="totalPage"></span> 页
                </div>
                <div class="col-md-8">
                    <button id="firstPageBtn">首页</button>
                    <button id="previousPageBtn">上一页</button>
                    <button id="nextPageBtn">下一页</button>
                    <button id="lastPageBtn">末页</button>
                    跳转到<input type="text" id="jumpPage" size="2"/>页
                    <button id="jumpPageBtn">跳转</button>
                </div>
                <div class="col-md-2">
                    <span id="totalCount"></span>
                </div>
            </div>
        </div>
        <script>

            let json1 = {'method':'page','currentPage':1}

            $(function(){
                sendGetRequest()

            })

            // 首页
            $("#firstPageBtn").click(function (){
                json1.currentPage = 1
                sendGetRequest()
            })

            // 上一页
            $("#previousPageBtn").click(function (){
                if($('#currentPage').text()==1){
                    alert('没有上一页')
                    return
                }
                json1.currentPage = parseInt($('#currentPage').text())-1
                sendGetRequest()
            })

            // 下一页
            $("#nextPageBtn").click(function (){
                if($('#currentPage').text()==$('#totalPage').text()){
                    alert('没有下一页')
                    return
                }
                json1.currentPage = parseInt($('#currentPage').text())+1
                sendGetRequest()
            })

            // 末页
            $("#lastPageBtn").click(function (){
                json1.currentPage = parseInt($('#totalPage').text())
                sendGetRequest()
            })

            // 跳转页
            $("#jumpPageBtn").click(function (){
                if(isNaN($('#jumpPage').val())){
                    alert('请输入有效的页码')
                    $('#jumpPage').val('')
                    $('#jumpPage').focus()
                    return
                }
                let jumpPage = parseInt($('#jumpPage').val())
                let totalPage = parseInt($('#totalPage').text());
                if(jumpPage<1 || jumpPage>totalPage){
                    alert('请输入有效的页码范围(1-'+totalPage+')')
                    return
                }
                json1.currentPage = jumpPage
                sendGetRequest()
            })

            function sendGetRequest(){
                if($('#brandId').val()!=0){
                    json1.brandId = +$('#brandId').val()
                }else{
                    delete json1.brandId
                }
                if($('#seriesId').val()!=0){
                    json1.seriesId = +$('#seriesId').val()
                }else{
                    delete json1.seriesId
                }
                /*if($('#smallPrice').val()!=''){
                    json1.smallPrice = +$('#smallPrice').val()
                }else{
                    delete json1.smallPrice
                }
                if($('#bigPrice').val()!=''){
                    json1.bigPrice = +$('#bigPrice').val()
                }else{
                    delete json1.bigPrice
                }*/

                console.log('pageJson',json1)

                $.get(
                    '/adminRacket',
                    json1,
                    function(data){
                        // 初始化当前页其他信息
                        console.log('data',data)
                        // 当前页
                        $('#currentPage').text(data.pageNum)
                        // 总页数
                        $('#totalPage').text(data.pages)
                        // 总记录数
                        $('#totalCount').text(data.total)

                        let currentPageNumber = parseInt($('#currentPage').text())

                        // 删除已有列表中的数据
                        $('.item').remove()
                        // 初始化当前页的数据
                        $.each(data.list,function (index,racket){
                            $('#tbody').append(
                                '<tr class="item">'+

                                '<td><input type="checkbox" name="ids" value="'+racket.brand.id+'"></td>'+
                                '<td>'+((currentPageNumber-1)*5+index+1)+'</td>'+
                                '<td>'+racket.name+'</td>'+
                                '<td><img src="/images/'+racket.imagePath+'" width="50px" height="50px"></td>'+
                                '<td>'+racket.shortDesc+'</td>'+
                                '<td>'+racket.price+'</td>'+
                                '<td>'+racket.stock+'</td>'+
                                '<td>'+racket.handle.value+'</td>'+
                                '<td>'+racket.weight.value+'</td>'+
                                '<td>'+racket.place.value+'</td>'+
                                '<td>'+
                                '<a class="btn btn-info btn-xs" href="/adminRacket?method=toDetail&id='+racket.id+'">明细</a>'+
                                '<a class="btn btn-success btn-xs" href="/adminRacket?method=toModify&id='+racket.id+'">修改</a>'+
                                '<a class="btn btn-danger btn-xs" onclick="return confirm(\'确定删除吗?\')" href="/adminRacket?method=remove&id='+racket.id+'">删除</a>'+
                                '</td>'+
                                '</tr>'
                            )
                        })
                    },
                    'json'
                )
            }

        </script>
    </body>
</html>
