package hu.elte.alkfejl.dao;

import hu.elte.alkfejl.model.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDao extends GenericDaoImpl<Order> {

    public OrderDao(Class<Order> orderClass, SessionFactory sessionFactory) {
        super(orderClass, sessionFactory);
    }

    public List<Order> getAllOrderToUser(Integer userId) {
        Query query = currentSession().createQuery("SELECT o FROM User u JOIN u.orderList o WHERE u.id = :userId");
        query.setParameter("userId", userId);
        return (List<Order>) query.list();
    }

}
