package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.dao.UserDao;
import hu.elte.alkfejl.exception.DataNotValidException;
import hu.elte.alkfejl.exception.DuplicatedDataException;
import hu.elte.alkfejl.exception.MissingDataException;
import hu.elte.alkfejl.exception.UserNotValidException;
import hu.elte.alkfejl.model.Order;
import hu.elte.alkfejl.model.User;
import hu.elte.alkfejl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




import java.util.List;

import static hu.elte.alkfejl.model.User.Role.ADMIN;
import static hu.elte.alkfejl.model.User.Role.USER;

@RestController
@RequestMapping("/user/")
public class UserController implements ControllerInterface<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Override
    @Role(ADMIN)
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        try {
            userService.update(user);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Role(ADMIN)
    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        try {
            userService.delete(user);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    @Role(ADMIN)
    public void create(@RequestBody User user) {
        try {
            userService.create(user);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @Role({ADMIN, USER})
    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @Role({ADMIN, USER})
    @GetMapping("/getall")
    public List<User> getAll() {
        return userDao.getEntities();
    }

    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        try {
            userService.login(user);
            return redirectToGreeting(user);
        }
        catch (UserNotValidException e) {
            model.addAttribute("error", true);
            return "login";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        user.setRole(USER);
        userService.register(user);

        return redirectToGreeting(user);
    }

    private String redirectToGreeting(@ModelAttribute User user) {
        return "redirect:/user/greet?name=" + user.getUsername();
    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/addOrder/{userId}")
    @Role(ADMIN)
    public void create(@PathVariable Integer userId, @RequestBody Order order) {
        userService.addOrder(userId, order);
    }
}