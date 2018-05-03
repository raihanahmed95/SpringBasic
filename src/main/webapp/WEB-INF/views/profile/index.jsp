<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
    <h2 class="col-md-offset-4">Lets get started with Java Spring !</h2>
    <div class="col-md-offset-5">
        <sec:authorize access="isAnonymous()">
            <div class="btn-group">
                <input type="button"  onclick="location.href='/register'" value="Register" class="btn btn-info active">
                <input type="button"  onclick="location.href='/login'" value="Login" class="btn btn-info active">
            </div>
        </sec:authorize>
    </div>
</div>


