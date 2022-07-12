package pages.DAD.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.DAD.main_pages.ConfirmPage;

public class CombatDefenseSecretsDownSellPage extends BasePage {
    public CombatDefenseSecretsDownSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineUpsell");
    By productID = By.xpath("//strong[contains(text(),'only $15')]");

    public void accept(){
        waitVisibility(productID);
        submitForm(upsellForm);
        logger.info("Combat Defense Secrets DownSell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("Combat Defense Secrets DownSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
