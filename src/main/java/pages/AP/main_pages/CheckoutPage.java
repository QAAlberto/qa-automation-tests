package pages.AP.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AP.up_down_sell_pages.ApostlePromiseUpSellPage;
import pages.BasePage;

import java.util.ArrayList;

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
    By submitButton = By.id("checkoutButton");
    By oneBottle = By.id("product332");
    By threeBottles = By.id("product333");
    By sixBottles = By.id("product334");

    public CheckoutPage checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "AP"));
        logger.info("Checkout Page loaded");
        return this;
    }

    public ArrayList<Object> submitCheckoutForm(String bottles){
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
        String email = "qa+AP" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "AP"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "AP"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "AP"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "AP"));
        writeText(cityTextbox, propertyManager.getProperty("city", "AP"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "AP"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "AP"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "AP"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "AP"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "AP"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "AP"));
        click(submitButton);
        logger.info("Checkout form submitted");
        ArrayList<Object> aux = new ArrayList<>();
        aux.add(email);
        aux.add(new ApostlePromiseUpSellPage(driver));
        return aux;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
