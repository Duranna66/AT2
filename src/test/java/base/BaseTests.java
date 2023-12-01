package base;
import org.example.task.ChromePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver chromeDriver;

    @BeforeEach
    public void before(){
//        System.setProperty("webdriver.chrome.driver","/Users/ivannikolaev/Downloads/chromedriver-mac-arm64/chromedriver");
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        chromeDriver=new ChromeDriver(desiredCapabilities);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

//    @AfterEach
//    public void after(){
//        chromeDriver.quit();
//    }
}
