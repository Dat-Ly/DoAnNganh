<%-- 
    Document   : book
    Created on : Aug 9, 2022, 11:46:10 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký lịch</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet"/>
    </head>
    <body>
        <form action="/action_page.php" class="was-validated">
            <h1>Đặt lịch khám</h1>
            <div class="mb-3">
                <label for="uname" class="form-label">Tên đăng ký lịch khám:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="bookname" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Đề nghị điền thông tin vào đây</div>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Thời gian dự định đến phòng khám:</label>
                <input type="date" class="form-control" id="pwd" placeholder="Enter booking date" name="bookdate" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Đề nghị điền thông tin vào đây</div>
            </div>
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" id="myCheck" name="remember" required>
                <label class="form-check-label" for="myCheck">Tôi khẳng định đây là thông tin chính xác</label>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Đề nghị xác nhận đánh dấu vào ô này</div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
