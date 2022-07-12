package tests.BU;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BU.main_pages.CheckoutPage;
import pages.BU.main_pages.ConfirmPage;
import pages.BU.up_down_sell_pages.BioUnityDownSellPage;
import pages.BU.up_down_sell_pages.BioUnityUpSellPage;
import pages.BU.up_down_sell_pages.CellDivinePage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class BU extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Bio Unity");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "BU");
    }

    @Test(dataProvider = "BUProvider", dataProviderClass = TestData.class)
    public void BUTest(String bottles, int off, int insurance, int bioUnityUpSell, int bioUnityDownSell, String cellDivine) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Utils utils = new Utils();
        BioUnityUpSellPage bioUnityUpSellPage = new BioUnityUpSellPage(driver);
        BioUnityDownSellPage bioUnityDownSellPage = new BioUnityDownSellPage(driver);
        CellDivinePage cellDivinePage = new CellDivinePage(driver);

        String title = utils.customReportName(new String[]{
                "BU",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                bioUnityUpSell == 1 ? "bioUnityUpSell" : "",
                bioUnityDownSell == 1 ? "bioUnityDownSell" : "",
                cellDivine.equals("1b") ? "cellDivine 1 bottle" : "",
                cellDivine.equals("3b") ? "cellDivine 3 bottles" : "",
                cellDivine.equals("6b") ? "cellDivine 6 bottles" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title);

        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        bioUnityUpSellPage.decide(bioUnityUpSell);
        if(bioUnityUpSell == 0) bioUnityDownSellPage.decide(bioUnityDownSell);
        ConfirmPage confirmPage = cellDivinePage.decide(cellDivine);
        node.info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, bioUnityUpSell, bioUnityDownSell, cellDivine)));
        nodeThread.set(node);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, bioUnityUpSell, bioUnityDownSell, cellDivine).get("total"));
    }
}
