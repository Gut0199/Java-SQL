package model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.BookDao;
import model.entities.Book;

public class BookDaoJDBC implements BookDao {

    private Connection conn;

    public BookDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inset(Book obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO books" +
                            "(Title, Author, category, Serie, NumberPages, Publisher, PublicationDate, Isbn10, Isbn13, Price, QuantityStock)"
                            +
                            "VALUE" +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getTitle());
            st.setString(2, obj.getAuthor());
            st.setString(3, obj.getCategory());
            st.setString(4, obj.getSerie());
            st.setInt(5, obj.getNumberPages());
            st.setString(6, obj.getPublisher());
            st.setInt(7, obj.getPublicationDate());
            st.setString(8, obj.getIsbn10());
            st.setString(9, obj.getIsbn13());
            st.setBigDecimal(10, obj.getPrice());
            st.setInt(11, obj.getQuantityStock());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setID(id);
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public void update(Book obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE books SET Title = ?, Author = ?, category = ?, Serie = ?, NumberPages = ?, Publisher = ?, PublicationDate = ?, Isbn10 = ?, Isbn13 = ?, Price = ?, QuantityStock = ? WHERE ID = ?");

            st.setString(1, obj.getTitle());
            st.setString(2, obj.getAuthor());
            st.setString(3, obj.getCategory());
            st.setString(4, obj.getSerie());
            st.setInt(5, obj.getNumberPages());
            st.setString(6, obj.getPublisher());
            st.setInt(7, obj.getPublicationDate());
            st.setString(8, obj.getIsbn10());
            st.setString(9, obj.getIsbn13());
            st.setBigDecimal(10, obj.getPrice());
            st.setInt(11, obj.getQuantityStock());
            st.setInt(12, obj.getID());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement("DELETE FROM books WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("No rows affected. No book found with Id: " + id);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Book selectById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM books WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiateBook(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    private Book instantiateBook(ResultSet rs) throws SQLException {

        Integer ID = rs.getInt("ID");
        String title = rs.getString("Title");
        String author = rs.getString("Author");
        String category = rs.getString("Category");
        String serie = rs.getString("Serie");
        Integer numberPages = rs.getInt("NumberPages");
        String publisher = rs.getString("Publisher");
        Integer publicationDate = rs.getInt("PublicationDate");
        String isbn10 = rs.getString("Isbn10");
        String isbn13 = rs.getString("Isbn13");
        BigDecimal price = rs.getBigDecimal("Price");
        Integer quantityStock = rs.getInt("QuantityStock");

        return new Book(ID, title, author, category, serie, numberPages, publisher,
                publicationDate, isbn10, isbn13, price, quantityStock);
    }

    @Override
    public List<Book> selectAll() {
        List<Book> bookList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM books");
            rs = st.executeQuery();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return bookList;
    }
}
