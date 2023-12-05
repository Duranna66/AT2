package base;

import org.example.basePage.BasePage;
import org.example.task.ChromePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * @author ivannikolaev
 */
public class BaseTest {
    /**
     * create object of webDriver
     */

    protected WebDriver webDriver;
    protected BasePage basePage;
    protected ChromePage chromePage;

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeOptions desiredCapabilities = new ChromeOptions();
        desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        webDriver=new ChromeDriver(desiredCapabilities);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromePage = new ChromePage(webDriver);
        basePage = new BasePage(webDriver);
    }

        @AfterEach
        public void after() {
            webDriver.close();
            webDriver.quit();
        }
}
