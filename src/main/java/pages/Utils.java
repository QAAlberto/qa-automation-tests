package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    public PropertyManager propertyManager = new PropertyManager();

    String[] ESProductID = {"832", "825", "836", "837", "838"};

    public double round(double number){
        return Math.round(number*100.00)/100.00;
    }

    public double truncate(double number){
        DecimalFormatSymbols symbol = new DecimalFormatSymbols();
        symbol.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.#", symbol);
        df.setRoundingMode(RoundingMode.DOWN);
        String s = df.format(number);
        return Double.parseDouble(s);
    }

    public void switchTab(WebDriver driver){
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }
    }

    public String customReportName(String[] list){
        List<String> title = new ArrayList<String>(Arrays.asList(list));
        title.removeAll(Arrays.asList(""));
        return String.join(", ", title);
    }

    public String getTimeStamp(){
        return new SimpleDateFormat("YYMMddHHmmss").format(new Date());
    }

    public String doubleToString(double number){
        return String.format(Locale.US, "%,.2f", number);
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath){
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserLogs(WebDriver driver){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        String logs = "";
        for (LogEntry entry : logEntries) {
            logs += new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage();
        }
        return logs;
    }
}
