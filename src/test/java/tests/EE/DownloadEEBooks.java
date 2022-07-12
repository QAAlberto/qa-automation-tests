package tests.EE;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EE.main_pages.*;
import pages.PropertyManager;
import tests.BaseTest;

public class DownloadEEBooks extends BaseTest {
    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        PropertyManager propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("Exodus Effect - Download Books");
        test.set(extentTest);
        baseUrl = propertyManager.getProperty("baseUrlEN", "EE");
    }

    @Test(dataProvider = "EEBooksProvider", dataProviderClass = TestData.class)
    public void downloadEEBooksTest(String fileName, long fileSize) throws InterruptedException {
        BooksPage booksPage = new BooksPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MembersPage membersPage = new MembersPage(driver);

        ExtentTest node = test.get().createNode("Iteration: " + fileName);

        loginPage.loginPage(baseUrl);
        loginPage.signIn();
        membersPage.closeModal();
        membersPage.exodusEffectPage();
        nodeThread.set(node);
        booksPage.downloadEEBook(fileName);
        Thread.sleep(8000);
        booksPage.verifyDownloadedBook(fileName, fileSize);
    }
}
