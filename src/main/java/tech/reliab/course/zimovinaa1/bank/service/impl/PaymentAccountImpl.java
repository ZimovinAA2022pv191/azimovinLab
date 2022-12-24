package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;
import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.PaymentAccountService;

public class PaymentAccountImpl implements PaymentAccountService {

    private PaymentAccount payAcc;

    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, int id) {
        payAcc = new PaymentAccount(bank, user, id);
        return payAcc;
    }

    @Override
    public PaymentAccount readPayAcc() {
        return payAcc;
    }

    @Override
    public void updateMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(money);
    }

    @Override
    public void delete(PaymentAccount payAcc) {
        if (this.payAcc == payAcc) {
            this.payAcc = null;
        }
    }


}
