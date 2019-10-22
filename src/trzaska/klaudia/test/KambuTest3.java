package trzaska.klaudia.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import trzaska.klaudia.java.CataloguePage;
import trzaska.klaudia.java.KambuPage;
import trzaska.klaudia.java.ProduktyCustomerPage;
import trzaska.klaudia.java.ProduktyPage;

public class KambuTest3 {
    private WebDriver driver;

    @Before
    public void setUp() {
        String driverPath = "./chromedriver";
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.get("https://test.qa.kambu.pl");
        driver.manage().window().setSize(new Dimension(1400, 880));
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void productDescriptionCanBeSet()  {
        KambuPage kambuPage = new KambuPage(driver);
        kambuPage.loginInput().sendKeys("dev+tpi+admin@kambu.pl");
        kambuPage.passwordInput().sendKeys("test");
        kambuPage.loginButton().click();

        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.produktyButton().click();

        ProduktyPage produktyPage = new ProduktyPage(driver);
        produktyPage.searchbar().sendKeys("06. MB - zaślepka pełna - Płyta boczna rozdzielacza - zaślepka");
        produktyPage.editButton().click();
        produktyPage.waitForSidebar();
        produktyPage.descriptionField().clear();
        produktyPage.descriptionField().sendKeys("test");
        produktyPage.saveButton().click();
        produktyPage.waitForSidebar(); // wait for sidebar to close
        produktyPage.profile().click();
        produktyPage.logOutButton().click();

        kambuPage.loginInput().sendKeys("dev+tpi+user@kambu.pl");
        kambuPage.passwordInput().sendKeys("test");
        kambuPage.loginButton().click();

        ProduktyCustomerPage produktyCustomerPage = new ProduktyCustomerPage(driver);
        produktyCustomerPage.searchBar().sendKeys("06. MB - zaślepka pełna - Płyta boczna rozdzielacza - zaślepka");

        Actions action = new Actions(driver);
        action.moveToElement(produktyCustomerPage.testElement());
       produktyCustomerPage.kartaProduktuButton().click();

       Assert.assertEquals("test" , produktyCustomerPage.testElementDescription().getText());


    }
}