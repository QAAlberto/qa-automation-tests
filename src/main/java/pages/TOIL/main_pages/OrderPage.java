package pages.TOIL.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    By oneBottleButton = By.xpath("//a[@data-productid='373']");
    By threeBottleButton = By.xpath("//a[@data-productid='374']");
    By sixBottleButton = By.xpath("//a[@data-productid='375']");

    public void selectBottles(String bottles){
        switch (bottles){
            case "1b":
                clickJS(oneBottleButton);
                break;
            case "3b":
                clickJS(threeBottleButton);
                break;
            case "6b":
                clickJS(sixBottleButton);
                break;
        }
        logger.info("Quantity of bottles selected");
    }
}
