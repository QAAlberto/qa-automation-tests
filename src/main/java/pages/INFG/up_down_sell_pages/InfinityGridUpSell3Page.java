package pages.INFG.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class InfinityGridUpSell3Page extends BasePage {
    public InfinityGridUpSell3Page(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//h3[contains(text(), '(And Claim $200 Off)')]");

    public void accept(){
        waitVisibility(productID);
        submitForm(upsellForm);
        logger.info("InfinityGrid Upsell 3 accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("InfinityGrid Upsell 3 declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
