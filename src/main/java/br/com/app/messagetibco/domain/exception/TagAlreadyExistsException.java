package br.com.app.messagetibco.domain.exception;

public class TagAlreadyExistsException extends RuntimeException {
    public TagAlreadyExistsException(String tag) {
        super("A tag '" + tag + "' já existe.");
    }
}