<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2018/4/15
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>模块状态</title>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="jsp/Assets/css/thems.css">
    <script type="text/javascript" src="Assets/js/jquery-1.8.3.min.js"></script>
    <script src="https://www.imooc.com/static/lib/jquery/1.9.1/jquery.js"></script>

    <script type="text/javascript">
        var j =1
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');

            <%--var  html = ${s}--%>
            <%--var div = $(html)--%>
            <%--$table.append(div)--%>
        });

    </script>
    <!--框架高度设置-->
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
                    <a href="">查看异常</a>

                </div>
                <!--当前位置-->
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <form action="" method="post">
                <table cellpadding="0" cellspacing="0" class="list_hy" id="table">
                    <tr>
                        <th scope="col" colspan="2">学生学号</th>
                        <th scope="col">具体异常</th>
                        <th scope="col">异常时间</th>
                    </tr>
                    <%--<tr>--%>
                        <%--<td colspan="2">主控模块</td>--%>
                        <%--<td>正常</td>--%>
                        <%--<td>315_20080610</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td colspan="2">协议栈</td>--%>
                        <%--<td>正常</td>--%>
                        <%--<td>315_20080610</td>--%>
                    <%--</tr>--%>
                    ${html}
                </table>
                <!--列表-->
            </form>
        </div>
        <!--会议列表-->
    </div>
</div>

</body>
</html>
