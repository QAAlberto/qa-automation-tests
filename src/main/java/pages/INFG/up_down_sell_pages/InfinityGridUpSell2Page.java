package pages.INFG.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class InfinityGridUpSell2Page extends BasePage {
    public InfinityGridUpSell2Page(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='1468']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("InfinityGrid Upsell 2 accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("InfinityGrid Upsell 2 declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
