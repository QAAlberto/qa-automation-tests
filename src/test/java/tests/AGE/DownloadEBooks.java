package tests.AGE;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AGE.main_pages.BooksPage;
import pages.AGE.main_pages.LoginPage;
import pages.AGE.main_pages.MembersPage;
import pages.PropertyManager;
import tests.BaseTest;

public class DownloadEBooks extends BaseTest {
    PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        ExtentTest extentTest = extent.createTest("AGE - Download Books");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrl", "AGE");
    }

    @Test(dataProvider = "AGEBonusesBooksProvider", dataProviderClass = TestData.class)
    public void downloadBonusesBooksTest(String fileName, long fileSize) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        MembersPage membersPage = loginPage.signIn();
        BooksPage booksPage = membersPage.bonusesPage();
        nodeThread.set(node);
        booksPage.downloadEEBook(fileName);
        Thread.sleep(8000);
        Object[] file = booksPage.getFile(fileName);
        Assert.assertTrue((boolean)file[0], "Failed to download Expected document");
        Assert.assertEquals(file[1], fileSize);
        booksPage.deleteFile(fileName);
    }

    @Test
    public void downloadAmplifireBookTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        String fileName = "ebook-AMPLI-FIRE.pdf";
        int fileSize = 369638;

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        MembersPage membersPage = loginPage.signIn();
        BooksPage booksPage = membersPage.bonusesPage();
        nodeThread.set(node);
        booksPage.downloadEEBook(fileName);
        Thread.sleep(8000);
        Object[] file = booksPage.getFile(fileName);
        Assert.assertTrue((boolean)file[0], "Failed to download Expected document");
        Assert.assertEquals(file[1], fileSize);
        booksPage.deleteFile(fileName);
    }

    @Test
    public void downloadKnightStickBookTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        String fileName = "ebook-Knightstick.pdf";
        int fileSize = 1419437;

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        MembersPage membersPage = loginPage.signIn();
        BooksPage booksPage = membersPage.bonusesPage();
        nodeThread.set(node);
        booksPage.downloadEEBook(fileName);
        Thread.sleep(8000);
        Object[] file = booksPage.getFile(fileName);
        Assert.assertTrue((boolean)file[0], "Failed to download Expected document");
        Assert.assertEquals(file[1], fileSize);
        booksPage.deleteFile(fileName);
    }
}
