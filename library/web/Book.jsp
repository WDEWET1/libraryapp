<%-- 
    Document   : Book
    Created on : May 11, 2013, 10:59:39 PM
    Author     : Wesley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Books page!</h1>
        
        <form action="Insert.jsp">
            <input type="submit" value="Insert a book"/>
        </form>
        
        <br></br>
        
        <form action="Update.jsp">
            <input type="submit" value="Update a book"/>
        </form>
        
        <br></br>
        
        <form action="Delete.jsp">
            <input type="submit" value="Delete a book"/>
        </form>
        
    </body>
</html>
