package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.*;

import java.time.LocalTime;
import java.util.Date;

public interface CrediteAccountService {

    CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                  PaymentAccount paymentAccount, Integer id, LocalTime startDate,
                                  LocalTime endDate, Integer countMonth, Double creditSum, Integer monthPay);


    CreditAccount readCreditAcc();

    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);

    void delete(CreditAccount creditAccount);
}
