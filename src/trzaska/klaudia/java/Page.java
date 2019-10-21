package trzaska.klaudia.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected static final int SHORT_WAIT = 3;
    WebDriverWait shortWait;
    WebDriver driver;

    public Page () {
        String driverPath = "./chromedriver";
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        shortWait = new WebDriverWait(driver, SHORT_WAIT);
    }

    public void quit () {
        driver.close();
        driver.quit();
    }
}
