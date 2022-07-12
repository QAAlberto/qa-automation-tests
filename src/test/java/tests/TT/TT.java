package tests.TT;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TT.main_pages.CheckoutPage;
import pages.TT.main_pages.ConfirmPage;
import pages.TT.up_down_sell_pages.TupiTeaDownSellPage;
import pages.TT.up_down_sell_pages.TupiTeaUpSellPage;
import pages.TT.up_down_sell_pages.TupiFlowPage;
import pages.TT.up_down_sell_pages.TupiTestPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class TT extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("TT");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl", "TT");
    }

    @Test(dataProvider = "TTProvider", dataProviderClass = TestData.class)
    public void TTTest(String bottles, int off, int insurance, int tupiTeaUpSell, int tupiTeaDownSell, String tupiTest, String tupiFlow) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        TupiTeaUpSellPage tupiTeaUpsellPage = new TupiTeaUpSellPage(driver);
        TupiTeaDownSellPage tupiTeaDownSellPage = new TupiTeaDownSellPage(driver);
        TupiTestPage tupiTestPage = new TupiTestPage(driver);
        TupiFlowPage tupiFlowPage = new TupiFlowPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "TupiTea",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                tupiTeaUpSell == 1 ? "tupiTeaUpSell" : "",
                tupiTeaDownSell == 1 ? "tupiTeaDownSell" : "",
                tupiTest.equals("1b") ? "1 bottle" : "",
                tupiTest.equals("3b") ? "3 bottles" : "",
                tupiTest.equals("6b") ? "6 bottles" : "",
                tupiFlow.equals("1b") ? "1 bottle" : "",
                tupiFlow.equals("3b") ? "3 bottles" : "",
                tupiFlow.equals("6b") ? "6 bottles" : ""
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, tupiTeaUpSell, tupiTeaDownSell, tupiTest, tupiFlow)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        tupiTeaUpsellPage.decide(tupiTeaUpSell);
        if (tupiTeaUpSell == 0) tupiTeaDownSellPage.decide(tupiTeaDownSell);
        tupiTestPage.decide(tupiTest);
        tupiFlowPage.decide(tupiFlow);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, tupiTeaUpSell, tupiTeaDownSell, tupiTest, tupiFlow).get("total"));
    }
}
