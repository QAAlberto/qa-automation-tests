package pages.BU.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By continuityCheckbox = By.id("addContinuity");
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
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("checkoutButton");
    By oneBottle = By.id("product810");
    By threeBottles = By.id("product811");
    By sixBottles = By.id("product812");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "BU"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(String bottles, int off, int insurance){
        switch (bottles){
            case "1b":
                click(oneBottle);
                break;
            case "3b":
                click(threeBottles);
                break;
            case "6b":
                click(sixBottles);
                break;
        }
        String email = "qa+BU" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "BU"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "BU"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "BU"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "BU"));
        writeText(cityTextbox, propertyManager.getProperty("city", "BU"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "BU"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "BU"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "BU"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "BU"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "BU"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "BU"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
