package pages.IH.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class FourthUpsellPage extends BasePage {
    public FourthUpsellPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='144']");
    By threeBottles = By.xpath("//a[@data-productid='145']");
    By sixBottles = By.xpath("//a[@data-productid='146']");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='144,145,146']");

    public void accept(String fourthUpsell){
        waitInvisibility(productID);
        switch (fourthUpsell){
            case "1b":
                click(oneBottle);
                break;
            case "3b":
                click(threeBottles);
                break;
            case "6b":
                click(sixBottles);
                break;
        }
        logger.info("Fourth Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Fourth Upsell declined");
    }

    public void decide(String fourthUpsell){
        if(fourthUpsell.equals("0")) this.decline(); else this.accept(fourthUpsell);
    }
}
