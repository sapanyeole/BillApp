<%-- 
    Document   : showAllStudents
    Created on : Sep 6, 2017, 11:38:43 AM
    Author     : kkannao
--%>

<%@page import="com.app.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <c:url value="${saveAction}" var="action"/>
        <form:form action="${action}" commandName="student">
        <table>
            <tr>
                <td>
                    Roll No
                </td>
                <td>
            <form:input path="rollNo" />
            </td>
            </tr>
            <tr>
                <td>
                    Name
                </td>
                <td>
            <form:input path="name" />
            </td>
            </tr>
            <tr>
                <td>
                    Age
                </td>
                <td>
            <form:input path="age" />
            </td>
            </tr>
            <tr>
                <td>
                    City
                </td>
                <td>
            <form:input path="city" />
            </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="save"/>
                </td>
            </tr>
        </table>
    </form:form>

    <center>
        <table cellpadding="5" cellspacing="5" border="1" >
            <tr>
                <th>Roll No</th>
                <th>Name</th>
                <th>Age</th>
                <th>City</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach  var="student" items="${lstStudent}">
                <tr>
                    <td><c:out value="${student.rollNo}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.age}" /></td>
                    <td><c:out value="${student.city}" /></td>
                    <td><a href="<%= request.getContextPath()%>/students/edit/${student.rollNo}">Edit</a></td>
                    <td><a href="<%= request.getContextPath()%>/students/delete/${student.rollNo}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
