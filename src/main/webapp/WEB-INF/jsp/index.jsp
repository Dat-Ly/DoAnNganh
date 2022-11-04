<%-- 
    Document   : index
    Created on : Aug 9, 2022, 11:39:42 AM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center">DANH SÁCH PHÒNG</h1>
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Nhập phòng cần tìm"/>
        </div>
        <div class="col-md-1">
            <input type="submit" value="Tìm kiếm"  class="btn btn-primary"/>
        </div>

    </div>

</form>

<div>
    
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/8)}" var="i">
            <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${i}">${i}</a></li>
        </c:forEach>
        
    </ul>
</div>
    
    <div class="row"> 

        <c:forEach var="r" items="${rooms}">
            <div class="card col-md-3">
                <div class="card-body">
                    <img class="img-fluid" src="${r.avatar}">
                </div>
                <div class="card-footer">
                    <h3>${r.roomName}</h3>
                    <h5>Trạng thái: ${r.trangthai}</h5>
                    <h5>Số lượng: ${r.soluong}</h5>
                    <p>${r.cost} VND</p>
                </div>
                    <div>
                        <div>
                            <a href="<c:url value="/addcustomer/${r.idRoom}"/>" class="btn btn-warning">Cho thuê</a>
                        </div>
                    </div>
            </div>

        </c:forEach>
    </div>  
