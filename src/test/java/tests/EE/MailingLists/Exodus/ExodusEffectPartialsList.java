package tests.EE.MailingLists.Exodus;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.OrderPage;
import pages.PropertyManager;
import tests.BaseTest;

public class ExodusEffectPartialsList extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("exodus_effect_partials List");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void exodusEffectPartialsListTest() throws InterruptedException {
        OrderPage orderPage = new OrderPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        test.get().info(email);
        Thread.sleep(500);
    }
}
