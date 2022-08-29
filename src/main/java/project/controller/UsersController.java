package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.service.UserService;
import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("user", userService.get());
        return "main";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "new";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){
            return "edit";
        }
        userService.update(id, user);
        return  "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return  "redirect:/";
    }
}
