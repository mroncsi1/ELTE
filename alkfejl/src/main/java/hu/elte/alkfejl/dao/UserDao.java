package hu.elte.alkfejl.dao;

import hu.elte.alkfejl.model.Order;
import hu.elte.alkfejl.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class UserDao extends GenericDaoImpl<User> {
    public UserDao(Class<User> userClass, SessionFactory sessionFactor) {
        super(userClass, sessionFactor);
    }

    public User findByUsername(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("username", username));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }

    public User findByUsernameAndPassword(String username, String password) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (User) executableCriteria.uniqueResult();
    }

    public void addOrderToUser(Integer userId, Order order) {
        User user = findEntity(userId);
        user.getOrderList().add(order);
        insertEntity(user);
    }
}