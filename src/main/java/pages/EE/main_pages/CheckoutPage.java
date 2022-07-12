package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameTextbox = By.id("firstName");
    By lastNameTextBox = By.id("lastName");
    By emailTextBox = By.id("emailAddress");
    By submitButton = By.id("checkoutButton");

    By address1Textbox = By.id("address1");
    By zipCodeTextbox = By.id("postalCode");
    By cityTextbox = By.id("city");
    By stateField = By.id("state");
    By countryField = By.id("country");
    By phoneNumberTextbox = By.id("phoneNumber");

    By shippingCheckbox = By.id("shippingDifferent");

    By shippingAddress1Textbox = By.id("shipAddress1");
    By shippingPostalCodeTextbox = By.id("shipPostalCode");
    By shippingStateField = By.id("shipState");
    By shippingCountryField = By.id("shipCountry");
    By shippingCityTextbox = By.id("shipCity");

    By creditCardNumberTextbox = By.id("cardNumber");
    By cardMonthField = By.id("cardMonth");
    By cardYearField = By.id("cardYear");
    By cardSecurityCodeTextbox = By.id("cardSecurityCode");
    By acceptSubscriptionCheckbox = By.id("acceptSubscription");
    By lifeTimeSubscriptionCheckbox = By.id("lifetimeUpgrade");
    By termsCheckbox = By.id("terms");

    By errorMessagesFields = By.xpath("//div[@class='inlineError' and @style='display: block;']//li");
    By errorMessagesBox = By.xpath("//div[@id='orderErrors']//ul[@class='errorList']/li");

    By closeErrorWindowLink = By.xpath("//div[@id='orderErrors']//div[@class='lityClose']");

    public String submitContactInformation(){
        String email = "qa+EE" + getTimeStamp() + "@redhotmarketingllc.com";
//        String email = "alberto.cuencaqa@gmail.com";
        writeText(firstNameTextbox, propertyManager.getProperty("firstName", "EE"));
        writeText(lastNameTextBox, propertyManager.getProperty("lastName", "EE"));
        writeText(emailTextBox, email);
        click(submitButton);
        logger.info("Contact Information form submitted");
        return email;
    }

    public void submitCustomContactInformation(String firstName, String lastName, String email){
        writeText(firstNameTextbox, firstName);
        writeText(lastNameTextBox, lastName);
        writeText(emailTextBox, email);
        click(submitButton);
        logger.info("Contact Information form submitted");
    }

    public void submitBillingAddress(String country) {
        writeText(address1Textbox, propertyManager.getProperty("address1", "EE"));
        writeText(zipCodeTextbox, propertyManager.getProperty("zipCode", "EE"));
        writeText(cityTextbox, propertyManager.getProperty("city", "EE"));
        selectOptionFromSelect(countryField, country);
        switch (country){
            case "United States":
                selectOptionFromSelect(stateField, propertyManager.getProperty("USstate", "EE"));
                break;
            case "Australia":
                selectOptionFromSelect(stateField, propertyManager.getProperty("AUstate", "EE"));
                break;
            case "Canada":
                selectOptionFromSelect(stateField, propertyManager.getProperty("CAstate", "EE"));
                break;
            case "New Zealand":
                selectOptionFromSelect(stateField, propertyManager.getProperty("NZstate", "EE"));
                break;
            case "United Kingdom":
                selectOptionFromSelect(stateField, propertyManager.getProperty("UKstate", "EE"));
                break;
            default:
                break;
        }
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "EE"));
        click(submitButton);
        click(submitButton);
        logger.info("Billing Address form submitted");
    }

    public void submitBillingAddressExodusSecret() {
        writeText(address1Textbox, propertyManager.getProperty("address1", "EE"));
        writeText(zipCodeTextbox, propertyManager.getProperty("zipCode", "EE"));
        writeText(cityTextbox, propertyManager.getProperty("city", "EE"));
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "EE"));
        click(submitButton);
        click(submitButton);
        logger.info("Billing Address form submitted");
    }

    public void submitBillingAddressNewPath(String country) {
        writeText(address1Textbox, propertyManager.getProperty("address1", "EE"));
        writeText(zipCodeTextbox, propertyManager.getProperty("zipCode", "EE"));
        writeText(cityTextbox, propertyManager.getProperty("city", "EE"));
        selectOptionFromSelect(countryField, country);
        switch (country){
            case "United States":
                selectOptionFromSelect(stateField, propertyManager.getProperty("USstate", "EE"));
                break;
            case "Australia":
                selectOptionFromSelect(stateField, propertyManager.getProperty("AUstate", "EE"));
                break;
            case "Canada":
                selectOptionFromSelect(stateField, propertyManager.getProperty("CAstate", "EE"));
                break;
            case "New Zealand":
                selectOptionFromSelect(stateField, propertyManager.getProperty("NZstate", "EE"));
                break;
            case "United Kingdom":
                selectOptionFromSelect(stateField, propertyManager.getProperty("UKstate", "EE"));
                break;
            default:
                break;
        }
        writeText(phoneNumberTextbox, propertyManager.getProperty("phoneNumber", "EE"));
        click(submitButton);
        logger.info("Billing Address form submitted");
    }

    public void submitCustomBillingAddress(String address1, String zipCode, String city, String phoneNumber){
        writeText(address1Textbox, address1);
        writeText(zipCodeTextbox, zipCode);
        writeText(cityTextbox, city);
        writeText(phoneNumberTextbox, phoneNumber);
        click(submitButton);
        click(submitButton);
        logger.info("Billing Address form submitted");
    }

    public void submitShippingAddress(String billingCountry, String shippingCountry){
        writeText(address1Textbox, "address1");
        writeText(zipCodeTextbox, "40010");
        writeText(cityTextbox, "city");
        selectOptionFromSelect(countryField, billingCountry);
        switch (billingCountry){
            case "United States":
                selectOptionFromSelect(stateField, propertyManager.getProperty("USstate", "EE"));
                break;
            case "Australia":
                selectOptionFromSelect(stateField, propertyManager.getProperty("AUstate", "EE"));
                break;
            case "Canada":
                selectOptionFromSelect(stateField, propertyManager.getProperty("CAstate", "EE"));
                break;
            case "New Zealand":
                selectOptionFromSelect(stateField, propertyManager.getProperty("NZstate", "EE"));
                break;
            case "United Kingdom":
                selectOptionFromSelect(stateField, propertyManager.getProperty("UKstate", "EE"));
                break;
            default:
                break;
        }
        writeText(phoneNumberTextbox, "1234567890");

        click(shippingCheckbox);

        writeText(shippingAddress1Textbox, "address1");
        writeText(shippingPostalCodeTextbox, "40010");
        writeText(shippingCityTextbox, "city");
        selectOptionFromSelect(shippingStateField, propertyManager.getProperty("USstate", "EE"));
        click(submitButton);
        click(submitButton);
        logger.info("Shipping Address form submitted");
    }

    public void submitCustomShippingAddress(String country, String address1, String postalCode, String city){
        writeText(address1Textbox, "address1");
        writeText(zipCodeTextbox, "40010");
        writeText(cityTextbox, "city");
        selectOptionFromSelect(countryField, country);
        switch (country){
            case "United States":
                selectOptionFromSelect(stateField, propertyManager.getProperty("USstate", "EE"));
                break;
            case "Australia":
                selectOptionFromSelect(stateField, propertyManager.getProperty("AUstate", "EE"));
                break;
            case "Canada":
                selectOptionFromSelect(stateField, propertyManager.getProperty("CAstate", "EE"));
                break;
            case "New Zealand":
                selectOptionFromSelect(stateField, propertyManager.getProperty("NZstate", "EE"));
                break;
            case "United Kingdom":
                selectOptionFromSelect(stateField, propertyManager.getProperty("UKstate", "EE"));
                break;
            default:
                break;
        }
        writeText(phoneNumberTextbox, "1234567890");

        click(shippingCheckbox);

        writeText(shippingAddress1Textbox, address1);
        writeText(shippingPostalCodeTextbox, postalCode);
        writeText(shippingCityTextbox, city);
        click(submitButton);
        logger.info("Shipping Address form submitted");
    }

    public void submitPayment(int powerPrayer){
        writeText(creditCardNumberTextbox, propertyManager.getProperty("cardNumber", "EE"));
        selectOptionFromSelect(cardMonthField, propertyManager.getProperty("cardMonth", "EE"));
        selectOptionFromSelect(cardYearField, propertyManager.getProperty("cardYear", "EE"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "EE"));
//        click(termsCheckbox);
        if(powerPrayer == 0) click(acceptSubscriptionCheckbox);
        click(submitButton);
        logger.info("Payment form submitted");
    }

    public void submitPaymentExodusSecret(int powerPrayer){
        writeText(creditCardNumberTextbox, propertyManager.getProperty("cardNumber", "EE"));
        selectOptionFromSelect(cardMonthField, propertyManager.getProperty("cardMonth", "EE"));
        selectOptionFromSelect(cardYearField, propertyManager.getProperty("cardYear", "EE"));
        writeText(cardSecurityCodeTextbox, propertyManager.getProperty("cardSecurityCode", "EE"));
        click(termsCheckbox);
        if(powerPrayer == 0) click(acceptSubscriptionCheckbox);
        click(submitButton);
        logger.info("Payment form submitted");
    }

    public void submitCustomPayment(String creditCardNumber, String cardSecurityCode){
        writeText(creditCardNumberTextbox, creditCardNumber);
        writeText(cardSecurityCodeTextbox, cardSecurityCode);
        click(submitButton);
        click(submitButton);
        click(closeErrorWindowLink);
        logger.info("Payment form submitted");
    }

    public void submitWrongCVV(){
        writeText(creditCardNumberTextbox, "0000000000000000");
        selectOptionFromSelect(cardMonthField, "12");
        selectOptionFromSelect(cardYearField, "27");
        writeText(cardSecurityCodeTextbox, "900");
        click(submitButton);
        click(submitButton);
        logger.info("Payment form submitted");
    }

    public void submitPaymentNewPath(int lifeTimeUpgrade){
        writeText(creditCardNumberTextbox, "0000000000000000");
        selectOptionFromSelect(cardMonthField, "12");
        selectOptionFromSelect(cardYearField, "27");
        writeText(cardSecurityCodeTextbox, "1212");
        if(lifeTimeUpgrade == 1) click(lifeTimeSubscriptionCheckbox);
        click(submitButton);
        logger.info("Payment form submitted");
    }

    public void submitCustomPaymentNewPath(String creditCardNumber, String cardSecurityCode){
        writeText(creditCardNumberTextbox, creditCardNumber);
        writeText(cardSecurityCodeTextbox, cardSecurityCode);
        click(submitButton);
        click(submitButton);
        click(closeErrorWindowLink);
        logger.info("Payment form submitted");
    }

    public void verifyErrorMessages(String[] errorMessages){
        assertEqualsMultipleElements(errorMessagesFields, errorMessages);
    }

    public void verifyErrorMessageBox(String[] errorMessages){
        assertEqualsMultipleElements(errorMessagesBox, errorMessages);
    }

    public String getDeviceID(){
        return "Device ID: " + executeJS("return amplitudeDeviceId");
    }
}
