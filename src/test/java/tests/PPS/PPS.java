package tests.PPS;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PPS.up_down_sell_pages.LifetimeUpSellPage;
import pages.PropertyManager;
import pages.PPS.main_pages.CheckoutPage;
import pages.PPS.main_pages.ConfirmPage;
import pages.Utils;
import tests.BaseTest;

public class PPS extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Profitable Put System");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "PPS");
    }

    @Test(dataProvider = "PPSProvider", dataProviderClass = TestData.class)
    public void PPSTest(String PPS, int lifetimeUpSell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        LifetimeUpSellPage lifetimeUpSellPage = new LifetimeUpSellPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Profitable Put System",
                PPS,
                lifetimeUpSell == 1 ? "lifetimeUpSell" : "",
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(PPS, lifetimeUpSell)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(PPS);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        if(PPS.equals("monthly") || PPS.equals("yearly"))lifetimeUpSellPage.decide(lifetimeUpSell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(PPS, lifetimeUpSell).get("total"));
    }
}
