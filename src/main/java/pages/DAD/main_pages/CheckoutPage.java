package pages.DAD.main_pages;

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
    By continuity = By.id("acceptContinuity");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "DAD"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(int boss){
        String email = "qa+DAD" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "DAD"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "DAD"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "DAD"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "DAD"));
        writeText(cityTextbox, propertyManager.getProperty("city", "DAD"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "DAD"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "DAD"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "DAD"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "DAD"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "DAD"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "DAD"));
        if(boss == 0)click(continuity);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
