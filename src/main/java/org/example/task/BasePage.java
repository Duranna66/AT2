package org.example.task;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver chromeDriver;

    public BasePage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }
}
