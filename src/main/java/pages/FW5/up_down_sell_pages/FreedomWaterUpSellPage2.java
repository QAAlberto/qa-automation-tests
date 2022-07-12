package pages.FW5.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class FreedomWaterUpSellPage2 extends BasePage {
    public FreedomWaterUpSellPage2(WebDriver driver) {
        super(driver);
    }
    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1486']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("FreedomWater Upsell 2 accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("FreedomWater Upsell 2 declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
