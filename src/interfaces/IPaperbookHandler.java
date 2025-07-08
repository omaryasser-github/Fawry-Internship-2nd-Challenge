package interfaces;

import models.PaperBook;

public interface IPaperbookHandler {
    double purchase(PaperBook book, int quantity, String address);
}
