<%-- 
    Document   : index
    Created on : Apr 20, 2013, 4:37:20 PM
    Author     : Wesley
--%>
<jsp:include page="header/include.jsp" />

<body>
    <h1 class="header">Hello World!</h1>
    <h2> ${msg.welcome}</h2>
    <h3> Today is ${msg.today}</h3>
    <button class="btn btn-large btn-block btn-primary" type="button">This is The Landing Page for the Application Menu</button>

<center>
    <button class="btn btn-success btn-large" type="button"><a href="form">Create book</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="courses">List books</a></button>
</center>


</body>

<jsp:include page="footer/include.jsp" />