package tests.EP;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EP.main_pages.CheckoutPage;
import pages.EP.main_pages.ConfirmPage;
import pages.EP.up_down_sell_pages.EndoBumpUpSellPage;
import pages.EP.up_down_sell_pages.ProstatePlusUpSellPage;
import pages.EP.up_down_sell_pages.EndoBumpDownSellPage;
import pages.EP.up_down_sell_pages.TestZillaUpSellPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class EP extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("EP");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "EP");
    }

    @Test(dataProvider = "EPProvider", dataProviderClass = TestData.class)
    public void EPTest(String bottles, int off, int insurance, int endoBumpUpsell, int endoBumpDownSell, String testZilla, String prostatePlus) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        EndoBumpUpSellPage endoBumpUpsellPage = new EndoBumpUpSellPage(driver);
        EndoBumpDownSellPage endoBumpDownSellPage = new EndoBumpDownSellPage(driver);
        TestZillaUpSellPage testZillaUpSellPage = new TestZillaUpSellPage(driver);
        ProstatePlusUpSellPage prostatePlusUpSellPage = new ProstatePlusUpSellPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Endo Pump",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                endoBumpUpsell == 1 ? "endoBumpUpsell" : "",
                endoBumpDownSell == 1 ? "endoBumpDownSell" : "",
                testZilla.equals("1b") ? "1 bottle" : "",
                testZilla.equals("3b") ? "3 bottles" : "",
                testZilla.equals("6b") ? "6 bottles" : "",
                prostatePlus.equals("1b") ? "1 bottle" : "",
                prostatePlus.equals("3b") ? "3 bottles" : "",
                prostatePlus.equals("6b") ? "6 bottles" : ""
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, endoBumpUpsell, endoBumpDownSell, testZilla, prostatePlus)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        endoBumpUpsellPage.decide(endoBumpUpsell);
        if (endoBumpUpsell == 0) endoBumpDownSellPage.decide(endoBumpDownSell);
        testZillaUpSellPage.decide(testZilla);
        prostatePlusUpSellPage.decide(prostatePlus);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, endoBumpUpsell, endoBumpDownSell, testZilla, prostatePlus).get("total"));
    }
}
