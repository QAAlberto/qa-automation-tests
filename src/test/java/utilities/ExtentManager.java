package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance("");
        return extent;
    }

    public static ExtentReports createInstance(String type) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/"+type+"/Report-"+type+"-"+timeStamp+".html");
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
