package tests.RR;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RR.main_pages.ChangePasswordPage;
import pages.RR.main_pages.HelpPage;
import pages.RR.main_pages.LoginPage;
import pages.RR.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class ChangePassword extends BaseTest {
    PropertyManager propertyManager = new PropertyManager();;

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("RR - Change Password");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "RR");
    }

    @Test
    public void changePasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        MembersPage membersPage = new MembersPage(driver);
        HelpPage helpPage = new HelpPage(driver);
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("newPassword", "RR"));
        changePasswordPage.verifyPasswordChange();
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("password", "RR"));
        changePasswordPage.verifyPasswordChange();
    }
}
