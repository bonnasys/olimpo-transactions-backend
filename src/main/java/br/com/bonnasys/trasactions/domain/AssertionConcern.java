package br.com.bonnasys.trasactions.domain;

public interface AssertionConcern {

    default <T> T assertArgumentNotNull(T argument, String aMessage) {
        if (argument == null) {
            throw new IllegalArgumentException(aMessage);
        }
        return argument;
    }

    default String assertArgumentNotEmpty(String argument, String aMessage) {
        if (argument == null || argument.isBlank()) {
            throw new IllegalArgumentException(aMessage);
        }
        return argument;
    }
}
