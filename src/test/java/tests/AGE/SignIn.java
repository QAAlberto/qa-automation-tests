package tests.AGE;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AGE.main_pages.LoginPage;
import pages.AGE.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class SignIn extends BaseTest {
    @BeforeClass
    public void beforeClass(){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("AGE - Sign In");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "AGE");
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        Assert.assertEquals(driver.getCurrentUrl(), "members");
    }
}
