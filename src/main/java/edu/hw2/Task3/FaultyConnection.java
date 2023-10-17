package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final float FAULT_CHANCE = 0.5f;

    @Override
    public void execute(String command) {
        var rand = new Random();
        if (rand.nextFloat() < FAULT_CHANCE) {
            throw new ConnectionException("Не удалось отправить пакет через плохое соединение", null);
        }
    }

    @Override
    public void close() throws Exception {
    }
}
