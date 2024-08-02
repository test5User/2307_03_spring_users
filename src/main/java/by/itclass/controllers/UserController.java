package by.itclass.controllers;

import by.itclass.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static by.itclass.constants.AppConst.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(ALL_USERS_URL)
    private String all(Model model) {
        var users = service.getAllUser();
        model.addAttribute(USER_LIST_ATTR, users);
        return USERS_PAGE;
    }
}
