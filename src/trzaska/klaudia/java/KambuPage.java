package trzaska.klaudia.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KambuPage {
    private WebDriver driver;

    public KambuPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginInput () {
       return driver.findElement(By.cssSelector("[type='email']"));
    }
    public WebElement passwordInput () {
       return driver.findElement(By.name("_password"));
    }
    public WebElement loginButton () {
        return driver.findElement(By.cssSelector("[type='button']"));
    }
}
