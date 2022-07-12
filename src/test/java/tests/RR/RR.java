package tests.RR;

import com.aventstack.extentreports.ExtentTest;
import data_set.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PropertyManager;
import pages.RR.main_pages.ConfirmPage;
import pages.RR.main_pages.ProductsPage;
import pages.RR.main_pages.ProductPage;
import tests.BaseTest;

public class RR extends BaseTest {
    PropertyManager propertyManager;

    @BeforeClass
    @Parameters("language")
    public void beforeClass(String language){
        propertyManager = new PropertyManager();
        ExtentTest extentTest = extent.createTest("RR");
        test.set(extentTest);
        lang = language;
        baseUrl = propertyManager.getProperty("baseUrl", "RR");
    }

    @Test(dataProvider = "RRProvider", dataProviderClass = TestData.class)
    public void RRTest(String product) {
        ProductsPage productsPage = new ProductsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);

        ExtentTest node = test.get().createNode("Iteration "+ product);

        productsPage.productPage(baseUrl, product);
        String email = productPage.submitProductForm();
        node.info(email);

        confirmPage.verifyGrandTotal(product);
        Assert.assertEquals(confirmPage.getGrandTotal(), "$" + propertyManager.getProperty(product + "Amount", "RR"));
        node.info("Password: " + confirmPage.getPassword());
        nodeThread.set(node);
    }
}
