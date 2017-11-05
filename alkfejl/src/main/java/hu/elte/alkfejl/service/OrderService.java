package hu.elte.alkfejl.service;

import groovy.transform.EqualsAndHashCode;
import hu.elte.alkfejl.dao.OrderDao;
import hu.elte.alkfejl.model.Order;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class OrderService extends AbstractService<Order> {

    @Autowired
    OrderDao orderDao;

    public List<Order> getAllOrderToUser(Integer userId) {
        return orderDao.getAllOrderToUser(userId);
    }
}
