package pages.KFX3.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class KetoDownSellPage extends BasePage {
    public KetoDownSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//strong[contains(text(),'$19')]");

    public void accept(){
        waitVisibility(productID);
        submitForm(upsellForm);
        logger.info("Keto DownSell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("Keto DownSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
