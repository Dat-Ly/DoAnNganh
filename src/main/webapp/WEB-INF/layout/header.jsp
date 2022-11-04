<%-- 
    Document   : header
    Created on : Aug 9, 2022, 11:41:07 AM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Danh sách phòng</a>
        </li> 
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/customer" />">Danh sách người thuê</a>   
        </li> 
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/thongke" />">Thống kê doanh thu</a>   
        </li> 
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/room" />">Quản lí phòng</a>   
        </li> 
    </ul>
</nav>