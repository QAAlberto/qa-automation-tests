package tests.GF;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GF.main_pages.CheckoutPage;
import pages.GF.main_pages.ConfirmPage;
import pages.GF.up_down_sell_pages.GorillaFlowDownSellPage;
import pages.GF.up_down_sell_pages.GorillaFlowUpsellPage;
import pages.GF.up_down_sell_pages.TestoIgnitePage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class GF extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Gorilla Flow");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "GF");
    }

    @Test(dataProvider = "GFProvider", dataProviderClass = TestData.class)
    public void GFTest(String bottles, int off, int insurance, int gorillaFlowUpSell, int gorillaFlowDownSell, String testoIgnite) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();
        GorillaFlowUpsellPage gorillaFlowUpsellPage = new GorillaFlowUpsellPage(driver);
        GorillaFlowDownSellPage gorillaFlowDownSellPage = new GorillaFlowDownSellPage(driver);
        TestoIgnitePage testoIgnitePage = new TestoIgnitePage(driver);

        String title = utils.customReportName(new String[]{
                "GF",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                gorillaFlowUpSell == 1 ? "gorillaFlowUpSell" : "",
                gorillaFlowDownSell == 1 ? "gorillaFlowDownSell" : "",
                testoIgnite.equals("1b") ? "testoIgnite 1b" : "",
                testoIgnite.equals("3b") ? "testoIgnite 3b" : "",
                testoIgnite.equals("6b") ? "testoIgnite 6b" : "",
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, gorillaFlowUpSell, gorillaFlowDownSell, testoIgnite)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        gorillaFlowUpsellPage.decide(gorillaFlowUpSell);
        if(gorillaFlowUpSell == 0)gorillaFlowDownSellPage.decide(gorillaFlowDownSell);
        testoIgnitePage.decide(testoIgnite);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, gorillaFlowUpSell, gorillaFlowDownSell, testoIgnite).get("total"));
    }
}
