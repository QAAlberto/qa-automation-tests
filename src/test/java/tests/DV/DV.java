package tests.DV;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DV.main_pages.CheckoutPage;
import pages.DV.main_pages.ConfirmPage;
import pages.DV.up_down_sell_pages.DBTurmericPage;
import pages.DV.up_down_sell_pages.DivineVisionDownSellPage;
import pages.DV.up_down_sell_pages.DivineVisionUpSellPage;
import pages.DV.up_down_sell_pages.MostPopularPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class DV extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Divine Vision");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "DV");
    }

    @Test(dataProvider = "DVProvider", dataProviderClass = TestData.class)
    public void DVTest(String bottles, int divineVisionUpSell, int divineVisionDownSell, String dbTurmeric, String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();
        DivineVisionUpSellPage divineVisionUpSellPage = new DivineVisionUpSellPage(driver);
        DivineVisionDownSellPage divineVisionDownSellPage = new DivineVisionDownSellPage(driver);
        DBTurmericPage dbTurmericPage = new DBTurmericPage(driver);
        MostPopularPage mostPopularPage = new MostPopularPage(driver);

        String title = utils.customReportName(new String[]{
                "DV",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                divineVisionUpSell == 1 ? "divineVisionUpSell" : "",
                divineVisionDownSell == 1 ? "divineVisionDownSell" : "",
                dbTurmeric.equals("1b") ? "dbTurmeric 1 bottle" : "",
                dbTurmeric.equals("3b") ? "dbTurmeric 3 bottles" : "",
                dbTurmeric.equals("6b") ? "dbTurmeric 6 bottles" : "",
                dbGlucose16.equals("1b") ? "dbGlucose16 1 bottle" : "",
                dbGlucose16.equals("3b") ? "dbGlucose16 3 bottles" : "",
                dbGlucose16.equals("6b") ? "dbGlucose16 6 bottles" : "",
                gloryBiotics.equals("1b") ? "gloryBiotics 1 bottle" : "",
                gloryBiotics.equals("3b") ? "gloryBiotics 3 bottles" : "",
                gloryBiotics.equals("6b") ? "gloryBiotics 6 bottles" : "",
                dbOmegaPlus.equals("1b") ? "dbOmegaPlus 1 bottle" : "",
                dbOmegaPlus.equals("3b") ? "dbOmegaPlus 3 bottles" : "",
                dbOmegaPlus.equals("6b") ? "dbOmegaPlus 6 bottles" : "",
                divineDailyEnergy.equals("1b") ? "divineDailyEnergy 1 bottle" : "",
                divineDailyEnergy.equals("3b") ? "divineDailyEnergy 3 bottles" : "",
                divineDailyEnergy.equals("6b") ? "divineDailyEnergy 6 bottles" : "",
        });
        ExtentTest node = test.get().createNode("Iteration " + title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, divineVisionUpSell, divineVisionDownSell, dbTurmeric, dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        divineVisionUpSellPage.decide(divineVisionUpSell);
        if(divineVisionUpSell == 0) divineVisionDownSellPage.decide(divineVisionDownSell);
        dbTurmericPage.decide(dbTurmeric);
        mostPopularPage.decide(dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, divineVisionUpSell, divineVisionDownSell, dbTurmeric, dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy));
    }
}
