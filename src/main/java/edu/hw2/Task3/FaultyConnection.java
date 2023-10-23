package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final float DEFAULT_FAULT_CHANCE = 0.5f;
    private final float faultyChance;

    FaultyConnection(float faultyChance) {
        this.faultyChance = faultyChance;
    }

    FaultyConnection() {
        this(DEFAULT_FAULT_CHANCE);
    }

    @Override
    public void execute(String command) {
        var rand = new Random();
        if (rand.nextFloat() < faultyChance) {
            throw new ConnectionException("Не удалось отправить пакет через плохое соединение", null);
        }
    }

    @Override
    public void close() throws Exception {
    }
}
