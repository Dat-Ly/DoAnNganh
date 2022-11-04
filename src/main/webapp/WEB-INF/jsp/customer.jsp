<%-- 
    Document   : customer
    Created on : Sep 25, 2022, 2:45:59 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Nhập khách thuê cần tìm"/>
        </div>
        <div class="col-md-1">
            <input type="submit" value="Tìm kiếm"  class="btn btn-primary"/>
        </div>

    </div>

</form>

<div class="table-responsive">            
    <table class="table table-striped">

        <tr>
            <th>Mã</th>
            <th>Tên người thuê</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Mã phòng</th>
        </tr>

        <c:forEach var="cus" items="${customers}">
            <tr>
                <td>${cus.idCustomer}</td>
                <td>${cus.name}</td>
                <td>${cus.phone}</td>
                <td>${cus.email}</td>
                <td>${cus.idRoom.idRoom}</td>
                <td>
                    <div>
                        <a href="<c:url value="/del/${cus.idCustomer}/${cus.idRoom.idRoom}"/>" class="btn btn-danger">Xóa</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="<c:url value="/update/${cus.idCustomer}"/>" class="btn btn-danger">Sửa</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="<c:url value="/bill/${cus.idCustomer}"/>" class="btn btn-danger">Thanh toán</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
