package tech.reliab.course.zimovinaa1.bank.entity;

import tech.reliab.course.zimovinaa1.bank.entity.detail.FIO;
import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.util.Date;

public class CreditAccount implements CrediteAccountService {
    private int id_credit_account;
    private User user;
    private String name_bank;
    private String date_start_credit, date_end_credit; //yyyy-mm-dd
    private int count_months_credit;
    private float sum_credit;
    private float month_pay;
    private int percentage;
    private Employee employee;
    private PaymentAccount paymentAccount;
    private Bank bank;

    public CreditAccount(int id_credit_account, User user, Bank bank, String date_start_credit,
                         String date_end_credit, int count_months_credit, float sum_credit, float month_pay,
                         int percentage, Employee employee)
    {
        this.id_credit_account = id_credit_account;
        this.user = user;
        this.bank=bank;
        this.name_bank = this.bank.getName();
        this.date_start_credit = date_start_credit;
        this.date_end_credit = date_end_credit;
        this.count_months_credit = count_months_credit;
        this.sum_credit = sum_credit;
        this.month_pay = month_pay;
        this.percentage = percentage;
        this.employee = employee;
        this.paymentAccount = new PaymentAccount(id_credit_account+1,user,this.bank.getName());
    }

    @Override
    public boolean isOpenCredit()
    {
        if((this.sum_credit>this.paymentAccount.getSum()) && !this.employee.getCanGiveCredit())
        {
            return false;
        }
        this.employee.setCanGiveCredit(true);
        this.count_months_credit=0;
        return true;
    }

    public int getIdCreditAccount() {
        return id_credit_account;
    }

    public void setIdCreditAccount(int id_credit_account) {
        this.id_credit_account = id_credit_account;
    }

    public FIO getUser() {
        return user.getFio();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FIO getEmployee() {
        return employee.getFio();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNameBank() {
        return name_bank;
    }

    public void setNameBank(String name_bank) {
        this.name_bank = name_bank;
    }

    public String getDateStartCredit() {
        return date_start_credit;
    }

    public void setDateStartCredit(String date_start_credit) {
        this.date_start_credit = date_start_credit;
    }

    public String getDateEndCredit() {
        return date_end_credit;
    }

    public void setDateEndCredit(String date_end_credit) {
        this.date_end_credit = date_end_credit;
    }

    public int getCountMonthsCredit() {
        return count_months_credit;
    }

    public void setCountMonthsCredit(int count_months_credit) {
        this.count_months_credit = count_months_credit;
    }

    public float getSum_credit() {
        return sum_credit;
    }

    public void setSum_credit(float sum_credit) {
        this.sum_credit = sum_credit;
    }

    public float getMonth_pay() {
        return month_pay;
    }

    public void setMonth_pay(float month_pay) {
        this.month_pay = month_pay;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void setPay_detail_account(int x) {
        this.paymentAccount.setSum(x);
    }
}
