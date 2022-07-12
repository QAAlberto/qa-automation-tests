package pages.TOIL.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MYOHOTurmericUpSellPage extends BasePage {
    public MYOHOTurmericUpSellPage(WebDriver driver) {
        super(driver);
    }

    By upsellForm = By.id("upsellForm");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='930']");

    public void accept(){
        waitInvisibility(productID);
        submitForm(upsellForm);
        logger.info("MYOHO Turmeric Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("MYOHO Turmeric Upsell declined");
    }

    public void decide(int firstUpsell){
        if(firstUpsell == 1) this.accept(); else this.decline();
    }
}
