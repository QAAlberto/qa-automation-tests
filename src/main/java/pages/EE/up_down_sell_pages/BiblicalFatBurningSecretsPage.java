package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BiblicalFatBurningSecretsPage extends BasePage {
    public BiblicalFatBurningSecretsPage(WebDriver driver) {
        super(driver);
    }

    By declineButton = By.id("declineButton");
    By submitButton = By.id("submitButton");
    By upsellNameEN = By.xpath("//div[contains(text(),'Biblical Fat Burning Secrets')]");
    By upsellNameES = By.xpath("//div[contains(text(),'Secretos Bíblicos Para Quemar Grasa')]");

    public void decline(String language){
        if(language.equals("EN")) waitInvisibility(upsellNameEN); else waitInvisibility(upsellNameES);
        click(declineButton);
        logger.info("Biblical Fat Burning Secrets upsell declined");
    }

    public void accept(String language) {
        if(language.equals("EN")) waitInvisibility(upsellNameEN); else waitInvisibility(upsellNameES);
        click(submitButton);
        logger.info("Biblical Fat Burning Secrets upsell accepted");
    }

    public void decide(int secondUpsell, String language){
        if(secondUpsell == 1) this.accept(language); else this.decline(language);
    }
}
