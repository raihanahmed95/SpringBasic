<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div id="top-menu">--%>
    <%--<ul>--%>
        <%--<li><a href="/home">Home</a></li>--%>
        <%--<li><a href="/projectProfile">Profile</a></li>--%>
        <%--<li><a href="/message">Messages</a></li>--%>
        <%--<c:if test="${pageContext['request'].userPrincipal != null}">--%>
            <%--<li> <a href="<c:url value='j_spring_security_logout'/>" >Logout</a></li>--%>
        <%--</c:if>--%>
    <%--</ul>--%>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">WebSiteName</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <li class="active"><a href="/projectProfile">Project Profile</a></li>
                <li class="active"><a href="/message">Messages</a></li>
                <c:if test="${pageContext['request'].userPrincipal != null}">
                    <li class="active"> <a href="<c:url value='j_spring_security_logout'/>" >Logout</a></li>
                </c:if>
            </ul>
            <%--<button class="btn btn-danger navbar-btn">Button</button>--%>
        </div>
    </nav>
<%--</div>--%>
