package com.radis.demo.controller;

import com.radis.demo.model.User;
import com.radis.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/redis")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Map<String, User> findAllUser() {
        return userRepository.findAll();
    }
    @GetMapping("/get")
    public User findAllUser(@RequestParam("id") String id) {
        return userRepository.findById("1");
    }
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestParam(value = "id",required = false,defaultValue = "1") final String id,
                                     @RequestParam(value = "name",required = false,defaultValue = "umakant") final String name,
                                     @RequestParam(value = "salary",required = false,defaultValue = "29000") final String salary) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSalary(salary);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("update")
    public ResponseEntity updateUser(@RequestParam("id") final String id, @RequestParam("name") final String name,
                                     @RequestParam("salary") final String salary) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSalary(salary);
        userRepository.update(user);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") final String id){
        userRepository.delete(id);
    }
}
