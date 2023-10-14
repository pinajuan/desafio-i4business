package br.com.i4business.money.domain.exception;

public class DataException extends RuntimeException {
    public DataException(final String msg) {
        super(msg);
    }
}