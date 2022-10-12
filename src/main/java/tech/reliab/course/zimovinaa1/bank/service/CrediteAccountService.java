package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.*;

import java.util.Date;

public interface CrediteAccountService {

    CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                  PaymentAccount paymentAccount, Integer id, Date startDate,
                                  Date endDate, Integer countMonth, int creditSum, int monthPay);

    void readCreditAcc(CreditAccount creditAcc);

    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);
}
