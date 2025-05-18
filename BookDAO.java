package com.dao;



import com.store.Book;
import com.store.DBConnection;

import java.sql.*;
import java.util.*;

public class BookDAO {

    public static int addBook(Book book) {
        int status = 0;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO books(title, author, price) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"),
                                  rs.getString("author"), rs.getDouble("price"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Book getBookById(int id) {
        Book book = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getInt("id"), rs.getString("title"),
                                rs.getString("author"), rs.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public static int updateBook(Book book) {
        int status = 0;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteBook(int id) {
        int status = 0;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

