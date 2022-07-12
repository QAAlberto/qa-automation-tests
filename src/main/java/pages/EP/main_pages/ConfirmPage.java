package pages.EP.main_pages;

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
    double oneBottle = 69;
    double threeBottles = 177;
    double sixBottles = 294;

    double off = 0.1;
    double shippingUS = 12.95;
    double insurance = 8.95;

    double endoBumpUpSell = 234;
    double endoBumpDownSell = 117;

    double oneBottleTestZilla = 47;
    double threeBottlesTestZilla = 111;
    double sixBottlesTestZilla = 162;

    double oneBottleProstatePlus = 69;
    double threeBottlesProstatePlus = 177;
    double sixBottlesProstatePlus = 294;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public void verifyGrandTotal(String bottles, int off, int insurance, int endoBumpUpSell, int endoBumpDownSell, String testZilla, String prostatePlus){
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, endoBumpUpSell, endoBumpDownSell, testZilla, prostatePlus).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int endoBumpUpSell, int endoBumpDownSell, String testZilla, String prostatePlus){
        double total = 0;
        double endoBumpRounded = 0;
        double insuranceRounded;
        double shippingRounded = 0;
        double endoBumpUpSellRounded;
        double endoBumpDownSellRounded;
        double testZillaRounded;
        double prostatePlusRounded;

        insuranceRounded = this.insurance*insurance;
        endoBumpUpSellRounded = this.endoBumpUpSell*endoBumpUpSell;
        endoBumpDownSellRounded = this.endoBumpDownSell*endoBumpDownSell;

        switch (testZilla){
            case "1b":
                testZillaRounded = this.oneBottleTestZilla;
                break;
            case "3b":
                testZillaRounded = this.threeBottlesTestZilla;
                break;
            case "6b":
                testZillaRounded = this.sixBottlesTestZilla;
                break;
            default:
                testZillaRounded = 0;
                break;
        }

        switch (prostatePlus){
            case "1b":
                prostatePlusRounded = this.oneBottleProstatePlus;
                break;
            case "3b":
                prostatePlusRounded = this.threeBottlesProstatePlus;
                break;
            case "6b":
                prostatePlusRounded = this.sixBottlesProstatePlus;
                break;
            default:
                prostatePlusRounded = 0;
                break;
        }

        if(bottles.equals("1b")){
            endoBumpRounded = (int)(this.oneBottle - this.oneBottle*this.off*off);
            shippingRounded = off == 0 ? shippingUS : 0;
        }else if(bottles.equals("3b")){
            endoBumpRounded = (int)(this.threeBottles - this.threeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            endoBumpRounded = (int)(this.sixBottles - this.sixBottles*this.off*off);
        }

        total = round(endoBumpRounded + shippingRounded + insuranceRounded + endoBumpUpSellRounded + endoBumpDownSellRounded + testZillaRounded + prostatePlusRounded);

        double finalTotal = total;
        double finalEndoBumpRounded = endoBumpRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("shipping", doubleToString(finalShippingRounded));
            put("endoBump", doubleToString(finalEndoBumpRounded));
            put("endoBumpUpSell", doubleToString(endoBumpUpSellRounded));
            put("endoBumpDownSell", doubleToString(endoBumpDownSellRounded));
            put("testZilla", doubleToString(testZillaRounded));
            put("prostatePlus", doubleToString(prostatePlusRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int endoBumpUpSell, int endoBumpDownSell, String testZilla, String prostatePlus){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, endoBumpUpSell, endoBumpDownSell, testZilla, prostatePlus);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "EndoBump: ID="+propertyManager.getProperty("endoBump" + bottles + off, "EP")+" $"+amounts.get("endoBump"),
                "Shipping: ID= $"+amounts.get("shipping"),
                "EndoBump UpSell: ID="+propertyManager.getProperty("endoBumpUpSell", "EP")+" $"+amounts.get("endoBumpUpSell"),
                "EndoBump DownSell: ID="+propertyManager.getProperty("endoBumpDownSell", "EP")+" $"+amounts.get("endoBumpDownSell"),
                "TestZilla: ID="+propertyManager.getProperty("testZilla" + bottles, "EP")+" $"+amounts.get("testZilla"),
                "ProstatePlus: ID="+propertyManager.getProperty("prostatePlus" + bottles, "EP")+" $"+amounts.get("prostatePlus"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "EP")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
