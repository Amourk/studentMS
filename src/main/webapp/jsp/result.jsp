<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2017/12/12
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>基本信息</title>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/thems.css">
    <script type="text/javascript" src="jsp/Assets/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');


            $('.xial_m span').click(function(){
                $(this).parent('.xial_m').siblings('.xl_ctn').toggle();
            });
        });
    </script>
</head>
<body>
<!--会议列表-->
<div class="hy_list">
    <div class="a">
        <div class="box_t">
            <span class="name">成绩管理</span>
            <!--当前位置-->
            <div class="position">
                <a href=""><img src="jsp/Assets/images/icon5.png" alt=""/></a>
                <a href="">首页</a>
                <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                <a href="">成绩管理</a>
                <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                <a href="">学科成绩</a>
            </div>
            <!--当前位置-->
        </div>
        <form action="" method="post">
            <div class="xjhy">
                <ul class="hypz gjpz clearfix">
                    <li>
                        <span class="title">高数：</span>
                        <div class="li_r">
                            <P name="math">${course[0]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">英语：</span>
                        <div class="li_r">
                            <P>${course[1]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">大学物理：</span>
                        <div class="li_r">
                            <P>${course[2]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">C语言：</span>
                        <div class="li_r">
                            <P>${course[3]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">Java：</span>
                        <div class="li_r">
                            <P>${course[4]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">Android：</span>
                        <div class="li_r">
                            <P>${course[5]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">JavaWeb：</span>
                        <div class="li_r">
                            <P>${course[6]}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">Spring：</span>
                        <div class="li_r">
                            <P>${course[7]}</P>
                        </div>
                    </li>
                </ul>

            </div>
        </form>
    </div>
</div>
</body>
</html>
