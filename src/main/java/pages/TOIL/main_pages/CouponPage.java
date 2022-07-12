package pages.TOIL.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CouponPage extends BasePage {
    public CouponPage(WebDriver driver) {
        super(driver);
    }

    By declineOfferLink = By.id("declineOffer");

    public void decline(){
        click(declineOfferLink);
        logger.info("Coupon Page declined");
    }
}
