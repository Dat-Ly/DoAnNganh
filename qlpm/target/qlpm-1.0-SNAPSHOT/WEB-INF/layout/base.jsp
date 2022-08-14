<%-- 
    Document   : base
    Created on : Aug 9, 2022, 11:43:38 AM
    Author     : Kyoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="<c:url value="/css/style.css" />" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>
            <tiles:insertAttribute name = "title"/>
        </title>
    </head>
    <body>
        <div class="container">
            <!-- HEADER -->
            <tiles:insertAttribute name = "header"/>
            <!-- CONTENT -->
            <tiles:insertAttribute name = "content"/>
            <!-- FOOTER -->
            <tiles:insertAttribute name = "footer"/>
        </div>
    </body>
</html>
