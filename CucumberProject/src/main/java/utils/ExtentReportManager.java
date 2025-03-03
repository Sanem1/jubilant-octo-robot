/*package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
	private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/target/ExtentReport_" + timeStamp + ".html";
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentTest startTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void flushReport() {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return test;
    }
}
*/