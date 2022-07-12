package pages.FW5.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class FreedomWaterUpSellPage1 extends BasePage {
    public FreedomWaterUpSellPage1(WebDriver driver) {
        super(driver);
    }
    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1479']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("FreedomWater Upsell 1 accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("FreedomWater Upsell 1 declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
