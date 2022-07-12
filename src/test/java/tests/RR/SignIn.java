package tests.RR;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RR.main_pages.LoginPage;
import pages.RR.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class SignIn extends BaseTest {
    @BeforeClass
    public void beforeClass(){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("RR - Sign In");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "RR");
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = new LoginPage(driver);
        MembersPage membersPage = new MembersPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.verifySignIn(baseUrl);
    }
}
