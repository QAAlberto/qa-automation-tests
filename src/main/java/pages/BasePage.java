package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage extends Utils{
    public WebDriver driver;
    public WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitInvisibility(By elementBy){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void waitForElementToBeClickable (By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void assertEqualsAttributes (By elementBy, String attributeName, String expectedText) {
        Assert.assertEquals(driver.findElement(elementBy).getAttribute(attributeName), expectedText);
    }

    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void selectOptionFromSelect(By elementBy, String option){
        Select stateSelect = new Select(driver.findElement(elementBy));
        stateSelect.selectByVisibleText(option);
    }

    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void assertEqualsMultipleElements(By elementBy, String[] expectedTexts){
        waitForElementToBeClickable(elementBy);
        List<WebElement> elements = driver.findElements(elementBy);
        ArrayList<String> messages = new ArrayList<String>();
        for(WebElement element : elements) {
            messages.add(element.getText());
        }
        for (int i = 0; i < expectedTexts.length; i++) {
            Assert.assertEquals(messages.get(i), expectedTexts[i]);
        }
    }

    public void assertEqualsURL(String expectedURL){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, expectedURL);
    }

    public Object[] getFile(String filename){
        Object[] file = isFileDownloaded(System.getProperty("user.dir") + File.separator + "downloads", filename);
        return file;
    }

    public void assertFile(String filename, long fileSize){
        Object[] file = isFileDownloaded(System.getProperty("user.dir") + File.separator + "downloads", filename);
        Assert.assertTrue((boolean)file[0], "Failed to download Expected document");
        Assert.assertEquals(file[1], fileSize);
        deleteFile(filename);
    }

    public Object[] isFileDownloaded(String downloadPath, String fileName) {
        Object[] file = new Object[2];
        file[0] = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)){
                file[0] = true;
                file[1] = dir_contents[i].length();
            }
        }

        return file;
    }

    public void deleteFile(String fileName){
        File dir = new File(System.getProperty("user.dir") + File.separator + "downloads");
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)){
                dir_contents[i].delete();
            }
        }
    }

    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void submitForm(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).submit();
    }

    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void clickJS(By elementBy){
        waitForElementToBeClickable(elementBy);
        WebElement element = driver.findElement(elementBy);
        String javascript = "arguments[0].click()";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript(javascript, element);
    }

    public void waitForElementToFadeIn (final By elementBy, final String cssValue, final String equals) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(elementBy).getCssValue(cssValue).equals(equals);
            }
        });
    }

    public String executeJS(String command){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = (String) js.executeScript(command);
        return value;
    }

    public void randomClick(By elementsBy){
        waitForElementToBeClickable(elementsBy);
        List<WebElement> elements = driver.findElements(elementsBy);
        Random rand = new Random();
        elements.get(rand.nextInt(elements.size())).click();
    }
}
