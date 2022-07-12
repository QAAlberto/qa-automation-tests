package pages.RR.main_pages;

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
    By submitButton = By.id("checkoutButton");
    By termsCheckbox = By.id("terms");
    By retireLiveCheckbox = By.id("acceptContinuity");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "RR"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(int retireLive){
        String email = "qa+RR" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "RR"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "RR"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("shippingAddress1", "RR"));
        writeText(postalCodeTextbox, propertyManager.getProperty("shippingZip", "RR"));
        writeText(cityTextbox, propertyManager.getProperty("shippingCity", "RR"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phone", "RR"));
        writeText(cardNumberTextbox, propertyManager.getProperty("creditCardNumber", "RR"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "RR"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "RR"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("CVV", "RR"));
        click(termsCheckbox);
        if(retireLive == 0) click(retireLiveCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
