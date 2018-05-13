<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2017/12/6
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>左边导航</title>
    <link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
    <script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
    <!--框架高度设置-->
    <script type="text/javascript">
        $(function(){
            $('.sidenav li').click(function(){
                $(this).siblings('li').removeClass('now');
                $(this).addClass('now');
            });

            $('.erji li').click(function(){
                $(this).siblings('li').removeClass('now_li');
                $(this).addClass('now_li');
            });

            var main_h = $(window).height();
            $('.sidenav').css('height',main_h+'px');
        })
    </script>
    <!--框架高度设置-->
</head>

<body>
<div id="left_ctn">
    <ul class="sidenav">
        <li class="now">
            <div class="nav_m">
                <span><a>管理员</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li class="now_li">
                    <span><a href="/ad_add_information" target="main">录入信息</a></span>
                </li>
                <li>
                    <span><a href="/ad_query_abnormal" target="main">查看异常</a></span>
                </li>
                <li>
                    <span><a href="/ad_query" target="main">查询</a></span>
                </li>
                <li>
                    <span><a href="/ad_add_activity" target="main">活动管理</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a href="cqxt.html" target="_blank">重启MCU</a></span>
            </div>
        </li>
        <li>
            <div class="nav_m">
                <span><a href="tcxt.html" target="_blank">退出系统</a></span>
            </div>
        </li>
    </ul>
</div>
</body>
</html>

