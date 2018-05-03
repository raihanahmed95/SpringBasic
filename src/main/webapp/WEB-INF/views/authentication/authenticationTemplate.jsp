<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BS-113-Jahangir
  Date: 3/10/2015
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <tiles:getAsString name="pageTitle" ignore="true"/>
    </title>
    <link type="text/css" rel="stylesheet"
          href='<c:url value="/contents/${applicationVersion}/css/customestyle.css"/>'/>
</head>
<body>

<div class="maincontainer">

    <!-- Insert Hearder -->
    <div class="mainheader">
        <tiles:insertAttribute name="header"/>
    </div>


    <!-- Insert common top menu -->

    <div class="tommenu">
        <tiles:insertAttribute name="topMenu"/>
    </div>

    <!-- Insert common welcome message -->
    <div class="welcomemessage">
        <tiles:insertAttribute name="welcomeMessage"/>
    </div>

    <!-- Insert main content -->
    <div class="bodycontent">
        <tiles:insertAttribute name="content"/>
    </div>

    <!-- Insert footer -->

    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

</body>
</html>
