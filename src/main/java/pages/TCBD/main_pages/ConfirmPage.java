package pages.TCBD.main_pages;

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

    double trinityOneBottle = 49;
    double trinityThreeBottles = 39;
    double trinitySixBottles = 29;

    double shippingUS = 12.95;

    double off = 0.1;

    double insurance = 8.95;

    double firstUpsell = 114;
    double secondUpsell = 57;

    By grandTotalField = By.id("orderTotal");

    public void verifyGrandTotal(String bottles, int off, int insurance, int firstUpsell, int secondUpsell){
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, firstUpsell, secondUpsell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int firstUpsell, int secondUpsell){
        double total = 0;
        double TCBDRounded = 0;
        double shippingRounded = 0;
        double insuranceRounded;
        double firstUpsellRounded;
        double secondUpsellRounded;

        insuranceRounded = this.insurance*insurance;
        firstUpsellRounded = this.firstUpsell*firstUpsell;
        secondUpsellRounded = this.secondUpsell*secondUpsell;

        if(bottles.equals("1b")){
            TCBDRounded = (int)(trinityOneBottle - trinityOneBottle*this.off*off);
            shippingRounded = off == 0 ? shippingUS : 0;
        }else if(bottles.equals("3b")){
            TCBDRounded = 3*(int)(trinityThreeBottles - trinityThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            TCBDRounded = 6*(int)(trinitySixBottles - trinitySixBottles*this.off*off);
        }
        total = round( TCBDRounded + shippingRounded + insuranceRounded + firstUpsellRounded + secondUpsellRounded);

        double finalTotal = total;
        double finalTCBDRounded = TCBDRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("TCBD", doubleToString(finalTCBDRounded));
            put("shipping", doubleToString(finalShippingRounded));
            put("firstUpsell", doubleToString(firstUpsellRounded));
            put("secondUpsell", doubleToString(secondUpsellRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int firstUpsell, int secondUpsell){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, firstUpsell, secondUpsell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "TCBD: ID="+propertyManager.getProperty("TCBD" + bottles + off, "TCBD")+" $"+amounts.get("TCBD"),
                "FirstUpsell: ID="+propertyManager.getProperty("firstUpsell", "TCBD")+" $"+amounts.get("firstUpsell"),
                "Second Upsell: ID="+propertyManager.getProperty("secondUpsell", "TCBD")+" $"+amounts.get("secondUpsell"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "TCBD")+" $"+amounts.get("insurance"),
                "Shipping: $"+amounts.get("shipping"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
