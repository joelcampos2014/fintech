package br.com.fintech.exception;

public class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException() {
    }
    public ObjectNotFoundException(String object) {
        super(object + " não encontrado(a).");
    }
}
