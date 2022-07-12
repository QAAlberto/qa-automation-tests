package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TheMemoryCovenantTwoPage extends BasePage {
    public TheMemoryCovenantTwoPage(WebDriver driver) {
        super(driver);
    }

    By declineButton = By.id("declineButton");
    By submitButton = By.id("upsellForm");
    By upsellNameEN = By.xpath("//span[contains(text(),'WAIT - Last Chance: Want 50% Off Memory Covenant Plus Free Gifts?')]");

    public void decline(){
        waitVisibility(upsellNameEN);
        clickJS(declineButton);
        logger.info("The Memory Covenant Two upsell declined");
    }

    public void accept(){
        waitVisibility(upsellNameEN);
        submitForm(submitButton);
        logger.info("The Memory Covenant Two upsell accepted");
    }

    public void decide(int fourthUpsell){
        if(fourthUpsell == 1) this.accept(); else this.decline();
    }
}
