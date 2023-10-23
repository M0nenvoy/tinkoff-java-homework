package edu.hw2.Task4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WhoCalledTest {
    @DisplayName("whoCalled - Имя класса")
    @Test
    void whoCalledClassName() {
        class Dummy {
            public CallingInfo call() {
                return ReflectionUtils.whoCalled();
            }
        }

        var d = new Dummy();
        var info = d.call();
        Assertions
            .assertThat(info.className()).isEqualTo("Dummy");
    }

    @DisplayName("whoCalled - Имя метода")
    @Test
    void whoCalledMethodName() {
        class Dummy {
            public CallingInfo call() {
                return ReflectionUtils.whoCalled();
            }
        }

        var d = new Dummy();
        var info = d.call();

        Assertions
            .assertThat(info.methodName()).isEqualTo("call");
    }
}
