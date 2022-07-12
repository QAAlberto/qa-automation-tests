package pages.TOIL.main_pages;

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
    By countrySelect = By.id("country");
    By stateSelect = By.id("state");
    By phoneNumberTextbox = By.id("phoneNumber");
    By cardNumberTextbox = By.id("cardNumber");
    By cardMonthSelect = By.id("cardMonth");
    By cardYearSelect = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By insuranceCheckbox = By.id("acceptOrderBumpInsurance");
    By submitButton = By.id("checkoutButton");
    By oneBottle = By.id("product373");
    By threeBottles = By.id("product374");
    By sixBottles = By.id("product375");

    By cinnamonOneBottle = By.id("product876");
    By cinnamonThreeBottles = By.id("product877");
    By cinnamonSixBottles = By.id("product878");

    By turmericOneBottle = By.id("product879");
    By turmericThreeBottles = By.id("product880");
    By turmericSixBottles = By.id("product881");

    public void checkoutPage(String baseUrl){
        driver.get(baseUrl + "/order/checkout" + propertyManager.getProperty("testingKey", "TOIL"));
        logger.info("Checkout Page loaded");
    }

    public void checkoutPageCinnamon(String baseUrl){
        driver.get(baseUrl + "cinnamon/order/checkout" + propertyManager.getProperty("testingKey", "TOIL"));
        logger.info("Checkout Page loaded");
    }

    public void checkoutPageTurmeric(String baseUrl){
        driver.get(baseUrl + "turmeric/order/checkout" + propertyManager.getProperty("testingKey", "TOIL"));
        logger.info("Checkout Page loaded");
    }

    public void checkoutPageDiscount30(String baseUrl){
        driver.get(baseUrl + "/order/checkout?discount=TOIL30");
        logger.info("Checkout Page loaded");
    }

    public String submitCheckoutForm(String bottles, int off, String country, int insurance){
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
        String email = "qa+TOIL" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "TOIL"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "TOIL"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "TOIL"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "TOIL"));
        writeText(cityTextbox, propertyManager.getProperty("city", "TOIL"));
        selectOptionFromSelect(countrySelect, country);
        switch (country){
            case "United States":
                selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "TOIL"));
                break;
            case "Australia":
                selectOptionFromSelect(stateSelect, propertyManager.getProperty("AUstate", "TOIL"));
                break;
            case "Canada":
                selectOptionFromSelect(stateSelect, propertyManager.getProperty("CAstate", "TOIL"));
                break;
            case "New Zealand":
                selectOptionFromSelect(stateSelect, propertyManager.getProperty("NZstate", "TOIL"));
                break;
            case "United Kingdom":
                selectOptionFromSelect(stateSelect, propertyManager.getProperty("UKstate", "TOIL"));
                break;
            default:
                break;
        }
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "TOIL"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "TOIL"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "TOIL"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "TOIL"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "TOIL"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String submitCheckoutFormCinnamon(String bottles, int off, int insurance){
        switch (bottles){
            case "1b":
                click(cinnamonOneBottle);
                break;
            case "3b":
                click(cinnamonThreeBottles);
                break;
            case "6b":
                click(cinnamonSixBottles);
                break;
        }
        String email = "qa+MYOHOCinnamon" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "TOIL"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "TOIL"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "TOIL"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "TOIL"));
        writeText(cityTextbox, propertyManager.getProperty("city", "TOIL"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "TOIL"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "TOIL"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "TOIL"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "TOIL"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "TOIL"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "TOIL"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String submitCheckoutFormTurmeric(String bottles, int off, int insurance){
        switch (bottles){
            case "1b":
                click(turmericOneBottle);
                break;
            case "3b":
                click(turmericThreeBottles);
                break;
            case "6b":
                click(turmericSixBottles);
                break;
        }
        String email = "qa+MYOHOTurmeric" + getTimeStamp() + "@redhotmarketingllc.com";
        if(off == 1) click(continuityCheckbox);
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "TOIL"));
        writeText(lastNameTextbox, propertyManager.getProperty("lastName", "TOIL"));
        writeText(emailTextbox, email);
        writeText(address1Textbox, propertyManager.getProperty("address1", "TOIL"));
        writeText(postalCodeTextbox, propertyManager.getProperty("zipCode", "TOIL"));
        writeText(cityTextbox, propertyManager.getProperty("city", "TOIL"));
        selectOptionFromSelect(stateSelect, propertyManager.getProperty("USstate", "TOIL"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "TOIL"));
        writeText(cardNumberTextbox, propertyManager.getProperty("cardNumber", "TOIL"));
        selectOptionFromSelect(cardMonthSelect, propertyManager.getProperty("cardMonth", "TOIL"));
        selectOptionFromSelect(cardYearSelect, propertyManager.getProperty("cardYear", "TOIL"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "TOIL"));
        if(insurance == 1) click(insuranceCheckbox);
        click(submitButton);
        logger.info("Checkout form submitted");
        return email;
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
