package tests.DAD;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DAD.main_pages.LoginPage;
import pages.DAD.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class SignIn extends BaseTest {
    public LoginPage loginPage;
    public MembersPage membersPage;
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("DAD - Sign In");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "DAD");
    }

    @Test
    public void signInTest(){
        loginPage = new LoginPage(driver);
        membersPage = new MembersPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.verifySignIn(baseUrl);
    }
}
