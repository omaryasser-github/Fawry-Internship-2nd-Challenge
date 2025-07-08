package models;


public class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, String author, int year, double price, String fileType) {
        super(ISBN, title, author, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}

