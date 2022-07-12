package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crossbrowsertesting.AutomatedTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utilities.ExtentManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public String lang;
    public String baseUrl;
    public RemoteWebDriver driver;
    public static ExtentReports extent;
    public AutomatedTest automatedTest;
    public static ThreadLocal<ExtentTest> test;
    public static ThreadLocal<ExtentTest> nodeThread;
    public static ThreadLocal<String> deviceId;

    public RemoteWebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    @Parameters({"type", "driverType"})
    public void beforeSuite(String type, String driverType) throws MalformedURLException{
        extent = ExtentManager.createInstance(type);
        test = new ThreadLocal<>();
        nodeThread = new ThreadLocal<>();
        deviceId = new ThreadLocal<>();

        switch (driverType){
            case "local":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "downloads");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                break;
            case "crossbrowsertesting":
                String username = "tech%40truebornpublishing.com";
                String authkey = "u4933d1688740210";
                DesiredCapabilities caps = new DesiredCapabilities();
//                caps.setCapability("browserName", "Chrome");
//                caps.setCapability("version", "102");
//                caps.setCapability("platform", "Windows 10");
//                caps.setCapability("screenResolution", "1920x1080");
                caps.setCapability("browserName", "Chrome");
                caps.setCapability("deviceName", "Pixel 5");
                caps.setCapability("platformVersion", "11.0");
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceOrientation", "portrait");
                caps.setCapability("name", type);

                driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
                automatedTest = new AutomatedTest(driver.getSessionId().toString());
        }
    }

    @BeforeClass
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
