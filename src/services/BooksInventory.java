package services;

import models.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BooksInventory {
    private List<Book> books;

    public BooksInventory() {
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
        System.out.println("Quantum Bookstore: Book added : " + book.getTitle());
    }


    public List<Book> removeOutdatedBooks(int maxAge) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isOutdated(maxAge)) {
                removedBooks.add(book);
                iterator.remove();
            }
        }

        return removedBooks;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void printAllBooks() {
        System.out.println("Quantum Bookstore: Inventory List:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " | " + book.getISBN());
        }
    }
}
