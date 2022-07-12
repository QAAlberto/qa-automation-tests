package tests.KFX3;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.KFX3.main_pages.CheckoutPage;
import pages.KFX3.main_pages.ConfirmPage;
import pages.KFX3.up_down_sell_pages.GlucoDefendPage;
import pages.KFX3.up_down_sell_pages.KetoDownSellPage;
import pages.KFX3.up_down_sell_pages.KetoUpSellPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class KFX3 extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Keto Fire X3");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "KFX3");
    }

    @Test(dataProvider = "KFX3Provider", dataProviderClass = TestData.class)
    public void KFX3Test(String bottles, int insurance, int ketoUpSell, int ketoDownSell, int glucoDefend) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();
        KetoUpSellPage ketoUpSellPage = new KetoUpSellPage(driver);
        KetoDownSellPage ketoDownSellPage = new KetoDownSellPage(driver);
        GlucoDefendPage glucoDefendPage = new GlucoDefendPage(driver);

        String title = utils.customReportName(new String[]{
                "KFX3",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, insurance, ketoUpSell, ketoDownSell, glucoDefend)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitContactInformation(bottles);
        checkoutPage.submitCheckoutForm(insurance);
        node.info(email);
        nodeThread.set(node);
        ketoUpSellPage.decide(ketoUpSell);
        if(ketoUpSell == 0)ketoDownSellPage.decide(ketoDownSell);
        glucoDefendPage.decide(glucoDefend);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, insurance, ketoUpSell, ketoDownSell, glucoDefend).get("total"));
    }
}
