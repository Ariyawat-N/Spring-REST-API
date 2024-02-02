package com.example.UserManagement.user;

import com.example.UserManagement.mail.GoogleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    // User Service
    private  final  UserService userService;

    // User Constructor Service
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//List all users
    @GetMapping("api/users")
        public List<User> getUsers(@RequestParam("active")Optional<Boolean> active){
        return userService.getUsers(active);
}

//Create User
    @PostMapping("api/users")
        public User createUser(@RequestBody UserRequest request){
            return userService.createUser(request);

    }


// Update User
    @PostMapping("api/users/{id}")
    public void editUser(@PathVariable ("id") int id,@RequestBody UserRequest request){
        userService.editUser(id,request);

    }


//  Delete User
    @DeleteMapping("api/users/{id}")
    public  void delete(@PathVariable("id")int id){
       userService.deleteUser(id);
    }

}

//Record
record UserRequest(String name,int age) {}


// MODEL
class User {
    private  int id;
    private String name;
    private  int age;
    private Boolean active;

    public User(int id, String name, int age, Boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }
}







