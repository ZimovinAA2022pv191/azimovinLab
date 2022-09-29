package tech.reliab.course.zimovinaa1.bank.entity;

import tech.reliab.course.zimovinaa1.bank.entity.detail.FIO;
import tech.reliab.course.zimovinaa1.bank.service.PaymentAccountService;

public class PaymentAccount implements PaymentAccountService {
    private int id_payment;
    private User user;
    private String name_bank;
    private int sum;

    public PaymentAccount(int id_payment, User user, String name_bank)
    {
        this.id_payment = id_payment;
        this.user = user;
        this.name_bank = name_bank;
        this.sum = 0;
    }


    @Override
    public String toString()
    {
        return "PaymentAccount{" +
                "id_payment=" + id_payment +
                ", user=" + user +
                ", name_bank='" + name_bank + '\'' +
                ", sum=" + sum +
                '}';
    }

    public int getIdPayment() {
        return id_payment;
    }

    public void setIdPayment(int id_payment) {
        this.id_payment = id_payment;
    }

    public FIO getUser() {
        return this.user.getFio();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName_bank() {
        return name_bank;
    }

    public void setNameBank(String name_bank) {
        this.name_bank = name_bank;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
