package pages.TOIL.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MYOHOCinnamonUpSellPage extends BasePage {
    public MYOHOCinnamonUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='928']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("MYOHO Cinnamon Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("MYOHO Cinnamon Upsell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
