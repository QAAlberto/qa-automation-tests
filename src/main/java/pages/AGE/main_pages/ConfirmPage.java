package pages.AGE.main_pages;

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

    double AGE = 69;
    double amplifire = 39;
    double knightStick = 19.95;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");

    public String getPassword(){
        return readText(password);
    }

    public HashMap<String, String> getAmount(int knightStick, int amplifire){
        double amount;
        double AGERounded;
        double amplifireRounded;
        double knightStickRounded;

        AGERounded = round(this.AGE);
        amplifireRounded = round(this.amplifire*amplifire);
        knightStickRounded = round(this.knightStick*knightStick);
        amount = AGERounded+amplifireRounded+knightStickRounded;

        return new HashMap <>() {{
            put("total", doubleToString(amount));
            put("AGE", doubleToString(AGERounded));
            put("amplifire", doubleToString(amplifireRounded));
            put("knightStick", doubleToString(knightStickRounded));
        }};
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public List<?> getList(int knightStick, int amplifire){
        HashMap<String, String> amounts = this.getAmount(knightStick, amplifire);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "AGE: ID="+propertyManager.getProperty("AGE", "AGE")+" $"+amounts.get("AGE"),
                "AGE Live: ID="+propertyManager.getProperty("AGELive", "AGE"),
                "Amplifire: ID="+propertyManager.getProperty("amplifire", "AGE")+" $"+amounts.get("amplifire"),
                "Knight Stick: ID="+propertyManager.getProperty("knightStick", "AGE")+" $"+amounts.get("knightStick"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }
}
