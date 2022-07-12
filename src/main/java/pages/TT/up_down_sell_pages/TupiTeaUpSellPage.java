package pages.TT.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TupiTeaUpSellPage extends BasePage {
    public TupiTeaUpSellPage(WebDriver driver) {
        super(driver);
    }
    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='1387']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("TupiTea Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("TupiTea Upsell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
