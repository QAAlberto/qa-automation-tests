package pages.EP.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class EndoBumpUpSellPage extends BasePage {
    public EndoBumpUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1398']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("EndoBump Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("EndoBump Upsell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
