<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2018/4/23
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>终端召集会议模板</title>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/thems.css">
    <script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
    <script src="https://www.imooc.com/static/lib/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            ${flag}
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

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <!--会议列表-->
        <div class="hy_list">
            <div class="box_t">
                <span class="name">管理员</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="jsp/Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">管理员</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">活动管理</a>
                </div>
                <!--当前位置-->
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--新建会议-->
            <form action="/add_activity" method="post">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">学号：</span>
                            <div class="li_r">
                                <input class="chang" name="id" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">具体活动：</span>
                            <div class="li_r">
                                <input class="chang" name="activity" type="text" style="width: 450px">
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">创新加分：</span>
                            <div class="li_r">
                                <input class="chang" name="cxf" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">综测加分：</span>
                            <div class="li_r">
                                <input class="chang" name="zcf" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <%--<li class="clearfix">--%>
                            <%--<span class="title">出生日期：</span>--%>
                            <%--<div class="li_r" >--%>
                                <%--<input class="chang" name="" type="text">--%>
                                <%--<i>*</i>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <li class="tj_btn">
                            <div id="aa" style="margin-left: 100px">
                                <button type="submit">保存</button>
                            </div>
                            <%--<a href="/add_information">保存</a>--%>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
            <!--新建会议-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>

