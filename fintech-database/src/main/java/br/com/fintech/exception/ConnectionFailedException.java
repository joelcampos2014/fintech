package br.com.fintech.exception;

public class ConnectionFailedException extends Exception {
    public ConnectionFailedException() {
    }
    public ConnectionFailedException(String message) {
        super(message);
    }
}
