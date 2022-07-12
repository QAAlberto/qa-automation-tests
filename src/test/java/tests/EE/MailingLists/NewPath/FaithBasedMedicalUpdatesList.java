package tests.EE.MailingLists.NewPath;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.OrderPage;
import pages.EE.up_down_sell_pages.BiblicalFatBurningSecretsPage;
import pages.EE.up_down_sell_pages.HighWayHealingPage;
import pages.EE.up_down_sell_pages.TheMemoryCovenantPage;
import pages.PropertyManager;
import tests.BaseTest;

public class FaithBasedMedicalUpdatesList extends BaseTest {
    public OrderPage orderPage;
    public CheckoutPage checkoutPage;
    public HighWayHealingPage highWayHealingPage;
    public BiblicalFatBurningSecretsPage biblicalFatBurningSecretsPage;
    public TheMemoryCovenantPage theMemoryCovenantPage;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("faith_based_medical_updates List");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void exodusEffectCustomerListTest() {
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        highWayHealingPage = new HighWayHealingPage(driver);
        biblicalFatBurningSecretsPage = new BiblicalFatBurningSecretsPage(driver);
        theMemoryCovenantPage = new TheMemoryCovenantPage(driver);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        test.get().info(email);
        checkoutPage.submitBillingAddress("United States");
        checkoutPage.submitPaymentNewPath(0);
        highWayHealingPage.decide(1);
        biblicalFatBurningSecretsPage.decide(0, "EN");
        theMemoryCovenantPage.decide(0);
    }
}
