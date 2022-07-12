package pages.BU.main_pages;

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

    double BUOneBottle = 69;
    double BUThreeBottles = 59;
    double BUSixBottles = 49;

    double off = 0.1;
    double shipping = 12.95;

    double insurance = 8.95;

    double bioUnityUpSell = 234;
    double bioUnityDownSell = 117;
    double oneBottleCellDivine = 47;
    double threeBottlesCellDivine = 111;
    double sixBottlesCellDivine = 162;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int off, int insurance, int bioUnityUpSell, int bioUnityDownSell, String cellDivine) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, bioUnityUpSell, bioUnityDownSell, cellDivine).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int bioUnityUpSell, int bioUnityDownSell, String cellDivine){
        double total = 0;
        double insuranceRounded;
        double shippingRounded = 0;
        double BURounded = 0;
        double bioUnityUpSellRounded;
        double bioUnityDownSellRounded;
        double cellDivineRounded;

        insuranceRounded = this.insurance*insurance;
        bioUnityUpSellRounded = this.bioUnityUpSell*bioUnityUpSell;
        bioUnityDownSellRounded = this.bioUnityDownSell*bioUnityDownSell;

        if(bottles.equals("1b")){
            BURounded = (int)(BUOneBottle - BUOneBottle*this.off*off);
            shippingRounded = off == 0 ? shipping : 0;
        }else if(bottles.equals("3b")){
            BURounded = 3*(int)(BUThreeBottles - BUThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            BURounded = 6*(int)(BUSixBottles - BUSixBottles*this.off*off);
        }

        switch (cellDivine){
            case "1b":
                cellDivineRounded = this.oneBottleCellDivine;
                break;
            case "3b":
                cellDivineRounded = this.threeBottlesCellDivine;
                break;
            case "6b":
                cellDivineRounded = this.sixBottlesCellDivine;
                break;
            default:
                cellDivineRounded = 0;
                break;
        }

        total = round( BURounded + shippingRounded + insuranceRounded + bioUnityUpSellRounded + bioUnityDownSellRounded + cellDivineRounded);

        double finalTotal = total;
        double finalBURounded = BURounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("BU", doubleToString(finalBURounded));
            put("bioUnityUpSell", doubleToString(bioUnityUpSellRounded));
            put("bioUnityDownSell", doubleToString(bioUnityDownSellRounded));
            put("cellDivine", doubleToString(cellDivineRounded));
            put("insurance", doubleToString(insuranceRounded));
            put("shipping", doubleToString(finalShippingRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int bioUnityUpSell, int bioUnityDownSell, String cellDivine){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, bioUnityUpSell, bioUnityDownSell, cellDivine);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Insurance: ID="+propertyManager.getProperty("insurance", "BU")+" $"+amounts.get("insurance"),
                "Shipping: $"+amounts.get("shipping"),
                "BU: ID="+propertyManager.getProperty("BU" + bottles + off, "BU")+" $"+amounts.get("BU"),
                "Bio Unity UpSell: ID="+propertyManager.getProperty("bioUnityUpSell", "BU")+" $"+amounts.get("bioUnityUpSell"),
                "Bio Unity DownSell: ID="+propertyManager.getProperty("bioUnityDownSell", "BU")+" $"+amounts.get("bioUnityDownSell"),
                "CellDivine: ID="+propertyManager.getProperty("cellDivine" + cellDivine, "BU")+" $"+amounts.get("cellDivine"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
