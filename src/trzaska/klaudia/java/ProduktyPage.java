package trzaska.klaudia.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProduktyPage {
    private WebDriver driver;
    WebDriverWait shortWait;

    public ProduktyPage(WebDriver driver) {
        this.driver = driver;
        shortWait = new WebDriverWait(driver, 5);
    }
    public WebElement searchbar () {
        return shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("search")));
    }
    public List<WebElement> findAll () {
        return driver.findElements(By.tagName("tr"));
    }

    public void waitForSearch () {
//        return shortWait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.tagName("table")));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement editButton () {
        return shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("icon-pencil")));
    }
    public WebElement checkBox () {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/label/span"));

    }
}
