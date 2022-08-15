<%-- 
    Document   : admin
    Created on : Aug 15, 2022, 8:45:22 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Danh sách quản lý người dùng</h1>
<c:forEach var="user" items="${users}">
    <table style="text-align: center">
        <tr>
            <th>Avatar</th>
            <th>Mã nhân viên</th>
            <th>Họ tên</th>
            <th>Chức vụ</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Email</th>
        </tr>
        <tr>
            <td>${user.avatar}</td>
            <td>${user.idUser}</td>
            <td>${user.hoTen}</td>
            <td>${user.chucvu}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
        </tr>
    </table>
    <%--${user.idUser} - ${user.hoTen} - ${user.chucvu} - ${user.username} - ${user.email}--%>

</c:forEach>
<div class="card" style="width:400px">
    <img class="card-img-top" src="img_avatar1.png" alt="Card image">
    <div class="card-body">
        <h4 class="card-title">John Doe</h4>
        <p class="card-text">Some example text.</p>
        <a href="#" class="btn btn-primary">See Profile</a>
    </div>
</div>
<h1>Danh sách quản lý thuốc</h1>
<div class="container mt-3">
    <h2>Hover Rows</h2>
    <p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>            
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
            </tr>
            <tr>
                <td>Mary</td>
                <td>Moe</td>
                <td>mary@example.com</td>
            </tr>
            <tr>
                <td>July</td>
                <td>Dooley</td>
                <td>july@example.com</td>
            </tr>
        </tbody>
    </table>
</div>
<%--<ul>
    <c:forEach var="user" items="${users}">
        <li>
            ${users.id_users} - ${users.hoTen} - ${users.chucVu} - ${users.username} - ${users.password} - ${users.email}
        </li>
    </c:forEach>
</ul> --%>
