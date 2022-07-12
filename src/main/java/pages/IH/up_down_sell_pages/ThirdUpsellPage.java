package pages.IH.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ThirdUpsellPage extends BasePage {
    public ThirdUpsellPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='141']");
    By threeBottles = By.xpath("//a[@data-productid='142']");
    By sixBottles = By.xpath("//a[@data-productid='143']");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='141,142,143']");

    public void accept(String thirdUpsell){
        waitInvisibility(productID);
        switch (thirdUpsell){
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
        logger.info("Third Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Third Upsell declined");
    }

    public void decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
    }
}
