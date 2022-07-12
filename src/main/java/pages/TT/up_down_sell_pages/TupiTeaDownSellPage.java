package pages.TT.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TupiTeaDownSellPage extends BasePage {
    public TupiTeaDownSellPage(WebDriver driver) {
        super(driver);
    }
    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='1388']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("TupiTea DownSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("TupiTea DownSell declined");
    }

    public void decide(int secondUpsell){
        if(secondUpsell == 1) this.accept(); else this.decline();
    }
}
