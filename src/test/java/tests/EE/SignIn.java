package tests.EE;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EE.main_pages.LoginPage;
import pages.EE.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class SignIn extends BaseTest {
    @BeforeClass
    public void beforeClass(){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Exodus Effect - Sign In");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        assertEquals(driver.getCurrentUrl(), baseUrl + "members/");
    }
}
