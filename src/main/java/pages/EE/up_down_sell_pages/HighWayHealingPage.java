package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HighWayHealingPage extends BasePage {
    public HighWayHealingPage(WebDriver driver) {
        super(driver);
    }

    By declineButton = By.id("declineButton");
    By submitButton = By.id("submitButton");
    By productID = By.xpath("//input[@value='1214']");

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Highway Healing upsell declined");
    }

    public void accept(){
        waitInvisibility(productID);
        click(submitButton);
        logger.info("Highway Healing upsell accepted");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
