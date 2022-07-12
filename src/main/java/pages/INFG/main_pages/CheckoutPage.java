package pages.INFG.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By option1 = By.xpath("//div[@data-option='option4']");
    By option2 = By.xpath("//div[@data-option='option2']");
    By option3 = By.xpath("//div[@data-option='option3']");
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
        driver.get(baseUrl + "order/checkout" + propertyManager.getProperty("testingKey", "INFG"));
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(String option, int insurance){
        switch (option){
            case "option1":
                click(option1);
                break;
            case "option2":
                click(option2);
                break;
            case "option3":
                click(option3);
                break;
        }
        String email = "qa+INFG" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "INFG"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "INFG"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "INFG"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "INFG"));
        writeText(cityTextbox, propertyManager.getProperty("city", "INFG"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "INFG"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "INFG"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "INFG"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "INFG"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "INFG"));
        if(insurance == 1) clickJS(insuranceCheckbox);
        submitForm(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
