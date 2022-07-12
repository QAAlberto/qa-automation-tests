package pages.FW5.main_pages;

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
    double freedomWater = 149;
    double insurance = 8.95;

    double freedomWaterUpSell1 = 148;
    double freedomWaterDownSell = 74;
    double freedomWaterUpSell2 = 99;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public void verifyGrandTotal(int insurance, int freedomWaterUpSell1, int freedomWaterDownSell, int freedomWaterUpSell2){
        assertEquals(grandTotalField, "$" + getAmount(insurance, freedomWaterUpSell1, freedomWaterDownSell, freedomWaterUpSell2).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(int insurance, int freedomWaterUpSell1, int freedomWaterDownSell, int freedomWaterUpSell2){
        double total = 0;
        double freedomWaterRounded = this.freedomWater;
        double insuranceRounded;
        double freedomWaterUpSell1Rounded;
        double freedomWaterDownSellRounded;
        double freedomWaterUpSell2Rounded;

        insuranceRounded = this.insurance*insurance;
        freedomWaterUpSell1Rounded = this.freedomWaterUpSell1*freedomWaterUpSell1;
        freedomWaterDownSellRounded = this.freedomWaterDownSell*freedomWaterDownSell;
        freedomWaterUpSell2Rounded = this.freedomWaterUpSell2*freedomWaterUpSell2;

        total = round(freedomWaterRounded + insuranceRounded + freedomWaterUpSell1Rounded + freedomWaterDownSellRounded + freedomWaterUpSell2Rounded);

        double finalTotal = total;
        double finalFreedomWaterRounded = freedomWaterRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("freedomWater", doubleToString(finalFreedomWaterRounded));
            put("freedomWaterUpSell1", doubleToString(freedomWaterUpSell1Rounded));
            put("freedomWaterDownSell", doubleToString(freedomWaterDownSellRounded));
            put("freedomWaterUpSell2", doubleToString(freedomWaterUpSell2Rounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(int insurance, int freedomWaterUpSell1, int freedomWaterDownSell, int freedomWaterUpSell2){
        HashMap<String, String> amounts = this.getAmount(insurance, freedomWaterUpSell1, freedomWaterDownSell, freedomWaterUpSell2);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Freedom Water: ID="+propertyManager.getProperty("freedomWater", "FW5")+" $"+amounts.get("freedomWater"),
                "Freedom Water UpSell 1: ID="+propertyManager.getProperty("freedomWaterUpSell1", "FW5")+" $"+amounts.get("freedomWaterUpSell1"),
                "Freedom Water DownSell: ID="+propertyManager.getProperty("freedomWaterDownSell", "FW5")+" $"+amounts.get("freedomWaterDownSell"),
                "Freedom Water UpSell 2: ID="+propertyManager.getProperty("freedomWaterUpSell2", "FW5")+" $"+amounts.get("freedomWaterUpSell2"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "FW5")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
