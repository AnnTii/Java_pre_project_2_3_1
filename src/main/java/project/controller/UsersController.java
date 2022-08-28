package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("user", userService.getUser());
        return "main";
    }

    @GetMapping(value = "/new")
    public String save(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showId(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return  "redirect:/";
    }

    @GetMapping(value = "/{id}/dell")
    public String dell(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showId(id));
        return "dell";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.dellUser(id);
        return  "redirect:/";
    }
}
