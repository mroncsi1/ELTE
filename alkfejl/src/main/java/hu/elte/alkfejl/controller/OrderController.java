package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.exception.DataNotValidException;
import hu.elte.alkfejl.exception.DuplicatedDataException;
import hu.elte.alkfejl.exception.MissingDataException;
import hu.elte.alkfejl.model.Order;
import hu.elte.alkfejl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.model.User.Role.ADMIN;
import static hu.elte.alkfejl.model.User.Role.USER;

@RestController
@RequestMapping("/api/orders")
public class OrderController implements ControllerInterface<Order> {

    @Autowired
    private OrderService orderService;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody Order order) {
        try {
            orderService.update(order);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            orderService.deleteById(id);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(Order order) {
        try {
            orderService.delete(order);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody Order order) {
        try {
            orderService.create(order);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public Order get(@PathVariable Integer id) {
        return orderService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @Role({ADMIN, USER})
    @GetMapping("/getAllToUser/{userId}")
    public List<Order> getAllToUser(@PathVariable Integer userId) {
        return orderService.getAllOrderToUser(userId);
    }

}