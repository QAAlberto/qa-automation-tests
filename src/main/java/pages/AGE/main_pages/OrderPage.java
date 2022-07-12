package pages.AGE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    By nextStepButton = By.id("claimButton");

    public OrderPage orderPage(String baseUrl){
        driver.get(baseUrl + "order" + propertyManager.getProperty("testingKey", "AGE"));
        logger.info("Order Page loaded");
        return this;
    }

    public CheckoutPage checkoutPage(){
        click(nextStepButton);
        logger.info("Checkout Page loaded");
        return new CheckoutPage(driver);
    }
}
