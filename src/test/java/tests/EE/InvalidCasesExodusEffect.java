package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.OrderPage;
import pages.PropertyManager;
import tests.BaseTest;

public class InvalidCasesExodusEffect extends BaseTest {
    public OrderPage orderPage;
    public CheckoutPage checkoutPage;
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("Contact Information Empty");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "EE");
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void emptyFieldsContactInformation() {
        ExtentTest node1 = test.get().createNode("Case 1").info("Invalid case: |firstName|lastName|email| fields empty.");
        nodeThread.set(node1);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitCustomContactInformation("", "", "");
        String[] errorMessages = {
                propertyManager.getProperty("firstNameErrorMessage" + lang, "EE"),
                propertyManager.getProperty("lastNameErrorMessage" + lang, "EE"),
                propertyManager.getProperty("emailErrorMessage" + lang, "EE")
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidEmail() {
        ExtentTest node2 = test.get().createNode("Case 2").info("Invalid case: |email| wrong value.");
        nodeThread.set(node2);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitCustomContactInformation("Alberto", "Test", "invalidEmail");
        String[] errorMessages = new String[]{
                propertyManager.getProperty("invalidEmailErrorMessage" + lang, "EE")
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void emptyFieldsBillingAddress() {
        ExtentTest node3 = test.get().createNode("Case 3").info("Invalid case: |address1|zipCode|city|phoneNumber| fields empty.");
        nodeThread.set(node3);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitCustomBillingAddress("", "", "", "");

        String[] errorMessages = new String[]{
                propertyManager.getProperty("addressErrorMessage" + lang, "EE"),
                propertyManager.getProperty("zipCodeErrorMessage" + lang, "EE"),
                propertyManager.getProperty("cityErrorMessage" + lang, "EE"),
                propertyManager.getProperty("phoneNumberErrorMessage" + lang, "EE")
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidPhoneNumber() {
        ExtentTest node4 = test.get().createNode("Case 4").info("Invalid case: |phoneNumber| wrong value.");
        nodeThread.set(node4);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitCustomBillingAddress("address", "1234", "city", "invalidPhoneNumber");
        String[] errorMessages = new String[]{
                propertyManager.getProperty("invalidPhoneNumberErrorMessage" + lang, "EE")
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void emptyFieldsShippingAddress() {
        if (lang.equals("EN")) {
            ExtentTest node5 = test.get().createNode("Case 5").info("Invalid case: |shippingAddress1|shippingPostalCode|shippingCity| fields empty.");
            nodeThread.set(node5);

            orderPage.orderPage(baseUrl);
            orderPage.checkoutPage();
            checkoutPage.submitContactInformation();
            checkoutPage.submitCustomShippingAddress("United States", "", "", "");
            String[] errorMessages = new String[]{
                    propertyManager.getProperty("shippingAddressErrorMessageEN", "EE"),
                    propertyManager.getProperty("postalCodeErrorMessageEN", "EE"),
                    propertyManager.getProperty("shippingCityErrorMessageEN", "EE")
            };
            checkoutPage.verifyErrorMessages(errorMessages);
        }
    }

    @Test
    public void emptyFieldsCreditCardNumberCardSecurityCode() {
        ExtentTest node6 = test.get().createNode("Case 6").info("Invalid case: |creditCardNumber|cardSecurityCode| fields empty.");
        nodeThread.set(node6);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        if (lang.equals("EN")) {
            checkoutPage.submitShippingAddress("United States", "United States");
        } else {
            checkoutPage.submitBillingAddress("United States");
        }
        checkoutPage.submitCustomPayment("", "");
        String[] errorMessages = new String[]{
                propertyManager.getProperty("cardNumberErrorMessage" + lang, "EE"),
                propertyManager.getProperty("cardSecurityCodeErrorMessage" + lang, "EE"),
                propertyManager.getProperty("invalidCardSecurityCodeErrorMessage" + lang, "EE")
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidCardSecurityCode() {
        ExtentTest node7 = test.get().createNode("Case 7").info("Invalid case: |cardSecurityCode| wrong CVV.");
        nodeThread.set(node7);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitBillingAddress("United States");
        checkoutPage.submitWrongCVV();
        String[] errorMessages = new String[]{
                propertyManager.getProperty("invalidTransactionEN", "EE"),
        };
        checkoutPage.verifyErrorMessageBox(errorMessages);
    }
}
