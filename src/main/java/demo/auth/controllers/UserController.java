package demo.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String getHome() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping(value = "/user")
    public String getUser() {
        return "<h1>Hello User</h1>";
    }

    @GetMapping(value = "/admin")
    public String getAdmin() {
        return "<h1>Hello Admin</h1>";
    }
    
}