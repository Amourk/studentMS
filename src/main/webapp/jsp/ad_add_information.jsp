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
                    <a href="">录入信息</a>
                </div>
                <!--当前位置-->
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--新建会议-->
            <form action="/add_information" method="post">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" >
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <input class="chang" name="sex" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">学号：</span>
                            <div class="li_r">
                                <input class="chang" name="id" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">班级：</span>
                            <div class="li_r">
                                <input class="chang" name="class" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">系别：</span>
                            <div class="li_r xial">
                                <div class="xial_w">
                                    <div class="xial_m">
                                        <select class="form-control" name="select">
                                            <option>软件工程</option>
                                            <option>网络工程</option>
                                            <option>计算机科学技术</option>
                                        </select>
                                        <%--<input class="duan" name="" type="text">--%>
                                        <%--<span>&nbsp;</span>--%>
                                    </div>
                                    <%--<ul class="xl_ctn">--%>
                                        <%--<li>4</li>--%>
                                        <%--<li>5</li>--%>
                                    <%--</ul>--%>
                                </div>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">籍贯：</span>
                            <div class="li_r">
                                <input class="chang" name="place" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">入学时间：</span>
                            <div class="li_r">
                                <div id="zz" style="width: 350px">
                                <input class="chang" name="rx_n" type="text" style="width: 70px">
                                    <i>年</i>
                                    <input class="chang" name="rx_y" type="text" style="width: 70px">
                                    <i>月</i>
                                    <input class="chang" name="rx_r" type="text" style="width: 70px">
                                    <i>日</i>
                                <i>*</i>
                                </div>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">出生日期：</span>
                            <div class="li_r">
                                <div id="zzz" style="width: 350px">
                                    <input class="chang" name="cs_n" type="text" style="width: 70px">
                                    <i>年</i>
                                    <input class="chang" name="cs_y" type="text" style="width: 70px">
                                    <i>月</i>
                                    <input class="chang" name="cs_r" type="text" style="width: 70px">
                                    <i>日</i>
                                    <i>*</i>
                                </div>
                            </div>
                        </li>
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

