package tests.TCBD;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PropertyManager;
import pages.TCBD.main_pages.*;
import pages.TCBD.up_down_sell_pages.*;
import pages.Utils;
import tests.BaseTest;

public class TCBD extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Trinity Oil CBD");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "TCBD");
    }

    @Test(dataProvider = "TCBDProvider", dataProviderClass = TestData.class)
    public void TCBDTest(String bottles, int off, int insurance, int firstUpsell, int secondUpsell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        FirstUpsellPage firstUpsellPage = new FirstUpsellPage(driver);
        SecondUpsellPage secondUpsellPage = new SecondUpsellPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "TCBD",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                firstUpsell == 1 ? "firstUpsell" : "",
                secondUpsell == 1 ? "secondUpsell" : "",
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, firstUpsell, secondUpsell)));

        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        firstUpsellPage.decide(firstUpsell);
        if(firstUpsell == 0) secondUpsellPage.decide(secondUpsell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, firstUpsell, secondUpsell).get("total"));
    }
}
