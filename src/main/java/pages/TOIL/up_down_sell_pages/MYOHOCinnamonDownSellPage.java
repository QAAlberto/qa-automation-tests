package pages.TOIL.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MYOHOCinnamonDownSellPage extends BasePage {
    public MYOHOCinnamonDownSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='929']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("MYOHO Cinnamon DownSell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("MYOHO Cinnamon DownSell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
