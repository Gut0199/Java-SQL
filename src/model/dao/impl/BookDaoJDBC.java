package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.BookDao;
import model.entities.Book;

public class BookDaoJDBC implements BookDao {

    private Connection conn;

    public BookDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inset(Book obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inset'");
    }

    @Override
    public void update(Book obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Book selectById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public List<Book> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }
    
}
