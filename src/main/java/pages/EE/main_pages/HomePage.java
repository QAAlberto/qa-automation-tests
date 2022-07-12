package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By squeezeOptions1 = By.xpath("//div[@id='slide1']//div[@class='option']");
    By squeezeOptions2 = By.xpath("//div[@id='slide2']//div[@class='option']");
    By squeezeOptions3 = By.xpath("//div[@id='slide3']//div[@class='option']");
    By squeezeOptions4 = By.xpath("//div[@id='slide4']//div[@class='option']");
    By squeezeOptions5 = By.xpath("//div[@id='slide5']//div[@class='option']");
    By emailField = By.id("email");


    public void homePage(String baseUrl){
        driver.get(baseUrl + propertyManager.getProperty("testingKey", "EE"));
        logger.info("Home Page loaded");
    }

    public void answerSqueeze(){
        String email = "alberto+test+EE" + getTimeStamp() + "@redhotmarketingllc.com";
        randomClick(squeezeOptions1);
        randomClick(squeezeOptions2);
        randomClick(squeezeOptions3);
        randomClick(squeezeOptions4);
        randomClick(squeezeOptions5);
        writeText(emailField, email);
    }
}
