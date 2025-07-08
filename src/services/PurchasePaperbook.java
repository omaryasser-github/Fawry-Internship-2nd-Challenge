package services;

import interfaces.IPaperbookHandler;
import models.PaperBook;
import interfaces.IShipping;

public class PurchasePaperbook implements IPaperbookHandler {

    private IShipping shippingService;

    public PurchasePaperbook(IShipping shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public double purchase(PaperBook book, int quantity, String address) {
        if (address == null || address.isBlank())
            throw new IllegalArgumentException("Quantum Bookstore: Address is required for PaperBook.");

        if (quantity <= 0)
            throw new IllegalArgumentException("Quantum Bookstore: Quantity must be greater than zero.");

        if (quantity > book.getStock())
            throw new IllegalArgumentException("Quantum Bookstore: Not enough stock.");

        book.setStock(book.getStock() - quantity);
        shippingService.shipPaperBook(address, book.getTitle());

        return book.getPrice() * quantity;
    }
}
