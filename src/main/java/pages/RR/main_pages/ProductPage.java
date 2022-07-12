package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By firstNameTextBox = By.id("firstName");
    By lastNameTextBox = By.id("lastName");
    By emailTextBox = By.id("email");
    By shippingAddressTextBox = By.id("shippingAddress1");
    By shippingZipTextBox = By.id("shippingZip");
    By shippingCityTextBox = By.id("shippingCity");
    By phoneTextBox = By.id("phone");
    By creditCardNumberTextBox = By.id("creditCardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By CVVTextBox = By.id("CVV");
    By termsCheckBox = By.xpath("//label[@for='terms']");
    By checkoutButton = By.id("orderForm");

    public String submitProductForm(){
        String email = "qa+RR" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextBox, propertyManager.getProperty("firstName", "RR"));
        writeText(lastNameTextBox, propertyManager.getProperty("lastName", "RR"));
        writeText(emailTextBox, email);
        writeText(shippingAddressTextBox, propertyManager.getProperty("shippingAddress1", "RR"));
        writeText(shippingZipTextBox, propertyManager.getProperty("shippingZip", "RR"));
        writeText(shippingCityTextBox, propertyManager.getProperty("shippingCity", "RR"));
        writeText(phoneTextBox, propertyManager.getProperty("phone", "RR"));
        writeText(creditCardNumberTextBox, propertyManager.getProperty("creditCardNumber", "RR"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "RR"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "RR"));
        writeText(CVVTextBox, propertyManager.getProperty("CVV", "RR"));
        clickJS(termsCheckBox);
        submitForm(checkoutButton);
        logger.info("Form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
