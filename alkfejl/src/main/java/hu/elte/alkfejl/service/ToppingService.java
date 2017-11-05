package hu.elte.alkfejl.service;

import groovy.transform.EqualsAndHashCode;
import hu.elte.alkfejl.dao.PizzaDao;
import hu.elte.alkfejl.dao.ToppingDao;
import hu.elte.alkfejl.model.Topping;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class ToppingService extends AbstractService<Topping> {

    @Autowired
    ToppingDao toppingDao;

    @Autowired
    PizzaDao pizzaDao;

    public List<Topping> getToppingsByPizza(Integer pizzaId) {
        return toppingDao.getToppingsByPizza(pizzaId);
    }

    public void addPizzaToTopping(Integer toppingId, Integer pizzaId) {
        toppingDao.addPizzaToTopping(toppingId, pizzaDao.findEntity(pizzaId));
    }
}
