package com.servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.dao.BookDAO;
@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDAO.deleteBook(id);
        response.sendRedirect("viewBooks.jsp");
    }
}

