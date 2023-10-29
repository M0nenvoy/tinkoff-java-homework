package edu.hw3.Task5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ContactProcessorTest {
    @DisplayName("parseContacts - Happy path")
    @Test
    void parseContactsHappyPath() {
        Assertions
            .assertThat(ContactProcessor.parseContacts(List.of(
                "Thomas Aquinas",
                "Rene Descartes",
                "David Hume",
                "John Locke"
            ), "ASC"))
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(
                new Contact("Thomas", "Aquinas"),
                new Contact("Rene", "Descartes"),
                new Contact("David", "Hume"),
                new Contact("John", "Locke")
            );
    }

    @DisplayName("parseContacts - Обратная сортировка")
    @Test
    void parseContactsDesc() {
        Assertions
            .assertThat(ContactProcessor.parseContacts(List.of(
                "Thomas Aquinas",
                "Rene Descartes",
                "David Hume",
                "John Locke"
            ), "DESC"))
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(
                new Contact("John", "Locke"),
                new Contact("David", "Hume"),
                new Contact("Rene", "Descartes"),
                new Contact("Thomas", "Aquinas")
            );
    }

    @DisplayName("parseContacts - Только имя")
    @Test
    void parseContactsOnlyName() {
        Assertions
            .assertThat(ContactProcessor.parseContacts(List.of(
                "Stanislav",
                "Ivan",
                "Cole"
            ), "ASC"))
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(
                new Contact("Cole"),
                new Contact("Ivan"),
                new Contact("Stanislav")
            );
    }

    @DisplayName("parseContacts - Передача null")
    @Test
    void parseContactsNull() {
        Assertions
            .assertThat(ContactProcessor.parseContacts(null, "ASC"))
            .containsExactly();
    }

    @DisplayName("parseContacts - Некорректные значения игнорируются")
    @Test
    void parseContactsIncorrectStringsIgnored() {
        Assertions
            .assertThat(ContactProcessor.parseContacts(
                List.of(
                    "",
                    "One Two Three",
                    "One Two Three Four"
                ), "ASC"
            ))
            .containsExactly();
    }

    @DisplayName("parseContacts - Метод сортировки null")
    @Test
    void parseContactsMethodNull() {
        Assertions.assertThatThrownBy(() -> ContactProcessor.parseContacts(List.of(), null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("parseContacts - Некорректный метод сортировки")
    @Test
    void parseContactsIllegalMethod() {
        Assertions.assertThatThrownBy(() -> ContactProcessor.parseContacts(List.of(), "ILLEGAL"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
