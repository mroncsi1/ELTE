package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.exception.DataNotValidException;
import hu.elte.alkfejl.exception.DuplicatedDataException;
import hu.elte.alkfejl.exception.MissingDataException;
import hu.elte.alkfejl.model.Pizza;
import hu.elte.alkfejl.model.Topping;
import hu.elte.alkfejl.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.model.User.Role.ADMIN;
import static hu.elte.alkfejl.model.User.Role.USER;

@RestController
@RequestMapping("/api/Toppings")
public class ToppingController implements ControllerInterface<Topping>{

    @Autowired
    private ToppingService toppingService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Topping topping) {
        try {
            toppingService.update(topping);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            toppingService.deleteById(id);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Topping topping) {
        try {
            toppingService.delete(topping);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Topping topping) {
        try {
            toppingService.create(topping);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Topping get(@PathVariable Integer id) {
        return toppingService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Topping> getAll() {
        return toppingService.getAll();
    }

    @Role({ADMIN, USER})
    @GetMapping("/getByPizza/{PizzaId}")
    public List<Topping> getByPizza(@PathVariable Integer pizzaId) {
        return toppingService.getToppingsByPizza(pizzaId);
    }

    @Role({ADMIN})
    @PostMapping("/addPizzaToTopping/{ToppingId}")
    public void addPizzaToTopping(@PathVariable Integer toppingId, @RequestBody Pizza pizza) {
        toppingService.addPizzaToTopping(toppingId, pizza.getId());
    }

}