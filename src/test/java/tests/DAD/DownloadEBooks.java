package tests.DAD;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DAD.main_pages.BooksPage;
import pages.DAD.main_pages.LoginPage;
import pages.DAD.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class DownloadEBooks extends BaseTest {
    public PropertyManager propertyManager = new PropertyManager();
    public BooksPage booksPage;
    public LoginPage loginPage;
    public MembersPage membersPage;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("DAD - Download Books");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "DAD");
    }

    @Test(dataProvider = "DADBooksProvider", dataProviderClass = TestData.class)
    public void downloadBonusesBooksTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        membersPage = new MembersPage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.DADPage();
        nodeThread.set(node);
        booksPage.downloadEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }

    @Test(dataProvider = "VelocityBooksProvider", dataProviderClass = TestData.class)
    public void downloadVelocityBookTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        membersPage = new MembersPage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.velocityPage();
        nodeThread.set(node);
        booksPage.downloadEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }

    @Test(dataProvider = "CombatDefenseSecretsBooksProvider", dataProviderClass = TestData.class)
    public void downloadCombatDefenseSecretsBookTest(String fileName, long fileSize) throws InterruptedException {
        booksPage = new BooksPage(driver);
        membersPage = new MembersPage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.combatDefenseSecretsPage();
        nodeThread.set(node);
        booksPage.downloadEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }
}
