package model.dao;

import java.util.List;

import model.entities.Book;

public interface BookDao {

    void inset(Book obj);

    void update(Book obj);

    void deleteById(Integer id);

    Book selectById(Integer id);

    List<Book> selectAll();
}
