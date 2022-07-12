package pages.RRU.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DivineTurmericPage extends BasePage {
    public DivineTurmericPage(WebDriver driver) {
        super(driver);
    }

    By oneBottle = By.xpath("//a[@data-productid='102']");
    By threeBottles = By.xpath("//a[@data-productid='103']");
    By sixBottles = By.xpath("//a[@data-productid='104']");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='102,103,104']");

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
        logger.info("DB Turmeric Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("DB Turmeric Upsell declined");
    }

    public void decide(String thirdUpsell){
        if(thirdUpsell.equals("0")) this.decline(); else this.accept(thirdUpsell);
    }
}
