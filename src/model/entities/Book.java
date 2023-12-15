package model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    // private String title, author, category, serie, publisher, isbn10, isbn13;
    // private Integer ID, numberPages, publicationDate, quantityStock;
    // private Double price;

    private Integer ID;
    private String title;
    private String author;
    private String category;
    private String serie;
    private Integer numberPages;
    private String publisher;
    private Integer publicationDate;
    private String isbn10;
    private String isbn13;
    private BigDecimal price;
    private Integer quantityStock;

    public Book() {
    }

    public Book(Integer iD, String title, String author, String category, String serie, Integer numberPages, String publisher,
            Integer publicationDate, String isbn10, String isbn13, BigDecimal price, Integer quantityStock) {
        ID = iD;
        this.title = title;
        this.author = author;
        this.category = category;
        this.serie = serie;
        this.numberPages = numberPages;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [ID=" + ID + ", title=" + title + ", author=" + author + ", category=" + category + ", serie="
                + serie + ", numberPages=" + numberPages + ", publisher=" + publisher + ", publicationDate="
                + publicationDate + ", isbn10=" + isbn10 + ", isbn13=" + isbn13 + ", price=" + price
                + ", quantityStock=" + quantityStock + "]";
    }

}
