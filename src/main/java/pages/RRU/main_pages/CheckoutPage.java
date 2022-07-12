package pages.RRU.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameTextbox = By.id("firstName");
    By lastNameTextbox = By.id("lastName");
    By emailTextbox = By.id("emailAddress");
    By address1Textbox = By.id("address1");
    By postalCodeTextbox = By.id("postalCode");
    By cityTextbox = By.id("city");
    By stateSelect = By.id("state");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By submitButton = By.id("checkoutButton");
    String oneBottle = "&productId=97";
    String threeBottles = "&productId=98";
    String sixBottles = "&productId=99";

    public void checkoutPage(String baseUrl, String bottles){
        switch (bottles){
            case "1b":
                driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "RRU") + oneBottle);
                break;
            case "3b":
                driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "RRU") + threeBottles);
                break;
            case "6b":
                driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "RRU") + sixBottles);
                break;
        }
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(){
        String email = "qa+RRU" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "RRU"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "RRU"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "RRU"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "RRU"));
        writeText(cityTextbox, propertyManager.getProperty("city", "RRU"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "RRU"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "RRU"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "RRU"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "RRU"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "RRU"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "RRU"));
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
