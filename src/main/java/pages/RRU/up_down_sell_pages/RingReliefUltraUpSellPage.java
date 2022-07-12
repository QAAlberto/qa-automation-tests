package pages.RRU.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class RingReliefUltraUpSellPage extends BasePage {
    public RingReliefUltraUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='100']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Ring Relief Ultra UpSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Ring Relief Ultra UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
