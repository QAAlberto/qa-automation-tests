package pages.IH.main_pages;

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

    double insurance = 8.95;

    double firstUpsell = 234;
    double secondUpsell = 117;

    double oneBottleThirdUpsell = 47;
    double threeBottlesThirdUpsell = 111;
    double sixBottlesThirdUpsell = 162;

    double oneBottleFourthUpsell = 68.95;
    double threeBottlesFourthUpsell = 176.95;
    double sixBottlesFourthUpsell = 293.95;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public void verifyGrandTotal(String bottles, int off, int insurance, int firstUpsell, int secondUpsell, String thirdUpsell, String fourthUpsell){
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, firstUpsell, secondUpsell, thirdUpsell, fourthUpsell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int firstUpsell, int secondUpsell, String thirdUpsell, String fourthUpsell){
        double total = 0;
        double instahardRounded = 0;
        double insuranceRounded;
        double firstUpsellRounded;
        double secondUpsellRounded;
        double thirdUpsellRounded;
        double fourthUpsellRounded;

        insuranceRounded = this.insurance*insurance;
        firstUpsellRounded = this.firstUpsell*firstUpsell;
        secondUpsellRounded = this.secondUpsell*secondUpsell;

        switch (thirdUpsell){
            case "1b":
                thirdUpsellRounded = this.oneBottleThirdUpsell;
                break;
            case "3b":
                thirdUpsellRounded = this.threeBottlesThirdUpsell;
                break;
            case "6b":
                thirdUpsellRounded = this.sixBottlesThirdUpsell;
                break;
            default:
                thirdUpsellRounded = 0;
                break;
        }

        switch (fourthUpsell){
            case "1b":
                fourthUpsellRounded = this.oneBottleFourthUpsell;
                break;
            case "3b":
                fourthUpsellRounded = this.threeBottlesFourthUpsell;
                break;
            case "6b":
                fourthUpsellRounded = this.sixBottlesFourthUpsell;
                break;
            default:
                fourthUpsellRounded = 0;
                break;
        }

        if(bottles.equals("1b")){
            instahardRounded = (int)(this.oneBottle - this.oneBottle*this.off*off);
        }else if(bottles.equals("3b")){
            instahardRounded = (int)(this.threeBottles - this.threeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            instahardRounded = (int)(this.sixBottles - this.sixBottles*this.off*off);
        }

        total = round(instahardRounded + insuranceRounded + firstUpsellRounded + secondUpsellRounded + thirdUpsellRounded + fourthUpsellRounded);

        double finalTotal = total;
        double finalInstahardRounded = instahardRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("instahard", doubleToString(finalInstahardRounded));
            put("firstUpsell", doubleToString(firstUpsellRounded));
            put("secondUpsell", doubleToString(secondUpsellRounded));
            put("thirdUpsell", doubleToString(thirdUpsellRounded));
            put("fourthUpsell", doubleToString(fourthUpsellRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int firstUpsell, int secondUpsell, String thirdUpsell, String fourthUpsell){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, firstUpsell, secondUpsell, thirdUpsell, fourthUpsell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Instahard: ID="+propertyManager.getProperty("instahard" + bottles + off, "IH")+" $"+amounts.get("instahard"),
                "FirstUpsell: ID="+propertyManager.getProperty("firstUpsell", "IH")+" $"+amounts.get("firstUpsell"),
                "Second Upsell: ID="+propertyManager.getProperty("secondUpsell", "IH")+" $"+amounts.get("secondUpsell"),
                "Third Upsell: ID="+propertyManager.getProperty("thirdUpsell" + bottles, "IH")+" $"+amounts.get("thirdUpsell"),
                "Fourth Upsell: ID="+propertyManager.getProperty("fourthUpsell" + bottles, "IH")+" $"+amounts.get("fourthUpsell"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "IH")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
