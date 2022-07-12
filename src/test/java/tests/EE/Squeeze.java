package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.HomePage;
import pages.PropertyManager;
import tests.BaseTest;

public class Squeeze extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Squeeze");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl"+language, "EE");
    }

    @Test
    public void squeezeTest(){
        HomePage homePage = new HomePage(driver);

        homePage.homePage(baseUrl);
        homePage.answerSqueeze();
    }
}
