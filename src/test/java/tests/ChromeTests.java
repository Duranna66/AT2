package tests;

import base.BaseTests;
import io.qameta.allure.Feature;
import org.example.task.ChromePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ChromeTests extends BaseTests {
    private String refOnYanMarket = "https://market.yandex.ru/";
    private String contentOfSelect = "//span[text()='Ноутбуки и компьютеры']";
    private String check = "/html/body/div[5]/div/div/div/div/div/div/div[1]/div/ul/li[6]/a";
    @Feature("Проверка открытия блока")
    @Test
    public void openChrome() {
        ChromePage chromePage = new ChromePage(chromeDriver);
        chromePage.clickOnSelector();
    }
    @Test
    public void cursorOnSelect() {
        chromeDriver.get(refOnYanMarket);
        ChromePage chromePage = new ChromePage(chromeDriver);
        chromePage.clickOnSelector().cursorOnSel();
    }
}
