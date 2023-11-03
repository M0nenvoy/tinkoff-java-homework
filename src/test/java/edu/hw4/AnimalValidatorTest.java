package edu.hw4;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AnimalValidatorTest {
    @DisplayName("Животные, в записях о которых есть ошибки: вернуть имя и список ошибок")
    @Test
    void getErrors() {
        assertThat(AnimalValidator.getErrors(List.of(
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, true),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal("", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal(null, Animal.Type.FISH, Animal.Sex.F, 16, 5, 130, true),
            new Animal("lowercase1", Animal.Type.SPIDER, Animal.Sex.M, 17, 101, 13, true),
            new Animal("Four", Animal.Type.SPIDER, Animal.Sex.M, 30, 0, 12, true)
        ))).hasSize(3)
            .anySatisfy(
                (k, v) -> {
                    assertThat(k).isEqualTo("");
                    assertThat(v)
                        .hasSize(1)
                        .extracting(e -> tuple(e.getMessage(), e.getFailedField()))
                        .contains(tuple("Имя животного не должно быть пустым", "name"));
                })
            .anySatisfy(
                (k, v) -> {
                    assertThat(k).isEqualTo(null);
                    assertThat(v)
                        .hasSize(1)
                        .extracting(e -> tuple(e.getMessage(), e.getFailedField()))
                        .contains(tuple("Имя животного не должно быть null", "name"));
                }
            )
            .anySatisfy(
                (k, v) -> {
                    assertThat(k).isEqualTo("lowercase1");
                    assertThat(v)
                        .hasSize(2)
                        .extracting(e -> tuple(e.getMessage(), e.getFailedField()))
                        .contains(
                            tuple("Имя животного должно начинаться с большой буквы", "name"),
                            tuple("Имя животного не может содержать цифр", "name")
                        );
                }
            );
    }

    @DisplayName("Читабельные сообщения об ошибках")
    @Test
    void getPrettyErrors() {
        assertThat(AnimalValidator.getPrettyErrors(AnimalValidator.getErrors(List.of(
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, true),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal("", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100, false),
            new Animal(null, Animal.Type.FISH, Animal.Sex.F, 16, 5, 130, true),
            new Animal("lowercase1", Animal.Type.SPIDER, Animal.Sex.M, 17, 101, 13, true),
            new Animal("Four", Animal.Type.SPIDER, Animal.Sex.M, 30, 0, 12, true)
        )))).hasSize(3)
            .contains(
                entry("", "name"),
                entry(null, "name"),
                entry("lowercase1", "name, name")
            );
    }
}
