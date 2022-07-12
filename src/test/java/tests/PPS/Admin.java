package tests.PPS;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PPS.main_pages.*;
import pages.PropertyManager;
import pages.Utils;
import tests.BaseTest;

public class Admin extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Admin Tests");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "PPS");
    }

//    @Test
//    public void loginTest() {
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.loginPage(baseUrl);
//        loginPage.signIn();
//        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/dashboard");
//    }

//    @Test
//    public void newTradeTest() {
//        LoginPage loginPage = new LoginPage(driver);
//        AdminPage adminPage = new AdminPage(driver);
//        NewTradePage newTradePage = new NewTradePage(driver);
//        TradesListPage tradesListPage = new TradesListPage(driver);
//        Utils utils = new Utils();
//
//        String title = "newTrade" + utils.getTimeStamp();
//
//        loginPage.loginPage(baseUrl);
//        loginPage.signIn();
//        adminPage.newTradePage();
//        newTradePage.newTrade(title);
//        Assert.assertEquals(title, tradesListPage.getLastCreatedTrade());
//    }

//    @Test
//    public void editTradeTest() {
//        LoginPage loginPage = new LoginPage(driver);
//        AdminPage adminPage = new AdminPage(driver);
//        TradesListPage tradesListPage = new TradesListPage(driver);
//        EditTradePage editTradePage = new EditTradePage(driver);
//
//        String title = "trade updated";
//
//        loginPage.loginPage(baseUrl);
//        loginPage.signIn();
//        adminPage.tradesListPage();
//        tradesListPage.editLastCreatedTradePage();
//        editTradePage.editTrade(title);
//        adminPage.tradesListPage();
//        Assert.assertEquals(title, tradesListPage.getLastCreatedTrade());
//    }

    @Test
    public void activeDeactivateTradeTest() {
        LoginPage loginPage = new LoginPage(driver);
        AdminPage adminPage = new AdminPage(driver);
        TradesListPage tradesListPage = new TradesListPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        adminPage.tradesListPage();
        tradesListPage.activeDeactivateLastCreatedTrade();
        Assert.assertEquals("Activate", tradesListPage.getActiveDeactivateButton());
        tradesListPage.activeDeactivateLastCreatedTrade();
        Assert.assertEquals("Deactivate", tradesListPage.getActiveDeactivateButton());
    }


}
