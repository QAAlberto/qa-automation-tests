package pages.AGE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MembersPage extends BasePage {
    public MembersPage(WebDriver driver) {
        super(driver);
    }

    By membersMenu = By.id("menuIcon");
    By helpButton = By.xpath("//a[contains(text(),'Help / FAQ')]");
    By changePasswordLinkModal = By.id("changePasswordLink");
    By bonusesButton = By.id("menuLinkBonuses");
    By amplifireButton = By.id("menuLinkAMPLI-FIRE");
    By knightStickButton = By.id("menuLinkKnightstick");

    public void verifySignIn(String baseUrl){
        assertEqualsURL(baseUrl + "members" );
    }

    public void helpPage(){
        click(membersMenu);
        click(helpButton);
    }

    public void changePasswordPage(){
        click(changePasswordLinkModal);
    }

    public BooksPage bonusesPage(){
        click(membersMenu);
        click(bonusesButton);
        logger.info("Bonuses page loaded.");
        return new BooksPage(driver);
    }

    public void amplifirePage(){
        click(membersMenu);
        click(amplifireButton);
        logger.info("Ampli Fire page loaded.");
    }

    public void knightStickPage(){
        click(membersMenu);
        click(knightStickButton);
        logger.info("Knight Stick page loaded.");
    }
}
