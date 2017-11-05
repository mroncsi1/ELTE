package hu.elte.alkfejl.dao;

import hu.elte.alkfejl.model.Dessert;
import org.hibernate.SessionFactory;

public class DessertDao extends GenericDaoImpl<Dessert> {
    public DessertDao(Class<Dessert> dessertClass, SessionFactory sessionFactor) {
        super(dessertClass, sessionFactor);
    }
}