package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.BooksPage;
import pages.EE.main_pages.LoginPage;
import pages.EE.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class DownloadTheMemoryCovenantBooks extends BaseTest {
    public PropertyManager propertyManager = new PropertyManager();
    public BooksPage booksPage;
    public LoginPage loginPage;
    public MembersPage membersPage;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("Highway Healing - Download Books");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test(dataProvider = "TheMemoryCovenantBooksProvider", dataProviderClass = TestData.class)
    public void downloadHighwayHealingBooksTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);
        membersPage = new MembersPage(driver);
        booksPage = new BooksPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.closeModal();
        membersPage.theMemoryCovenantPage();
        nodeThread.set(node);
        booksPage.downloadEEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }
}
