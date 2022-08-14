<%-- 
    Document   : login
    Created on : Aug 9, 2022, 11:45:13 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang đăng nhập</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet"/>
    </head>
    <body>
        <form action="/action_page.php">
            <h1>ĐĂNG NHẬP</h1>
            <div class="mb-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
            </div>

            <div class="mb-3">
                <label for="username" class="form-label">Tên đăng nhập:</label>
                <input type="text" class="form-control" id="usn" placeholder="Enter name" name="username">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
            </div>

            <div class="mb-3">
                <label for="role" class="form-label">Chức vụ:</label>
                <select class="form-select">
                    <option class="admin">Admin</option>
                    <option class="doctor">Bác sĩ</option>
                    <option class="nurse">Y tá</option>
                    <option class="patient">Bệnh nhân</option>
                </select>
            </div>

            <div class="form-check mb-3">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> Remember me
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>


