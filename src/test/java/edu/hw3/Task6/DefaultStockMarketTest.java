package edu.hw3.Task6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class DefaultStockMarketTest {
    DefaultStockMarket market;
    private static final Comparator<Stock> stockCompare = Comparator.comparing(Stock::getId).thenComparing(Stock::getPrice);
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
            .usingComparator(stockCompare)
            .isEqualTo(new Stock(2, 200));
    }

    @DisplayName("Нет акций")
    @Test
    void noStocks() {
        Assertions
            .assertThat(market.mostValuableStock()).isNull();
    }

    @DisplayName("Удаление")
    @Test
    void removeStock() {
        var removed = new Stock(1, 200);
        market.add(removed);
        market.add(new Stock(2, 100));

        market.remove(removed);

        Assertions
            .assertThat(market.mostValuableStock())
            .usingComparator(stockCompare)
            .isEqualTo(new Stock(2, 100));
    }
}
