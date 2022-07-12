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
import pages.EE.main_pages.SpiritOfHealingPage;
import pages.EE.up_down_sell_pages.*;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class SpiritOfHealing extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Spirit Of Healing");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test(dataProvider = "exodusEffectProvider", dataProviderClass = TestData.class)
    public void spiritOfHealingTest(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        Utils utils = new Utils();
        SpiritOfHealingPage spiritOfHealingPage = new SpiritOfHealingPage(driver);
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
                .info(MarkupHelper.createOrderedList(confirmPage.getListSpiritOfHealing(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell)));

        spiritOfHealingPage.spiritOfHealing(baseUrl);
        spiritOfHealingPage.checkoutPage();
        utils.switchTab(driver);
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
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmountSpiritOfHealing(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell,firstUpsell).get("total"));
        node.info("Password: " + confirmPage.getPassword());
    }
}
