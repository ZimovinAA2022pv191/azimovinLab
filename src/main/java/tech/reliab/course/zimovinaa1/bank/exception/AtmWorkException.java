package tech.reliab.course.zimovinaa1.bank.exception;

public class AtmWorkException extends Exception{
    public AtmWorkException() {
        super("Данный банкомат не работает, обратитесь в другой!");
    }
}
