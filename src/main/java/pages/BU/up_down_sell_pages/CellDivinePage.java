package pages.BU.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BU.main_pages.ConfirmPage;
import pages.BasePage;

public class CellDivinePage extends BasePage {
    public CellDivinePage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='1058']");
    By threeBottles = By.xpath("//a[@data-productid='1059']");
    By sixBottles = By.xpath("//a[@data-productid='1060']");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='1058']");

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
        logger.info("Cell Divine Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Cell Divine Upsell declined");
    }

    public ConfirmPage decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
        return new ConfirmPage(driver);
    }
}
