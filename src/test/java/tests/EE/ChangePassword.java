package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EE.main_pages.ChangePasswordPage;
import pages.EE.main_pages.HelpPage;
import pages.EE.main_pages.LoginPage;
import pages.EE.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class ChangePassword extends BaseTest {
    public PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void beforeClass(){
        ExtentTest extentTest = extent.createTest("Exodus Effect - Change Password");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void changePasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        MembersPage membersPage = new MembersPage(driver);
        HelpPage helpPage = new HelpPage(driver);
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.closeModal();
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("newPassword", "EE"));
        Assert.assertEquals(changePasswordPage.getMembersTitle(), "Password Change Complete");
        membersPage.helpPage();
        helpPage.changePasswordPage();
        changePasswordPage.changePassword(propertyManager.getProperty("password", "EE"));
        Assert.assertEquals(changePasswordPage.getMembersTitle(), "Password Change Complete");
    }
}
