package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.util.Date;

public class CrediteAccountImpl implements CrediteAccountService {
    public CrediteAccountImpl(){}

    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, int creditSum, int monthPay) {
        return new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
    }

    @Override
    public void readCreditAcc(CreditAccount creditAcc) {
        System.out.println(creditAcc);
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
