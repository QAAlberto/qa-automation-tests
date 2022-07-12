package pages.PPS.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NewTradePage extends BasePage {
    public NewTradePage(WebDriver driver) {
        super(driver);
    }

    By inputFile = By.id("uploadImage");
    By titleField = By.id("title");
    By bodyField = By.id("body");
    By actionField = By.id("action");
    By tagsField = By.id("tags");
    By addForm = By.id("addForm");

    public void newTrade(String title){
        writeText(inputFile, propertyManager.getProperty("filePath", "PPS"));
        writeText(titleField, title);
        writeText(bodyField, "body");
        writeText(actionField, "action");
        writeText(tagsField, "tag");
        submitForm(addForm);
    }
}
