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

public class ExodusEffect extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Exodus Effect");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test(dataProvider = "exodusEffectProvider", dataProviderClass = TestData.class)
    public void exodusEffectTest(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        Utils utils = new Utils();
        OrderPage orderPage = new OrderPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HighWayHealingPage highWayHealingPage = new HighWayHealingPage(driver);
        HighWayHealingTwoPage highWayHealingTwoPage = new HighWayHealingTwoPage(driver);
        TheMemoryCovenantPage theMemoryCovenantPage = new TheMemoryCovenantPage(driver);
        TheMemoryCovenantTwoPage theMemoryCovenantTwoPage = new TheMemoryCovenantTwoPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);

        String title = utils.customReportName(new String[]{
                "Exodus Effect",
                prayerPower == 1 ? "prayerPower" : "",
                fourthUpsell == 1 ? "theMemoryCovenantTwoPage" : "",
                thirdUpsell == 1 ? "theMemoryCovenantPage" : "",
                secondUpsell == 1 ? "highWayHealingTwoPage" : "",
                firstUpsell == 1 ? "highWayHealingPage" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell)));

        orderPage.orderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        checkoutPage.submitBillingAddress(country);
        checkoutPage.submitPayment(prayerPower);
        highWayHealingPage.decide(firstUpsell);
        if(firstUpsell == 0) highWayHealingTwoPage.decide(secondUpsell);
        theMemoryCovenantPage.decide(thirdUpsell);
        if(thirdUpsell == 0) theMemoryCovenantTwoPage.decide(fourthUpsell);
        confirmPage.verifyHighwayHealingBook(country, firstUpsell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell));
        node.info("Password: " + confirmPage.getPassword());
    }
}
