<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
    <thead>
    <tr>
        <td>Full Name</td>
        <td>User Name</td>
        <td>DOB</td>
        <td>Mobile</td>
        <td>Email</td>
        <td>Photo</td>
    </tr>
    </thead>


    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <c:out value="${user.fullName}"/>
            </td>
            <td>
                <c:out value="${user.userName}"/>
            </td>
            <td>
                <fmt:formatDate value="${user.dateOfBirth}" pattern="dd-MM-yyyy"/>
                <%--<c:out value="${user.dateOfBirth}"/>--%>
            </td>

            <td>
                <c:out value="${user.mobile}"/>
            </td>

            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.imageString=='noimage'}">
                        No Image
                    </c:when>
                    <c:otherwise>
                        <img class="img-responsive" src="data:image/jpg;base64,${user.imageString}" alt="Image not found" height="40" width="40"/>
                    </c:otherwise>
                </c:choose>
          </td>

        </tr>
    </c:forEach>

</table>
