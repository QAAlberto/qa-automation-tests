package pages.EE.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfirmPage extends BasePage {
    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    double exodusEffect = 67;
    double spanishExodusEffect = 67;
    double spanishPrayerPower = 9.95;
    double prayerPower = 0;
    double highwayHealing = 69;
    double highwayHealingTwo = 35;
    double highwayHealingNewPath = 35;
    double biblicalFatBurning = 39.95;
    double biblicalFatBurningNewPath = 20;
    double theMemoryCovenant = 29;
    double theMemoryCovenantTwo = 15;
    double theMemoryCovenantNewPath = 15;
    double monthlyFee = 9.95;
    double oneTimeFee = 49.95;
    double tax = 1;

    double shipping = 7;
    double trinityOilUpSell = 234;
    double trinityOilDownSell = 117;
    double trinityOilDownSell2 = 49;

    By grandTotalField = By.id("orderTotal");
    By password = By.id("userPassword");
    By highwayHealingBook = By.xpath("//td[contains(text(),'HighWay Healing')]");
    By highwayHealingEbook = By.xpath("//td[contains(text(),'HighWay Healing - EBook')]");
    By submitButton = By.xpath("//a[@id='submitButton']");

    public String getPassword() {
        return readText(password);
    }

    public void membersPage() {
        clickJS(submitButton);
    }

    public HashMap<String, String> getAmount(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell) {
        double amount;
        double exodusEffectRounded;
        double prayerPowerRounded;
        double theMemoryCovenantRounded;
        double theMemoryCovenantTwoRounded;
        double highwayHealingRounded;
        double highwayHealingTwoRounded;
        switch (country) {
            case "United States":
                exodusEffectRounded = round(this.exodusEffect * tax);
                prayerPowerRounded = round(this.prayerPower * tax * prayerPower);
                theMemoryCovenantTwoRounded = round(this.theMemoryCovenantTwo * tax * fourthUpsell);
                theMemoryCovenantRounded = round(this.theMemoryCovenant * tax * thirdUpsell);
                highwayHealingTwoRounded = round(this.highwayHealingTwo * tax * secondUpsell);
                highwayHealingRounded = round(this.highwayHealing * tax * firstUpsell);
                amount = exodusEffectRounded + prayerPowerRounded + theMemoryCovenantTwoRounded + theMemoryCovenantRounded + highwayHealingTwoRounded + highwayHealingRounded;
                break;
            default:
                exodusEffectRounded = this.exodusEffect;
                prayerPowerRounded = this.prayerPower * prayerPower;
                theMemoryCovenantTwoRounded = this.theMemoryCovenantTwo * fourthUpsell;
                theMemoryCovenantRounded = this.theMemoryCovenant * thirdUpsell;
                highwayHealingTwoRounded = this.highwayHealingTwo * secondUpsell;
                highwayHealingRounded = this.highwayHealing * firstUpsell;
                amount = round(exodusEffectRounded + prayerPowerRounded + theMemoryCovenantTwoRounded + theMemoryCovenantRounded + highwayHealingTwoRounded + highwayHealingRounded);
                break;
        }
        return new HashMap<>() {{
            put("total", doubleToString(amount));
            put("exodus", doubleToString(exodusEffectRounded));
            put("prayerPowerUpgrade", doubleToString(prayerPowerRounded));
            put("theMemoryCovenantTwo", doubleToString(theMemoryCovenantTwoRounded));
            put("theMemoryCovenant", doubleToString(theMemoryCovenantRounded));
            put("highwayHealingTwo", doubleToString(highwayHealingTwoRounded));
            put("highwayHealing", doubleToString(highwayHealingRounded));
            put("country", country);
        }};
    }

    public HashMap<String, String> getAmountExodusSecret(int prayer, int trinityOilUpSell, int trinityOilDownSell, int trinityOilDownSell2, int highWayHealingUpSell, int highWayHealingDownSell) {
        double amount;
        double shippingRounded = this.shipping;
        double trinityOilUpSellRounded;
        double trinityOilDownSellRounded;
        double trinityOilDownSell2Rounded;
        double highWayHealingUpSellRounded;
        double highWayHealingDownSellRounded;

        trinityOilUpSellRounded = round(this.trinityOilUpSell * trinityOilUpSell);
        trinityOilDownSellRounded = round(this.trinityOilDownSell * trinityOilDownSell);
        trinityOilDownSell2Rounded = round(this.trinityOilDownSell2 * trinityOilDownSell2);
        highWayHealingUpSellRounded = round(this.highwayHealing * highWayHealingUpSell);
        highWayHealingDownSellRounded = round(this.highwayHealingTwo * highWayHealingDownSell);

        amount = shippingRounded + trinityOilUpSellRounded + trinityOilDownSellRounded + trinityOilDownSell2Rounded + highWayHealingUpSellRounded + highWayHealingDownSellRounded;

        return new HashMap<>() {{
            put("total", doubleToString(amount));
            put("exodus", "0");
            put("prayerPowerUpgrade", "0");
            put("trinityOilUpSell", doubleToString(trinityOilUpSellRounded));
            put("trinityOilDownSell", doubleToString(trinityOilDownSellRounded));
            put("trinityOilDownSell2", doubleToString(trinityOilDownSell2Rounded));
            put("highWayHealingUpSell", doubleToString(highWayHealingUpSellRounded));
            put("highWayHealingDownSell", doubleToString(highWayHealingDownSellRounded));
            put("shipping", doubleToString(shippingRounded));
        }};
    }

    public HashMap<String, String> getSpanishAmount(String country, int prayerPower, int thirdUpsell, int secondUpsell, int firstUpsell) {
        double amount;
        double exodusEffectRounded;
        double prayerPowerRounded;
        double theMemoryCovenantRounded;
        double biblicalFatBurningRounded;
        double highwayHealingRounded;

        exodusEffectRounded = this.spanishExodusEffect;
        prayerPowerRounded = this.spanishPrayerPower * prayerPower;
        theMemoryCovenantRounded = this.theMemoryCovenant * thirdUpsell;
        biblicalFatBurningRounded = this.biblicalFatBurning * secondUpsell;
        highwayHealingRounded = this.highwayHealing * firstUpsell;
        amount = round(exodusEffectRounded + prayerPowerRounded + biblicalFatBurningRounded + theMemoryCovenantRounded + highwayHealingRounded);

        return new HashMap<>() {{
            put("total", doubleToString(amount));
            put("exodus", doubleToString(exodusEffectRounded));
            put("prayerPowerUpgrade", doubleToString(prayerPowerRounded));
            put("biblicalFatBurning", doubleToString(biblicalFatBurningRounded));
            put("theMemoryCovenant", doubleToString(theMemoryCovenantRounded));
            put("highwayHealing", doubleToString(highwayHealingRounded));
            put("country", country);
        }};
    }

    public HashMap<String, String> getAmountSpiritOfHealing(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell) {
        double amount;
        double exodusEffectRounded;
        double prayerPowerRounded;
        double theMemoryCovenantRounded;
        double theMemoryCovenantTwoRounded;
        double highwayHealingRounded;
        double highwayHealingTwoRounded;

        exodusEffectRounded = this.exodusEffect - 22;
        prayerPowerRounded = this.prayerPower * prayerPower;
        theMemoryCovenantTwoRounded = this.theMemoryCovenantTwo * fourthUpsell;
        theMemoryCovenantRounded = this.theMemoryCovenant * thirdUpsell;
        highwayHealingTwoRounded = this.highwayHealingTwo * secondUpsell;
        highwayHealingRounded = this.highwayHealing * firstUpsell;
        amount = round(exodusEffectRounded + prayerPowerRounded + theMemoryCovenantTwoRounded + theMemoryCovenantRounded + highwayHealingTwoRounded + highwayHealingRounded);

        return new HashMap<>() {{
            put("total", doubleToString(amount));
            put("exodus", doubleToString(exodusEffectRounded));
            put("prayerPowerUpgrade", doubleToString(prayerPowerRounded));
            put("theMemoryCovenantTwo", doubleToString(theMemoryCovenantTwoRounded));
            put("theMemoryCovenant", doubleToString(theMemoryCovenantRounded));
            put("highwayHealingTwo", doubleToString(highwayHealingTwoRounded));
            put("highwayHealing", doubleToString(highwayHealingRounded));
            put("country", country);
        }};
    }

//    public HashMap<String, String> getAmountNewPath(String country, int lifeTimeUpgrade, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
//        double amount;
//        double lifeTimeUpgradeRounded;
//        double theMemoryCovenantTwoRounded;
//        double theMemoryCovenantRounded;
//        double highwayHealingTwoRounded;
//        double highwayHealingRounded;
//        switch (country){
//            case "United States":
//                lifeTimeUpgradeRounded = round((lifeTimeUpgrade == 1 ? this.oneTimeFee : this.monthlyFee)*tax);
//                theMemoryCovenantRounded = round(this.theMemoryCovenantNewPath*tax*thirdUpsell);
//                highwayHealingTwoRounded = round(this.highwayHealingNewPath*tax*firstUpsell);
//                highwayHealingRounded = round(this.highwayHealingNewPath*tax*firstUpsell);
//                amount = lifeTimeUpgradeRounded+theMemoryCovenantRounded+biblicalFatBurningRounded+highwayHealingRounded;
//                break;
//            default:
//                lifeTimeUpgradeRounded = lifeTimeUpgrade == 1 ? this.oneTimeFee : this.monthlyFee;
//                theMemoryCovenantRounded = this.theMemoryCovenantNewPath*thirdUpsell;
//                biblicalFatBurningRounded = this.biblicalFatBurningNewPath*secondUpsell;
//                highwayHealingRounded = this.highwayHealingNewPath*firstUpsell;
//                amount = round(lifeTimeUpgradeRounded+theMemoryCovenantRounded+biblicalFatBurningRounded+highwayHealingRounded);
//                break;
//        }
//
//        return new HashMap <>() {{
//            put("total", doubleToString(amount));
//            put("lifeTimeUpgrade", doubleToString(lifeTimeUpgradeRounded));
//            put("theMemoryCovenant", doubleToString(theMemoryCovenantRounded));
//            put("biblicalFatBurning", doubleToString(biblicalFatBurningRounded));
//            put("highwayHealing", doubleToString(highwayHealingRounded));
//            put("country", country);
//        }};
//    }

    public void verifyHighwayHealingBook(String country, int firstUpsell) {
        if (firstUpsell == 1) {
            if (country == "United States") {
                assertEquals(highwayHealingBook, "HighWay Healing");
            } else {
                assertEquals(highwayHealingEbook, "HighWay Healing - EBook");
            }
        }
    }

    public void verifyGrandTotal(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell) {
        assertEquals(grandTotalField, "$" + getAmount(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell).get("total"));
    }

    public String getGrandTotal(){
        return readText(grandTotalField);
    }

    public void verifyGrandTotalExodusSecret(int prayer, int trinityOilUpSell, int trinityOilDownSell, int trinityOilDownSell2, int highWayHealingUpSell, int highWayHealingDownSell){
        assertEquals(grandTotalField, "$" + getAmountExodusSecret(prayer, trinityOilUpSell, trinityOilDownSell, trinityOilDownSell2, highWayHealingUpSell, highWayHealingDownSell).get("total"));
    }

    public void verifySpanishGrandTotal(String country, int prayerPower, int thirdUpsell, int secondUpsell, int firstUpsell){
        assertEquals(grandTotalField, "$" + getSpanishAmount(country, prayerPower, thirdUpsell, secondUpsell,firstUpsell).get("total"));
    }

    public String getSpanishGrandTotal(){
        return readText(grandTotalField);
    }

    public void verifyGrandTotalSpiritOfHealing(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        assertEquals(grandTotalField, "$" + getAmountSpiritOfHealing(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell,firstUpsell).get("total"));
    }

//    public void verifyGrandTotalNewPath(String country, int lifeTimeUpgrade, int thirdUpsell, int secondUpsell, int firstUpsell){
//        assertEquals(grandTotalField, "$" + getAmountNewPath(country, lifeTimeUpgrade, thirdUpsell, secondUpsell,firstUpsell).get("total"));
//    }

    public List getList(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        HashMap<String, String> amounts = this.getAmount(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell);
        List<Object> items;
        switch (country){
            case "United States":
                items = Arrays.asList(new Object[] {
                        "Country : "+ amounts.get("country"),
                        "Exodus Effect: ID="+propertyManager.getProperty("physicalBookEN", "EE")+","+propertyManager.getProperty("eBookEN", "EE")+" $"+amounts.get("exodus"),
                        "Prayer Power Upgrade: ID="+propertyManager.getProperty("prayerPowerUpgradeEN", "EE")+" $"+amounts.get("prayerPowerUpgrade"),
                        "The Covenant Memory Two: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenantTwo"),
                        "The Covenant Memory: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenant"),
                        "Highway Healing Two: ID="+propertyManager.getProperty("highwayHealingEN", "EE")+" $"+amounts.get("highwayHealingTwo"),
                        "Highway Healing: ID="+propertyManager.getProperty("highwayHealingEN", "EE")+" $"+amounts.get("highwayHealing"),
                        "Total: $"+amounts.get("total")
                });
                break;
                default:
                    items = Arrays.asList(new Object[] {
                            "Country : "+ amounts.get("country"),
                            "Exodus Effect: ID="+propertyManager.getProperty("eBookInternationalEN", "EE")+" $"+amounts.get("exodus"),
                            "Prayer Power Upgrade: ID="+propertyManager.getProperty("prayerPowerUpgradeEN", "EE")+" $"+amounts.get("prayerPowerUpgrade"),
                            "The Covenant Memory Two: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenantTwo"),
                            "The Covenant Memory: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenant"),
                            "Highway Healing Two: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealingTwo"),
                            "Highway Healing: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealing"),
                            "Total: $"+amounts.get("total")
                    });
        }
        return items;
    }

    public List getSpanishList(String country, int prayerPower, int thirdUpsell, int secondUpsell, int firstUpsell){
        HashMap<String, String> amounts = this.getSpanishAmount(country, prayerPower, thirdUpsell, secondUpsell, firstUpsell);
        List<Object> items;

        items = Arrays.asList(new Object[] {
                "Country : "+ amounts.get("country"),
                "Exodus Effect: ID="+propertyManager.getProperty("eBookES", "EE")+" $"+amounts.get("exodus"),
                "Prayer Power Upgrade: ID="+propertyManager.getProperty("prayerPowerUpgradeES", "EE")+" $"+amounts.get("prayerPowerUpgrade"),
                "The Covenant Memory: ID="+propertyManager.getProperty("theCovenantMemoryES", "EE")+" $"+amounts.get("theMemoryCovenant"),
                "Biblical Fat Burning: ID="+propertyManager.getProperty("biblicalFatBurningES", "EE")+" $"+amounts.get("biblicalFatBurning"),
                "Highway Healing: ID="+propertyManager.getProperty("highwayHealingES", "EE")+" $"+amounts.get("highwayHealing"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }

    public List getListSpiritOfHealing(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
        HashMap<String, String> amounts = this.getAmountSpiritOfHealing(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell);
        List<Object> items;

        items = Arrays.asList(new Object[] {
                "Country : "+ amounts.get("country"),
                "Exodus Effect: ID="+propertyManager.getProperty("eBookInternationalEN", "EE")+" $"+amounts.get("exodus"),
                "Prayer Power Upgrade: ID="+propertyManager.getProperty("prayerPowerUpgradeEN", "EE")+" $"+amounts.get("prayerPowerUpgrade"),
                "The Covenant Memory Two: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenantTwo"),
                "The Covenant Memory: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenant"),
                "Highway Healing Two: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealingTwo"),
                "Highway Healing: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealing"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }

    public List getListExodusSecret(int prayer, int trinityOilUpSell, int trinityOilDownSell, int trinityOilDownSell2, int highWayHealingUpSell, int highWayHealingDownSell){
        HashMap<String, String> amounts = this.getAmountExodusSecret(prayer, trinityOilUpSell, trinityOilDownSell, trinityOilDownSell2, highWayHealingUpSell, highWayHealingDownSell);
        List<Object> items;

        items = Arrays.asList(new Object[] {
                "Exodus Effect: ID="+propertyManager.getProperty("eBookInternationalEN", "EE")+" $0",
                "Prayer Power Upgrade: ID="+propertyManager.getProperty("prayerPowerUpgradeEN", "EE")+" $0",
                "trinityOilUpSell: ID="+propertyManager.getProperty("trinityOilUpSell", "EE")+" $"+amounts.get("trinityOilUpSell"),
                "trinityOilDownSell: ID="+propertyManager.getProperty("trinityOilDownSell", "EE")+" $"+amounts.get("trinityOilDownSell"),
                "trinityOilDownSell2: ID="+propertyManager.getProperty("trinityOilDownSell2", "EE")+" $"+amounts.get("trinityOilDownSell2"),
                "highWayHealingUpSell: ID="+propertyManager.getProperty("highWayHealingUpSell", "EE")+" $"+amounts.get("highWayHealingUpSell"),
                "highWayHealingDownSell: ID="+propertyManager.getProperty("highWayHealingDownSell", "EE")+" $"+amounts.get("highWayHealingDownSell"),
                "Total: $"+amounts.get("total")
        });
        return items;
    }

//    public List getListNewPath(String country, int prayerPower, int fourthUpsell, int thirdUpsell, int secondUpsell, int firstUpsell){
//        HashMap<String, String> amounts = this.getAmountNewPath(country, prayerPower, fourthUpsell, thirdUpsell, secondUpsell, firstUpsell);
//        List<Object> items = Arrays.asList(new Object[] {
//                "Country : $"+amounts.get("country"),
//                "Monthly Fee(ID="+propertyManager.getProperty("prayerWarriorLifetime", "EE")+")/One Time Fee(ID="+propertyManager.getProperty("prayerPowerUpgradeEN", "EE")+"): $"+amounts.get("lifeTimeUpgrade"),
//                "The Covenant Memory Two: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenantTwo"),
//                "The Covenant Memory: ID="+propertyManager.getProperty("theCovenantMemoryEN", "EE")+" $"+amounts.get("theMemoryCovenant"),
//                "Highway Healing Two: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealingTwo"),
//                "Highway Healing: ID="+propertyManager.getProperty("highwayHealingInternationalEN", "EE")+" $"+amounts.get("highwayHealing"),
//                "Total: $"+amounts.get("total")
//        });
//        return items;
//    }
}
