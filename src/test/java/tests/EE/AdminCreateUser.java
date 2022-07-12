package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EE.main_pages.AddUserPage;
import pages.EE.main_pages.AdminPage;
import pages.EE.main_pages.LoginPage;
import pages.PropertyManager;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class AdminCreateUser extends BaseTest {
    AdminPage adminPage;
    PropertyManager propertyManager;
    @BeforeClass
    public void beforeClass(){
        propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Admin - Create User");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("adminURL", "EE");
        adminPage = new AdminPage(driver);
        adminPage.loginPage(baseUrl);
        adminPage.signIn();
        adminPage.membersPage();
    }

    @Test
    public void adminCreateUser(){
        AddUserPage addUserPage = new AddUserPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        adminPage.clickAddNewMembership();
        String email = addUserPage.addUser(new int[]{0, 0, 0, 0});
        loginPage.loginPage(propertyManager.getProperty("baseUrlEN", "EE"));
        loginPage.signIn(email, propertyManager.getProperty("newAdminPassword", "EE"));
        assertEquals(driver.getCurrentUrl(), propertyManager.getProperty("baseUrlEN", "EE") + "members/");
    }
}
