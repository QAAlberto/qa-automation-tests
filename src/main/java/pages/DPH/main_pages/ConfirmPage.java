package pages.DPH.main_pages;

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

    double DPHOneBottle = 69;
    double DPHThreeBottles = 59;
    double DPHSixBottles = 49;

    double off = 0.1;
    double shipping = 12.95;

    double insurance = 8.95;

    double DPH6BottlesUpsell = 234;
    double DPH3BottlesUpsell = 117;
    double waterPitcher1CartridgeUpsell = 149;
    double waterPitcher2CartridgeUpsell = 99;
    double cartridge4Upsell = 148;
    double cartridge2Upsell = 74;

    By grandTotalField = By.id("orderTotal");

    public void verifyGrandTotal(String bottles, int off, int insurance, int DPH6BottlesUpsell, int DPH3BottlesUpsell, int waterPitcher1CartridgeUpsell, int waterPitcher2CartridgeUpsell, int cartridge4Upsell, int cartridge2Upsell) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, DPH6BottlesUpsell, DPH3BottlesUpsell, waterPitcher1CartridgeUpsell, waterPitcher2CartridgeUpsell, cartridge4Upsell, cartridge2Upsell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int DPH6BottlesUpsell, int DPH3BottlesUpsell, int waterPitcher1CartridgeUpsell, int waterPitcher2CartridgeUpsell, int cartridge4Upsell, int cartridge2Upsell){
        double total = 0;
        double insuranceRounded;
        double shippingRounded = 0;
        double DPHRounded = 0;
        double DPH6BottlesUpsellRounded;
        double DPH3BottlesUpsellRounded;
        double waterPitcher1CartridgeUpsellRounded;
        double waterPitcher2CartridgeUpsellRounded;
        double cartridge4UpsellRounded;
        double cartridge2UpsellRounded;

        insuranceRounded = this.insurance*insurance;
        DPH6BottlesUpsellRounded = this.DPH6BottlesUpsell*DPH6BottlesUpsell;
        DPH3BottlesUpsellRounded = this.DPH3BottlesUpsell*DPH3BottlesUpsell;
        waterPitcher1CartridgeUpsellRounded = this.waterPitcher1CartridgeUpsell*waterPitcher1CartridgeUpsell;
        waterPitcher2CartridgeUpsellRounded = this.waterPitcher2CartridgeUpsell*waterPitcher2CartridgeUpsell;
        cartridge4UpsellRounded = this.cartridge4Upsell*cartridge4Upsell;
        cartridge2UpsellRounded = this.cartridge2Upsell*cartridge2Upsell;

        if(bottles.equals("1b")){
            DPHRounded = (int)(DPHOneBottle - DPHOneBottle*this.off*off);
            shippingRounded = off == 0 ? shipping : 0;
        }else if(bottles.equals("3b")){
            DPHRounded = 3*(int)(DPHThreeBottles - DPHThreeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            DPHRounded = 6*(int)(DPHSixBottles - DPHSixBottles*this.off*off);
        }
        total = round( DPHRounded + shippingRounded + insuranceRounded + DPH6BottlesUpsellRounded + DPH3BottlesUpsellRounded + waterPitcher1CartridgeUpsellRounded + waterPitcher2CartridgeUpsellRounded + cartridge4UpsellRounded + cartridge2UpsellRounded);

        double finalTotal = total;
        double finalDPHRounded = DPHRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("DPH", doubleToString(finalDPHRounded));
            put("DPH6BottlesUpsell", doubleToString(DPH6BottlesUpsellRounded));
            put("DPH3BottlesUpsell", doubleToString(DPH3BottlesUpsellRounded));
            put("waterPitcher1CartridgeUpsell", doubleToString(waterPitcher1CartridgeUpsellRounded));
            put("waterPitcher2CartridgeUpsell", doubleToString(waterPitcher2CartridgeUpsellRounded));
            put("cartridge4Upsell", doubleToString(cartridge4UpsellRounded));
            put("cartridge2Upsell", doubleToString(cartridge2UpsellRounded));
            put("insurance", doubleToString(insuranceRounded));
            put("shipping", doubleToString(finalShippingRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int DPH6BottlesUpsell, int DPH3BottlesUpsell, int waterPitcher1CartridgeUpsell, int waterPitcher2CartridgeUpsell, int cartridge4Upsell, int cartridge2Upsell){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, DPH6BottlesUpsell, DPH3BottlesUpsell, waterPitcher1CartridgeUpsell, waterPitcher2CartridgeUpsell, cartridge4Upsell, cartridge2Upsell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Insurance: ID="+propertyManager.getProperty("insurance", "DPH")+" $"+amounts.get("insurance"),
                "Shipping: $"+amounts.get("shipping"),
                "DPH: ID="+propertyManager.getProperty("DPH" + bottles + off, "DPH")+" $"+amounts.get("DPH"),
                "DPH6BottlesUpsell: ID="+propertyManager.getProperty("DPH6BottlesUpsell", "DPH")+" $"+amounts.get("DPH6BottlesUpsell"),
                "DPH3BottlesUpsell: ID="+propertyManager.getProperty("DPH3BottlesUpsell", "DPH")+" $"+amounts.get("DPH3BottlesUpsell"),
                "waterPitcher1CartridgeUpsell: ID="+propertyManager.getProperty("waterPitcher1CartridgeUpsell", "DPH")+" $"+amounts.get("waterPitcher1CartridgeUpsell"),
                "waterPitcher2CartridgeUpsell: ID="+propertyManager.getProperty("waterPitcher2CartridgeUpsell", "DPH")+" $"+amounts.get("waterPitcher2CartridgeUpsell"),
                "cartridge4Upsell: ID="+propertyManager.getProperty("cartridge4Upsell", "DPH")+" $"+amounts.get("cartridge4Upsell"),
                "cartridge2Upsell: ID="+propertyManager.getProperty("cartridge2Upsell", "DPH")+" $"+amounts.get("cartridge2Upsell"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
