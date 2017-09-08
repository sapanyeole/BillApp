<%-- 
    Document   : home
    Created on : Sep 5, 2017, 10:56:36 AM
    Author     : kkannao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello from controller </h1>
        message ${student.name} <br/>
        
        <a href="<%= request.getContextPath() %>/students/all">link</a><br/>
        <a href="<%= request.getContextPath() %>/students/form">Add Student</a><br/>
        
    </body>
</html>
