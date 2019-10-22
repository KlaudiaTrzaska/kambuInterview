package trzaska.klaudia.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProduktyCustomerPage {
    private WebDriver driver;
    WebDriverWait longWait;

    public ProduktyCustomerPage(WebDriver driver) {
        this.driver = driver;
        longWait = new WebDriverWait(driver, 15);
    }

    public WebElement searchBar () {
        return longWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("search")));
    }

    public boolean isTestElementVisible () {
        return longWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"app\"]/div/div/div/main/div[2]/div/div[2]/div/div[3]/div/div/div[2]/div[1]"))).isDisplayed();

    }
}
