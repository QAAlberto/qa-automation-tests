package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.OrderPage;
import pages.PropertyManager;
import tests.BaseTest;

public class InvalidCasesNewPath extends BaseTest {
    public OrderPage orderPage;
    public CheckoutPage checkoutPage;
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("Contact Information Empty");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void emptyFirstNameLastNameEmail() {
        ExtentTest node1 = test.get().createNode("Case 1").info("|firstName|lastName|email|");
        nodeThread.set(node1);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitCustomContactInformation("", "", "");

        String[] errorMessages = {
                "First Name Must Be At Least 2 Characters",
                "Last Name Must Be At Least 2 Characters",
                "An email address is required to proceed."
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidEmail() {
        ExtentTest node2 = test.get().createNode("Case 2").info("|email|");
        nodeThread.set(node2);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitCustomContactInformation("Alberto", "Test", "invalidEmail");

        String[] errorMessages = new String[]{
                "The email address you entered is invalid."
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void emptyAddressZipCodeCityPhoneNumber() {
        ExtentTest node3 = test.get().createNode("Case 3").info("|address1|zipCode|city|phoneNumber|");
        nodeThread.set(node3);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitCustomBillingAddress("", "", "", "");

        String[] errorMessages = new String[]{
                "Address Must Be At Least 2 Characters",
                "Billing Postal Code Must Be At Between 3-10 Characters",
                "City Must Be At Least 2 Characters",
                "Phone number is required to send you updates regarding your order."
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidPhoneNumber() {
        ExtentTest node4 = test.get().createNode("Case 4").info("|phoneNumber|");
        nodeThread.set(node4);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitCustomBillingAddress("address", "1234", "city", "invalidPhoneNumber");

        String[] errorMessages = new String[]{
                "Phone Number Must Be Numeric"
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void emptyCreditCardNumberCardSecurityCode() {
        ExtentTest node6 = test.get().createNode("Case 6").info("|creditCardNumber|cardSecurityCode|");
        nodeThread.set(node6);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitBillingAddressNewPath("United States");
        checkoutPage.submitCustomPaymentNewPath("", "");

        String[] errorMessages = new String[]{
                "Card Number length is Invalid",
                "CVV Must Be 3 or 4 Digits",
                "CVV Must Be Numeric"
        };
        checkoutPage.verifyErrorMessages(errorMessages);
    }

    @Test
    public void invalidCardSecurityCode() {
        ExtentTest node7 = test.get().createNode("Case 7").info("Invalid case: |cardSecurityCode| wrong CVV.");
        nodeThread.set(node7);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        checkoutPage.submitContactInformation();
        checkoutPage.submitBillingAddressNewPath("United States");
        checkoutPage.submitWrongCVV();
        String[] errorMessages = new String[]{
                propertyManager.getProperty("invalidTransactionEN", "EE"),
        };
        checkoutPage.verifyErrorMessageBox(errorMessages);
    }
}
