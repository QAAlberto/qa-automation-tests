package pages.AGE.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AmplifirePage extends BasePage {
    public AmplifirePage(WebDriver driver) {
        super(driver);
    }

    By declineRadioButton = By.id("buyUpsellNo");
    By form = By.id("upsellForm");

    public void decline(){
        click(declineRadioButton);
        submitForm(form);
        logger.info("Amplifire page declined");
    }

    public void accept() {
        submitForm(form);
        logger.info("Amplifire accepted");
    }

    public KnightStickPage decide(int amplifire){
        if(amplifire == 1) this.accept(); else this.decline();
        return new KnightStickPage(driver);
    }
}
