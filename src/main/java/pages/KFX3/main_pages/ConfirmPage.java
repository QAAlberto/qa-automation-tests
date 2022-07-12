package pages.KFX3.main_pages;

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

    double bundle1 = 199.99;
    double bundle2 = 149.99;
    double bundle3 = 99.99;
    double bundle4 = 49.99;

    double insurance = 8.95;

    double glucoDefend = 49;

    double ketoUpSell = 95;
    double ketoDownSell = 57;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int insurance, int ketoUpSell, int ketoDownSell, int glucoDefend) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, insurance, ketoUpSell, ketoDownSell, glucoDefend).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int insurance, int ketoUpSell, int ketoDownSell, int glucoDefend){
        double total = 0;
        double KFX3Rounded = 0;
        double insuranceRounded = 0;
        double ketoUpSellRounded;
        double ketoDownSellRounded;
        double glucoDefendRounded;

        ketoUpSellRounded = this.ketoUpSell*ketoUpSell;
        ketoDownSellRounded = this.ketoDownSell*ketoDownSell;
        glucoDefendRounded = this.glucoDefend*glucoDefend;
        insuranceRounded = this.insurance*insurance;

        if(bottles.equals("bundle1")){
            KFX3Rounded = bundle1;
        }else if(bottles.equals("bundle2")){
            KFX3Rounded = bundle2;
        }else if(bottles.equals("bundle3")){
            KFX3Rounded = bundle3;
        }else if(bottles.equals("bundle4")){
            KFX3Rounded = bundle4;
        }

        total = round( KFX3Rounded + insuranceRounded + ketoUpSellRounded + ketoDownSellRounded + glucoDefendRounded);

        double finalTotal = total;
        double finalKFX3Rounded = KFX3Rounded;
        double finalInsuranceRounded = insuranceRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("KFX3", doubleToString(finalKFX3Rounded));
            put("ketoUpSell", doubleToString(ketoUpSellRounded));
            put("ketoDownSell", doubleToString(ketoDownSellRounded));
            put("glucoDefend", doubleToString(glucoDefendRounded));
            put("insurance", doubleToString(finalInsuranceRounded));
        }};
    }

    public List getList(String bottles, int insurance, int ketoUpSell, int ketoDownSell, int glucoDefend){
        HashMap<String, String> amounts = this.getAmount(bottles, insurance, ketoUpSell, ketoDownSell, glucoDefend);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "KFX3: ID="+propertyManager.getProperty("KFX3" + bottles, "KFX3")+" $"+amounts.get("KFX3"),
                "Keto UpSell: ID="+propertyManager.getProperty("ketoUpSell", "KFX3")+" $"+amounts.get("ketoUpSell"),
                "Keto DownSell: ID="+propertyManager.getProperty("ketoDownSell", "KFX3")+" $"+amounts.get("ketoDownSell"),
                "Gluco Defend: ID="+propertyManager.getProperty("glucoDefend", "KFX3")+" $"+amounts.get("glucoDefend"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "KFX3")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
