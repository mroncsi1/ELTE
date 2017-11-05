package hu.elte.alkfejl.dao;

import hu.elte.alkfejl.model.Pizza;
import org.hibernate.SessionFactory;

public class PizzaDao extends GenericDaoImpl<Pizza> {
    public PizzaDao(Class<Pizza> pizzaClass, SessionFactory sessionFactor) {
        super(pizzaClass, sessionFactor);
    }
}