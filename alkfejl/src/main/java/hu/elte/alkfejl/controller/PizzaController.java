package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.exception.DataNotValidException;
import hu.elte.alkfejl.exception.DuplicatedDataException;
import hu.elte.alkfejl.exception.MissingDataException;
import hu.elte.alkfejl.model.Pizza;
import hu.elte.alkfejl.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.model.User.Role.ADMIN;
import static hu.elte.alkfejl.model.User.Role.USER;

@RestController
@RequestMapping("/api/Pizzas")
public class PizzaController implements ControllerInterface<Pizza> {

    @Autowired
    private PizzaService pizzaService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Pizza pizza) {

        try {
            pizzaService.update(pizza);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            pizzaService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Pizza Pizza) {
        try {
            pizzaService.delete(Pizza);
        } catch (DataNotValidException e) {

        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Pizza pizza) {
        try {
            pizzaService.create(pizza);
        } catch (DuplicatedDataException e) {

        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Pizza get(@PathVariable Integer id) {
        return pizzaService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Pizza> getAll() {
        return pizzaService.getAll();
    }
}