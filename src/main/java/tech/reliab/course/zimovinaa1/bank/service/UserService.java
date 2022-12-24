package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.*;

import java.io.IOException;
import java.util.ArrayList;


public interface UserService {
    User createUser(Integer id, String firstName, String lastName, String patronymic,
                    String dateBirth, String workPlace);
    User createUser(Integer id, String firstName, String lastName, String patronymic,
                    String dateBirth, String workPlace, Double salary);

    User readUser();

    ArrayList<PaymentAccount> getPaymentAcc();

    ArrayList<CreditAccount> getCreditAcc();

    void updateUserWork(User user, String workPlace);

    void addPaymentAcc(int id, PaymentAccount paymentAccount, User user);

    void addCreditAcc(int id, CreditAccount creditAccount, User user);

    void delete(User user);

    void saveToFile(String fileName, Bank bank) throws IOException;

    void updateFromFile(String fileName) throws IOException;
}
