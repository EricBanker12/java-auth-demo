package demo.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String getHome() {
        return "<h1>Hello World</h1> <a href=/user>user page</a> <br> <a href=/admin>admin page</a>";
    }

    @GetMapping(value = "/user")
    public String getUser() {
        return "<h1>Hello User</h1> <a href=/logout>logout</a>";
    }

    @GetMapping(value = "/admin")
    public String getAdmin() {
        return "<h1>Hello Admin</h1> <a href=/logout>logout</a>";
    }
    
}