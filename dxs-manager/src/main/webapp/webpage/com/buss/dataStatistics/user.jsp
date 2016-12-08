<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<html>
<head lang="en">
        <meta charset="UTF-8">
        <title>全国大学生创业就业中心</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript">
                $(function(){
                   $(".quyu p").click(function(){
                           $(this).parents(".quyu").find("ul").slideToggle();
                   })
                        /*全国组注册*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        queryAllUser:0
                                },
                                success:function(data){
                                     $("#allcount").text(data.data)
                                }
                        });
                        /*今日新增*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        newlyIncreasedNum:0
                                },
                                success:function(data){
                                        $("#addcount").text(data.data)
                                }
                        });

                        /*北一*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:1,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count1").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:1,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add1").text(data.data)
                                }
                        });
                        /*北中*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:6,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count2").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:6,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add2").text(data.data)
                                }
                        });
                        /*北二区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:2,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count3").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:2,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add3").text(data.data)
                                }
                        });
                        /*东一区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:7,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count4").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:7,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add4").text(data.data)
                                }
                        });
                        /*北三区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:3,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count5").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:3,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add5").text(data.data)
                                }
                        });
                        /*北二区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:2,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count6").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:2,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add6").text(data.data)
                                }
                        });
                        /*西北区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:4,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count7").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:4,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add7").text(data.data)
                                }
                        });
                        /*南区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:9,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count8").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:9,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add8").text(data.data)
                                }
                        });
                        /*西南区*/
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:5,
                                        queryType:0
                                },
                                success:function(data){
                                        $("#count9").text(data.data)
                                }
                        });
                        $.ajax({
                                url:"dxsUserController.do",
                                type:"post",
                                dataType:"json",
                                data:{
                                        rangeStatistics:0,
                                        type:5,
                                        queryType:5
                                },
                                success:function(data){
                                        $("#add9").text(data.data)
                                }
                        });

                })
        </script>

</head>
<style>
        .content .title{height: 30px;width: 100%;background-color: #EEEEEE;border-radius: 5px 5px 0 0 ;float: left; color: #8b0f11;line-height: 30px;text-indent: 20px;}
        .content .center{width: 100%;height: 50px;float: left;background-color: #f8f8f8;}
        .content .center p{float: left;line-height: 50px;height: 50px;margin-top: 0;font-size: 14px;}
        .content .center p span{font-size: 16px;font-weight: bold;}
        .content .center .a1{margin-left: 50px}
        .content .center .a2{margin-left: 150px}
        .content .quyu{float: left;width: 100%;}
        .content .quyu p{background-color: #F8F8F8; height: 40px;border: 1px #e8e8e8 solid;width: 100% ; margin-top: 0;float: left;line-height: 40px;text-indent: 20px;}
        .content .quyu ul{display: none; width: 100%;float: left;margin-top:-10px; padding: 0;}
        .content .quyu ul li{text-indent: 50px; float: left;width: 100%;height: 30px;line-height: 30px;margin: 0;padding: 0;list-style: none;}
        .content .quyu ul li a{text-decoration: none;color: #3C3C3C;}
        .top10{margin-top: 17px;}
</style>
<body>
<div class="content">
<div class="title">
区域统计
</div>

        <div class="center">
                     <p class="a1"> 全国注册用户：<span id="allcount">  </span> 人 </p>    <p class="a2"> 今日新增人数：<span id="addcount">  </span> 人</p>
        </div>
        <div class="quyu top10">
               <p> 北一区（<span id="count1"></span>人，今日新增 <span id="add1"> </span>人）</p>
                <ul>
                        <li><a href="">黑龙江省</a></li>
                        <li><a href="">吉林市</a></li>
                        <li><a href="">辽宁省</a></li>

                </ul>
        </div>
        <div class="quyu ">
                <p> 北二区（<span id="count3"></span>人，今日新增 <span id="add3"> </span>人）</p>
                <ul>
                        <li><a href="">内蒙古</a></li>
                        <li><a href="">北京市</a></li>
                        <li><a href="">天津市</a></li>

                </ul>
        </div>
        <div class="quyu">
                <p> 北三区（<span id="count5"></span>人，今日新增 <span id="add5"> </span>人）</p>
                <ul>
                        <li><a href="">河北省</a></li>
                        <li><a href="">山东省</a></li>
                        <li><a href="">山西省</a></li>

                </ul>
        </div>
        <div class="quyu">
                <p> 西北区（<span id="count7"></span>人，今日新增 <span id="add7"> </span>人）</p>
                <ul>
                        <li><a href="">陕西省</a></li>
                        <li><a href="">宁夏</a></li>
                        <li><a href="">甘肃省</a></li>
                        <li><a href="">青海省</a></li>
                        <li><a href="">新疆</a></li>
                        <li><a href="">西藏</a></li>

                </ul>
        </div>
        <div class="quyu">
                <p> 西南区（<span id="count9"></span>人，今日新增 <span id="add9"> </span>人）</p>
                <ul>
                        <li><a href="">四川省</a></li>
                        <li><a href="">重庆市</a></li>
                        <li><a href="">云南省</a></li>
                        <li><a href="">贵州省</a></li>

                </ul>
        </div>

        <div class="quyu">
                <p> 华中区（<span id="count2"></span>人，今日新增 <span id="add2"> </span>人）</p>
                <ul>
                        <li><a href="">河南省</a></li>
                        <li><a href="">湖北省</a></li>
                        <li><a href="">湖南省</a></li>

                </ul>
        </div>

        <div class="quyu">
                <p> 东一区（<span id="count4"></span>人，今日新增 <span id="add4"> </span>人）</p>
                <ul>
                        <li><a href="">安徽省</a></li>
                        <li><a href="">江苏省</a></li>
                        <li><a href="">上海市</a></li>

                </ul>
        </div>

        <div class="quyu">
                <p> 东二区（<span id="count6"></span>人，今日新增 <span id="add6"> </span>人）</p>
                <ul>
                        <li><a href="">浙江省</a></li>
                        <li><a href="">福建省</a></li>
                        <li><a href="">江西省</a></li>

                </ul>
        </div>

        <div class="quyu">
                <p> 南区（<span id="count8"></span>人，今日新增 <span id="add8"> </span>人）</p>
                <ul>
                        <li><a href="">广东省</a></li>
                        <li><a href="">海南市</a></li>
                        <li><a href="">广西省</a></li>

                </ul>
        </div>

</div>

</body>
</html>