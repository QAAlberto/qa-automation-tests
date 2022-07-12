package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HighWayHealingPage extends BasePage {
    public HighWayHealingPage(WebDriver driver) {
        super(driver);
    }

    By title = By.id("membersPageTitle");

    public String getTitle(){
        return readText(title);
    }
}
