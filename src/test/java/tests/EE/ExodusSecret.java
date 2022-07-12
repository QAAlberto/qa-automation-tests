package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
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

public class ExodusSecret extends BaseTest {
    public OrderPage orderPage;
    public CheckoutPage checkoutPage;
    public HighWayHealingPage highWayHealingPage;
    public HighWayHealingTwoPage highWayHealingTwoPage;
    public TrinityOilUpSellPage trinityOilUpSellPage;
    public TrinityOilDownSellPage trinityOilDownSellPage;
    public TrinityOilDownSellPage2 trinityOilDownSellPage2;
    public ConfirmPage confirmPage;
    public Utils utils;
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("Exodus Secret");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlExodusSecret", "EE");
    }

    @Test(dataProvider = "exodusSecretProvider", dataProviderClass = TestData.class)
    public void exodusEffectTest(int prayer, int trinityOilUpSell, int trinityOilDownSell, int trinityOilDownSell2, int highWayHealingUpSell, int highWayHealingDownSell){
        utils = new Utils();
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        highWayHealingPage = new HighWayHealingPage(driver);
        highWayHealingTwoPage = new HighWayHealingTwoPage(driver);
        trinityOilUpSellPage = new TrinityOilUpSellPage(driver);
        trinityOilDownSellPage = new TrinityOilDownSellPage(driver);
        trinityOilDownSellPage2 = new TrinityOilDownSellPage2(driver);

        confirmPage = new ConfirmPage(driver);

        String title = utils.customReportName(new String[]{
                "Exodus Effect",
                prayer == 1 ? "prayer" : "",
                trinityOilUpSell == 1 ? "trinityOilUpSell" : "",
                trinityOilDownSell == 1 ? "trinityOilDownSell" : "",
                trinityOilDownSell2 == 1 ? "trinityOilDownSell2" : "",
                highWayHealingUpSell == 1 ? "highWayHealingUpSell" : "",
                highWayHealingDownSell == 1 ? "highWayHealingDownSell" : ""
        });
        ExtentTest node = test.get().createNode("Iteration ")
                .info(MarkupHelper.createOrderedList(confirmPage.getListExodusSecret(prayer, trinityOilUpSell, trinityOilDownSell, trinityOilDownSell2, highWayHealingUpSell, highWayHealingDownSell)));

        orderPage.checkoutPageURL(baseUrl);
        String email = checkoutPage.submitContactInformation();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        checkoutPage.submitBillingAddressExodusSecret();
        checkoutPage.submitPaymentExodusSecret(prayer);
        trinityOilUpSellPage.decide(trinityOilUpSell);
        if(trinityOilUpSell == 0) {
            trinityOilDownSellPage.decide(trinityOilDownSell);
            if(trinityOilDownSell == 0) trinityOilDownSellPage2.decide(trinityOilDownSell2);
        }
        highWayHealingPage.decide(highWayHealingUpSell);
        if(highWayHealingUpSell == 0)highWayHealingTwoPage.decide(highWayHealingDownSell);

        confirmPage.verifyGrandTotalExodusSecret(prayer, trinityOilUpSell, trinityOilDownSell, trinityOilDownSell2, highWayHealingUpSell, highWayHealingDownSell);
        node.info("Password: " + confirmPage.getPassword());
    }
}
