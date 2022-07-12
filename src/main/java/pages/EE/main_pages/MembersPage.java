package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MembersPage extends BasePage {
    public MembersPage(WebDriver driver) {
        super(driver);
    }

    By xButton = By.xpath("//button[contains(text(),'✕')]");
    By membersMenu = By.id("membersMenu");
    By helpButton = By.xpath("//a[contains(text(),'Help / FAQ')]");
    By changePasswordLinkModal = By.id("changePasswordLink");
    By exodusEffectButton = By.id("ExodusEffect");
    By highwayHealingButton = By.xpath("//span[contains(text(),'Click here to read HighWay Healing.')]");
    By theMemoryCovenantButton = By.xpath("//span[contains(text(),'Click here to read The Memory Covenant.')]");

    public MembersPage verifySignIn(String baseUrl){
        assertEqualsURL(baseUrl + "members/" );
        return this;
    }

    public void closeModal(){
        click(xButton);
        logger.info("Modal closed");
    }

    public void helpPage(){
        click(membersMenu);
        click(helpButton);
    }

    public void changePasswordPage(){
        click(changePasswordLinkModal);
    }

    public void exodusEffectPage(){
        click(exodusEffectButton);
        logger.info("Exodus Effect page loaded.");
    }

    public void highwayHealingPage(){
        click(highwayHealingButton);
        logger.info("Highway Healing page loaded.");
    }

    public void theMemoryCovenantPage(){
        click(theMemoryCovenantButton);
        logger.info("The Memory Covenant page loaded.");
    }
}
