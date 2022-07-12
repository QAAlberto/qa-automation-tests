package pages.AGE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AGE.main_pages.ConfirmPage;
import pages.BasePage;

public class KnightStickPage extends BasePage {
    public KnightStickPage(WebDriver driver) {
        super(driver);
    }

    By declineRadioButton = By.id("buyUpsellNo");
    By form = By.id("upsellForm");
    By productID = By.xpath("//input[@value='402']");

    public void decline(){
        waitInvisibility(productID);
        click(declineRadioButton);
        submitForm(form);
        logger.info("Amplifire page declined");
    }

    public void accept() {
        waitInvisibility(productID);
        submitForm(form);
        logger.info("Amplifire accepted");
    }

    public ConfirmPage decide(int knightStick){
        if(knightStick == 1) this.accept(); else this.decline();
        return new ConfirmPage(driver);
    }
}
