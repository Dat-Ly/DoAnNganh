<%-- 
    Document   : listbill
    Created on : Oct 14, 2022, 2:34:05 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center">DANH SÁCH HÓA ĐƠN</h1>
<div class="table-responsive">            
    <table class="table table-striped">

        <tr>
            <th>Mã hóa đơn</th>
            <th>Mã phòng</th>
            <th>Mã khách hàng</th>
            <th>Ngày tạo</th>
            <th>Tiền điện</th>
            <th>Tiền nước</th>
            <th>Tiền phòng</th>
            <th>Tổng tiền</th>
        </tr>

        <c:forEach var="bill" items="${bill}">
            <tr>
                <td>${bill.idBill}</td>
                <td>${bill.idRoom.idRoom}</td>
                <td>${bill.idCustomer.idCustomer}</td>
                <td>${bill.createDate}</td>
                <td>${bill.tienDien}</td>
                <td>${bill.tienNuoc}</td>
                <td>${bill.tienPhong}</td>
                <td>${bill.total}</td>
                <td>
                    <div>
                        <a href="<c:url value="/bill/pdf/${bill.idBill}"/>" class="btn btn-danger">IN</a>
                    </div>
                </td>
               
            </tr>
        </c:forEach>
    </table>
</div>