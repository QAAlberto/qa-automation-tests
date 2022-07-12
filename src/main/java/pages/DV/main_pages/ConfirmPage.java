package pages.DV.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfirmPage extends BasePage {
    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    double DVOneBottle = 69;
    double DVThreeBottles = 59;
    double DVSixBottles = 49;

    double dbTurmericOneBottle = 69;
    double dbTurmericThreeBottles = 59;
    double dbTurmericSixBottles = 49;

    double dbGlucose16OneBottle = 49;
    double dbGlucose16ThreeBottles = 34;
    double dbGlucose16SixBottles = 24;

    double gloryBioticsOneBottle = 25;
    double gloryBioticsThreeBottles = 23;
    double gloryBioticsSixBottles = 19;

    double dbOmegaPlusOneBottle = 25;
    double dbOmegaPlusThreeBottles = 23;
    double dbOmegaPlusSixBottles = 19;

    double divineDailyEnergyOneBottle = 45;
    double divineDailyEnergyThreeBottles = 39;
    double divineDailyEnergySixBottles = 29;

    double divineVisionUpSell = 234;
    double divineVisionDownSell = 117;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int divineVisionUpSell, int divineVisionDownSell, String dbTurmeric, String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, divineVisionUpSell, divineVisionDownSell, dbTurmeric, dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int divineVisionUpSell, int divineVisionDownSell, String dbTurmeric, String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy){
        double total = 0;
        double DVRounded = 0;
        double divineVisionUpSellRounded;
        double divineVisionDownSellRounded;
        double dbTurmericRounded;
        double dbGlucose16Rounded;
        double gloryBioticsRounded;
        double dbOmegaPlusRounded;
        double divineDailyEnergyRounded;

        divineVisionUpSellRounded = this.divineVisionUpSell*divineVisionUpSell;
        divineVisionDownSellRounded = this.divineVisionDownSell*divineVisionDownSell;

        if(bottles.equals("1b")){
            DVRounded = (int)(DVOneBottle);
        }else if(bottles.equals("3b")){
            DVRounded = 3*(int)(DVThreeBottles);
        }else if(bottles.equals("6b")){
            DVRounded = 6*(int)(DVSixBottles);
        }

        switch (dbTurmeric){
            case "1b":
                dbTurmericRounded = this.dbTurmericOneBottle;
                break;
            case "3b":
                dbTurmericRounded = 3*this.dbTurmericThreeBottles;
                break;
            case "6b":
                dbTurmericRounded = 6*this.dbTurmericSixBottles;
                break;
            default:
                dbTurmericRounded = 0;
                break;
        }

        switch (dbGlucose16){
            case "1b":
                dbGlucose16Rounded = this.dbGlucose16OneBottle;
                break;
            case "3b":
                dbGlucose16Rounded = 3*this.dbGlucose16ThreeBottles;
                break;
            case "6b":
                dbGlucose16Rounded = 6*this.dbGlucose16SixBottles;
                break;
            default:
                dbGlucose16Rounded = 0;
                break;
        }

        switch (gloryBiotics){
            case "1b":
                gloryBioticsRounded = this.gloryBioticsOneBottle;
                break;
            case "3b":
                gloryBioticsRounded = 3*this.gloryBioticsThreeBottles;
                break;
            case "6b":
                gloryBioticsRounded = 6*this.gloryBioticsSixBottles;
                break;
            default:
                gloryBioticsRounded = 0;
                break;
        }

        switch (dbOmegaPlus){
            case "1b":
                dbOmegaPlusRounded = this.dbOmegaPlusOneBottle;
                break;
            case "3b":
                dbOmegaPlusRounded = 3*this.dbOmegaPlusThreeBottles;
                break;
            case "6b":
                dbOmegaPlusRounded = 6*this.dbOmegaPlusSixBottles;
                break;
            default:
                dbOmegaPlusRounded = 0;
                break;
        }

        switch (divineDailyEnergy){
            case "1b":
                divineDailyEnergyRounded = this.divineDailyEnergyOneBottle;
                break;
            case "3b":
                divineDailyEnergyRounded = 3*this.divineDailyEnergyThreeBottles;
                break;
            case "6b":
                divineDailyEnergyRounded = 6*this.divineDailyEnergySixBottles;
                break;
            default:
                divineDailyEnergyRounded = 0;
                break;
        }

        total = round( DVRounded + divineVisionUpSellRounded + divineVisionDownSellRounded + dbTurmericRounded + dbGlucose16Rounded + gloryBioticsRounded + dbOmegaPlusRounded + divineDailyEnergyRounded);

        double finalTotal = total;
        double finalDVRounded = DVRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("DV", doubleToString(finalDVRounded));
            put("divineVisionUpSell", doubleToString(divineVisionUpSellRounded));
            put("divineVisionDownSell", doubleToString(divineVisionDownSellRounded));
            put("dbTurmeric", doubleToString(dbTurmericRounded));
            put("dbGlucose16", doubleToString(dbGlucose16Rounded));
            put("gloryBiotics", doubleToString(gloryBioticsRounded));
            put("dbOmegaPlus", doubleToString(dbOmegaPlusRounded));
            put("divineDailyEnergy", doubleToString(divineDailyEnergyRounded));
        }};
    }

    public List getList(String bottles, int divineVisionUpSell, int divineVisionDownSell, String dbTurmeric, String dbGlucose16, String gloryBiotics, String dbOmegaPlus, String divineDailyEnergy){
        HashMap<String, String> amounts = this.getAmount(bottles, divineVisionUpSell, divineVisionDownSell, dbTurmeric, dbGlucose16, gloryBiotics, dbOmegaPlus, divineDailyEnergy);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "DV: ID="+propertyManager.getProperty("DV" + bottles, "DV")+" $"+amounts.get("DV"),
                "Divine Vision UpSell: ID="+propertyManager.getProperty("divineVisionUpSell", "DV")+" $"+amounts.get("divineVisionUpSell"),
                "Divine Vision DownSell: ID="+propertyManager.getProperty("divineVisionDownSell", "DV")+" $"+amounts.get("divineVisionDownSell"),
                "DB Turmeric: ID="+propertyManager.getProperty("dbTurmeric" + dbTurmeric, "DV")+" $"+amounts.get("dbTurmeric"),
                "DB Glucose 16: ID="+propertyManager.getProperty("dbGlucose16" + dbGlucose16, "DV")+" $"+amounts.get("dbGlucose16"),
                "Glory Biotics: ID="+propertyManager.getProperty("gloryBiotics" + gloryBiotics, "DV")+" $"+amounts.get("gloryBiotics"),
                "DB Omega Plus: ID="+propertyManager.getProperty("dbOmegaPlus" + dbOmegaPlus, "DV")+" $"+amounts.get("dbOmegaPlus"),
                "Divine Daily Energy: ID="+propertyManager.getProperty("divineDailyEnergy" + divineDailyEnergy, "DV")+" $"+amounts.get("divineDailyEnergy"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
