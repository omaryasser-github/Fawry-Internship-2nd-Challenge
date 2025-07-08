package models;


public class PaperBook extends Book {
    private int stock;

    public PaperBook(String ISBN, String title, String author, int year, double price, int stock) {
        super(ISBN, title, author, year, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

