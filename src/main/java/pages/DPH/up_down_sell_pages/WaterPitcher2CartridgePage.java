package pages.DPH.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WaterPitcher2CartridgePage extends BasePage {
    public WaterPitcher2CartridgePage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1035']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Water Pitcher 2 cartridge upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Water Pitcher 2 cartridge upsell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
