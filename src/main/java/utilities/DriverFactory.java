package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            // Initialize the WebDriver instance
            String browser = ConfigReader.get("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    // Set ChromeOptions to disable SSL verification
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--disable-popup-blocking");
                    
                    driver.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Apply global implicit wait
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitWait()));
        }
        return driver.get();
    }

    private static long getImplicitWait() {
        String waitTime = ConfigReader.get("implicit.wait");
        return waitTime != null ? Long.parseLong(waitTime) : 10; // Default to 10 seconds
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
