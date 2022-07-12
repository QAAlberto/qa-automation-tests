package pages.DV.up_down_sell_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MostPopularPage extends BasePage {
    public MostPopularPage(WebDriver driver) {
        super(driver);
    }

    By dbGlucose16OneBottle = By.xpath("//input[@value='9']");
    By dbGlucose16ThreeBottles = By.xpath("//input[@value='10']");
    By dbGlucose16SixBottles = By.xpath("//input[@value='11']");
    By gloryBioticsOneBottle = By.xpath("//input[@value='12']");
    By gloryBioticsThreeBottles = By.xpath("//input[@value='13']");
    By gloryBioticsSixBottles = By.xpath("//input[@value='14']");
    By dbOmegaPlusOneBottle = By.xpath("//input[@value='15']");
    By dbOmegaPlusThreeBottles = By.xpath("//input[@value='16']");
    By dbOmegaPlusSixBottles = By.xpath("//input[@value='17']");
    By divineDailyEnergyOneBottle = By.xpath("//input[@value='18']");
    By divineDailyEnergyThreeBottles = By.xpath("//input[@value='19']");
    By divineDailyEnergySixBottles = By.xpath("//input[@value='20']");
    By declineButton = By.className("declineButton");
    By productID = By.xpath("//input[@value='9,10,11,12,13,14,15,16,17,18,19,20']");
    By upsellForm = By.id("upsellForm");
    By submitButton = By.className("submitButton");

    public void accept(String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy){
        waitInvisibility(productID);
        switch (dbGlucose16){
            case "1b":
                click(dbGlucose16OneBottle);
                break;
            case "3b":
                click(dbGlucose16ThreeBottles);
                break;
            case "6b":
                click(dbGlucose16SixBottles);
                break;
        }

        switch (gloryBiotics){
            case "1b":
                click(gloryBioticsOneBottle);
                break;
            case "3b":
                click(gloryBioticsThreeBottles);
                break;
            case "6b":
                click(gloryBioticsSixBottles);
                break;
        }

        switch (dbOmegaPlus){
            case "1b":
                click(dbOmegaPlusOneBottle);
                break;
            case "3b":
                click(dbOmegaPlusThreeBottles);
                break;
            case "6b":
                click(dbOmegaPlusSixBottles);
                break;
        }

        switch (divineDailyEnergy){
            case "1b":
                click(divineDailyEnergyOneBottle);
                break;
            case "3b":
                click(divineDailyEnergyThreeBottles);
                break;
            case "6b":
                click(divineDailyEnergySixBottles);
                break;
        }
//        submitForm(upsellForm);
        click(submitButton);
        logger.info("Most Popular Upsell accepted");
    }

    public void decline(){
        waitInvisibility(productID);
        click(declineButton);
        logger.info("Most Popular Upsell declined");
    }

    public void decide(String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy){
        if(dbGlucose16.equals("0") && gloryBiotics.equals("0") && dbOmegaPlus.equals("0") && divineDailyEnergy.equals("0")) this.decline(); else this.accept(dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy);
    }
}
