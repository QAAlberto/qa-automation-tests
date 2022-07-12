package pages.EP.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class EndoBumpDownSellPage extends BasePage {
    public EndoBumpDownSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1399']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("EndoBump DownSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("EndoBump DownSell declined");
    }

    public void decide(int secondUpsell){
        if(secondUpsell == 1) this.accept(); else this.decline();
    }
}
