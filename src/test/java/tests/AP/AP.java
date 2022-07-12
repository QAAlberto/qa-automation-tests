package tests.AP;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AP.up_down_sell_pages.ApostlePromiseDownSellPage;
import pages.AP.up_down_sell_pages.ApostlePromiseUpSellPage;
import pages.AP.up_down_sell_pages.DivineTurmericPage;
import pages.PropertyManager;
import pages.AP.main_pages.CheckoutPage;
import pages.AP.main_pages.ConfirmPage;
import pages.Utils;
import tests.BaseTest;

public class AP extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Apostle's Promise");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "AP");
    }

    @Test(dataProvider = "APProvider", dataProviderClass = TestData.class)
    public void APTest(String bottles, int apostlePromiseUpSell, int apostlePromiseDownSell, String divineTurmeric) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Utils utils = new Utils();
        ApostlePromiseDownSellPage apostlePromiseDownSellPage = new ApostlePromiseDownSellPage(driver);
        DivineTurmericPage divineTurmericPage = new DivineTurmericPage(driver);

        String title = utils.customReportName(new String[]{
                "AP",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                apostlePromiseUpSell == 1 ? "apostlePromiseUpSell" : "",
                apostlePromiseDownSell == 1 ? "apostlePromiseDownSell" : "",
                divineTurmeric.equals("1b") ? "divineTurmeric 1 bottle" : "",
                divineTurmeric.equals("3b") ? "divineTurmeric 3 bottles" : "",
                divineTurmeric.equals("6b") ? "divineTurmeric 6 bottles" : ""
        });
        ExtentTest node = test.get().createNode("Iteration " + title);

        checkoutPage.checkoutPage(baseUrl);
        String email = (String) checkoutPage.submitCheckoutForm(bottles).get(0);
        ApostlePromiseUpSellPage apostlePromiseUpSellPage = (ApostlePromiseUpSellPage) checkoutPage.submitCheckoutForm(bottles).get(1);
        node.info(email);
        apostlePromiseUpSellPage.decide(apostlePromiseUpSell);
        if(apostlePromiseUpSell == 0) apostlePromiseDownSellPage.decide(apostlePromiseDownSell);
        ConfirmPage confirmPage = divineTurmericPage.decide(divineTurmeric);
        node.info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, apostlePromiseUpSell, apostlePromiseDownSell, divineTurmeric)));
        nodeThread.set(node);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, apostlePromiseUpSell, apostlePromiseDownSell, divineTurmeric).get("total"));
    }
}
