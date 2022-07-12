package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By RRButton = By.xpath("//a[@aria-label='Retire Richer']");

    public void productPage(String baseUrl, String product){
        driver.get(baseUrl + "order/" + product + propertyManager.getProperty("testingKey", "DPH"));
        logger.info("Product Page loaded");
    }
}
