package org.example.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * @author ivannikolaev
 */
public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void openPage(String url) {
        webDriver.get(url);
    }
    /**
     * create webDriverWait to exclude flaky tests
     */
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
