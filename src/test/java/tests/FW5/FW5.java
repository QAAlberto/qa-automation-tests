package tests.FW5;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FW5.main_pages.CheckoutPage;
import pages.FW5.main_pages.ConfirmPage;
import pages.FW5.up_down_sell_pages.FreedomWaterUpSellPage1;
import pages.FW5.up_down_sell_pages.FreedomWaterDownSellPage;
import pages.FW5.up_down_sell_pages.FreedomWaterUpSellPage2;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class FW5 extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("FW5");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "FW5");
    }

    @Test(dataProvider = "FW5Provider", dataProviderClass = TestData.class)
    public void FW5Test(int insurance, int freedomWaterUpSell1, int freedomWaterDownSell, int freedomWaterUpSell2) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        FreedomWaterUpSellPage1 freedomWaterUpSellPage1 = new FreedomWaterUpSellPage1(driver);
        FreedomWaterDownSellPage freedomWaterDownSellPage = new FreedomWaterDownSellPage(driver);
        FreedomWaterUpSellPage2 freedomWaterUpSellPage2 = new FreedomWaterUpSellPage2(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Freedom Water",
                insurance == 1 ? "insurance" : "",
                freedomWaterUpSell1 == 1 ? "freedomWaterUpSell1" : "",
                freedomWaterDownSell == 1 ? "freedomWaterDownSell" : "",
                freedomWaterUpSell2 == 1 ? "freedomWaterUpSell2" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(insurance, freedomWaterUpSell1, freedomWaterDownSell, freedomWaterUpSell2)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        freedomWaterUpSellPage1.decide(freedomWaterUpSell1);
        if(freedomWaterUpSell1 == 0)freedomWaterDownSellPage.decide(freedomWaterDownSell);
        freedomWaterUpSellPage2.decide(freedomWaterUpSell2);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(insurance, freedomWaterUpSell1, freedomWaterDownSell, freedomWaterUpSell2).get("total"));
    }
}
