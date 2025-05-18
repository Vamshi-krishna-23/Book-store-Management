<%@ page import="java.util.*,com.dao.BookDAO,com.store.Book" %>
<html>
<head>
<title>Books List</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
    <h2>Books List</h2>
    <a href="addBook.jsp">Add Book</a><br/><br/>
    <table border="1">
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
        <%
            List<Book> list = BookDAO.getAllBooks();
            for(Book b : list){
        %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getAuthor() %></td>
                <td><%= b.getPrice() %></td>
                <td>
                    <a href="edit?id=<%= b.getId() %>">Edit</a> |
                    <a href="delete?id=<%= b.getId() %>">Delete</a>
                </td>
            </tr>
        <% } %>
    </table>
</body>
</html>
