package pages.DAD.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class VelocityUpSellPage extends BasePage {
    public VelocityUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineUpsell");
    By productID = By.xpath("//input[@value='1192']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Velocity UpSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Velocity UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
