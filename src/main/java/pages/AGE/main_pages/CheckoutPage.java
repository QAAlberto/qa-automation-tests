package pages.AGE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AGE.up_down_sell_pages.AmplifirePage;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameTextbox = By.id("firstName");
    By lastNameTextBox = By.id("lastName");
    By emailTextBox = By.id("emailAddress");
    By secureButton = By.id("secureButton");

    By address1Textbox = By.id("address1");
    By zipCodeTextbox = By.id("postalCode");
    By cityTextbox = By.id("city");
    By stateField = By.id("state");
    By countryField = By.id("country");
    By yesButton = By.id("yesButton");

    By creditCardNumberTextbox = By.id("cardNumber");
    By cardMonthField = By.id("cardMonth");
    By cardYearField = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By submitButton = By.id("submitButton");

    public String submitContactInformation(){
        String email = "qa+AGE" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(emailTextBox, email);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "EE"));
        writeText(lastNameTextBox, propertyManager.getProperty("lastName", "EE"));
        click(secureButton);
        logger.info("Contact Information form submitted");
        return email;
    }

    public CheckoutPage submitBillingAddress() {
        writeText(address1Textbox, propertyManager.getProperty("address1", "AGE"));
        writeText(zipCodeTextbox, propertyManager.getProperty("zipCode", "AGE"));
        writeText(cityTextbox, propertyManager.getProperty("city", "AGE"));
        selectOptionFromSelect(countryField, "United States");
        selectOptionFromSelect(stateField, propertyManager.getProperty("USstate", "AGE"));
        click(yesButton);
        logger.info("Billing Address form submitted");
        return this;
    }

    public AmplifirePage submitPayment(){
        writeText(creditCardNumberTextbox, propertyManager.getProperty("cardNumber", "AGE"));
        selectOptionFromSelect(cardMonthField, propertyManager.getProperty("cardMonth", "AGE"));
        selectOptionFromSelect(cardYearField, propertyManager.getProperty("cardYear", "AGE"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "AGE"));
        click(submitButton);
        logger.info("Payment form submitted");
        return new AmplifirePage(driver);
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
