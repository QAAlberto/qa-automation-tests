package tests.RRU;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RRU.main_pages.CheckoutPage;
import pages.RRU.main_pages.ConfirmPage;
import pages.PropertyManager;
import pages.RRU.up_down_sell_pages.DivineTurmericPage;
import pages.RRU.up_down_sell_pages.ProbioMaxPlusPage;
import pages.RRU.up_down_sell_pages.RingReliefUltraUpSellPage;
import pages.Utils;
import tests.BaseTest;

public class RRU extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Ring Relief Ultra");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "RRU");
    }

    @Test(dataProvider = "RRUProvider", dataProviderClass = TestData.class)
    public void RRUTest(String bottles, int ringReliefUltraUpSell, String divineTurmeric, String probioMaxPlus) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();
        RingReliefUltraUpSellPage ringReliefUltraUpSellPage = new RingReliefUltraUpSellPage(driver);
        DivineTurmericPage divineTurmericPage = new DivineTurmericPage(driver);
        ProbioMaxPlusPage probioMaxPlusPage = new ProbioMaxPlusPage(driver);

        String title = utils.customReportName(new String[]{
                "RRU",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                ringReliefUltraUpSell == 1 ? "ringReliefUltraUpSell" : "",
                divineTurmeric.equals("1b") ? "divineTurmeric 1 bottle" : "",
                divineTurmeric.equals("3b") ? "divineTurmeric 3 bottles" : "",
                divineTurmeric.equals("6b") ? "divineTurmeric 6 bottles" : "",
                probioMaxPlus.equals("1b") ? "probioMaxPlus 1 bottle" : "",
                probioMaxPlus.equals("3b") ? "probioMaxPlus 3 bottles" : "",
                probioMaxPlus.equals("6b") ? "probioMaxPlus 6 bottles" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, ringReliefUltraUpSell, divineTurmeric, probioMaxPlus)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl, bottles);
        String email = checkoutPage.submitCheckoutForm();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        ringReliefUltraUpSellPage.decide(ringReliefUltraUpSell);
        divineTurmericPage.decide(divineTurmeric);
        probioMaxPlusPage.decide(probioMaxPlus);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, ringReliefUltraUpSell, divineTurmeric, probioMaxPlus).get("total"));
    }
}
