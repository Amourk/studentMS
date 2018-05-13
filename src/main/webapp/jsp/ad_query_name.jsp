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
    <title>会议列表</title>
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

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>
<body>
<div id="right_ctn">
    <div class="right_m">
        <!--会议列表-->
        <div class="hy_list">
            <div class="box_t">
                <span class="name">查询</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="jsp/Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">信息管理</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">查询</a>
                </div>
                <!--当前位置-->
            </div>
            <!--查询-->
            <div class="search">
                <form action="/querybyname" method="post">
                <span>按姓名查询：</span>
                <div class="s_text"><input name="sname" type="text"></div>
                    <button class="but" type="submit">查询</button>
                <%--<a href="" class="btn">查询</a>--%>
                </form>
            </div>
            <!--查询-->
            <div class="space_hx">&nbsp;</div>
                <div class="xjhy">
                    <ul class="hypz gjpz clearfix">
                        <li>
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <P name="sname">${ssname}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <P>${sssex}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">出生日期：</span>
                            <div class="li_r">
                                <P>${ssbirthday}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">籍贯：</span>
                            <div class="li_r">
                                <P>${ssplace}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">系别：</span>
                            <div class="li_r">
                                <P>${ssdepartment}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">班级：</span>
                            <div class="li_r">
                                <P>${ssclass}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">学号：</span>
                            <div class="li_r">
                                <P>${ssid}</P>
                            </div>
                        </li>
                        <li>
                            <span class="title">入学日期：</span>
                            <div class="li_r">
                                <P>${ssinschool}</P>
                            </div>
                        </li>
                        <li>
                            <form style="float: left" action="/deletebyname">
                                <button type="submit">删除</button>
                            </form>
                            <form style="float: left" action="/updatabyname">
                                <button type="submit">修改</button>
                            </form>
                            <%--<form style="float: left" action="/addgrade">--%>
                                <%--<button type="submit">添加成绩</button>--%>
                            <%--</form>--%>
                        </li>
                    </ul>

                </div>
        </div>
    </div>
</div>

</body>
</html>
