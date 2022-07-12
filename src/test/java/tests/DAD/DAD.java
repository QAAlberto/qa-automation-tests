package tests.DAD;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DAD.main_pages.CheckoutPage;
import pages.DAD.main_pages.ConfirmPage;
import pages.DAD.up_down_sell_pages.CombatDefenseSecretsDownSellPage;
import pages.DAD.up_down_sell_pages.CombatDefenseSecretsUpSellPage;
import pages.DAD.up_down_sell_pages.VelocityDownSellPage;
import pages.DAD.up_down_sell_pages.VelocityUpSellPage;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class DAD extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Dark Age Defense");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "DAD");
    }

    @Test(dataProvider = "DADProvider", dataProviderClass = TestData.class)
    public void DADTest(int boss, int velocityUpSell, int velocityDownSell, int combatDefenseSecretsUpSell, int combatDefenseSecretsDownSell) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        Utils utils = new Utils();
        VelocityUpSellPage velocityUpSellPage = new VelocityUpSellPage(driver);
        VelocityDownSellPage velocityDownSellPage = new VelocityDownSellPage(driver);
        CombatDefenseSecretsUpSellPage combatDefenseSecretsUpSellPage = new CombatDefenseSecretsUpSellPage(driver);
        CombatDefenseSecretsDownSellPage combatDefenseSecretsDownSellPage = new CombatDefenseSecretsDownSellPage(driver);

        String title = utils.customReportName(new String[]{
                "DAD",
                boss == 1 ? "BOSS" : "",
                velocityUpSell == 1 ? "velocityUpSell" : "",
                velocityDownSell == 1 ? "velocityDownSell" : "",
                combatDefenseSecretsUpSell == 1 ? "combatDefenseSecretsUpSell" : "",
                combatDefenseSecretsDownSell == 1 ? "combatDefenseSecretsDownSell" : "",

        });
        ExtentTest node = test.get().createNode("Iteration " + title);

        checkoutPage.checkoutPage(baseUrl);
        String email = checkoutPage.submitCheckoutForm(boss);
        node.info(email);
        node.info(checkoutPage.getDeviceID());
        velocityUpSellPage.decide(velocityUpSell);
        if(velocityUpSell == 0) velocityDownSellPage.decide(velocityDownSell);
        combatDefenseSecretsUpSellPage.decide(combatDefenseSecretsUpSell);
        if(combatDefenseSecretsUpSell == 0) combatDefenseSecretsDownSellPage.decide(combatDefenseSecretsDownSell);
        node.info(MarkupHelper.createOrderedList(confirmPage.getList(boss, velocityUpSell, velocityDownSell, combatDefenseSecretsUpSell, combatDefenseSecretsDownSell)));
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + confirmPage.getAmount(boss, velocityUpSell, velocityDownSell, combatDefenseSecretsUpSell, combatDefenseSecretsDownSell).get("total"));
        node.info("Password: " + confirmPage.getPassword());
        nodeThread.set(node);
    }
}
