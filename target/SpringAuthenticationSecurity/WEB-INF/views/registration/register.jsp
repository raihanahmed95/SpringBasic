<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18/02/2015
  Time: 04:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form commandName="userEntity" method="POST">
    <form:input path="id" type="hidden" id="id"/>
    <div class="form-group">
    <div class="row">
    <div class="col-md-2 col-md-offset-4">
        <label>
            User Name
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="username" id="username"/>
            <br/>
        <form:errors path="username" cssClass="errors"/>
    </div>
    </div>
        <br/>
    <div class="row">
    <div class="col-md-2 col-md-offset-4">

        <label>
            New Password
        </label>
    </div>

    <div class="col-md-4">
        <form:password path="password" id="password"/>
        <form:errors path="password" cssClass="errors"/>
        <b>${message}<b/>
    </div>
    </div>
        <br/>
    <div class="row">
    <div class="col-md-4 col-md-offset-6">
        <input type="submit" class="btn btn-info active" value="Register"/>
    </div>
</div>
</div>
</form:form>
