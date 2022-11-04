<%-- 
    Document   : bill
    Created on : Oct 8, 2022, 3:54:52 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/bill/${idCustomer}/${cus.idRoom.idRoom}" var="action"/>
<h1 class="text-center">THANH TOÁN</h1>
<form:form method="post" action="${action}" modelAttribute="bills" >
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label>Lượng điện tiêu thụ</label>
        <div class="row">
            <div class="col-md-11">
                <input type="text" id="Evalue1" class="form-control"placeholder="Nhap luong dien"/>
            </div>
            <div class="col-md-1">
                <input type="button" class="btn btn-danger" value="Tính" onclick="equalDien()"/>
            </div>
        </div>    
    </div>
    <div>
        <label>Tiền điện:</label>
        <form:input type="text" path="tienDien" id="result1" value="" cssClass="form-control "/>
        <form:errors path="tienDien" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label>Lượng nước tiêu thụ</label>
        <div class="row">
            <div class="col-md-11">
                <input type="text" id="Evalue2" class="form-control"placeholder="Nhap luong nuoc"/>
            </div>
            <div class="col-md-1">
                <input type="button" class="btn btn-danger" value="Tính" onclick="equalNuoc()"/>
            </div>
        </div>    
    </div>
    <div>
        <label>Tiền nước:</label>
        <form:input type="text" path="tienNuoc" id="result2" value=""  cssClass="form-control "/>
        <form:errors path="tienNuoc" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="idRoom">Mã khách hàng</label>
        <form:input  type="text" value="${idCustomer}"  path="idCustomer" class="form-control"/>
    </div>
        
    <div class="form-group">
        <label>Tiền phòng</label>
        <form:input type="text" path="tienPhong" value="${cus.idRoom.cost}" id="result3" cssClass="form-control"/>
    </div>
    


    <div class="form-group">
        <label for="name">Mã phòng</label>
        <form:input  type="text" id="name" path="idRoom" value="${cus.idRoom.idRoom}" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="button" class="btn btn-danger" value="Tính" onclick="equalTotal()"/>
        <form:input type="text" path="total" id="results" value="" cssClass="form-control"/>
        <form:errors path="total" cssClass="alert alert-danger" element="div"/>
    </div>  
    <div class="form-group">
        <input type="submit" value="THANH TOÁN"  class="btn btn-danger"/>
    </div>

</form:form>
<script>
    
    
    function tinhTienDien(){
        let number1=document.getElementById("Evalue1").value;
        let i=2000;
        let n=number1*i;
        let m=parseFloat(n);
        return m;
        
    }
    function equalDien(){
        document.getElementById("result1").value=tinhTienDien();
    }
    function tinhTienNuoc(){
        let number2=document.getElementById("Evalue2").value;
        let i=1000;
        let n=number2*i;
        let m=parseFloat(n);
        return m;
    }
     function equalNuoc(){
        document.getElementById("result2").value=tinhTienNuoc();
    }

    
    function tinhTongTienPhong(){
        let number3=document.getElementById("result3").value;
        let number=tinhTienDien();
        let numbers=tinhTienNuoc();
        let a=parseFloat(number);
        let b=parseFloat(numbers);
        let c=parseFloat(number3);
        let n= a+b+c;
        let d=eval(n);
        let m =parseFloat(d);
        return m;
    }
    function equalTotal(){
        document.getElementById("results").value=tinhTongTienPhong();
    }
</script>