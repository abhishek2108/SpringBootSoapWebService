package com.abhishek.learning.soapwebservice.service;

import com.abhishek.learning.producingwebservice.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){

        User John = new User();
        John.setName("John");
        John.setSalary(900000);
        John.setCompany("Microsoft");

        User Doe = new User();
        Doe.setName("Doe");
        Doe.setSalary(900000);
        Doe.setCompany("Microsoft");

        users.put("John",John);
        users.put("Doe",Doe);

    }

    public User getUser(String name){
        return users.get(name);
    }

}
