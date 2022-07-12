package pages.INFG.main_pages;

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

    double option1 = 895;
    double option2 = 795;
    double shipping = 50;
    double option3 = 595 + shipping;
    double insurance = 49;

    double infinityGridUpSell1 = 250;
    double infinityGridUpSell2 = 445;
    double infinityGridUpSell3 = 250;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public void verifyGrandTotal(String option, int insurance, int infinityGridUpSell1, int infinityGridUpSell2, int infinityGridUpSell3){
        assertEquals(grandTotalField, "$" + getAmount(option, insurance, infinityGridUpSell1, infinityGridUpSell2, infinityGridUpSell3).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(String option, int insurance, int infinityGridUpSell1, int infinityGridUpSell2, int infinityGridUpSell3){
        double total = 0;
        double infinityGridRounded = 0;
        double insuranceRounded;
        double infinityGridUpSell1Rounded;
        double infinityGridUpSell2Rounded;
        double infinityGridUpSell3Rounded;

        insuranceRounded = this.insurance*insurance;
        infinityGridUpSell1Rounded = this.infinityGridUpSell1*infinityGridUpSell1;
        infinityGridUpSell2Rounded = this.infinityGridUpSell2*infinityGridUpSell2;
        infinityGridUpSell3Rounded = this.infinityGridUpSell3*infinityGridUpSell3;

        if(option.equals("option1")){
            infinityGridRounded = this.option1;
        }else if(option.equals("option2")){
            infinityGridRounded = this.option2;
        }else if(option.equals("option3")){
            infinityGridRounded = this.option3;
        }

        total = round(infinityGridRounded + insuranceRounded + infinityGridUpSell1Rounded + infinityGridUpSell2Rounded + infinityGridUpSell3Rounded);

        double finalTotal = total;
        double finalInfinityGridRounded = infinityGridRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("infinityGrid", doubleToString(finalInfinityGridRounded));
            put("infinityGridUpSell1", doubleToString(infinityGridUpSell1Rounded));
            put("infinityGridUpSell2", doubleToString(infinityGridUpSell2Rounded));
            put("infinityGridUpSell3", doubleToString(infinityGridUpSell3Rounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String option, int insurance, int infinityGridUpSell1, int infinityGridUpSell2, int infinityGridUpSell3){
        HashMap<String, String> amounts = this.getAmount(option, insurance, infinityGridUpSell1, infinityGridUpSell2, infinityGridUpSell3);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Infinity Grid: ID="+propertyManager.getProperty("infinityGrid" + option, "INFG")+" $"+amounts.get("infinityGrid"),
                "Infinity Grid UpSell 1: ID="+propertyManager.getProperty("infinityGridUpSell1", "INFG")+" $"+amounts.get("infinityGridUpSell1"),
                "Infinity Grid UpSell 2: ID="+propertyManager.getProperty("infinityGridUpSell2", "INFG")+" $"+amounts.get("infinityGridUpSell2"),
                "Infinity Grid UpSell 3: ID="+propertyManager.getProperty("infinityGridUpSell3", "INFG")+" $"+amounts.get("infinityGridUpSell3"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "INFG")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
