<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2018/4/18
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>流服务器</title>
    <link rel="stylesheet" type="text/css" href="Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="Assets/css/thems.css">
    <script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');


        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <!--会议列表-->
        <div class="hy_list">
            <div class="box_t">
                <span class="name">成绩管理</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="Assets/images/icon3.png" alt=""/></span>
                    <a href="">成绩管理</a>
                    <span><img src="Assets/images/icon3.png" alt=""/></span>
                    <a href="">提出异常</a>
                </div>
                <!--当前位置-->
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--终端列表-->
            <%--<form action="" method="post">--%>
                <div class="xjhy">
                    <!--基本配置-->
                    <ul class="hypz">
                        <li class="clearfix" >
                            <span class="title">提出异常：</span>
                            <div class="li_r">
                                <%--<input  name="" type="text" >--%>
                                    <form action="/abnormal" method="post">
                                    <input type="text" name="thing" style="width: 300px"></input>
                                        <%--<textarea name="things"   cols="40"   rows="4"   style="OVERFLOW:   hidden"></textarea>--%>
                                        <button type="submit">提交</button>
                                    <%--<a href="/abnormal">确定</a>--%>
                                    </form>

                                    <%--<a href="/abnormal">确定</a>--%>
                                    <%--<form  action="/abnormal.do" method="post">--%>
                                    <%--<button type="submit" >确定</button>--%>
                                    <%--</form>--%>
                                <%--<i>*</i>--%>
                            </div>
                        </li>
                        <%--<li class="clearfix">--%>
                            <%--<span class="title">IP地址：</span>--%>
                            <%--<div class="li_r">--%>
                                <%--<input  name="" type="text">--%>
                                <%--<i>*</i>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li class="tj_btn">--%>
                            <%--&lt;%&ndash;<a href="" class="back">返回</a>&ndash;%&gt;--%>
                            <%--<a href="">保存</a>--%>
                        <%--</li>--%>
                    </ul>
                    <!--基本配置-->
                </div>
            <%--</form>--%>
            <!--终端列表-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>

