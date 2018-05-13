<%--
  Created by IntelliJ IDEA.
  User: 阳瑞
  Date: 2017/12/1
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理系统</title>
    <style>
        body
        {
            scrollbar-base-color:#C0D586;
            scrollbar-arrow-color:#FFFFFF;
            scrollbar-shadow-color:DEEFC6;
        }
    </style>

</head>
<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="jsp/top.jsp" name="topFrame" scrolling="no">
    <frameset cols="225,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
        <frame src="jsp/ad_left.jsp" noresize name="menu" scrolling="yes">
        <frame src="/ad_add_information" class="frame_r" noresize name="main" scrolling="yes">
    </frameset>
</frameset>
<noframes>
    <body>您的浏览器不支持框架！</body>
</noframes>
</html>

