package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.exception.DataNotValidException;
import hu.elte.alkfejl.exception.DuplicatedDataException;
import hu.elte.alkfejl.exception.MissingDataException;
import hu.elte.alkfejl.model.Dessert;
import hu.elte.alkfejl.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.model.User.Role.ADMIN;
import static hu.elte.alkfejl.model.User.Role.USER;

@RestController
@RequestMapping("/api/Desserts")
public class DessertController implements ControllerInterface<Dessert> {

    @Autowired
    private DessertService dessertService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Dessert dessert) {

        try {
            dessertService.update(dessert);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            dessertService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Dessert dessert) {
        try {
            dessertService.delete(dessert);
        } catch (DataNotValidException e) {

        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Dessert dessert) {
        try {
            dessertService.create(dessert);
        } catch (DuplicatedDataException e) {

        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Dessert get(@PathVariable Integer id) {
        return dessertService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Dessert> getAll() {
        return dessertService.getAll();
    }
}