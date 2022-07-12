package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HelpPage extends BasePage {
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    By changePasswordLink = By.xpath("//a[contains(text(),'click here to set your own password?')]");

    public void changePasswordPage(){
        click(changePasswordLink);
    }
}
