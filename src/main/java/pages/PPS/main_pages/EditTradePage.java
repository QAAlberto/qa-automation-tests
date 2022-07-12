package pages.PPS.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class EditTradePage extends BasePage {
    public EditTradePage(WebDriver driver) {
        super(driver);
    }

    By titleField = By.id("title");
    By bodyField = By.id("body");
    By actionField = By.id("action");
    By tagsField = By.id("tags");
    By editForm = By.id("editForm");

    public void editTrade(String title){
        writeText(titleField, title);
        writeText(bodyField, "body updated");
        writeText(actionField, "action updated");
        writeText(tagsField, "tag updated");
        submitForm(editForm);
    }
}
