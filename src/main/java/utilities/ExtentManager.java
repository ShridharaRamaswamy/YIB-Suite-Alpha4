package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports createInstance(String filePath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Extent Report");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        return extentReports;
    }

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports instance has not been created. Call createInstance() first.");
        }
        return extentReports;
    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
