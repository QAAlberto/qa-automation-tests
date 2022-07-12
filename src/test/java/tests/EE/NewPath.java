package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EE.main_pages.CheckoutPage;
import pages.EE.main_pages.ConfirmPage;
import pages.EE.main_pages.OrderPage;
import pages.EE.up_down_sell_pages.*;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class NewPath extends BaseTest {
    public Utils utils;
    public OrderPage orderPage;
    public CheckoutPage checkoutPage;
    public HighWayHealingPage highWayHealingPage;
    public HighWayHealingTwoPage highWayHealingTwoPage;
    public TheMemoryCovenantPage theMemoryCovenantPage;
    public TheMemoryCovenantTwoPage theMemoryCovenantTwoPage;
    public ConfirmPage confirmPage;
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("Exodus Effect - New Path");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test(dataProvider = "exodusEffectProvider", dataProviderClass = TestData.class)
    public void mainProductNewPathTest (String country, int lifeTimeUpgrade, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        utils = new Utils();
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        highWayHealingPage = new HighWayHealingPage(driver);
        highWayHealingTwoPage = new HighWayHealingTwoPage(driver);
        theMemoryCovenantPage = new TheMemoryCovenantPage(driver);
        theMemoryCovenantTwoPage = new TheMemoryCovenantTwoPage(driver);
        confirmPage = new ConfirmPage(driver);

        String title = utils.customReportName(new String[]{
                "Prayer Warrior Network",
                lifeTimeUpgrade == 1 ? "lifeTimeUpgrade" : "",
                fourthUpsell == 1 ? "theMemoryCovenantTwoPage" : "",
                thirdUpsell == 1 ? "theMemoryCovenantPage" : "",
                secondUpsell == 1 ? "highWayHealingTwoPage" : "",
                firstUpsell == 1 ? "highWayHealingPage" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title);
//                .info(MarkupHelper.createOrderedList(confirmPage.getListNewPath(country, lifeTimeUpgrade, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell)));

        orderPage.newPathOrderPage(baseUrl);
        orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        checkoutPage.submitBillingAddress(country);
        checkoutPage.submitPaymentNewPath(lifeTimeUpgrade);
        highWayHealingPage.decide(firstUpsell);
        if(firstUpsell == 0) highWayHealingTwoPage.decide(secondUpsell);
        theMemoryCovenantPage.decide(thirdUpsell);
        if(thirdUpsell == 0) theMemoryCovenantTwoPage.decide(fourthUpsell);
//            confirmPage.verifyGrandTotalNewPath(country, lifeTimeUpgrade, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell);
    }
}
