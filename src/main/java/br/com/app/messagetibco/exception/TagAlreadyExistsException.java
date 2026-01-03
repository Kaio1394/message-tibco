package br.com.app.messagetibco.exception;

public class TagAlreadyExistsException extends RuntimeException {
    public TagAlreadyExistsException(String tag) {
        super("A tag '" + tag + "' já existe.");
    }
}