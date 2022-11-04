<%-- 
    Document   : room
    Created on : Oct 19, 2022, 2:38:00 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center">Quản lí phòng</h1>
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="tm" placeholder="Nhập phòng cần tìm"/>
        </div>
        <div class="col-md-1">
            <input type="submit" value="Tìm kiếm"  class="btn btn-primary"/>
        </div>

    </div>

</form>
<div>
    <a href="<c:url value="/addroom"/>" class="btn btn-danger">Thêm</a>
</div>
<div class="table-responsive">            
    <table class="table table-striped">

        <tr>
            <th>Mã phòng</th>
            <th>Tên phòng</th>
            <th>Giá tiền</th>
            <th>Ảnh</th>
            <th>Số lượng</th>
        </tr>

        <c:forEach var="p" items="${roomlist}">
            <tr>
                <td>${p.idRoom}</td>
                <td>${p.roomName}</td>
                <td>${p.cost}</td>
                <td><img style="width: 200px" class="card-img-top" src="${p.avatar}"></td>
                <td>${p.soluong}</td>

                <td>
                    <div>
                        <a href="<c:url value="/delete/${p.idRoom}"/>" class="btn btn-danger">Xóa</a>
                        <a href="<c:url value="/upd/${p.idRoom}"/>" class="btn btn-danger">Cập Nhật</a>
                    </div>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>