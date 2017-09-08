<%-- 
    Document   : addStudent
    Created on : Sep 6, 2017, 2:14:43 PM
    Author     : kkannao
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add student</title>
    </head>
    <body>
        <h1>Form</h1>

        <c:url var="addAction" value="/students/save" ></c:url>

        <form:form action="${addAction}" commandName="student">
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




    </body>
</html>
