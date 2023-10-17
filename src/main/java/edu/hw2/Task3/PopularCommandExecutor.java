package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        this.tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        var con = manager.getConnection();
        Exception lastException = null;
        for (int i = 0; i < maxAttempts; ++i) {
            try {
                con.execute(command);
                con.close();
                return;
            } catch (Exception e) {
                lastException = e;
            }
        }
        try {
            con.close();
        } catch (Exception ignored) {
        }
        throw new ConnectionException("Выполнено максимальное число попыток", lastException);
    }
}
