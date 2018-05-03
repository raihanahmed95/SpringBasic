<%--
  Created by IntelliJ IDEA.
  User: BS-113-Jahangir
  Date: 3/6/2015
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="j_spring_security_check" name="f" method="POST" class="col-md-offset-5">

    <table>

        <tr>
            <div id="userIdPasswordNotGiven">
                Please enter User ID and Password.
            </div>
            <td>User:</td>
            <td><input type="text" name="j_username" value=""></td>
        </tr>

        <tr>
            <td>Password</td>
            <td><input type="password" name="j_password"></td>
        </tr>

        <tr>
            <td class="btn-group">
                <input type="submit" name="Submit" value="Submit" class="btn btn-success">
                <input type="reset" name="Reset" value="Reset" class="btn btn-primary">
            </td>

        </tr>

        <tr>
            <td align="left" colspan="2">
                <c:if test="${not empty param.error}">
                    <div>
                        <c:out value='${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}'></c:out>
                    </div>
                </c:if>
            </td>
        </tr>
    </table>

</form>