package pages.TCBD.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SecondUpsellPage extends BasePage {
    public SecondUpsellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='667']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("Second Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Second Upsell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
