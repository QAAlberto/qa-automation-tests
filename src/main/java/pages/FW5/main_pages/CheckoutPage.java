package pages.FW5.main_pages;

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
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("orderForm");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("testingKey", "FW5"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(int insurance){
        String email = "qa+FW5" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "FW5"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "FW5"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "FW5"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "FW5"));
        writeText(cityTextbox, propertyManager.getProperty("city", "FW5"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "FW5"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "FW5"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "FW5"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "FW5"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "FW5"));
        if(insurance == 1) clickJS(insuranceCheckbox);
        submitForm(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
