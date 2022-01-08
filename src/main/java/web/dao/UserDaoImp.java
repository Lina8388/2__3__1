package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getListUsers() {
        String HQL = "from User";
        return  entityManager.createQuery(HQL, User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

  /*  @Override
    public void update(User user) {
        entityManager.merge(user);
    }*/

   /* @Override
    public void update(int id, User updateUser) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setName(updateUser.getName());
    }*/


    @Transactional
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User update(int id, User user) {
        User  toBeUpdated = getUser(id);
        if(user.getId()==id){
            toBeUpdated.setName(user.getName());
            toBeUpdated.setSurname(user.getSurname());
            toBeUpdated.setEmail(user.getEmail());
        }
        return entityManager.merge(toBeUpdated);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }


}
