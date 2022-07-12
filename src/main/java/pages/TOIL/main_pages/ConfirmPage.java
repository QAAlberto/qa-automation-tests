package pages.TOIL.main_pages;

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

    double trinityOneBottle = 69;
    double trinityThreeBottles = 59;
    double trinitySixBottles = 49;

    double cinnamonOneBottle = 49;
    double cinnamonThreeBottles = 39;
    double cinnamonSixBottles = 29;

    double turmericOneBottle = 49;
    double turmericThreeBottles = 39;
    double turmericSixBottles = 29;

    double shippingUS = 12.95;
    double shipping = 24.95;

    double off = 0.1;

    double insurance = 8.95;

    double firstUpsell = 234;
    double secondUpsell = 117;
    double thirdUpsell = 39;

    double myohoCinnamonUpSell = 2;
    double myohoCinnamonDownSell = 2;

    double myohoTurmericUpSell = 2;
    double myohoTurmericDownSell = 2;

    double discount30 = 0.3;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell){
        assertEquals(grandTotalField, "$" + getAmount(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public void verifyGrandTotalDiscount30(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell){
        assertEquals(grandTotalField, "$" + getAmountDiscount30(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell).get("total"));
    }

    public HashMap<String, String> getAmount(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell){
        double total = 0;
        double trinityRounded = 0;
        double shippingRounded = 0;
        double insuranceRounded;
        double firstUpsellRounded;
        double secondUpsellRounded;
        double thirdUpsellRounded;

        insuranceRounded = this.insurance*insurance;
        firstUpsellRounded = this.firstUpsell*firstUpsell;
        secondUpsellRounded = this.secondUpsell*secondUpsell;
        thirdUpsellRounded = this.thirdUpsell*thirdUpsell;

        switch (country){
            case "United States":
                if(bottles.equals("1b")){
                    trinityRounded = (int)(trinityOneBottle - trinityOneBottle*this.off*off);
                    shippingRounded = off == 0 ? shippingUS : 0;
                }else if(bottles.equals("3b")){
                    trinityRounded = 3*(int)(trinityThreeBottles - trinityThreeBottles*this.off*off);
                }else if(bottles.equals("6b")){
                    trinityRounded = 6*(int)(trinitySixBottles - trinitySixBottles*this.off*off);
                }
                break;
            default:
                shippingRounded = shipping;
                if(bottles.equals("1b")){
                    trinityRounded = (int)(trinityOneBottle - trinityOneBottle*this.off*off);
                }else if(bottles.equals("3b")){
                    trinityRounded = 3*(int)(trinityThreeBottles - trinityThreeBottles*this.off*off);
                }else if(bottles.equals("6b")){
                    trinityRounded = 6*(int)(trinitySixBottles - trinitySixBottles*this.off*off);
                }
                break;
        }
        total = round( trinityRounded + shippingRounded + insuranceRounded + firstUpsellRounded + secondUpsellRounded + thirdUpsellRounded);

        double finalTotal = total;
        double finalTrinityRounded = trinityRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("trinity", doubleToString(finalTrinityRounded));
            put("shipping", doubleToString(finalShippingRounded));
            put("firstUpsell", doubleToString(firstUpsellRounded));
            put("secondUpsell", doubleToString(secondUpsellRounded));
            put("thirdUpsell", doubleToString(thirdUpsellRounded));
            put("insurance", doubleToString(insuranceRounded));
            put("country", country);
        }};
    }

    public HashMap<String, String> getAmountDiscount30(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell){
        double total = 0;
        double trinityRounded = 0;
        double shippingRounded = 0;
        double insuranceRounded;
        double firstUpsellRounded;
        double secondUpsellRounded;
        double thirdUpsellRounded;

        insuranceRounded = this.insurance*insurance;
        firstUpsellRounded = this.firstUpsell*firstUpsell;
        secondUpsellRounded = this.secondUpsell*secondUpsell;
        thirdUpsellRounded = this.thirdUpsell*thirdUpsell;

        switch (country){
            case "United States":
                if(bottles.equals("1b")){
                    trinityRounded = trinityOneBottle - trinityOneBottle*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                    shippingRounded = off == 0 ? shippingUS : 0;
                }else if(bottles.equals("3b")){
                    trinityRounded = trinityThreeBottles - trinityThreeBottles*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                    trinityRounded = 3*trinityRounded;
                }else if(bottles.equals("6b")){
                    trinityRounded = trinitySixBottles - trinitySixBottles*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                    trinityRounded = 6*trinityRounded;
                }
                break;
            default:
                shippingRounded = shipping;
                if(bottles.equals("1b")){
                    trinityRounded = trinityOneBottle - trinityOneBottle*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                }else if(bottles.equals("3b")){
                    trinityRounded = trinityThreeBottles - trinityThreeBottles*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                    trinityRounded = 3*trinityRounded;
                }else if(bottles.equals("6b")){
                    trinityRounded = trinitySixBottles - trinitySixBottles*this.discount30;
                    trinityRounded = truncate(trinityRounded - trinityRounded*this.off*off);
                    trinityRounded = 6*trinityRounded;
                }
                break;
        }
        trinityRounded = round(trinityRounded);
        total = round( trinityRounded + shippingRounded + insuranceRounded + firstUpsellRounded + secondUpsellRounded + thirdUpsellRounded);

        double finalTotal = total;
        double finalTrinityRounded = trinityRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("shipping", doubleToString(finalShippingRounded));
            put("trinity", doubleToString(finalTrinityRounded));
            put("firstUpsell", doubleToString(firstUpsellRounded));
            put("secondUpsell", doubleToString(secondUpsellRounded));
            put("thirdUpsell", doubleToString(thirdUpsellRounded));
            put("insurance", doubleToString(insuranceRounded));
            put("country", country);
        }};
    }

    public HashMap<String, String> getAmountCinnamon(String bottles, int off, int insurance, int myohoCinnamonUpSell, int myohoCinnamonDownSell){
        double total = 0;
        double trinityRounded = 0;
        double shippingRounded = 0;
        double insuranceRounded;
        double myohoCinnamonUpSellRounded;
        double myohoCinnamonDownSellRounded;

        insuranceRounded = this.insurance*insurance;
        myohoCinnamonUpSellRounded = this.myohoCinnamonUpSell*myohoCinnamonUpSell;
        myohoCinnamonDownSellRounded = this.myohoCinnamonDownSell*myohoCinnamonDownSell;

        if(bottles.equals("1b")){
            trinityRounded = (int)(cinnamonOneBottle - cinnamonOneBottle*this.off*off);
            shippingRounded = off == 0 ? shippingUS : 0;
        }else if(bottles.equals("3b")){
            trinityRounded = 3*(int)(cinnamonThreeBottles - cinnamonThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            trinityRounded = 6*(int)(cinnamonSixBottles - cinnamonSixBottles*this.off*off);
        }

        total = round( trinityRounded + shippingRounded + insuranceRounded + myohoCinnamonUpSellRounded + myohoCinnamonDownSellRounded);

        double finalTotal = total;
        double finalTrinityRounded = trinityRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("trinity", doubleToString(finalTrinityRounded));
            put("myohoCinnamonUpSell", doubleToString(myohoCinnamonUpSellRounded));
            put("myohoCinnamonDownSell", doubleToString(myohoCinnamonDownSellRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public HashMap<String, String> getAmountTurmeric(String bottles, int off, int insurance, int myohoTurmericUpSell, int myohoTurmericDownSell){
        double total = 0;
        double trinityRounded = 0;
        double shippingRounded = 0;
        double insuranceRounded;
        double myohoTurmericUpSellRounded;
        double myohoTurmericDownSellRounded;

        insuranceRounded = this.insurance*insurance;
        myohoTurmericUpSellRounded = this.myohoTurmericUpSell*myohoTurmericUpSell;
        myohoTurmericDownSellRounded = this.myohoTurmericDownSell*myohoTurmericDownSell;

        if(bottles.equals("1b")){
            trinityRounded = (int)(turmericOneBottle - turmericOneBottle*this.off*off);
            shippingRounded = off == 0 ? shippingUS : 0;
        }else if(bottles.equals("3b")){
            trinityRounded = 3*(int)(turmericThreeBottles - turmericThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            trinityRounded = 6*(int)(turmericSixBottles - turmericSixBottles*this.off*off);
        }

        total = round( trinityRounded + shippingRounded + insuranceRounded + myohoTurmericUpSellRounded + myohoTurmericDownSellRounded);

        double finalTotal = total;
        double finalTrinityRounded = trinityRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("trinity", doubleToString(finalTrinityRounded));
            put("myohoTurmericUpSell", doubleToString(myohoTurmericUpSellRounded));
            put("myohoTurmericDownSell", doubleToString(myohoTurmericDownSellRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell, String language){
        HashMap<String, String> amounts = this.getAmount(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell);
        List<Object> items;
        String continuity = off == 1 ? "Continuity" : "";
        items = Arrays.asList(new Object[] {
                "Country: "+ amounts.get("country"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "TOIL")+" $"+amounts.get("insurance"),
                "Shipping:  $"+amounts.get("shipping"),
                "Trinity Oil: ID="+propertyManager.getProperty(bottles+continuity, "TOIL")+" $"+amounts.get("trinity"),
                "First Upsell: ID="+propertyManager.getProperty("firstUpsell", "TOIL")+" $"+amounts.get("firstUpsell"),
                "Second Upsell: ID="+propertyManager.getProperty("secondUpsell", "TOIL")+" $"+amounts.get("secondUpsell"),
                "Third Upsell: ID="+propertyManager.getProperty("thirdUpsell", "TOIL")+" $"+amounts.get("thirdUpsell"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }

    public List getListDiscount30(String bottles, String country, int off, int insurance, int firstUpsell, int secondUpsell, int thirdUpsell, String language){
        HashMap<String, String> amounts = this.getAmountDiscount30(bottles, country, off, insurance, firstUpsell, secondUpsell, thirdUpsell);
        List<Object> items;
        String continuity = off == 1 ? "Continuity" : "";
        items = Arrays.asList(new Object[] {
                "Country: "+ amounts.get("country"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "TOIL")+" $"+amounts.get("insurance"),
                "Shipping:  $"+amounts.get("shipping"),
                "Trinity Oil: ID="+propertyManager.getProperty(bottles+continuity, "TOIL")+" $"+amounts.get("trinity"),
                "First Upsell: ID="+propertyManager.getProperty("firstUpsell", "TOIL")+" $"+amounts.get("firstUpsell"),
                "Second Upsell: ID="+propertyManager.getProperty("secondUpsell", "TOIL")+" $"+amounts.get("secondUpsell"),
                "Third Upsell: ID="+propertyManager.getProperty("thirdUpsell", "TOIL")+" $"+amounts.get("thirdUpsell"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }

    public List getListCinnamon(String bottles, int off, int insurance, int myohoCinnamonUpSell, int myohoCinnamonDownSell){
        HashMap<String, String> amounts = this.getAmountCinnamon(bottles, off, insurance, myohoCinnamonUpSell, myohoCinnamonDownSell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Insurance: ID="+propertyManager.getProperty("insurance", "TOIL")+" $"+amounts.get("insurance"),
                "Trinity Oil: ID="+propertyManager.getProperty(bottles + "MYOHOCinnamon", "TOIL")+" $"+amounts.get("trinity"),
                "myohoCinnamonUpSell: ID="+propertyManager.getProperty("myohoCinnamonUpSell", "TOIL")+" $"+amounts.get("myohoCinnamonUpSell"),
                "myohoCinnamonDownSell: ID="+propertyManager.getProperty("myohoCinnamonDownSell", "TOIL")+" $"+amounts.get("myohoCinnamonDownSell"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }

    public List getListTurmeric(String bottles, int off, int insurance, int myohoTurmericUpSell, int myohoTurmericDownSell){
        HashMap<String, String> amounts = this.getAmountTurmeric(bottles, off, insurance, myohoTurmericUpSell, myohoTurmericDownSell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Insurance: ID="+propertyManager.getProperty("insurance", "TOIL")+" $"+amounts.get("insurance"),
                "Trinity Oil: ID="+propertyManager.getProperty(bottles + "MYOHOTurmeric", "TOIL")+" $"+amounts.get("trinity"),
                "myohoTurmericUpSell: ID="+propertyManager.getProperty("myohoTurmericUpSell", "TOIL")+" $"+amounts.get("myohoTurmericUpSell"),
                "myohoTurmericDownSell: ID="+propertyManager.getProperty("myohoTurmericDownSell", "TOIL")+" $"+amounts.get("myohoTurmericDownSell"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
