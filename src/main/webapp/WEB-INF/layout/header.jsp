<%-- 
    Document   : header
    Created on : Aug 9, 2022, 11:41:07 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/register" />">Đăng ký</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/book" />">Đặt lịch</a>
    </ul>
</nav>