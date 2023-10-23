package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final static Logger LOGGER = LogManager.getLogger();
    private final int maxAttempts;

    PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        this.tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Exception lastException = null;
        try (var con = manager.getConnection()) {
            for (int i = 0; i < maxAttempts; ++i) {
                try {
                    con.execute(command);
                    con.close();
                    return;
                } catch (Exception e) {
                    lastException = e;
                }
            }
        } catch (Exception e) {
            LOGGER.info("Ошибка при использовании подключения: {}", e.getMessage());
        }

        throw new ConnectionException("Выполнено максимальное число попыток", lastException);
    }
}
