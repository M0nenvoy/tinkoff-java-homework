package edu.hw2.Task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FaultyConnectionTest {
    @DisplayName("FaultyConnection - Бросает исключение")
    @Test
    void faultyConnectionThrows() {
        Assertions.assertThatThrownBy(() -> {
            try (var con = new FaultyConnection(1.0f)) {
                con.execute("whoami");
            }
        }).isInstanceOf(ConnectionException.class);
    }
}
