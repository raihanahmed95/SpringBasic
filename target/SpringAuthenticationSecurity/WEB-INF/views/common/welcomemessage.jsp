<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <h4>Logged in as: <sec:authentication property="principal.username"/></h4>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <h4>Please login to get access !</h4>
</sec:authorize>
