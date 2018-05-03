<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 23/02/2015
  Time: 04:16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c' %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>

    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico" />

    <title>
        <tiles:getAsString name="pageTitle" ignore="true"/>
    </title>

    <link type="text/css" rel="stylesheet"
          href='<c:url value="/contents/${applicationVersion}/css/customestyle.css"/>'/>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>

<div class="main-container">
    <!-- Insert Hearder -->
    <div class="rows">
        <tiles:insertAttribute name="header"/>
    </div>


    <!-- Insert common top menu -->

    <div class="rows">
        <tiles:insertAttribute name="topMenu"/>
    </div>

    <!-- Insert common welcome message -->
    <div class="rows">
        <tiles:insertAttribute name="welcomeMessage"/>
    </div>

    <br/><br/>
    <!-- Insert main content -->
    <div class="rows">
        <tiles:insertAttribute name="content" />
    </div>

    <br/><br/><br/><br/>
    <!-- Insert footer -->

    <div class="rows">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

</body>
</html>
