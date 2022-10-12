package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.UserService;

import java.util.Date;

public class UserImpl implements UserService {
    public UserImpl(){}

    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           Date dateBirth, String workPlace) {
        return new User(id, firstName, lastName, patronymic, dateBirth, workPlace);
    }

    @Override
    public void readUser(User user) {
        System.out.println(user);
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }
}
