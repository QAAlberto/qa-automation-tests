package tests.AGE;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AGE.main_pages.CheckoutPage;
import pages.AGE.main_pages.ConfirmPage;
import pages.AGE.main_pages.OrderPage;
import pages.AGE.up_down_sell_pages.AmplifirePage;
import pages.AGE.up_down_sell_pages.KnightStickPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class AGE extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("AGE");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "AGE");
    }

    @Test(dataProvider = "AGEProvider", dataProviderClass = TestData.class)
    public void AGETest(int knightStick, int amplifire){
        OrderPage orderPage = new OrderPage(driver);
        Utils utils = new Utils();
        String title = utils.customReportName(new String[]{
                "AGE",
                knightStick == 1 ? "knightStickPage" : "",
                amplifire == 1 ? "amplifirePage" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title);

        orderPage.orderPage(baseUrl);
        CheckoutPage checkoutPage = orderPage.checkoutPage();
        String email = checkoutPage.submitContactInformation();
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        checkoutPage.submitBillingAddress();
        AmplifirePage amplifirePage = checkoutPage.submitPayment();
        KnightStickPage knightStickPage = amplifirePage.decide(amplifire);
        ConfirmPage confirmPage = knightStickPage.decide(knightStick);
        node.info(MarkupHelper.createOrderedList(confirmPage.getList(knightStick, amplifire)));
        nodeThread.set(node);

        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(knightStick, amplifire).get("total"));
        node.info("Password: " + confirmPage.getPassword());
    }
}
