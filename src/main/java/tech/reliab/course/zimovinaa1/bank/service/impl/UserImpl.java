package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.UserService;

import java.time.LocalTime;

public class UserImpl implements UserService {
    private User user;

    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           LocalTime dateBirth, String workPlace) {
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
    public void delete(User user) {
        if (this.user == user) {
            this.user = null;
        }
    }
}
