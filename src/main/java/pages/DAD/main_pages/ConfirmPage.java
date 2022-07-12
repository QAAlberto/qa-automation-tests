package pages.DAD.main_pages;

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

    double DAD = 67;

    double boss = 0;

    double velocityUpSell = 69;
    double velocityDownSell = 35;

    double combatDefenseSecretsUpSell = 29;
    double combatDefenseSecretsDownSell = 15;

    By grandTotalField = By.xpath("//div[@id='receipt']//strong");

    By password = By.id("userPassword");


    public String getPassword(){
        return readText(password);
    }


    public void verifyGrandTotal(int boss, int velocityUpSell, int velocityDownSell, int combatDefenseSecretsUpSell, int combatDefenseSecretsDownSell) {
        assertEquals(grandTotalField, "$" + getAmount(boss, velocityUpSell, velocityDownSell, combatDefenseSecretsUpSell, combatDefenseSecretsDownSell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public HashMap<String, String> getAmount(int boss, int velocityUpSell, int velocityDownSell, int combatDefenseSecretsUpSell, int combatDefenseSecretsDownSell){
        double total = 0;
        double bossRounded = 0;
        double DADRounded = this.DAD;
        double velocityUpSellRounded;
        double velocityDownSellRounded;
        double combatDefenseSecretsUpSellRounded;
        double combatDefenseSecretsDownSellRounded;

        bossRounded = this.boss*boss;
        velocityUpSellRounded = this.velocityUpSell*velocityUpSell;
        velocityDownSellRounded = this.velocityDownSell*velocityDownSell;
        combatDefenseSecretsUpSellRounded = this.combatDefenseSecretsUpSell*combatDefenseSecretsUpSell;
        combatDefenseSecretsDownSellRounded = this.combatDefenseSecretsDownSell*combatDefenseSecretsDownSell;

        total = round( DADRounded + bossRounded + velocityUpSellRounded + velocityDownSellRounded + combatDefenseSecretsUpSellRounded + combatDefenseSecretsDownSellRounded);

        double finalTotal = total;
        double finalDADRounded = DADRounded;
        double finalBossRounded = bossRounded;
        return new HashMap <>() {{
            put("total", doubleToString(finalTotal));
            put("DAD", doubleToString(finalDADRounded));
            put("boss", doubleToString(finalBossRounded));
            put("velocityUpSell", doubleToString(velocityUpSellRounded));
            put("velocityDownSell", doubleToString(velocityDownSellRounded));
            put("combatDefenseSecretsUpSell", doubleToString(combatDefenseSecretsUpSellRounded));
            put("combatDefenseSecretsDownSell", doubleToString(combatDefenseSecretsDownSellRounded));
        }};
    }

    public List getList(int boss, int velocityUpSell, int velocityDownSell, int combatDefenseSecretsUpSell, int combatDefenseSecretsDownSell){
        HashMap<String, String> amounts = this.getAmount(boss, velocityUpSell, velocityDownSell, combatDefenseSecretsUpSell, combatDefenseSecretsDownSell);
        List<Object> items;
        items = Arrays.asList(new Object[] {
                "DAD: ID="+propertyManager.getProperty("DAD", "DAD")+" $"+amounts.get("DAD"),
                "BOSS: ID="+propertyManager.getProperty("boss", "DAD")+" $"+amounts.get("boss"),
                "Velocity UpSell: ID="+propertyManager.getProperty("velocityUpSell", "DAD")+" $"+amounts.get("velocityUpSell"),
                "Velocity DownSell: ID="+propertyManager.getProperty("velocityDownSell", "DAD")+" $"+amounts.get("velocityDownSell"),
                "Combat Defense Secrets UpSell: ID="+propertyManager.getProperty("combatDefenseSecretsUpSell", "DAD")+" $"+amounts.get("combatDefenseSecretsUpSell"),
                "Combat Defense Secrets DownSell: ID="+propertyManager.getProperty("combatDefenseSecretsDownSell", "DAD")+" $"+amounts.get("combatDefenseSecretsDownSell"),
                "Total: $"+amounts.get("total")
        });

        return items;
    }
}
