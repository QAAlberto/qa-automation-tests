package tests.TOIL;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PropertyManager;
import pages.TOIL.main_pages.*;
import pages.TOIL.up_down_sell_pages.*;
import pages.Utils;
import tests.BaseTest;

public class MYOHO extends BaseTest {
    PropertyManager propertyManager = new PropertyManager();
    CheckoutPage checkoutPage;
    ConfirmPage confirmPage;
    Utils utils;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("Make Your Own Holy Oil");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlMYOHO", "TOIL");
    }

    @Test(dataProvider = "MYOHOCinnamonProvider", dataProviderClass = TestData.class)
    public void MYOHOCinnamonTest(String bottles, int off, int insurance, int myohoCinnamonUpSell, int myohoCinnamonDownSell) {
        checkoutPage = new CheckoutPage(driver);
        MYOHOCinnamonUpSellPage myohoCinnamonUpSellPage = new MYOHOCinnamonUpSellPage(driver);
        MYOHOCinnamonDownSellPage myohoCinnamonDownSellPage = new MYOHOCinnamonDownSellPage(driver);
        confirmPage = new ConfirmPage(driver);
        utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Trinity Oil",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                insurance == 1 ? "insurance" : "",
                myohoCinnamonUpSell == 1 ? "myohoCinnamonUpSell" : "",
                myohoCinnamonDownSell == 1 ? "myohoCinnamonDownSell" : "",
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getListCinnamon(bottles, off, insurance, myohoCinnamonUpSell, myohoCinnamonDownSell)));

        checkoutPage.checkoutPageCinnamon(baseUrl);
        String email = checkoutPage.submitCheckoutFormCinnamon(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        myohoCinnamonUpSellPage.decide(myohoCinnamonUpSell);
        if(myohoCinnamonUpSell == 0) myohoCinnamonDownSellPage.decide(myohoCinnamonDownSell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmountCinnamon(bottles, off, insurance, myohoCinnamonUpSell, myohoCinnamonDownSell).get("total"));
    }

    @Test(dataProvider = "MYOHOTurmericProvider", dataProviderClass = TestData.class)
    public void MYOHOTurmericTest(String bottles, int off, int insurance, int myohoTurmericUpSell, int myohoTurmericDownSell) {
        checkoutPage = new CheckoutPage(driver);
        MYOHOTurmericUpSellPage myohoTurmericUpSellPage = new MYOHOTurmericUpSellPage(driver);
        MYOHOTurmericDownSellPage myohoTurmericDownSellPage = new MYOHOTurmericDownSellPage(driver);
        confirmPage = new ConfirmPage(driver);
        utils = new Utils();

        String title = utils.customReportName(new String[]{
                "Trinity Oil",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                insurance == 1 ? "insurance" : "",
                myohoTurmericUpSell == 1 ? "myohoTurmericUpSell" : "",
                myohoTurmericDownSell == 1 ? "myohoTurmericDownSell" : "",
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getListTurmeric(bottles, off, insurance, myohoTurmericUpSell, myohoTurmericDownSell)));

        checkoutPage.checkoutPageTurmeric(baseUrl);
        String email = checkoutPage.submitCheckoutFormTurmeric(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        myohoTurmericUpSellPage.decide(myohoTurmericUpSell);
        if(myohoTurmericUpSell == 0) myohoTurmericDownSellPage.decide(myohoTurmericDownSell);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmountTurmeric(bottles, off, insurance, myohoTurmericUpSell, myohoTurmericDownSell).get("total"));
    }
}
