package pages.PPS.main_pages;

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

    double lifetimeUpSell = 1000;
    double monthly = 495;
    double yearly = 1497;
    double lifetime = 2997;
    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(String PPS, int lifetimeUpSell){
        double total = 0;
        double PPSRounded = 0;
        double lifetimeUpSellRounded = 0;


        if(PPS.equals("monthly")){
            PPSRounded = this.monthly;
            lifetimeUpSellRounded = 1000*lifetimeUpSell;
        }else if(PPS.equals("yearly")){
            PPSRounded = this.yearly;
            lifetimeUpSellRounded = 500*lifetimeUpSell;
        }else if(PPS.equals("lifetime")){
            PPSRounded = this.lifetime;
        }

        total = round( PPSRounded + lifetimeUpSellRounded);

        double finalTotal = total;
        double finalPPSRounded= PPSRounded;
        double finalLifetimeUpSellRounded = lifetimeUpSellRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("Plan", doubleToString(finalPPSRounded));
            put("lifetimeUpSell", doubleToString(finalLifetimeUpSellRounded));
        }};
    }

    public List getList(String plan, int lifetimeUpSell){
        HashMap<String, String> amounts = this.getAmount(plan, lifetimeUpSell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "PPS : ID="+propertyManager.getProperty("PPS" + plan, "PPS")+" $"+amounts.get("PPS"),
                "Lifetime UpSell: ID="+propertyManager.getProperty("lifetimeUpSell", "PPS")+" $"+amounts.get("lifetimeUpSell"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
