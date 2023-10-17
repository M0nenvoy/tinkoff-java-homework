package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final float FAULTY_CONNECTION_CHANCE = 0.5f;

    @Override
    public Connection getConnection() {
        var rand = new Random();
        if (rand.nextFloat() < FAULTY_CONNECTION_CHANCE) {
            return new FaultyConnection();
        }

        return new StableConnection();
    }
}
