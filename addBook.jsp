<%@ page language="java" %>
<html>
<head>
<title>Add Book</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
    <h2>Add New Book</h2>
    <form action="add" method="post">
        Title: <input type="text" name="title"/><br/>
        Author: <input type="text" name="author"/><br/>
        Price: <input type="text" name="price"/><br/>
        <input type="submit" value="Add Book"/>
    </form>
    <a href="viewBooks.jsp">Back to List</a>
</body>
</html>
