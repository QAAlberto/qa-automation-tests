package pages.PPS.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TradesListPage extends BasePage {
    public TradesListPage(WebDriver driver) {
        super(driver);
    }

    By lastCreatedTrade = By.xpath("//tbody/tr[2]/td[1]");
    By editLastCreatedTrade = By.xpath("//tbody/tr[2]/td[1]/following-sibling::td/a[contains(text(),'Edit')]");
    By activeDeactivateLastCreatedTrade = By.xpath("//tbody/tr[2]/td[1]/following-sibling::td/a/following-sibling::a");

    public String getLastCreatedTrade(){
        return readText(lastCreatedTrade);
    }

    public void editLastCreatedTradePage(){
        click(editLastCreatedTrade);
    }

    public void activeDeactivateLastCreatedTrade(){
        click(activeDeactivateLastCreatedTrade);
    }

    public String getActiveDeactivateButton(){
        return readText(activeDeactivateLastCreatedTrade);
    }
}
