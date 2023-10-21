package edu.hw2.Task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectionManagerTest {
    @DisplayName("ConnectionManager - Дает FaultyConnection")
    @Test
    void connectionManagerGivesFaultyConnection() {
        Assertions
            .assertThat((new DefaultConnectionManager(1.0f)).getConnection())
            .isInstanceOf(FaultyConnection.class);
    }
}
