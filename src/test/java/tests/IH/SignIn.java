package tests.IH;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IH.main_pages.LoginPage;
import pages.IH.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class SignIn extends BaseTest {
    @BeforeClass
    public void beforeClass(){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("IH - Sign In");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "IH");
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
