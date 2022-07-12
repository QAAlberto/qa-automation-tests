package pages.DAD.main_pages;

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

    public void helpPage(){
        click(helpButton);
    }

    public void changePasswordPage(){
        click(changePasswordLinkModal);
    }

    public void DADPage(){
        click(DADButton);
        logger.info("DAD page loaded.");
    }

    public void velocityPage(){
        click(velocityButton);
        logger.info("Velocity page loaded.");
    }

    public void combatDefenseSecretsPage(){
        click(combatDefenseSecretsButton);
        logger.info("Combat Defense Secrets page loaded.");
    }
}
