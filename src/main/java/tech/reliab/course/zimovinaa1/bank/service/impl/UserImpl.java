package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.CreditAccount;
import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;
import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.UserService;

public class UserImpl implements UserService {
    private User user;

    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           String dateBirth, String workPlace, Double salary) {
        user = new User(id, firstName, lastName, patronymic, dateBirth, workPlace, salary);
        return user;
    }
    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           String dateBirth, String workPlace) {
        user = new User(id, firstName, lastName, patronymic, dateBirth, workPlace);
        return user;
    }

    @Override
    public User readUser() {
        return user;
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

    @Override
    public void addPaymentAcc(int id, PaymentAccount paymentAccount, User user){
        user.addPaymentAcc(user.getUserId(), paymentAccount, user);
    }

    @Override
    public void addCreditAcc(int id, CreditAccount creditAccount, User user){
        user.addCreditAcc(id, creditAccount);
    }


    @Override
    public void delete(User user) {
        if (this.user == user) {
            this.user = null;
        }
    }
}
