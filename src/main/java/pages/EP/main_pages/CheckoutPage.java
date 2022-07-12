package pages.EP.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.id("package1");
    By threeBottles = By.id("package3");
    By sixBottles = By.id("package2");
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
    By submitButton = By.id("orderForm");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("testingKey", "EP"));
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
        String email = "qa+EP" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "EP"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "EP"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "EP"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "EP"));
        writeText(cityTextbox, propertyManager.getProperty("city", "EP"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "EP"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "EP"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "EP"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "EP"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "EP"));
        if(insurance == 1) clickJS(insuranceCheckbox);
        submitForm(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
