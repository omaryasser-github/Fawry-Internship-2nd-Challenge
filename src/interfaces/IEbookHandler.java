package interfaces;

import models.EBook;

public interface IEbookHandler {
    double purchase(EBook book, int quantity, String email);
}
