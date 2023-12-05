package org.example.task;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataProvider {
    public static Stream<Arguments> providerInsertText() {
        return Stream.of(
                Arguments.of("Ноутбуки и планшеты", "Ноутбуки")
        );
    }
    public static Stream<Arguments> providerInsertValue() {
        List<String> money = new ArrayList<>();
        money.add("10000");
        money.add("30000");
        return Stream.of(
                Arguments.of("Ноутбуки и планшеты", "Ноутбуки",money, "Цена, ₽")
        );
    }
    public static Stream<Arguments> providerInsertManufacturers() {
        List<String> money = new ArrayList<>();
        money.add("10000");
        money.add("30000");
        List<String> manu = new ArrayList<>();
        manu.add("HP");
        manu.add("Lenovo");
        return Stream.of(
                Arguments.of("Ноутбуки и планшеты", "Ноутбуки",money, "Цена, ₽", "Производитель", manu)
        );
    }

    public static Stream<Arguments> provideCheckingMoneyList() {
        List<String> money = new ArrayList<>();
        money.add("USD");
        money.add("EUR");
        return Stream.of(
                Arguments.of("Oткрытие", "Банк Открытие: кредит наличными, ипотека, кредитные и ...", money)
        );
    }
}

