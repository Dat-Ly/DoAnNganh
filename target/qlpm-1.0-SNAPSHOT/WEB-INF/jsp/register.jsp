<%-- 
    Document   : register
    Created on : Aug 9, 2022, 11:45:44 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký người dùng</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet"/>
    </head>
    <body>
<!--        <form action="upload.php" method="post" enctype="multipart/form-data" class="image-form">
            <label>Chọn ảnh đại diện:</label>
            <input type="file" name="fileToUpload" id="fileToUpload"><br>
            <input type="submit" value="Upload Image" name="submit">
        </form>-->
        <form action="/action_page.php" class="content-form">
            <h1>ĐĂNG KÝ</h1>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
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
                    <option class="patient">Bệnh nhân</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="avatar" class="form-label">Avatar:</label>
                <input type="file" class="form-control" id="avatar" name="avatar">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
