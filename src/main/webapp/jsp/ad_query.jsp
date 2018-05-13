<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2017/12/7
  Time: 19:55
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
    <script type="text/javascript" src="jsp/Assets/js/jquery-1.6.4.js"></script>
    <script type="text/javascript">
        $(function(){
            ${flag}
            //$('.list_hy').css('width',search_w+'px');
            //自适应屏幕宽度
            window.onresize=function(){ location=location };
            var main_h = $(window).height();

            $('.hy_list').css('height',main_h-45+'px');
            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
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
                <span class="name">管理员</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="jsp/Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">管理员</a>
                    <span><img src="jsp/Assets/images/icon3.png" alt=""/></span>
                    <a href="">查询</a>
                </div>
                <!--当前位置-->
            </div>
            <!--查询-->
            <form action="/querybyid" method="post">
            <div class="search">
                <span>按学号查询：</span>
                <div class="s_text"><input name="sid" type="text"></div>
                <button type="submit">查询</button>
                <%--<a href="/querybyid" class="btn">查询</a>--%>
            </div>
            </form>
            <!--查询-->
            <div class="space_hx">&nbsp;</div>
            <!--查询-->
            <form action="/querybyname" method="post">
            <div class="search">
                <span>按姓名查询：</span>
                <div class="s_text"><input name="sname" type="text"></div>
                <button type="submit">查询</button>
                <%--<a href="/querybyname" class="btn">查询</a>--%>
            </div>
            </form>
            <!--查询-->
            <%--<form action="/querybyname" method="post">--%>
                <%--<div class="search">--%>
                    <%--<span>按班级查询：</span>--%>
                    <%--<div class="s_text">--%>
                        <%--<div id="zz">--%>
                        <%--<select class="form-control" name="select" style="float: left">--%>
                            <%--<option>软件工程</option>--%>
                            <%--<option>网络工程</option>--%>
                            <%--<option>计算机科学技术</option>--%>
                        <%--</select>--%>
                        <%--<input class="chang" name="cc" type="text" style="width: 30px ; float: left" >--%>
                    <%--<button onclick="zz()" type="submit" style="float: right">查询</button>--%>
                        <%--</div>--%>
                    <%--&lt;%&ndash;<a href="/querybyname" class="btn">查询</a>&ndash;%&gt;--%>
                <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
            <div class="space_hx">&nbsp;</div>
        </div>
    </div>
</div>

</body>
</html>
