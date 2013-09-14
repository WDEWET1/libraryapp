<%-- 
    Document   : book-result
    Created on : Aug 20, 2013, 11:03:21 AM
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
        <form action="/library" method="POST">
            <h1>
                <strong>${msg}</strong>
            </h1>
            <table>
                <tr>
                    <td>Book title</td>
                    <td><input type="text" value="${book.bookTitle}"></td>
                </tr>
                <br>
                <tr>
                    <td>Book ISBN</td>
                    <td><input type="text" value="${book.isbn}"></td>
                </tr>
                <br>
                <tr>
                    <td>Number of books</td>
                    <td><input type="text" value="${book.numberOfBooks}"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
