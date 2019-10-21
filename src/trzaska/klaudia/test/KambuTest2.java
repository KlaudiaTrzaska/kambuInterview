package trzaska.klaudia.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import trzaska.klaudia.java.CataloguePage;
import trzaska.klaudia.java.KambuPage;
import trzaska.klaudia.java.ProduktyPage;

public class KambuTest2 {
    private WebDriver driver;

    @Before
    public void setUp() {
        String driverPath = "./chromedriver";
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.get("https://test.qa.kambu.pl");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void manageProductVisibility() {
        KambuPage kambuPage = new KambuPage(driver);
        kambuPage.loginInput().sendKeys("dev+tpi+admin@kambu.pl");
        kambuPage.passwordInput().sendKeys("test");
        kambuPage.loginButton().click();
        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.produktyButton().click();
        ProduktyPage produktyPage = new ProduktyPage(driver);
        produktyPage.searchbar().sendKeys("CoolBox 66 6R 400");
        produktyPage.editButton().click();
        produktyPage.checkBox().click();
        enableCheckBox(produktyPage.checkBox());
//        enableCheckBox(produktyPage.checkBox());

    }
    private void enableCheckBox (WebElement checkbox) {
        if ( !checkbox.isSelected())
        {
            checkbox.click();
        }
    }
}