package pages.DAD.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CombatDefenseSecretsUpSellPage extends BasePage {
    public CombatDefenseSecretsUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineUpsell");
    By productID = By.xpath("//input[@value='1200']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Combat Defense Secrets UpSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Combat Defense Secrets UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
