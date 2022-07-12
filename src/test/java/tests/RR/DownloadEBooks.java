package tests.RR;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RR.main_pages.BooksPage;
import pages.RR.main_pages.LoginPage;
import pages.RR.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class DownloadEBooks extends BaseTest {
    public BooksPage booksPage;
    public LoginPage loginPage;
    public MembersPage membersPage;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("RR - Download Books");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "RR");
    }

    @Test(dataProvider = "RRBooksProvider", dataProviderClass = TestData.class)
    public void downloadRRBooksTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        membersPage = new MembersPage(driver);
        loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.RRPage();
        nodeThread.set(node);
        booksPage.downloadEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }

    @Test(dataProvider = "ConfessionsBooksProvider", dataProviderClass = TestData.class)
    public void downloadConfessionsBookTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        membersPage = new MembersPage(driver);
        loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.confessionsPage();
        nodeThread.set(node);
        booksPage.downloadEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }
}
