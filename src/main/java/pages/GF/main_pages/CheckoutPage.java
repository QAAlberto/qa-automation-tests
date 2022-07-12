package pages.GF.main_pages;

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
    By countrySelect = By.id("country");
    By stateSelect = By.id("state");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("checkoutButton");
    By oneBottle = By.id("product803");
    By threeBottles = By.id("product804");
    By sixBottles = By.id("product805");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "GF"));
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
        String email = "qa+GF" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "GF"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "GF"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "GF"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "GF"));
        writeText(cityTextbox, propertyManager.getProperty("city", "GF"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "GF"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "GF"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "GF"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "GF"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "GF"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "GF"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
