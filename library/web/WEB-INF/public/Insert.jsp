<%-- 
    Document   : Insert
    Created on : May 11, 2013, 11:05:20 PM
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
        <h1>Insert book!</h1>
        <br></br>
        <form:form method="post" action="addBook.html">
            <table>
                <tr>
                    <td><form:label path="bookTitle">Book Title</form:label>></td>
                    <td><form:input type="text" path="bookTitle"/></td>
                </tr>
                <tr>
                    <td><form:label path="bookISBN">Book ISBN</form:label>></td>
                    <td><form:input type="text" path="bookISBN"/></td>
                </tr>
                <tr>
                    <td><form:label path="numberOfBooks">Number of books</form:label>></td>
                    <td><form:input type="text" path="numberOfBooks"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                    </td>
                </tr>
            </table>
            <br></br>
            <input type="submit" value="Add book">
        </form>
    </body>
</html>
