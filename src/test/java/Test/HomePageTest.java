package Test;

import org.testng.annotations.Test;

public class HomePageTest  extends BaseClass {

    @Test
    public void BookStore() throws InterruptedException {
        pageFactory.getHomePage().books();
        pageFactory.getHomePage().booksApi();
        pageFactory.getHomePage().booksVerify();
    }
}