package tests.INFG;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.crossbrowsertesting.Snapshot;
import com.mashape.unirest.http.exceptions.UnirestException;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.INFG.main_pages.CheckoutPage;
import pages.INFG.main_pages.ConfirmPage;
import pages.INFG.up_down_sell_pages.InfinityGridUpSell1Page;
import pages.INFG.up_down_sell_pages.InfinityGridUpSell2Page;
import pages.INFG.up_down_sell_pages.InfinityGridUpSell3Page;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class INFG extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("INFG");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "INFG");
    }

    @Test(dataProvider = "INFGProvider", dataProviderClass = TestData.class)
    public void INFGTest(String option, int insurance, int infinityGridUpSell1, int infinityGridUpSell2, int infinityGridUpSell3) throws Exception {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        InfinityGridUpSell1Page infinityGridUpSell1Page = new InfinityGridUpSell1Page(driver);
        InfinityGridUpSell2Page infinityGridUpSell2Page = new InfinityGridUpSell2Page(driver);
        InfinityGridUpSell3Page infinityGridUpSell3Page = new InfinityGridUpSell3Page(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Infinity Grid",
                option,
                insurance == 1 ? "insurance" : "",
                infinityGridUpSell1 == 1 ? "infinityGridUpSell1" : "",
                infinityGridUpSell2 == 1 ? "infinityGridUpSell2" : "",
                infinityGridUpSell3 == 1 ? "infinityGridUpSell3" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(option, insurance, infinityGridUpSell1, infinityGridUpSell2, infinityGridUpSell3)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        Snapshot googleSnap = automatedTest.takeSnapshot();
        googleSnap.setDescription("google.com");
        googleSnap.saveLocally("test1212/google.png");
        String email = checkoutPage.submitCheckoutForm(option, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        infinityGridUpSell1Page.decide(infinityGridUpSell1);
        infinityGridUpSell2Page.decide(infinityGridUpSell2);
        if(infinityGridUpSell1 == 0 && infinityGridUpSell2 == 1)infinityGridUpSell3Page.decide(infinityGridUpSell3);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(option, insurance, infinityGridUpSell1, infinityGridUpSell2, infinityGridUpSell3).get("total"));
    }
}
