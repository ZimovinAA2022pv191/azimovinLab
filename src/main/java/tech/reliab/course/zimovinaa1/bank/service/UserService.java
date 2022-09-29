package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Employee;

public interface UserService {
    void leaveBank();
    void calc_rate();
    void addPaymentAccount();
    void addCreditAccount(String date_start, String date_end, int count_mount, float sum_credit, float month_pay,
                          int percentage, Employee employee);
}
