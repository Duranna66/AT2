package org.example.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.task.Constant.contentOfSelect;

public class ChromePage {
    private final String block = "//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']";
    protected WebDriver driver;
    private String check = "/html/body/span[2]";
    private String click = "/html/body/div[5]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[1]/div/a";
    public ChromePage(WebDriver chromeDriver) {
        this.driver = chromeDriver;
    }

    public ChromePage clickOnSelector() {//"/html/body/div[5]/div/div/div/div/div/div/div[1]/div/ul/li[6]/a
        driver.get("https://market.yandex.ru/");
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']")));
        WebElement element = driver.findElement(By.xpath("//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']"));
        element.click();
//        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[1]/div/ul/li[6]/a")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element1).perform();
//        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[1]/div/a")));
//        element2.click();
//        WebElement webElement = driver.findElement(By.xpath(check));
//        System.out.println(webElement.getText());
        return this;
    }
    public ChromePage cursorOnSel() {
        WebElement sel = driver.findElement(By.xpath(contentOfSelect));
        System.out.println(sel);
        return this;
    }
}
