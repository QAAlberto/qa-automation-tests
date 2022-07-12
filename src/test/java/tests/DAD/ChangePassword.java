package tests.DAD;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DAD.main_pages.ChangePasswordPage;
import pages.DAD.main_pages.HelpPage;
import pages.DAD.main_pages.LoginPage;
import pages.DAD.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class ChangePassword extends BaseTest {
    public LoginPage loginPage;
    public MembersPage membersPage;
    public PropertyManager propertyManager = new PropertyManager();
    public HelpPage helpPage;
    public ChangePasswordPage changePasswordPage;

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("DAD - Change Password");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "DAD");
    }

    @Test
    public void changePasswordTest(){
        loginPage = new LoginPage(driver);
        membersPage = new MembersPage(driver);
        helpPage = new HelpPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("newPassword", "DAD"));
        changePasswordPage.verifyPasswordChange();
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("password", "DAD"));
        changePasswordPage.verifyPasswordChange();
    }
}
