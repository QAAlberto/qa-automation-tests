package pages.RRU.main_pages;

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

    double RRUOneBottle = 69;
    double RRUThreeBottles = 177;
    double RRUSixBottles = 294;

    double divineTurmericOneBottle = 69;
    double divineTurmericThreeBottles = 177;
    double divineTurmericSixBottles = 294;

    double probioMaxPlusOneBottle = 69;
    double probioMaxPlusThreeBottles = 177;
    double probioMaxPlusSixBottles = 294;

    double ringReliefUltraUpSell = 234;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int ringReliefUltraUpSell, String divineTurmeric, String probioMaxPlus) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, ringReliefUltraUpSell, divineTurmeric, probioMaxPlus).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int ringReliefUltraUpSell, String divineTurmeric, String probioMaxPlus){
        double total = 0;
        double RRURounded = 0;
        double ringReliefUltraUpSellRounded;
        double divineTurmericRounded;
        double probioMaxPlusRounded;

        switch (bottles){
            case "1b":
                RRURounded = this.RRUOneBottle;
                break;
            case "3b":
                RRURounded = this.RRUThreeBottles;
                break;
            case "6b":
                RRURounded = this.RRUSixBottles;
                break;
        }

        ringReliefUltraUpSellRounded = this.ringReliefUltraUpSell*ringReliefUltraUpSell;

        switch (divineTurmeric){
            case "1b":
                divineTurmericRounded = this.divineTurmericOneBottle;
                break;
            case "3b":
                divineTurmericRounded = this.divineTurmericThreeBottles;
                break;
            case "6b":
                divineTurmericRounded = this.divineTurmericSixBottles;
                break;
            default:
                divineTurmericRounded = 0;
                break;
        }

        switch (probioMaxPlus){
            case "1b":
                probioMaxPlusRounded = this.probioMaxPlusOneBottle;
                break;
            case "3b":
                probioMaxPlusRounded = this.probioMaxPlusThreeBottles;
                break;
            case "6b":
                probioMaxPlusRounded = this.probioMaxPlusSixBottles;
                break;
            default:
                probioMaxPlusRounded = 0;
                break;
        }

        total = round( RRURounded + ringReliefUltraUpSellRounded + divineTurmericRounded + probioMaxPlusRounded);

        double finalTotal = total;
        double finalRRURounded = RRURounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("RRU", doubleToString(finalRRURounded));
            put("ringReliefUltraUpSell", doubleToString(ringReliefUltraUpSellRounded));
            put("divineTurmeric", doubleToString(divineTurmericRounded));
            put("probioMaxPlus", doubleToString(probioMaxPlusRounded));
        }};
    }

    public List getList(String bottles, int ringReliefUltraUpSell, String divineTurmeric, String probioMaxPlus){
        HashMap<String, String> amounts = this.getAmount(bottles, ringReliefUltraUpSell, divineTurmeric, probioMaxPlus);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "RRU: ID="+propertyManager.getProperty("RRU" + bottles, "RRU")+" $"+amounts.get("RRU"),
                "Ring Relief Ultra UpSell: ID="+propertyManager.getProperty("ringReliefUltraUpSell", "RRU")+" $"+amounts.get("ringReliefUltraUpSell"),
                "Divine Turmeric: ID="+propertyManager.getProperty("divineTurmeric" + divineTurmeric, "RRU")+" $"+amounts.get("divineTurmeric"),
                "Pro Bio Max Plus: ID="+propertyManager.getProperty("probioMaxPlus" + probioMaxPlus, "RRU")+" $"+amounts.get("probioMaxPlus"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
