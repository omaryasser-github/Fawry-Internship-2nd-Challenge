package models;

public abstract class Book {
    private String ISBN;
    private String title;
    private int year;
    private double price;

    public Book(String ISBN, String title,  int year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public boolean isOutdated(int maxAge) {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year > maxAge;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }


    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}

