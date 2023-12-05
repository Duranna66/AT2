package tests;


import base.BaseTest;
import org.example.task.ChromePage;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ChromeTests extends BaseTest {
    private String refOnYanMarket = "https://market.yandex.ru/";
    private String contentOfSelect = "//span[text()='Ноутбуки и компьютеры']/..";
    private String check = "/html/body/div[5]/div/div/div/div/div/div/div[1]/div/ul/li[6]/a";
//    @Feature("Проверка открытия блока")
    @Test
    public void openChrome() {
        webDriver.get(refOnYanMarket);
        chromePage.clickOnSelector();
    }
    @Test
    public void cursorOnSelect() {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel();
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertText")
    public void clickOnComp(String title, String subTitle) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle);
//        Assertions.assertTrue(webDriver.getTitle().contains(subTitle), "currT:" + webDriver.getTitle() + " expeEcted " + title);
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertValue")
    public void setFilterRange(String title, String subTitle, List<String> money, String select) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle).setFilterRange(money.get(0), money.get(1), select);
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertManufacturers")
    public void chooseManufacturers(String title, String subTitle, List<String> money, String select, String manu, List<String> list) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle).setFilterRange(money.get(0), money.get(1), select)
                .chooseManufacturers(manu, list);
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertManufacturers")
    public void checkCountOfEl(String title, String subTitle, List<String> money, String select, String manu, List<String> list) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle).setFilterRange(money.get(0), money.get(1), select)
                .chooseManufacturers(manu, list).checkCountOfEl();
        Assertions.assertTrue(chromePage.getCountOfEl() > 12);
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertManufacturers")
    public void checkCountOfElOnAllPages(String title, String subTitle, List<String> money, String select, String manu, List<String> list) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle).setFilterRange(money.get(0), money.get(1), select)
                .chooseManufacturers(manu, list).checkCountOfElOnAllPages();
        StringBuilder stringBuilder = new StringBuilder();
        chromePage.getUncorr().forEach(stringBuilder::append);
        Assertions.assertTrue(chromePage.getUncorr().size() == 0, "неподходящая(ие) строки: " + stringBuilder.toString());
    }
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("org.example.task.DataProvider#providerInsertManufacturers")
    public void checkFirstPage(String title, String subTitle, List<String> money, String select, String manu, List<String> list) {
        basePage.openPage("https://market.yandex.ru/");
        chromePage.clickOnSelector().cursorOnSel().clickOnComp(title, subTitle).setFilterRange(money.get(0), money.get(1), select)
                .chooseManufacturers(manu, list).checkFirstPage();
        Assertions.assertTrue(chromePage.isCorrect(), "не совпадают");
    }
        @After
    public void end() {
        webDriver.quit();
        webDriver.close();
    }
}
