package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HelpPage extends BasePage {
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    By changePasswordLink = By.xpath("//div[@id='collapse1']//a");
    By accordion1 = By.xpath("//a[@href='#collapse1']");

    public void changePasswordPage(){
        click(accordion1);
        click(changePasswordLink);
    }
}
