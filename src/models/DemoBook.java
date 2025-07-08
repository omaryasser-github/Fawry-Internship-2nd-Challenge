package models;

public class DemoBook extends Book {

    public DemoBook(String ISBN, String title,  int year) {
        super(ISBN, title, year , 0.0);
    }

    public boolean isForSale() {
        return false;
    }
}
