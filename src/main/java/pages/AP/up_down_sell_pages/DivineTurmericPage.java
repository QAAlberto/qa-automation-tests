package pages.AP.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AP.main_pages.ConfirmPage;
import pages.BasePage;

public class DivineTurmericPage extends BasePage {
    public DivineTurmericPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='351']");
    By threeBottles = By.xpath("//a[@data-productid='352']");
    By sixBottles = By.xpath("//a[@data-productid='353']");
    By declineButton = By.id("declineButton");
    By productID = By.xpath("//input[@value='0']");

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
        logger.info("Divine Turmeric Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Divine Turmeric Upsell declined");
    }

    public ConfirmPage decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
        return new ConfirmPage(driver);
    }
}
