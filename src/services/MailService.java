package services;

import interfaces.IMail;

public class MailService implements IMail {
    @Override
    public void sendEBook(String email, String title) {
        System.out.println("Quantum Bookstore: Sending eBook '" + title + "' to " + email);
    }
}
