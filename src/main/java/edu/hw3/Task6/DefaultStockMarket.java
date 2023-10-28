package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DefaultStockMarket implements StockMarket {
    private final PriorityQueue<Stock> stocks;

    DefaultStockMarket() {
        this.stocks = new PriorityQueue<>(
            Comparator.comparing(Stock::getPrice).reversed()
        );
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        if (stocks.isEmpty()) {
            return null;
        }

        return stocks.peek();
    }
}
