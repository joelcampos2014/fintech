package br.com.fintech.exception;

public class InvalidTypeException extends Exception{
    public InvalidTypeException() {
    }
    public InvalidTypeException(String type) {
        super("O tipo " + type + " é inválido!");
    }
}
