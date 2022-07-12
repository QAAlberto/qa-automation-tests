package pages.KFX3.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GlucoDefendPage extends BasePage {
    public GlucoDefendPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//h3[contains(text(),'It’s Called GlucoDefend 16… ')]");

    public void accept(){
        waitVisibility(productID);
        submitForm(upsellForm);
        logger.info("GlucoDefend UpSell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("GlucoDefend UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
