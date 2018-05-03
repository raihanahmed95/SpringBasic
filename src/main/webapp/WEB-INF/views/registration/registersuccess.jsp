<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 19/02/2015
  Time: 05:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-offset-4">
    <h3>Hi <b>${userEntity.username}</b>! ${message}</h3>
</div>

<div class="col-md-offset-6">
    <input type="button"  onclick="location.href='/'" value="Log in now!" class="btn btn-info success">
</div>
