package pages.EE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TrinityOilDownSellPage2 extends BasePage {
    public TrinityOilDownSellPage2(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='1213']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Trinity Oil DownSell 2 accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Trinity Oil DownSell 2 declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
