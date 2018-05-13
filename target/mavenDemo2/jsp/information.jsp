<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2017/12/6
  Time: 19:49
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
        <span class="name">基本信息</span>
        <!--当前位置-->
        <div class="position">
            <a href=""><img src="jsp/Assets/images/icon5.png" alt=""/></a>
            <a href="">首页</a>
            <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
            <a href="">信息管理</a>
            <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
            <a href="">基本信息</a>
        </div>
        <!--当前位置-->
        </div>
        <form action="" method="post">
            <div class="xjhy">
                <ul class="hypz gjpz clearfix">
                    <li>
                        <span class="title">姓名：</span>
                        <div class="li_r">
                            <P name="sname">${sname}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">性别：</span>
                        <div class="li_r">
                            <P>${ssex}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">出生日期：</span>
                        <div class="li_r">
                            <P>${sbirthday}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">籍贯：</span>
                        <div class="li_r">
                            <P>${splace}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">系别：</span>
                        <div class="li_r">
                            <P>${sdepartment}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">班级：</span>
                        <div class="li_r">
                            <P>${sclass}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">学号：</span>
                        <div class="li_r">
                            <P>${sid}</P>
                        </div>
                    </li>
                    <li>
                        <span class="title">入学日期：</span>
                        <div class="li_r">
                            <P>${sinschool}</P>
                        </div>
                    </li>
                </ul>

            </div>
        </form>
    </div>
</div>
</body>
</html>
