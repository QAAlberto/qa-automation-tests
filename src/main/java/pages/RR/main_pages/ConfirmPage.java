package pages.RR.main_pages;

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

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    double RR = 67;
    double confessions = 245;
    double retireLiveVip = 249;
    double retireLive = 0;

    public void verifyGrandTotal(String product){
        assertEquals(grandTotalField, "$" + propertyManager.getProperty(product + "Amount", "RR"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public String getPassword(){
        return readText(password);
    }

    public void verifyGrandTotal2(int retireLive, int confessions, int retireLiveVip) {
        assertEquals(grandTotalField, "$" + getAmount(retireLive, confessions, retireLiveVip).get("total"));
    }

    public HashMap<String, String> getAmount(int retireLive, int confessions, int retireLiveVip){
        double total = 0;
        double retireLiveRounded = 0;
        double RRRounded = this.RR;
        double confessionsRounded;
        double retireLiveVipRounded;

        retireLiveRounded = this.retireLive*retireLive;
        confessionsRounded = this.confessions*confessions;
        retireLiveVipRounded = this.retireLiveVip*retireLiveVip;

        total = round( RRRounded + retireLiveRounded + confessionsRounded + retireLiveVipRounded);

        double finalTotal = total;
        double finalRRRounded = RRRounded;
        double finalRetireLiveRounded = retireLiveRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("RR", doubleToString(finalRRRounded));
            put("retireLive", doubleToString(finalRetireLiveRounded));
            put("confessions", doubleToString(confessionsRounded));
            put("retireLiveVip", doubleToString(retireLiveVipRounded));
        }};
    }

    public List getList(int retireLive, int confessions, int retireLiveVip){
        HashMap<String, String> amounts = this.getAmount(retireLive, confessions, retireLiveVip);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "RR: ID="+propertyManager.getProperty("RR", "RR")+" $"+amounts.get("RR"),
                "Retire Live: ID="+propertyManager.getProperty("retireLive", "RR")+" $"+amounts.get("retireLive"),
                "confessions: ID="+propertyManager.getProperty("confessions", "RR")+" $"+amounts.get("confessions"),
                "Retire Live Vip: ID="+propertyManager.getProperty("retireLiveVip", "RR")+" $"+amounts.get("retireLiveVip"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
