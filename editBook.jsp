<%@ page import="com.store.Book" %>
<%
    Book book = (Book) request.getAttribute("book");
%>
<html>
<head>
<title>Edit Book</title>
<link rel="stylesheet" href="css/style.css">


</head>
<body>
    <h2>Edit Book</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= book.getId() %>"/>
        Title: <input type="text" name="title" value="<%= book.getTitle() %>"/><br/>
        Author: <input type="text" name="author" value="<%= book.getAuthor() %>"/><br/>
        Price: <input type="text" name="price" value="<%= book.getPrice() %>"/><br/>
        <input type="submit" value="Update Book"/>
    </form>
    <a href="viewBooks.jsp">Back to List</a>
</body>
</html>
