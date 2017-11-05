package hu.elte.alkfejl.dao;

import hu.elte.alkfejl.model.Pizza;
import hu.elte.alkfejl.model.Topping;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class ToppingDao extends GenericDaoImpl<Topping> {

    public ToppingDao(Class<Topping> toppingClass, SessionFactory sessionFactory) {
        super(toppingClass, sessionFactory);
    }

    public List<Topping> getToppingsByPizza(Integer pizzaId) {
        Query query = currentSession().createQuery("SELECT t FROM Topping t JOIN t.pizzas p WHERE p.id = :pizzaId");
        query.setParameter("pizzaId", pizzaId);
        return (List<Topping>) query.list();
    }

    public void addPizzaToTopping(Integer toppingId, Pizza pizza) {
        Topping topping = findEntity(toppingId);
        topping.getPizzas().add(pizza);
        updateEntity(topping);
    }

}
