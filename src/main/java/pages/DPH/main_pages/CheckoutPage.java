package pages.DPH.main_pages;

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
    By oneBottle = By.id("product726");
    By threeBottles = By.id("product727");
    By sixBottles = By.id("product728");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "DPH"));
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
        String email = "qa+DPH" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "DPH"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "DPH"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "DPH"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "DPH"));
        writeText(cityTextbox, propertyManager.getProperty("city", "DPH"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "DPH"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "DPH"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "DPH"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "DPH"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "DPH"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "DPH"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
