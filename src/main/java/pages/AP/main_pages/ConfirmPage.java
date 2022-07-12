package pages.AP.main_pages;

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

    double APOneBottle = 69;
    double APThreeBottles = 59;
    double APSixBottles = 49;

    double shipping = 9.95;

    double divineTurmericOneBottle = 65;
    double divineTurmericThreeBottles = 55;
    double divineTurmericSixBottles = 45;

    double apostlePromiseUpSell = 174;
    double apostlePromiseDownSell = 87;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public void verifyGrandTotal(String bottles, int apostlePromiseUpSell, int apostlePromiseDownSell, String divineTurmeric) {
        assertEquals(grandTotalField, "$" + getAmount(bottles, apostlePromiseUpSell, apostlePromiseDownSell, divineTurmeric).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String bottles, int apostlePromiseUpSell, int apostlePromiseDownSell, String divineTurmeric){
        double total = 0;
        double APRounded = 0;
        double shippingRounded = 0;
        double apostlePromiseUpSellRounded;
        double apostlePromiseDownSellRounded;
        double divineTurmericRounded;

        apostlePromiseUpSellRounded = this.apostlePromiseUpSell*apostlePromiseUpSell;
        apostlePromiseDownSellRounded = this.apostlePromiseDownSell*apostlePromiseDownSell;

        if(bottles.equals("1b")){
            APRounded = (int)(APOneBottle);
            shippingRounded = this.shipping;
        }else if(bottles.equals("3b")){
            APRounded = 3*(int)(APThreeBottles);
        }else if(bottles.equals("6b")){
            APRounded = 6*(int)(APSixBottles);
        }

        switch (divineTurmeric){
            case "1b":
                divineTurmericRounded = this.divineTurmericOneBottle;
                break;
            case "3b":
                divineTurmericRounded = 3*this.divineTurmericThreeBottles;
                break;
            case "6b":
                divineTurmericRounded = 6*this.divineTurmericSixBottles;
                break;
            default:
                divineTurmericRounded = 0;
                break;
        }

        total = round( APRounded + shippingRounded + apostlePromiseUpSellRounded + apostlePromiseDownSellRounded + divineTurmericRounded);

        double finalTotal = total;
        double finalAPRounded = APRounded;
        double finalShippingRounded = shippingRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("AP", doubleToString(finalAPRounded));
            put("shipping", doubleToString(finalShippingRounded));
            put("apostlePromiseUpSell", doubleToString(apostlePromiseUpSellRounded));
            put("apostlePromiseDownSell", doubleToString(apostlePromiseDownSellRounded));
            put("divineTurmeric", doubleToString(divineTurmericRounded));
        }};
    }

    public List getList(String bottles, int apostlePromiseUpSell, int apostlePromiseDownSell, String divineTurmeric){
        HashMap<String, String> amounts = this.getAmount(bottles, apostlePromiseUpSell, apostlePromiseDownSell, divineTurmeric);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "Apostle Promise "+bottles+": ID="+propertyManager.getProperty("AP" + bottles, "AP")+" $"+amounts.get("AP"),
                "Shipping: $"+amounts.get("shipping"),
                "Apostles Promise - 6 Bottles - Discount: ID="+propertyManager.getProperty("apostlePromiseUpSell", "AP")+" $"+amounts.get("apostlePromiseUpSell"),
                "Apostles Promise - 3 Bottles - Discount: ID="+propertyManager.getProperty("apostlePromiseDownSell", "AP")+" $"+amounts.get("apostlePromiseDownSell"),
                "Divine Turmeric "+divineTurmeric+": ID="+propertyManager.getProperty("divineTurmeric" + divineTurmeric, "AP")+" $"+amounts.get("divineTurmeric"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
