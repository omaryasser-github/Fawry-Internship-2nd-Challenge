package services;

import interfaces.IShipping;

public class ShippingService implements IShipping {
    @Override
    public void shipPaperBook(String address, String title) {
        System.out.println("Quantum Bookstore: Shipping paper book '" + title + "' to " + address);
    }
}
