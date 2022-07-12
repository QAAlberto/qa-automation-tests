package pages.TT.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TupiFlowPage extends BasePage {
    public TupiFlowPage(WebDriver driver) {
        super(driver);
    }
    By oneBottle = By.xpath("//a[@data-productid='1383']");
    By threeBottles = By.xpath("//a[@data-productid='1384']");
    By sixBottles = By.xpath("//a[@data-productid='1385']");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//span[contains(text(), 'TupiFlow')]");

    public void accept(String thirdUpsell){
        waitVisibility(productID);
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
        logger.info("TupiFlow Upsell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("TupiFlow Upsell declined");
    }

    public void decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
    }
}
