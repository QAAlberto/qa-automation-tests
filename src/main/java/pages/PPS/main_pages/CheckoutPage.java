package pages.PPS.main_pages;

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
    By submitButton1 = By.id("checkoutButton");
    By termsCheckbox = By.id("terms");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "PPS"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(String plan){
        By option = By.xpath("//div[@data-billingmodel='" + plan + "']");
        click(option);
        String email = "qa+PPS" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "PPS"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "PPS"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "PPS"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "PPS"));
        writeText(cityTextbox, propertyManager.getProperty("city", "PPS"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "PPS"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "PPS"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "PPS"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "PPS"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "PPS"));
        click(termsCheckbox);
        click(submitButton1);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
