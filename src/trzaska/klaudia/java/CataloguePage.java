package trzaska.klaudia.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CataloguePage {
    private WebDriver driver;
    WebDriverWait shortWait;

    public CataloguePage (WebDriver driver){
        this.driver = driver;
        shortWait = new WebDriverWait(driver, 10);
    }

    public WebElement produktyButton () {
        return shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Produkty")));
    }
}
