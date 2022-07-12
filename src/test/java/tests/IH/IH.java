package tests.IH;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IH.main_pages.CheckoutPage;
import pages.IH.main_pages.ConfirmPage;
import pages.IH.up_down_sell_pages.FirstUpsellPage;
import pages.IH.up_down_sell_pages.FourthUpsellPage;
import pages.IH.up_down_sell_pages.SecondUpsellPage;
import pages.IH.up_down_sell_pages.ThirdUpsellPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class IH extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Instahard");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "IH");
    }

    @Test(dataProvider = "IHProvider", dataProviderClass = TestData.class)
    public void IHTest(String bottles, int off, int insurance, int firstUpsell, int secondUpsell, String thirdUpsell, String fourthUpsell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        FirstUpsellPage firstUpsellPage = new FirstUpsellPage(driver);
        SecondUpsellPage secondUpsellPage = new SecondUpsellPage(driver);
        ThirdUpsellPage thirdUpsellPage = new ThirdUpsellPage(driver);
        FourthUpsellPage fourthUpsellPage = new FourthUpsellPage(driver);
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
                thirdUpsell.equals("1b") ? "1 bottle" : "",
                thirdUpsell.equals("3b") ? "3 bottles" : "",
                thirdUpsell.equals("6b") ? "6 bottles" : "",
                fourthUpsell.equals("1b") ? "1 bottle" : "",
                fourthUpsell.equals("3b") ? "3 bottles" : "",
                fourthUpsell.equals("6b") ? "6 bottles" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, firstUpsell, secondUpsell, thirdUpsell, fourthUpsell)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        firstUpsellPage.decide(firstUpsell);
        if(firstUpsell == 0) secondUpsellPage.decide(secondUpsell);
        thirdUpsellPage.decide(thirdUpsell);
        fourthUpsellPage.decide(fourthUpsell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, firstUpsell, secondUpsell, thirdUpsell, fourthUpsell).get("total"));
        node.info("Password: " + confirmPage.getPassword());
    }
}
