package tech.reliab.course.zimovinaa1.bank.exception;

public class AtmMoneyExceptions extends Exception {
    public AtmMoneyExceptions() {
        super("В банкомате недостаточно денег!\n Обратитесь к другому банкомату");
    }
}

