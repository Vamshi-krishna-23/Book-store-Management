package com.servlet;




import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.dao.BookDAO;
import com.store.Book;
@WebServlet("/add")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book(0, title, author, price);
        BookDAO.addBook(book);
        response.sendRedirect("viewBooks.jsp");
    }
}

