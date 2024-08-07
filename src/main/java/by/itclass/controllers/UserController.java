package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.itclass.constants.AppConst.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return INDEX_PAGE;
    }

    @GetMapping(ALL_USERS_URL)
    public String all(Model model) {
        var users = service.getAllUser();
        model.addAttribute(USER_LIST_ATTR, users);
        return USERS_PAGE;
    }

    @GetMapping(DEL_USERS_URL)
    public String delete(@RequestParam(name = "id") int id) {
        service.deleteById(id);
        return INDEX_PAGE;
    }

    @GetMapping(ADD_USER_URL)
    public ModelAndView add() {
        var modelAndView = new ModelAndView(ADD_PAGE, USER_ATTR, new User());
        return modelAndView;
    }

    @PostMapping(SAVE_USER_URL)
    public String save(@ModelAttribute(name = USER_ATTR) User user) {
        service.add(user);
        return "redirect:" + ALL_USERS_URL;
    }

    @PostMapping(ADD_USER_SECOND_URL)
    public String addSecond(
            @RequestParam(name = NAME_PARAM) String name,
            @RequestParam(name = AGE_PARAM) int age) {
        service.add(new User(name, age));
        return "redirect:" + ALL_USERS_URL;
    }
}
