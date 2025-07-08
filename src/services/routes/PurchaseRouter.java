package services.routes;

import interfaces.IPaperbookHandler;
import interfaces.IEbookHandler;
import models.*;

public class PurchaseRouter {

    private IPaperbookHandler paperHandler;
    private IEbookHandler ebookHandler;

    public PurchaseRouter(IPaperbookHandler paperHandler, IEbookHandler ebookHandler) {
        this.paperHandler = paperHandler;
        this.ebookHandler = ebookHandler;
    }

    public double purchase(Book book, int quantity, String email, String address) {

        if (book == null)
            throw new IllegalArgumentException("Quantum Bookstore: Book cannot be null.");

        if (book instanceof DemoBook)
            throw new UnsupportedOperationException("Quantum Bookstore: Demo books are not for sale.");

        if (book instanceof PaperBook paperBook) {
            return paperHandler.purchase(paperBook, quantity, address);
        }

        if (book instanceof EBook ebook) {
            return ebookHandler.purchase(ebook, quantity, email);
        }

        throw new UnsupportedOperationException("Quantum Bookstore: Unsupported book type.");
    }
}
