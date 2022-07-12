package pages.KFX3.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameTextbox = By.id("shipFirstName");
    By lastNameTextbox = By.id("shipLastName");
    By emailTextbox = By.id("emailAddress");
    By address1Textbox = By.id("shipAddress1");
    By postalCodeTextbox = By.id("shipPostalCode");
    By cityTextbox = By.id("shipCity");
    By stateSelect = By.id("shipState");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By submitButton1 = By.id("checkoutButton1");
    By submitButton2 = By.id("checkoutButton2");
    By insuranceCheckbox = By.id("shippingInsurance");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "KFX3"));
        logger.info("Checkout Page loaded");
    }

    public String submitContactInformation(String bottles){
        By bundle = By.id(bottles);
        click(bundle);
        String email = "qa+KFX3" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "KFX3"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "KFX3"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "KFX3"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "KFX3"));
        writeText(cityTextbox, propertyManager.getProperty("city", "KFX3"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "KFX3"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "KFX3"));
        click(submitButton1);
        logger.info("Contact Information submitted");
        return email;
    }

    public void submitCheckoutForm(int insurance){
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "KFX3"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "KFX3"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "KFX3"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "KFX3"));
        if(insurance == 1)click(this.insuranceCheckbox);
        click(submitButton2);
        logger.info("Checkout form submitted");
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
