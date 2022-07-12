package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SpiritOfHealingPage extends BasePage {
    public SpiritOfHealingPage(WebDriver driver) {
        super(driver);
    }

    By mainButton = By.id("floatingCTA");

    public void checkoutPage(){
        click(mainButton);
        logger.info("Checkout Page loaded");
    }

    public void spiritOfHealing(String baseUrl){
        driver.get(baseUrl + "Spirit-Of-Healing");
        logger.info("Spirit Of Healing Page loaded");
    }
}
