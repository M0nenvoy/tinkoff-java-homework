package edu.hw4;

public class ValidationError extends RuntimeException {
    private final Animal failedAnimal;
    private final String failedField;

    ValidationError(String message, String failedField, Animal failedAnimal) {
        super(message);

        this.failedAnimal = failedAnimal;
        this.failedField = failedField;
    }

    public Animal getFailedAnimal() {
        return failedAnimal;
    }

    public String getFailedField() {
        return failedField;
    }
}
