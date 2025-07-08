package services;

import interfaces.IEbookHandler;
import interfaces.IMail;
import models.EBook;

public class PurchaseEbook implements IEbookHandler {

    private IMail mailService;

    public PurchaseEbook(IMail mailService) {
        this.mailService = mailService;
    }

    @Override
    public double purchase(EBook book, int quantity, String email) {
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Quantum Bookstore: Email is required for EBook.");

        if (quantity <= 0)
            throw new IllegalArgumentException("Quantum Bookstore: Quantity must be greater than zero.");

        //  Assuming EBooks are unlimited in quantity.
        for (int i = 0; i < quantity; i++) {
            mailService.sendEBook(email, book.getTitle());
        }

        return book.getPrice() * quantity;
    }
}
