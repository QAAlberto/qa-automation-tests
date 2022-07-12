package pages.EP.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProstatePlusUpSellPage extends BasePage {
    public ProstatePlusUpSellPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='1403']");
    By threeBottles = By.xpath("//a[@data-productid='1404']");
    By sixBottles = By.xpath("//a[@data-productid='1405']");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//span[contains(text(), 'ProstatePlus')]");

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
        logger.info("ProstatePlus Upsell accepted");
    }

    public void decline(){
        waitVisibility(productID);
        click(declineButton);
        logger.info("ProstatePlus Upsell declined");
    }

    public void decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
    }
}
