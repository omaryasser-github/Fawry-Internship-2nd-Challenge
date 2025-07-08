import interfaces.*;
import models.*;
import services.*;
import services.routes.PurchaseRouter;

public class Main {
    public static void main(String[] args) {


        BooksInventory inventory = new BooksInventory();


        PaperBook paperBook = new PaperBook("ISBN001", "Java for Pros", "Omar Yasser", 2021, 250.0, 10);
        EBook eBook = new EBook("ISBN002", "Mastering React", "Yasmin Dev", 2015, 150.0, "PDF");
        DemoBook demoBook = new DemoBook("ISBN003", "Prototype Design", "Ali Tester", 2019 );

        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(demoBook);


        IMail mailService = new MailService();
        IShipping shippingService = new ShippingService();


        IPaperbookHandler paperHandler = new PurchasePaperbook(shippingService);
        IEbookHandler ebookHandler = new PurchaseEbook(mailService);


        PurchaseRouter router = new PurchaseRouter(paperHandler, ebookHandler);



        try {
            double total1 = router.purchase(paperBook, 2, null, "123 Street, Cairo");
            System.out.println("Done , PaperBook Purchase Total: $" + total1);
        } catch (Exception e) {
            System.err.println("error " + e.getMessage());
        }

        try {
            double total2 = router.purchase(eBook, 1, "omar@example.com", null);
            System.out.println("Done , EBook Purchase Total: $" + total2);
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }

        try {
            router.purchase(demoBook, 1, "test@test.com", "Address");
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }

        try {
            router.purchase(paperBook, 20, null, "Alex");
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }

        try {
            router.purchase(eBook, 1, "", null);
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }
    }
}
