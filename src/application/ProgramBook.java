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

        newBook.setTitle("Lógica de Programação e Algoritmos com JavaScript 2ª Edição");
        newBook.setAuthor("Edécio Fernando lepsen");
        newBook.setCategory("Education");
        newBook.setSerie("Lógica de Programação e Algoritmos com JavaScript");
        newBook.setNumberPages(352);
        newBook.setPublisher("Novatec Editora");
        newBook.setPublicationDate(2022);
        newBook.setIsbn10("9786586057904");
        newBook.setIsbn13("6586057906");
        newBook.setPrice(BigDecimal.valueOf(79.49));
        newBook.setQuantityStock(100);

        bookDao.inset(newBook);
        System.out.println("New Book inserted with successfully! Id: " + newBook.getID());

        System.out.println("===== TEST 1.2: Book UPDATE INTO Books =====");
        Book selectBook = bookDao.selectById(2);
        selectBook.setIsbn10("6586057906");
        selectBook.setIsbn13("9786586057904");
        bookDao.update(selectBook);
        System.out.println("Update completed!");
    }
}
