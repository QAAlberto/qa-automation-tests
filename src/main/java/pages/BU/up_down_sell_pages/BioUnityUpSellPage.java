package pages.BU.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BioUnityUpSellPage extends BasePage {
    public BioUnityUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='850']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Bio Unity UpSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Bio Unity UpSell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
