package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest  extends BaseClass {

    @Test
    public void BookStore() throws InterruptedException {
        pageFactory.getHomePage().books();
        pageFactory.getHomePage().booksApi();
    }
}