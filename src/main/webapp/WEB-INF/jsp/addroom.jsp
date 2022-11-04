<%-- 
    Document   : addroom
    Created on : Sep 23, 2022, 3:16:22 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center">THÊM PHÒNG</h1>
<c:url value="/addroom" var="action"/>
<form:form method="post" action="${action}" modelAttribute="rooms" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="roomName">Tên phòng</label>
        <form:input  type="text" id="roomName" path="roomName" class="form-control"/>
        <form:errors path="roomName" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="cost">Giá tiền </label>
        <form:input  type="text" id="cost" path="cost" class="form-control"/>
        <form:errors path="cost" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh đại diện</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
        <form:errors path="file" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="soluong">Số lượng </label>
        <form:input  type="text" id="soluong" path="soluong" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="THÊM" class="btn btn-danger"/>
    </div>
</form:form>