package com.example.UserManagement.user;

import com.example.UserManagement.mail.GoogleMailService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {


    // Mockup users data
    List<User> users = new ArrayList<>(
            List.of(
                    new User(1,"Ging",99,true),
                    new User(2,"Mild",99,false),
                    new User(3,"Mawin",99,true),
                    new User(4,"PP",99,false)
            )
    );

    private GoogleMailService googleMailService;

    public UserService() {
        this.googleMailService = googleMailService;
        this.googleMailService.setUrl("mail.google.com");
        this.googleMailService.setPort("42");
    }

    public List<User> getUsers(Optional<Boolean> active) {
        // Check if user is active
        if(active.isPresent()){
            return users.stream().filter(u -> u.getActive() == active.get()).toList();
        }
        return users;
    }


    public  User createUser(@RequestBody UserRequest request){

        //Generate nextId
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        User user = new User(nextId, request.name(), request.age(), true);
        users.add(user);

        //Send Mail
        googleMailService.sentEmail("dev@gmail.com","User Created");
        return user;
    }

    public void editUser(int id,UserRequest request){
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();

        if(user.isPresent()){
            User u = user.get();
            u.setName(request.name());
        }
    }


    public void deleteUser(int id){
        users.removeIf(u -> u.getId() == id);
    }

}

