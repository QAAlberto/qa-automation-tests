package tests.EE.MailingLists.Exodus;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.OrderPage;
import pages.EE.up_down_sell_pages.*;
import pages.PropertyManager;
import tests.BaseTest;

public class FaithBasedMedicalUpdatesList extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("faith_based_medical_updates List");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void faithBasedMedicalUpdatesListTest() {
        OrderPage orderPage = new OrderPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HighWayHealingPage highWayHealingPage = new HighWayHealingPage(driver);
        HighWayHealingTwoPage highWayHealingTwoPage = new HighWayHealingTwoPage(driver);
        TheMemoryCovenantPage theMemoryCovenantPage = new TheMemoryCovenantPage(driver);
        TheMemoryCovenantTwoPage theMemoryCovenantTwoPage = new TheMemoryCovenantTwoPage(driver);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        test.get().info(email);
        checkoutPage.submitBillingAddress("United States");
        checkoutPage.submitPayment(0);
        highWayHealingPage.decide(0);
        highWayHealingTwoPage.decide(0);
        theMemoryCovenantPage.decide(0);
        theMemoryCovenantTwoPage.decide(0);
    }
}
