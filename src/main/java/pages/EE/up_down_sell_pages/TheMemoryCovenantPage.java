package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TheMemoryCovenantPage extends BasePage {
    public TheMemoryCovenantPage(WebDriver driver) {
        super(driver);
    }

    By declineButton = By.id("declineButton");
    By submitButton = By.id("upsellForm");
    By upsellNameEN = By.xpath("//div[contains(text(),'The Memory Covenant')]");
    By upsellNameES = By.xpath("//div[contains(text(),'Un Pacto con tu Memoria')]");

    public void decline(){
        waitInvisibility(upsellNameEN);
        clickJS(declineButton);
        logger.info("The Memory Covenant upsell declined");
    }

    public void accept(){
        waitInvisibility(upsellNameEN);
        submitForm(submitButton);
        logger.info("The Memory Covenant upsell accepted");
    }

    public void decide(int thirdUpsell){
        if(thirdUpsell == 1) this.accept(); else this.decline();
    }
}
