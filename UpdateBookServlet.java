package com.servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.dao.BookDAO;
import com.store.Book;
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book(id, title, author, price);
        BookDAO.updateBook(book);
        response.sendRedirect("viewBooks.jsp");
    }
}

