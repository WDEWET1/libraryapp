<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 
    Document   : page
    Created on : Aug 19, 2013, 9:11:53 AM
    Author     : Wesley
--%>
<body>
    <div id="container" style="width:1360px">
        <div id="header" style="background-color: #99FF00;">
            <font color="0000FF"><h1 style="margin-bottom:0;">Library</h1></font></div></div>
            
        <div id="menu" style="background-color: #99FF00; height:600px; width: 220px; float: left;">
            
        <b><font color="0000FF"><strong>Menu</strong></font></b><br><br>
        
        <a href="updateBook.html">Update Book</a><br>
        <a href="deleteBook.html">Delete Book</a><br>
        <a href="viewBooks.html">View Books</a><br>
        <a href="/library">Back</a><br>
        </div>
    
    <div id="content" style="background-color: #0066FF; height: 600px; width: 1112px; float: left;">
            
        <strong>Please fill in text boxes below </strong>
        <br><br>
            <form:form method="post" action="book-result">
                <table>
                    <tr>
                        <td><label path="bookTitle">Book Title</label></td>
                        <td><input path="bookTitle" id="bookTitle" name="bookTitle"/></td>
                    </tr>
                 
                     <tr>
                        <td><label path="isbn">ISBN</label></td>
                        <td><input path="isbn" id="isbn" name="isbn"/></td>
                    </tr>
                    
                    <tr>
                        <td><label path="numberOfBooks">Number of books</label></td>
                        <td><input path="numberOfBooks" id="numberOfBooks" name="numberOfBooks"/></td>
                    </tr> 
                    <tr>
                        <br>
                        <td><input type="submit" value="Submit" name="submit"/></td>
                    </tr> 
                </table>
            </form:form>        
        </div>
        <div id="footer" style="background-color: #0066FF; clear: both; text-align: center;">
            <font color="0000FF">Wesley De Wet</font>
        </div>
    </body>
