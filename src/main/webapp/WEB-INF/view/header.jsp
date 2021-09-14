<%@ include file="/WEB-INF/view/base.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta content='text/html; charset=UTF-8'>
    <title>${param["title"]}</title>
    <link href="/css/index.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
    <script src="/js/index.js"></script>
</head>
<body>
<div class="body-wrapper">
    <div class="content">
        <div class="title" style="text-align: left; position:relative;">
            <a href="/">BeautyService!!!</a>
            <div style="position: absolute; right: 0px; top: 13px; font-size: 18px; font-weight: bold">
                <a href="/master" style="margin-right: 20px">
                    <fmt:message key="home.master"/>
                </a>
                <a href="/admin" style="margin-right: 50px"><fmt:message key="home.administrator"/></a>
                <%
                    if (session.getAttribute("user") == null) {
                %>
                <a href="/auth/login" style="margin-right: 20px"><fmt:message key="home.login"/></a>
                <a href="/auth/register"><fmt:message key="home.registration"/></a>
                <% } else { %>
                <b>${sessionScope.user.getEmail()}</b>
                <a href="/auth/logout"><fmt:message key="home.logout"/></a>
                <% }%>
            </div>
        </div>
        <div class="menu">
            <%--            <a href="#" class="menu__item">Services</a>--%>
            <%--            <a href="#" class="menu__item">Masters</a>--%>
            <%--            <a href="#" class="menu__item">About Us</a>--%>
            ....................... Foto .......... Slider .......................
            <%@include file="lang.jsp" %>
            <span>${defaultLocale}</span>
        </div>
