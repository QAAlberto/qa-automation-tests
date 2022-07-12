package pages.TCBD.main_pages;

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
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("checkoutButton");
    By oneBottle = By.id("product662");
    By threeBottles = By.id("product663");
    By sixBottles = By.id("product664");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("testingKey", "TCBD"));
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
        String email = "qa+TCBD" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "TCBD"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "TCBD"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "TCBD"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "TCBD"));
        writeText(cityTextbox, propertyManager.getProperty("city", "TCBD"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "TCBD"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "TCBD"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "TCBD"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "TCBD"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "TCBD"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
