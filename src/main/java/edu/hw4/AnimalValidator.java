package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnimalValidator {
    private final static int TOO_LONG_NAME_LENGTH = 16;
    private final static String FIELD_NAME = "name";

    private AnimalValidator() {

    }

    /**
     * Задание 19. Животные, в записях о которых есть ошибки:
     * вернуть имя и список ошибок
     */
    public static Map<String, Set<ValidationError>> getErrors(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Невозможно проверить на ошибки null список");
        }

        var errorsByName = new HashMap<String, Set<ValidationError>>();

        for (var animal : animals) {
            var errors = errorsByName.getOrDefault(animal.name(), new HashSet<ValidationError>());

            validateNameNotNull(errors, animal);
            validateNameNotEmpty(errors, animal);
            validateNameLength(errors, animal);
            validateNameNotContainingDigits(errors, animal);
            validateNameStartingWithUppercase(errors, animal);

            if (!errors.isEmpty()) {
                errorsByName.put(animal.name(), errors);
            }
        }

        return errorsByName;
    }

    /**
     * Задание 20. Сделать результат предыдущего задания более читабельным:
     * вернуть имя и названия полей с ошибками, объединенные в строку
     */
    public static Map<String, String> getPrettyErrors(Map<String, Set<ValidationError>> errorsByName) {
        var fieldErrorByName = new HashMap<String, String>();
        for (var name : errorsByName.keySet()) {
            Set<ValidationError> errors = errorsByName.get(name);
            var fieldsJoin = errors
                .stream()
                .map(ValidationError::getFailedField)
                .collect(Collectors.joining(", "));

            fieldErrorByName.put(name, fieldsJoin);
        }

        return fieldErrorByName;
    }

    private static void validateNameNotNull(Set<ValidationError> errors, Animal animal) {
        if (animal.name() == null) {
            errors.add(new ValidationError("Имя животного не должно быть null", FIELD_NAME, animal));
        }
    }

    private static void validateNameNotEmpty(Set<ValidationError> errors, Animal animal) {
        if (animal.name() != null && animal.name().isEmpty()) {
            errors.add(new ValidationError("Имя животного не должно быть пустым", FIELD_NAME, animal));
        }
    }

    private static void validateNameLength(Set<ValidationError> errors, Animal animal) {
        if (animal.name() == null) {
            return;
        }

        if (animal.name().length() >= TOO_LONG_NAME_LENGTH) {
            errors.add(new ValidationError("Имя животного слишком длинное", FIELD_NAME, animal));
        }

    }

    private static void validateNameNotContainingDigits(Set<ValidationError> errors, Animal animal) {
        if (animal.name() == null) {
            return;
        }

        if (animal.name().chars().anyMatch(Character::isDigit)) {
            errors.add(new ValidationError("Имя животного не может содержать цифр", FIELD_NAME, animal));
        }
    }

    private static void validateNameStartingWithUppercase(Set<ValidationError> errors, Animal animal) {
        if (animal.name() == null || animal.name().isEmpty()) {
            return;
        }

        var first = animal.name()
            .chars()
            .findFirst()
            .orElseThrow();

        if (!Character.isUpperCase(first)) {
            errors.add(new ValidationError("Имя животного должно начинаться с большой буквы", FIELD_NAME, animal));
        }
    }
}
