package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.time.LocalDate;
import java.time.LocalTime;

public class CrediteAccountImpl implements CrediteAccountService {
    private CreditAccount crediteAcc;

    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, String startDate,
                                         String endDate, Integer countMonth, Double creditSum) {
        double monthPay = creditSum * bank.getPercentage()/12;
        crediteAcc = new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
        return crediteAcc;
    }

    @Override
    public CreditAccount readCreditAcc() {
         return crediteAcc;
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }

    @Override
    public void delete(CreditAccount creditAccount) {
        if (this.crediteAcc == creditAccount) {
            this.crediteAcc = null;
        }
    }
}
