package models;

public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, String author, int year) {
        super(ISBN, title, author, year , 0.0);
    }

    public boolean isForSale() {
        return false;
    }
}
