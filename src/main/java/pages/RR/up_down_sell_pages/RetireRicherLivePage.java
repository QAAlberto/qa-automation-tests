package pages.RR.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class RetireRicherLivePage extends BasePage {
    public RetireRicherLivePage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineUpsell");
    By productID = By.xpath("//input[@value='1135']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Retire Richer Live UpSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Retire Richer Live UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
