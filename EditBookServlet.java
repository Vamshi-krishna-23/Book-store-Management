package com.servlet;




import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.dao.BookDAO;
import com.store.Book;
@WebServlet("/edit")
public class EditBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = BookDAO.getBookById(id);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editBook.jsp");
        dispatcher.forward(request, response);
    }
}
