package pages.DAD.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class VelocityDownSellPage extends BasePage {
    public VelocityDownSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineUpsell");
    By productID = By.xpath("//strong[contains(text(),'only $35')]");

    public void accept(){
        waitVisibility(productID);
        submitForm(upsellForm);
        logger.info("Velocity DownSell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("Velocity DownSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
