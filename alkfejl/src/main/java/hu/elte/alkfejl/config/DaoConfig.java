package hu.elte.alkfejl.config;

import hu.elte.alkfejl.dao.*;
import hu.elte.alkfejl.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

public class DaoConfig {

    @Autowired
    SessionFactory sessionFactory;

    @Bean
    ToppingDao toppingDao() {
        return new ToppingDao(Topping.class, sessionFactory);
    }

    @Bean
    PizzaDao pizzaDao() {
        return new PizzaDao(Pizza.class, sessionFactory);
    }

    @Bean
    DessertDao dessertDao() {
        return new DessertDao(Dessert.class, sessionFactory);
    }

    @Bean
    UserDao userDao() {
        return new UserDao(User.class, sessionFactory);
    }

    @Bean
    OrderDao OrderDao() {
        return new OrderDao(Order.class, sessionFactory);
    }
}