<%-- 
    Document   : index
    Created on : Apr 20, 2013, 4:37:20 PM
    Author     : Wesley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home page</h1>
        <h2> ${msg.welcome}</h2>
        <h3> Today is ${msg.today}</h3>
        
        <a href="Book">Book</a>
        
    </body>
</html>
