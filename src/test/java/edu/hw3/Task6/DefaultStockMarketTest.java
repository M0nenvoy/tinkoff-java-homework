package edu.hw3.Task6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class DefaultStockMarketTest {
    DefaultStockMarket market;
    @BeforeEach
    void prepareMarket() {
        market = new DefaultStockMarket();
    }

    @DisplayName("Получение самой дорогой акции")
    @Test
    void getMostValuableStock() {
        market.add(new Stock(1, 100));
        market.add(new Stock(2, 200));
        market.add(new Stock(3, 50));

        Assertions
            .assertThat(market.mostValuableStock())
            .usingComparator(Comparator.comparing(Stock::getId).thenComparing(Stock::getPrice))
            .isEqualTo(new Stock(2, 200));
    }

    @DisplayName("Нет акций")
    @Test
    void noStocks() {
        Assertions
            .assertThat(market.mostValuableStock()).isNull();
    }
}
