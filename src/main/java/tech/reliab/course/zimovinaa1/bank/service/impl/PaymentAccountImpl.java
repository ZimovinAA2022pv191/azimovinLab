package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;
import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.PaymentAccountService;

public class PaymentAccountImpl implements PaymentAccountService {

    public PaymentAccountImpl(){}

    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, Integer id) {
        bank.setCountClient(bank.getCountClient() + 1);
        return new PaymentAccount(bank, user, id);
    }

    @Override
    public void readPayAcc(PaymentAccount payAcc) {
        System.out.println(payAcc);
    }

    @Override
    public void updateMoney(PaymentAccount payAcc, int money) {
        payAcc.setMoney(money);
    }
}
