package pages.TOIL.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By introButtons = By.xpath("//*[@class='cartButton clearExitPop']");

    public void homePage(String baseUrl){
        driver.get(baseUrl + propertyManager.getProperty("testingKey", "TOIL"));
        logger.info("Home Page loaded");
    }

    public void orderPage(){
        randomClick(introButtons);
        logger.info("Order Page loaded");
    }
}
