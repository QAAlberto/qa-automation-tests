package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By productsLink = By.xpath("//a[contains(text(),'Products')]");

    public void homePage(String baseUrl){
        driver.get(baseUrl + propertyManager.getProperty("testingKey", "DPH"));
        logger.info("Home Page loaded");
    }

    public void productsPage(){
        click(productsLink);
        logger.info("Products Page loaded.");
    }
}
