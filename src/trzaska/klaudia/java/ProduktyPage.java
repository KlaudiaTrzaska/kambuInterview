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
        shortWait = new WebDriverWait(driver, 10);
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
        ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div/div/div/div/main/div[2]/div[2]/div/table/tbody/tr/td[6]/button")));
    }

    public void waitForSidebar () {
//        shortWait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/label/span")
//                        ));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement checkBox () {

        return shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/label/span")));

//        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/label/span"));
    }

    public void enableCheckBox () {
        if (!checkboxStatus())
        {
            checkBox().click();
        }
    }

    public boolean checkboxStatus () {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/label/input")).isSelected();
    }

    public WebElement saveButton () {
        return driver.findElement(By.xpath(".//button[text()='Zapisz zmiany']"));
    }
    public WebElement profile() {
        return driver.findElement(By.cssSelector("i[class*='icon-chevron-bottom']"));
    }
    public WebElement logOutButton () {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/header/div/nav/div[1]/div/div[2]/ul/li[2]/a/i"));

        //
    }
}
