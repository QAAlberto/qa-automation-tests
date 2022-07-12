package pages.INFG.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class InfinityGridUpSell1Page extends BasePage {
    public InfinityGridUpSell1Page(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1467']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("InfinityGrid Upsell 1 accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("InfinityGrid Upsell 1 declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
