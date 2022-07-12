package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AddUserPage extends BasePage {
    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.id("email");
    By passwordField = By.id("password");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By affiliateIdField = By.id("affiliateId");
    By contactIdField = By.id("contactId");
    By orderIdField = By.id("orderId");
    By exodusEffectCheckbox = By.xpath("//input[@value='175']");
    By highWayHealingBundleCheckbox = By.xpath("//input[@value='176']");
    By biblicalFatBurningSecretsBundleCheckbox = By.xpath("//input[@value='177']");
    By theMemoryCovenantCheckbox = By.xpath("//input[@value='178']");
    By prayerWarriorNetworkCheckbox = By.xpath("//input[@value='198']");
    By saveUserButton = By.xpath("//input[@value='Save User']");

    public String addUser(int[] products){
        String email = "qa+EE" + getTimeStamp() + "@redhotmarketingllc.com";
        writeText(emailField, email);
        writeText(passwordField, propertyManager.getProperty("newAdminPassword", "EE"));
        writeText(firstNameField, propertyManager.getProperty("firstName", "EE"));
        writeText(lastNameField, propertyManager.getProperty("lastName", "EE"));
        writeText(affiliateIdField, "1212");
        writeText(contactIdField, "1212");
        writeText(orderIdField, "1212");
        click(exodusEffectCheckbox);
        if(products[0] == 1) click(highWayHealingBundleCheckbox);
        if(products[1] == 1) click(biblicalFatBurningSecretsBundleCheckbox);
        if(products[2] == 1) click(theMemoryCovenantCheckbox);
        if(products[3] == 1) click(prayerWarriorNetworkCheckbox);
        click(saveUserButton);
        return email;
    }
}
