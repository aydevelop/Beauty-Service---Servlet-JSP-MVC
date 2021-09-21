<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='registration' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="text-align: center; margin-top: 30px">
    <h1><fmt:message key="registration"/></h1>
</div>
<br/>

<style>
    Body {
        font-family: Calibri, Helvetica, sans-serif;
    }

    button {
        background-color: #4CAF50;
        width: 100%;
        color: black;
        padding: 15px;
        margin: 10px 0px;
        border: none;
        cursor: pointer;
    }

    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text], input[type=password] {
        width: 100%;
        margin: 8px 0;
        padding: 12px 20px;
        display: inline-block;
        border: 2px solid green;
        box-sizing: border-box;
    }

    button:hover {
        opacity: 0.7;
    }

    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        margin: 10px 5px;
    }


    .container {
        padding: 25px;
        background-color: lightblue;
    }
</style>
<form method="post" action="/auth/register">
    <div class="container">
        <label><fmt:message key="first_name"/> : </label>
        <input type="text" placeholder="<fmt:message key="first_name"/>" name="first-name" value="${sessionScope.registerFirstName}"
               required>
        <label><fmt:message key="last_name"/> : </label>
        <input type="text" placeholder="<fmt:message key="last_name"/>" name="last-name" value="${sessionScope.registerLastName}" required>
        <label>Email : </label>
        <input type="text" placeholder="Email" name="email" value="${sessionScope.registerEmail}" required>
        <label><fmt:message key="password"/> : </label>
        <input type="password" placeholder="<fmt:message key="password"/>" name="password" required>
        <button type="submit"><fmt:message key="registration"/></button>
        <%--        <input type="checkbox" checked="checked"> Remember me--%>
        <%--        <button type="button" class="cancelbtn"> Cancel</button>--%>
        <%--        Forgot <a href="#"> password? </a>--%>
    </div>
</form>

<%@include file="../../fragment/footer.jspf" %>