package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }


    /*@Override
    public void update(User user) {
        userDao.update(user);
    }*/

    @Override
    public User update(int id, User updateUser) {
       return userDao.update(id, updateUser);
    }


    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }


    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
