package pages.RR.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MembersPage extends BasePage {
    public MembersPage(WebDriver driver) {
        super(driver);
    }

    By membersMenu = By.id("hamburgerMenuIcon");
    By helpButton = By.xpath("//a[contains(text(),'Help')]");
    By changePasswordLinkModal = By.id("changePasswordLink");
    By RRButton = By.xpath("//a[contains(text(),'Retire Richer')]");
    By confessionsButton = By.xpath("//a[contains(text(),'Confessions Of A Hedge Fund Manager')]");
    By combatDefenseSecretsButton = By.xpath("//a[contains(text(),'Combat Defense Secrets')]");

    public MembersPage verifySignIn(String baseUrl){
        assertEqualsURL(baseUrl + "members" );
        return this;
    }

    public void helpPage(){
        click(membersMenu);
        click(helpButton);
    }

    public void changePasswordPage(){
        click(changePasswordLinkModal);
    }

    public void RRPage(){
        click(membersMenu);
        click(RRButton);
        logger.info("RR page loaded.");
    }

    public void confessionsPage(){
        click(membersMenu);
        click(confessionsButton);
        logger.info("Confessions page loaded.");
    }

    public void combatDefenseSecretsPage(){
        click(combatDefenseSecretsButton);
        logger.info("Combat Defense Secrets page loaded.");
    }
}
