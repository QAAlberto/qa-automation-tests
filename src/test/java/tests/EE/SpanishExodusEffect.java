package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.ConfirmPage;
import pages.EE.main_pages.OrderPage;
import pages.EE.up_down_sell_pages.*;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class SpanishExodusEffect extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Spanish Exodus Effect");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlES", "EE");
    }

    @Test(dataProvider = "spanishExodusEffectProvider", dataProviderClass = TestData.class)
    public void exodusEffectTest(String country, int prayerPower, int thirdUpsell, int secondUpsell, int firstUpsell){
        Utils utils = new Utils();
        OrderPage orderPage = new OrderPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HighWayHealingPage highWayHealingPage = new HighWayHealingPage(driver);
        BiblicalFatBurningSecretsPage biblicalFatBurningSecretsPage = new BiblicalFatBurningSecretsPage(driver);
        TheMemoryCovenantPage theMemoryCovenantPage = new TheMemoryCovenantPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);

        String title = utils.customReportName(new String[]{
                "Exodus Effect",
                prayerPower == 1 ? "prayerPower" : "",
                thirdUpsell == 1 ? "theMemoryCovenantTwoPage" : "",
                secondUpsell == 1 ? "biblicalFatBurningSecrets" : "",
                firstUpsell == 1 ? "highWayHealingPage" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getSpanishList(country, prayerPower, thirdUpsell, secondUpsell, firstUpsell)));

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        checkoutPage.submitBillingAddress(country);
        checkoutPage.submitPayment(prayerPower);
        highWayHealingPage.decide(firstUpsell);
        biblicalFatBurningSecretsPage.decide(secondUpsell, "ES");
        theMemoryCovenantPage.decide(thirdUpsell);
        Assert.assertEquals(confirmPage.getSpanishGrandTotal(), "$" + confirmPage.getSpanishAmount(country, prayerPower, thirdUpsell, secondUpsell, firstUpsell).get("total"));
        confirmPage.verifySpanishGrandTotal(country, prayerPower, thirdUpsell, secondUpsell, firstUpsell);
        node.info("Password: " + confirmPage.getPassword());
    }
}
