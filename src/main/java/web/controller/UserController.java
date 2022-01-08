package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.models.User;
import web.service.UserService;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getListUsers(Model model){
        model.addAttribute("users", userService.getListUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }


    @PostMapping(value ="edit/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") int id){
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}
