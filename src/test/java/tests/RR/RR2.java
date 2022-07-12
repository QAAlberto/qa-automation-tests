package tests.RR;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PropertyManager;
import pages.RR.main_pages.CheckoutPage;
import pages.RR.main_pages.ConfirmPage;
import pages.RR.up_down_sell_pages.ConfessionsPage;
import pages.RR.up_down_sell_pages.RetireRicherLivePage;
import pages.Utils;
import tests.BaseTest;

public class RR2 extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("RR");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl", "RR");
    }

    @Test(dataProvider = "RR2Provider", dataProviderClass = TestData.class)
    public void RR2Test(int retireLive, int confessions, int retireLiveVip) {
        ConfirmPage confirmPage = new ConfirmPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Utils utils = new Utils();
        ConfessionsPage confessionsPage = new ConfessionsPage(driver);
        RetireRicherLivePage retireRicherLivePage = new RetireRicherLivePage(driver);

        String title = utils.customReportName(new String[]{
                "RR",
                retireLive == 1 ? "retireLive" : "",
                confessions == 1 ? "confessions" : "",
                retireLiveVip == 1 ? "retireLiveVip" : "",
        });

        ExtentTest node = test.get().createNode("Iteration "+ title)
                        .info(MarkupHelper.createOrderedList(confirmPage.getList(retireLive, confessions, retireLiveVip)));

        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(retireLive);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        confessionsPage.decide(confessions);
        retireRicherLivePage.decide(retireLiveVip);

        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(retireLive, confessions, retireLiveVip).get("total"));
        node.info("Password: " + confirmPage.getPassword());
        nodeThread.set(node);
    }
}
