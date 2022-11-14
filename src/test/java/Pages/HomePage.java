package Pages;

import Enums.ToolsQA_enum;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    String MenuBar = "//h5[contains(text(),'%s')]";

    By LandingPage = By.xpath("//div[@class='main-header']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(17));
    }

    public void books() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1000)");
        driver.findElement(By.xpath(String.format(MenuBar, ToolsQA_enum.Menu_items.getResourcesName()))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPage));
        String actual = driver.findElement(LandingPage).getText();
        Assert.assertEquals(actual, ToolsQA_enum.Menu_items.getResourcesName(), "Validation failed");
    }

    public void booksApi() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("BookStore/v1/Books");
        ResponseBody body = response.getBody();
        String responseBody = body.asString();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String s = jsonPathEvaluator.get("books").toString();
        JsonElement fileElement = JsonParser.parseString(responseBody);
        JsonObject fileObj = fileElement.getAsJsonObject();
        JsonArray booksList = fileObj.get("books").getAsJsonArray();
        List<BooksPojo> books = new ArrayList<>();
        for (JsonElement booksElement : booksList.getAsJsonArray()) {
            JsonObject jsonObj = booksElement.getAsJsonObject();
            BooksPojo bookData = new BooksPojo(jsonObj.get("title").toString(), jsonObj.get("author").toString(), jsonObj.get("publisher").toString());
            books.add(bookData);
            System.out.println(bookData);
        }
        System.out.println(s);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code error");
        System.out.println(statusCode);
    }
}