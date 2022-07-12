package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    By nextStepButton = By.id("orderButtonContainer");

    public void orderPage(String baseUrl){
        driver.get(baseUrl + "order" + propertyManager.getProperty("testingKey", "EE"));
        logger.info("Order Page loaded");
    }

    public void checkoutPageURL(String baseUrl){
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("testingKey", "EE"));
        logger.info("Checkout Page loaded");
    }

    public void checkoutPage(){
        click(nextStepButton);
        logger.info("Checkout Page loaded");
    }

    public void newPathOrderPage(String baseUrl){
        driver.get(baseUrl + "prayer-warrior/order/cart" + propertyManager.getProperty("testingKey", "EE"));
        logger.info("Order page loaded");
    }
}
