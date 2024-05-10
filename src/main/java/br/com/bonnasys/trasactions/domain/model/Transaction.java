package br.com.bonnasys.trasactions.domain.model;

public record Transaction(String id, String errorMessage) {

    public boolean isSuccess() {
        return errorMessage == null;
    }

    public static Transaction success(String id) {
        return new Transaction(id, null);
    }

    public static Transaction failure(String id, String errorMessage) {
        return new Transaction(id, errorMessage);
    }
}
