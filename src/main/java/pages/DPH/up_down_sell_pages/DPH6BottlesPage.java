package pages.DPH.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DPH6BottlesPage extends BasePage {
    public DPH6BottlesPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='735']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("DPH 6 bottles upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("DPH 6 bottles upsell declined");
    }

    public void decide(int upsell){
        if(upsell == 1) this.accept(); else this.decline();
    }
}
