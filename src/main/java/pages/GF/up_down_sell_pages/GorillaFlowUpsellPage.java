package pages.GF.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GorillaFlowUpsellPage extends BasePage {
    public GorillaFlowUpsellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='817']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Gorilla Flow upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Gorilla Flow upsell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
