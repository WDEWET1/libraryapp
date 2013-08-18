<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header/include.jsp" />

<body>

    <button class="btn btn-large btn-block btn-primary" type="button">This is The Landing Page for the Application Menu</button>

<center>
    <button class="btn btn-success btn-large" type="button"><a href="/marksapp">Home</a></button>
    <button class="btn btn-success btn-large" type="button"><a href="courseform">Create Book</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="courses">List Books</a></button>
</center>
<p></p>
<center>
    <table class="table table-hover">
        <caption> <h2>The Books </h2></caption>
        <thead>
            <tr>
                <th>Book title</th>
                <th>Book ISBN</th>
                <th>Edit 
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseCode} </td>
                    <td><a href="editcourseform?id=${course.id}"> Edit </a></td>
                    <td><a href="deletecourse?coursecodeId=${course.id}"> Delete </a></td>
                </tr>

            </c:forEach>

        </tbody>


    </table>

</center>

</body>

<jsp:include page="../footer/include.jsp" />
