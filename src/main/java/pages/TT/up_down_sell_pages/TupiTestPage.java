package pages.TT.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TupiTestPage extends BasePage {
    public TupiTestPage(WebDriver driver) {
        super(driver);
    }
    By oneBottle = By.xpath("//a[@data-productid='1380']");
    By threeBottles = By.xpath("//a[@data-productid='1381']");
    By sixBottles = By.xpath("//a[@data-productid='1382']");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='Array']");

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
        logger.info("TupiTest Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("TupiTest Upsell declined");
    }

    public void decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
    }
}
