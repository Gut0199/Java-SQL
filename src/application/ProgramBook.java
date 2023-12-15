package application;

import java.math.BigDecimal;

import model.dao.BookDao;
import model.dao.DaoFactory;
import model.entities.Book;

public class ProgramBook {
    public static void main(String[] args) {
        
        BookDao bookDao = DaoFactory.createBookDao();

        System.out.println("===== TEST 1: Book INSERT INTO Books =====");
        Book newBook = new Book();

        newBook.setTitle("Clean Code");
        newBook.setAuthor("Robert C. Martin");
        newBook.setCategory("Education");
        newBook.setSerie("Clean Architecture");
        newBook.setNumberPages(456);
        newBook.setPublisher("Alta Books");
        newBook.setPublicationDate(2008);
        newBook.setIsbn10("8576082675");
        newBook.setIsbn13("9788576082675");
        newBook.setPrice(BigDecimal.valueOf(202.71));
        newBook.setQuantityStock(100);

        bookDao.inset(newBook);
        System.out.println("New Book inserted with successfully! Id: " + newBook.getID());

    }
}
