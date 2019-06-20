package hello.controllers;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.entities.User;
import hello.entities.dataObjects.UserLoggedDTO;
import hello.services.UserServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class MainController {

    private final UserServiceImpl userService;
    @Autowired
    ObjectMapper objectMapper;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return "Hello World";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    UserLoggedDTO logUserIn(@RequestParam String password, @RequestParam String login) {

        return userService.logUserIn(login, password.toCharArray());
    }

    @PostMapping(path = "/register")
    public @ResponseBody
    User registerNewUser(@RequestBody User u) {
        return userService.registerNewUser(u);
    }


}