<%@ include file="/WEB-INF/view/base.jspf" %>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>

<h1>Register</h1>
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
<form>
    <div class="container">
        <label>First Name : </label>
        <input type="text" placeholder="First Name" name="first-name" required>
        <label>Email : </label>
        <input type="text" placeholder="Last Name" name="last-name" required>
        <label>Email : </label>
        <input type="text" placeholder="Enter Email" name="email" required>
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <label>Password Again : </label>
        <input type="password" placeholder="Enter Password Again" name="password2" required>
        <button type="submit">R e g i s t e r</button>
        <%--        <input type="checkbox" checked="checked"> Remember me--%>
        <%--        <button type="button" class="cancelbtn"> Cancel</button>--%>
        <%--        Forgot <a href="#"> password? </a>--%>
    </div>
</form>

<%@include file="../footer.jsp" %>