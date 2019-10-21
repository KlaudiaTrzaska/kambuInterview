package trzaska.klaudia.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import trzaska.klaudia.java.CataloguePage;
import trzaska.klaudia.java.KambuPage;
import trzaska.klaudia.java.ProduktyPage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        // Click on searchbar and Type "CoolBox"
        ProduktyPage produktyPage = new ProduktyPage(driver);
        produktyPage.searchbar().sendKeys("CoolBox");
        // Assert there are 17 Web Elements that meet criteria
        produktyPage.waitForSearch();
        List<WebElement> coolboxList = produktyPage.findAll();
        Assert.assertEquals(17, coolboxList.size());
    }
}