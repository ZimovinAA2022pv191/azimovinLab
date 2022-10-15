package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;
import tech.reliab.course.zimovinaa1.bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount createPayAcc(Bank bank, User user, Integer id);

    PaymentAccount readPayAcc();

    void updateMoney(PaymentAccount payAcc, Double money);

    void delete(PaymentAccount payAcc);
}
