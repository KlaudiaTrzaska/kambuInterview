package trzaska.klaudia.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trzaska.klaudia.java.CataloguePage;
import trzaska.klaudia.java.KambuPage;
import trzaska.klaudia.java.Page;

import static org.junit.Assert.*;

public class KambuTest1 {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String driverPath = "./chromedriver";
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.get("https://test.qa.kambu.pl");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @org.junit.Test
    public void productSearch() {
        // Open page
        // Log in as Admin
        KambuPage kambuPage = new KambuPage(driver);
        kambuPage.loginInput().sendKeys("dev+tpi+admin@kambu.pl");
        kambuPage.passwordInput().sendKeys("test");
        kambuPage.loginButton().click();
        // Click on Produkty button
        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.produktyButton().click();
        // Click on searchbar
        // Type "CoolBox"

        // Assert there are 31 Web Elements that meet criteria
    }
}