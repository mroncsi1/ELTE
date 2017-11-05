package hu.elte.alkfejl.service;

import hu.elte.alkfejl.exception.UserNotValidException;
import hu.elte.alkfejl.model.Order;
import hu.elte.alkfejl.model.User;
import hu.elte.alkfejl.dao.UserDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService extends AbstractService<User> {

    @Autowired
    private UserDao userDao;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userDao.findByUsername(user.getUsername());
        }
        throw new UserNotValidException("Username already exists!");
    }

    public void logout() {
        user = null;
    }

    public void register(User user) {
        userDao.insertEntity(user);
        this.user = userDao.findByUsername(user.getUsername());
    }

    public boolean isValid(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public User getLoggedInUser() {
        return user;
    }

    public void addOrder(Integer userId, Order order) {
        userDao.addOrderToUser(userId, order);
    }
}