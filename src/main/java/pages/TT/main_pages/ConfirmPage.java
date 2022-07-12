package pages.TT.main_pages;

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

    double tupiTeaUpSell = 234;
    double tupiTeaDownSell = 117;

    double oneBottleTupiTest = 47;
    double threeBottlesTupiTest = 111;
    double sixBottlesTupiTest = 162;

    double oneBottleTupiFlow = 69;
    double threeBottlesTupiFlow = 177;
    double sixBottlesTupiFlow = 294;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public void verifyGrandTotal(String bottles, int off, int insurance, int tupiTeaUpSell, int tupiTeaDownSell, String tupiTest, String tupiFlow){
        assertEquals(grandTotalField, "$" + getAmount(bottles, off, insurance, tupiTeaUpSell, tupiTeaDownSell, tupiTest, tupiFlow).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(String bottles, int off, int insurance, int tupiTeaUpSell, int tupiTeaDownSell, String tupiTest, String tupiFlow){
        double total = 0;
        double tupiTeaRounded = 0;
        double insuranceRounded;
        double shippingRounded = 0;
        double tupiTeaUpSellRounded;
        double tupiTeaDownSellRounded;
        double tupiTestRounded;
        double tupiFlowRounded;

        insuranceRounded = this.insurance*insurance;
        tupiTeaUpSellRounded = this.tupiTeaUpSell*tupiTeaUpSell;
        tupiTeaDownSellRounded = this.tupiTeaDownSell*tupiTeaDownSell;

        switch (tupiTest){
            case "1b":
                tupiTestRounded = this.oneBottleTupiTest;
                break;
            case "3b":
                tupiTestRounded = this.threeBottlesTupiTest;
                break;
            case "6b":
                tupiTestRounded = this.sixBottlesTupiTest;
                break;
            default:
                tupiTestRounded = 0;
                break;
        }

        switch (tupiFlow){
            case "1b":
                tupiFlowRounded = this.oneBottleTupiFlow;
                break;
            case "3b":
                tupiFlowRounded = this.threeBottlesTupiFlow;
                break;
            case "6b":
                tupiFlowRounded = this.sixBottlesTupiFlow;
                break;
            default:
                tupiFlowRounded = 0;
                break;
        }

        if(bottles.equals("1b")){
            tupiTeaRounded = (int)(this.oneBottle - this.oneBottle*this.off*off);
            shippingRounded = off == 0 ? shippingUS : 0;
        }else if(bottles.equals("3b")){
            tupiTeaRounded = (int)(this.threeBottles - this.threeBottles*this.off*off);
        }else if(bottles.equals("6b")){
            tupiTeaRounded = (int)(this.sixBottles - this.sixBottles*this.off*off);
        }

        total = round(tupiTeaRounded + shippingRounded + insuranceRounded + tupiTeaUpSellRounded + tupiTeaDownSellRounded + tupiTestRounded + tupiFlowRounded);

        double finalTotal = total;
        double finalTupiTeaRounded = tupiTeaRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("shipping", doubleToString(finalShippingRounded));
            put("tupiTea", doubleToString(finalTupiTeaRounded));
            put("tupiTeaUpSell", doubleToString(tupiTeaUpSellRounded));
            put("tupiTeaDownSell", doubleToString(tupiTeaDownSellRounded));
            put("tupiTest", doubleToString(tupiTestRounded));
            put("tupiFlow", doubleToString(tupiFlowRounded));
            put("insurance", doubleToString(insuranceRounded));
        }};
    }

    public List getList(String bottles, int off, int insurance, int tupiTeaUpSell, int tupiTeaDownSell, String tupiTest, String tupiFlow){
        HashMap<String, String> amounts = this.getAmount(bottles, off, insurance, tupiTeaUpSell, tupiTeaDownSell, tupiTest, tupiFlow);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "TupiTea: ID="+propertyManager.getProperty("tupiTea" + bottles + off, "TT")+" $"+amounts.get("tupiTea"),
                "Shipping: ID= $"+amounts.get("shipping"),
                "TupiTea UpSell: ID="+propertyManager.getProperty("tupiTeaUpSell", "TT")+" $"+amounts.get("tupiTeaUpSell"),
                "TupiTea DownSell: ID="+propertyManager.getProperty("tupiTeaDownSell", "TT")+" $"+amounts.get("tupiTeaDownSell"),
                "TupiTest: ID="+propertyManager.getProperty("tupiTest" + bottles, "TT")+" $"+amounts.get("tupiTest"),
                "TupiFlow: ID="+propertyManager.getProperty("tupiFlow" + bottles, "TT")+" $"+amounts.get("tupiFlow"),
                "Insurance: ID="+propertyManager.getProperty("insurance", "TT")+" $"+amounts.get("insurance"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
