package pages.IH.main_pages;

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
    By stateSelect = By.id("state");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("orderForm");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("buyParameter", "IH"));
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
        String email = "qa+IH" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "IH"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "IH"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "IH"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "IH"));
        writeText(cityTextbox, propertyManager.getProperty("city", "IH"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "IH"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "IH"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "IH"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "IH"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "IH"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "IH"));
        if(insurance == 1) click(insuranceCheckbox);
        submitForm(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
