package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final float FAULTY_CONNECTION_CHANCE = 0.5f;
    private final float faultyChance;

    DefaultConnectionManager(float faultyChance) {
        this.faultyChance = faultyChance;
    }

    DefaultConnectionManager() {
        this(FAULTY_CONNECTION_CHANCE);
    }

    @Override
    public Connection getConnection() {
        var rand = new Random();
        if (rand.nextFloat() < faultyChance) {
            return new FaultyConnection();
        }

        return new StableConnection();
    }
}
