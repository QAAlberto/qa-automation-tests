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

public class PrayerWarriorNetworkNonBillingList extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("prayer_warrior_network_nonbilling List");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void prayerWarriorNetworkBillingListTest() {
        OrderPage orderPage = new OrderPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HighWayHealingPage highWayHealingPage = new HighWayHealingPage(driver);
        BiblicalFatBurningSecretsPage biblicalFatBurningSecretsPage = new BiblicalFatBurningSecretsPage(driver);
        TheMemoryCovenantPage theMemoryCovenantPage = new TheMemoryCovenantPage(driver);

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        test.get().info(email);
        checkoutPage.submitBillingAddress("United States");
        checkoutPage.submitPaymentNewPath(1);
        highWayHealingPage.decide(0);
        biblicalFatBurningSecretsPage.decide(0, "EN");
        theMemoryCovenantPage.decide(0);
    }
}
