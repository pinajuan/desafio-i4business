package br.com.i4business.money.domain.exception;

public class InternalErrorException extends NoStacktraceException{
    protected InternalErrorException(final String aMessage, final Throwable t) {
        super(aMessage, t);
    }

    public static InternalErrorException with(final String message, final Throwable t) {
        return new InternalErrorException(message, t);
    }
}
