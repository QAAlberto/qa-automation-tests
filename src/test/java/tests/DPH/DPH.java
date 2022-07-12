package tests.DPH;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DPH.main_pages.*;
import pages.DPH.up_down_sell_pages.*;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class DPH extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("DPH");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrlEN", "DPH");
    }

    @Test(dataProvider = "DPHProvider", dataProviderClass = TestData.class)
    public void DPHTest(String bottles, int off, int insurance, int DPH6BottlesUpsell, int DPH3BottlesUpsell, int waterPitcher1CartridgeUpsell, int waterPitcher2CartridgeUpsell, int cartridge4Upsell, int cartridge2Upsell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        DPH6BottlesPage DPH6BottlesPage = new DPH6BottlesPage(driver);
        DPH3BottlesPage DPH3BottlesPage = new DPH3BottlesPage(driver);
        WaterPitcher1CartridgePage waterPitcher1CartridgePage = new WaterPitcher1CartridgePage(driver);
        WaterPitcher2CartridgePage waterPitcher2CartridgePage = new WaterPitcher2CartridgePage(driver);
        Cartridge4Page cartridge4Page = new Cartridge4Page(driver);
        Cartridge2Page cartridge2Page = new Cartridge2Page(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();

        String title = utils.customReportName(new String[]{
                "DPH",
                bottles.equals("1b") ? "1 bottle" : "",
                bottles.equals("3b") ? "3 bottles" : "",
                bottles.equals("6b") ? "6 bottles" : "",
                off == 1 ? "continuity" : "",
                insurance == 1 ? "insurance" : "",
                DPH6BottlesUpsell == 1 ? "DPH6BottlesUpsell" : "",
                DPH3BottlesUpsell == 1 ? "DPH3BottlesUpsell" : "",
                waterPitcher1CartridgeUpsell == 1 ? "waterPitcher1CartridgeUpsell" : "",
                waterPitcher2CartridgeUpsell == 1 ? "waterPitcher2CartridgeUpsell" : "",
                cartridge4Upsell == 1 ? "cartridge4Upsell" : "",
                cartridge2Upsell == 1 ? "cartridge2Upsell" : ""
        });
        ExtentTest node = test.get().createNode("Iteration "+ title)
                .info(MarkupHelper.createOrderedList(confirmPage.getList(bottles, off, insurance, DPH6BottlesUpsell, DPH3BottlesUpsell, waterPitcher1CartridgeUpsell, waterPitcher2CartridgeUpsell, cartridge4Upsell, cartridge2Upsell)));

        nodeThread.set(node);
        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(bottles, off, insurance);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        nodeThread.set(node);
        if(bottles.equals("1b")){
            DPH6BottlesPage.decide(DPH6BottlesUpsell);
            if(DPH6BottlesUpsell == 0) DPH3BottlesPage.decide(DPH3BottlesUpsell);
            waterPitcher1CartridgePage.decide(waterPitcher1CartridgeUpsell);
            if(waterPitcher1CartridgeUpsell == 0) waterPitcher2CartridgePage.decide(waterPitcher2CartridgeUpsell);
            if(waterPitcher2CartridgeUpsell == 1 || waterPitcher1CartridgeUpsell == 1) {
                cartridge4Page.decide(cartridge4Upsell);
                if(cartridge4Upsell == 0) cartridge2Page.decide(cartridge2Upsell);
            }
        }else{
            waterPitcher1CartridgePage.decide(waterPitcher1CartridgeUpsell);
            if(waterPitcher1CartridgeUpsell == 0) waterPitcher2CartridgePage.decide(waterPitcher2CartridgeUpsell);
            if(waterPitcher2CartridgeUpsell == 1 || waterPitcher1CartridgeUpsell == 1) {
                cartridge4Page.decide(cartridge4Upsell);
                if(cartridge4Upsell == 0) cartridge2Page.decide(cartridge2Upsell);
            }
            DPH6BottlesPage.decide(DPH6BottlesUpsell);
            if(DPH6BottlesUpsell == 0) DPH3BottlesPage.decide(DPH3BottlesUpsell);
        }
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(bottles, off, insurance, DPH6BottlesUpsell, DPH3BottlesUpsell, waterPitcher1CartridgeUpsell, waterPitcher2CartridgeUpsell, cartridge4Upsell, cartridge2Upsell));
    }
}
