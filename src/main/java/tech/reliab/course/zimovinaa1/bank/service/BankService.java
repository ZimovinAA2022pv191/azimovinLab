package tech.reliab.course.zimovinaa1.bank.service;

public interface BankService {
    int rnd(int max);

    void calc_percent();

    void addMoney(int x);

    public void addCountOffice(int i);
    public void addCountAtm(int i);
    public void addCountClient(int i);
    public void addCountEmployee(int i);

}
