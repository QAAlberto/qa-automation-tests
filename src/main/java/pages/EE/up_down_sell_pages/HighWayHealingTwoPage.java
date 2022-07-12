package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HighWayHealingTwoPage extends BasePage {
    public HighWayHealingTwoPage(WebDriver driver) {
        super(driver);
    }

    By declineButton = By.id("declineButton");
    By submitButton = By.id("submitButton");
    By upsellNameEN = By.xpath("//span[contains(.,'Want 50%')]");

    public void decline(){
        waitVisibility(upsellNameEN);
        click(declineButton);
        logger.info("Highway Healing Two upsell declined");
    }

    public void accept(){
        waitVisibility(upsellNameEN);
        click(submitButton);
        logger.info("Highway Healing upsell accepted");
    }

    public void decide(int secondUpsell){
        if(secondUpsell == 1) this.accept(); else this.decline();
    }
}
