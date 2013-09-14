<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <strong>List of books</strong>
            </h1>
            <table>
                <?php
                    foreach($books as book): ?>
                        <tr>
                            <td><?php echo $book; ?></td>
                        </tr>
                <?php endforeach; ?>        
            </table>
        </form>
    </body>
</html>
