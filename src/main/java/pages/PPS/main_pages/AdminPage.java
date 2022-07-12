package pages.PPS.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    By newTradeButton = By.xpath("//a[@href='/admin/trades/add']");
    By tradesListButton = By.xpath("//a[@href='/admin/trades/list']");

    public void newTradePage(){
        click(newTradeButton);
    }

    public void tradesListPage(){
        click(tradesListButton);
    }

}
