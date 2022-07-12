package pages.GF.main_pages;

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

    double GFOneBottle = 69;
    double GFThreeBottles = 59;
    double GFSixBottles = 49;

    double off = 0.1;
    double shipping = 12.95;

    double insurance = 8.95;

    double gorillaFlowUpSell = 234;
    double gorillaFlowDownSell = 117;
    double oneBottleTestoIgnite = 47;
    double threeBottlesTestoIgnite = 111;
    double sixBottlesTestoIgnite = 162;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int off, int insurance, int gorillaFlowUpSell, int gorillaFlowDownSell, String testoIgnite) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, gorillaFlowUpSell, gorillaFlowDownSell, testoIgnite).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int gorillaFlowUpSell, int gorillaFlowDownSell, String testoIgnite){
        double total = 0;
        double insuranceRounded;
        double shippingRounded = 0;
        double GFRounded = 0;
        double gorillaFlowUpSellRounded;
        double gorillaFlowDownSellRounded;
        double testoIgniteRounded;

        insuranceRounded = this.insurance*insurance;
        gorillaFlowUpSellRounded = this.gorillaFlowUpSell*gorillaFlowUpSell;
        gorillaFlowDownSellRounded = this.gorillaFlowDownSell*gorillaFlowDownSell;

        if(bottles.equals("1b")){
            GFRounded = (int)(GFOneBottle - GFOneBottle*this.off*off);
            shippingRounded = off == 0 ? shipping : 0;
        }else if(bottles.equals("3b")){
            GFRounded = 3*(int)(GFThreeBottles - GFThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            GFRounded = 6*(int)(GFSixBottles - GFSixBottles*this.off*off);
        }

        switch (testoIgnite){
            case "1b":
                testoIgniteRounded = this.oneBottleTestoIgnite;
                break;
            case "3b":
                testoIgniteRounded = this.threeBottlesTestoIgnite;
                break;
            case "6b":
                testoIgniteRounded = this.sixBottlesTestoIgnite;
                break;
            default:
                testoIgniteRounded = 0;
                break;
        }

        total = round( GFRounded + shippingRounded + insuranceRounded + gorillaFlowUpSellRounded + gorillaFlowDownSellRounded + testoIgniteRounded);

        double finalTotal = total;
        double finalGFRounded = GFRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("GF", doubleToString(finalGFRounded));
            put("gorillaFlowUpSell", doubleToString(gorillaFlowUpSellRounded));
            put("gorillaFlowDownSell", doubleToString(gorillaFlowDownSellRounded));
            put("testoIgnite", doubleToString(testoIgniteRounded));
            put("insurance", doubleToString(insuranceRounded));
            put("shipping", doubleToString(finalShippingRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int gorillaFlowUpSell, int gorillaFlowDownSell, String testoIgnite){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, gorillaFlowUpSell, gorillaFlowDownSell, testoIgnite);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Insurance: ID="+propertyManager.getProperty("insurance", "GF")+" $"+amounts.get("insurance"),
                "Shipping: $"+amounts.get("shipping"),
                "GF: ID="+propertyManager.getProperty("GF" + bottles + off, "GF")+" $"+amounts.get("GF"),
                "Gorilla Flow UpSell: ID="+propertyManager.getProperty("gorillaFlowUpSell", "GF")+" $"+amounts.get("gorillaFlowUpSell"),
                "Gorilla Flow DownSell: ID="+propertyManager.getProperty("gorillaFlowDownSell", "GF")+" $"+amounts.get("gorillaFlowDownSell"),
                "TestoIgnite: ID="+propertyManager.getProperty("testoIgnite" + testoIgnite, "GF")+" $"+amounts.get("testoIgnite"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
