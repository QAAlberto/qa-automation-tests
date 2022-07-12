package tests.TOIL;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TOIL.main_pages.*;
import pages.PropertyManager;
import pages.TOIL.up_down_sell_pages.FirstUpsellPage;
import pages.TOIL.up_down_sell_pages.SecondUpsellPage;
import pages.TOIL.up_down_sell_pages.ThirdUpsellPage;
import pages.Utils;
import tests.BaseTest;

public class TOILDiscount30 extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Trinity Oil - Discount 30%");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "TOIL");
    }

    @Test(dataProvider = "TOILProvider", dataProviderClass = TestData.class)
    public void TOILDiscount30Test(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        FirstUpsellPage firstUpsellPage = new FirstUpsellPage(driver);
        SecondUpsellPage secondUpsellPage = new SecondUpsellPage(driver);
        ThirdUpsellPage thirdUpsellPage = new ThirdUpsellPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Trinity Oil",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                firstUpsell == 1 ? "firstUpsell" : "",
                secondUpsell == 1 ? "secondUpsell" : "",
                thirdUpsell == 1 ? "thirdUpsell" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getListDiscount30(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell, lang)));

        nodeThread.set(node);
        checkoutPage.checkoutPageDiscount30(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, country, insurance);
        node.info(email);
        nodeThread.set(node);
        firstUpsellPage.decide(firstUpsell);
        if(firstUpsell == 0) secondUpsellPage.decide(secondUpsell);
        thirdUpsellPage.decide(thirdUpsell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmountDiscount30(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell).get("total"));
    }
}
