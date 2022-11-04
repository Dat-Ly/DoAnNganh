<%-- 
    Document   : addcustomer
    Created on : Sep 25, 2022, 3:29:39 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center">THUÊ PHÒNG</h1>
<c:url value="/addcustomer/${idRoom}" var="action"/>
<form:form method="post" action="${action}" modelAttribute="cus">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Tên khách hàng</label>
        <form:input  type="text" id="name" path="name" class="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="phone">Số điện thoại</label>
        <form:input  type="text" id="phone" path="phone" class="form-control"/>
        <form:errors path="phone" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input  type="text" id="email" path="email" class="form-control"/>
        <form:errors path="email" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="idRoom">Mã phòng</label>
        <form:input  type="text" value="${idRoom}"  path="idRoom" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="THUÊ" class="btn btn-danger"/>
    </div>
</form:form>
