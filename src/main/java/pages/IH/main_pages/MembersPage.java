package pages.IH.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MembersPage extends BasePage {
    public MembersPage(WebDriver driver) {
        super(driver);
    }

    By membersMenu = By.id("menuIcon");
    By helpButton = By.xpath("//a[contains(text(),'Help')]");
    By changePasswordLinkModal = By.id("changePasswordLink");
    By DADButton = By.xpath("//a[contains(text(),'Dark Age Defense')]");
    By velocityButton = By.xpath("//a[contains(text(),'Velocity')]");
    By combatDefenseSecretsButton = By.xpath("//a[contains(text(),'Combat Defense Secrets')]");

    public MembersPage verifySignIn(String baseUrl){
        assertEqualsURL(baseUrl + "members" );
        return this;
    }


}
