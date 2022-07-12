package pages.DV.main_pages;

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
    By stateSelect = By.id("state");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By submitButton = By.id("checkoutButton4");
    By oneBottle = By.xpath("//li[@data-pid='1']");
    By threeBottles = By.xpath("//li[@data-pid='2']");
    By sixBottles = By.xpath("//li[@data-pid='3']");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "DV"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(String bottles){
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
        String email = "qa+DV" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "DV"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "DV"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "DV"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "DV"));
        writeText(cityTextbox, propertyManager.getProperty("city", "DV"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "DV"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "DV"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "DV"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "DV"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "DV"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "DV"));
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
