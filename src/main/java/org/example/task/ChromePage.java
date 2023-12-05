package org.example.task;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.util.*;


public class ChromePage extends org.example.basePage.BasePage {
    private List<String> uncorr = new ArrayList<>();
    private boolean isCorrect;
    private final String block = "//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']";
    protected WebDriver driver;
    private String check = "/html/body/span[2]";
    private String click = "/html/body/div[5]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[1]/div/a";
    private int countOfEl;

    public ChromePage(WebDriver chromeDriver) {
        super(chromeDriver);
        this.driver = chromeDriver;
    }

    public int getCountOfEl() {
        return countOfEl;
    }

    public List<String> getUncorr() {
        return uncorr;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public ChromePage clickOnSelector() {
        openPage(Constant.refOnYanMarket);
        try {
            Thread.sleep(5000);
        }
        catch (Exception e) {

        }
        WebElement search = webDriver.findElement(By.xpath("//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']"));
        try {
            Thread.sleep(5000);
        }
        catch (Exception e) {

        }
        search.click();
        return this;
    }

    public ChromePage cursorOnSel() {
        List<WebElement> wait = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a/span[@class='_3krX4']")));
        for (WebElement element : wait) {
            if (element.getText().equals("Ноутбуки и компьютеры")) {
                Actions actions = new Actions(webDriver);
                actions.moveToElement(element).perform();
                break;
            }
        }
        return this;
    }

    public ChromePage clickOnComp(String title, String subTitle) {
        List<WebElement> webElements = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='zkcAX']/div/div")));
        for (WebElement w : webElements) {
            WebElement currTitle = w.findElement(By.xpath(".//div/div/a"));
            if (currTitle.getText().equals(title)) {
                List<WebElement> currSubtitles = w.findElements(By.xpath(".//ul[@class='_72Lfy']/li"));
                currSubtitles.get(currSubtitles.size() - 1).click();
                for (WebElement c : currSubtitles) {
                    if (c.getText().equals(subTitle)) {
                        c.click();
                        return this;
                    }
                }
            }
        }
        return this;
    }

    public ChromePage setFilterRange(String value1, String value2, String sel) {

        List<WebElement> inputs =  new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@data-auto='filter-range-glprice']/div/div/span/div/div/input")));
        WebElement from = inputs.get(0);
        WebElement to = inputs.get(1);
        from.click();
        from.sendKeys(value1);
        to.click();
        to.sendKeys(value2);
        return this;
    }

    public ChromePage chooseManufacturers(String manu, List<String> list) {
        List<WebElement> filters = new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@data-grabber=\"SearchFilters\"]/div/div/fieldset/legend")));
        for (WebElement f : filters) {
            if(f.getText().equals(manu)) {
                WebElement more = webDriver.findElement(By.xpath(".//../div/div/div[@data-zone-name=\"LoadFilterValues\"]/button/span"));
                more.click();
                List<WebElement> els = f.findElements(By.xpath(".//../div/div/div/div/div/div"));
                for(WebElement e : els) {
                    if(list.stream().anyMatch(x -> x.equals(e.getText()))) {
                        e.click();
                    }
                }
            }
        }

        return this;
    }
    public ChromePage checkCountOfEl() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> elements =  new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@data-zone-name=\"title\"]")));
        elements.forEach(x -> System.out.println(x.getText()));
        this.countOfEl = elements.size();
        return this;
    }
    public ChromePage checkCountOfElOnAllPages() {
        JavascriptExecutor jsExecutor;
        WebElement forward;
        List<WebElement> elements =  webDriver.findElements(By.xpath("//h3[@data-zone-name=\"title\"]"));
        while(true) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elements =  webDriver.findElements(By.xpath("//h3[@data-zone-name=\"title\"]"));
            elements.stream().allMatch(x ->  {
                if(x.getText().toLowerCase().contains("hp") || x.getText().toLowerCase().contains("lenovo")) {
                    return true;
                }
                uncorr.add(x.getText());
                return false;
            });

            try {
                forward = webDriver.findElement(By.xpath("//span[@class=\"_3e9Bd\"]"));
                forward.click();
            }
            catch (Exception e){
                break;
            }
        }
        return this;
    }
    public ChromePage checkFirstPage() {
        List<WebElement> elements =  webDriver.findElements(By.xpath("//h3[@data-zone-name=\"title\"]"));
       String  value = elements.get(0).getText();
        WebElement search = webDriver.findElement(By.xpath("//div[@data-zone-name=\"search-input\"]/input"));
        search.click();
        search.sendKeys(value);
        search.submit();
        elements =  new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@data-zone-name=\"title\"]")));
        isCorrect = elements.stream().anyMatch(x -> x.getText().equals(value));
        return this;

    }
}
