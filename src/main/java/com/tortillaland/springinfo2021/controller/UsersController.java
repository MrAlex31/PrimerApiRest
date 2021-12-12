package com.tortillaland.springinfo2021.controller;

import java.util.List;
import java.util.Optional;
import com.tortillaland.springinfo2021.dao.UsersDAO;
import com.tortillaland.springinfo2021.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersDAO userDAO;
   
    @GetMapping
   public ResponseEntity<List<User>> getUser(){
       List<User> users = userDAO.findAll();
       return ResponseEntity.ok(users);
   }

    @RequestMapping(value="{userId}")
   public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
       Optional<User> Optionalusers = userDAO.findById(userId);
       if(Optionalusers.isPresent()){
           return ResponseEntity.ok(Optionalusers.get());
       }else{
           return ResponseEntity.noContent().build();
       }
   }
   @PostMapping
   public ResponseEntity<User> createUser(@RequestBody User user){
       User newUser = userDAO.save(user);
       return ResponseEntity.ok(newUser);
   }
   @DeleteMapping(value="{userId}")
   public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
       userDAO.deleteById(userId);
       return ResponseEntity.ok(null);
   }
   @PutMapping
   public ResponseEntity<User> updateUser(@RequestBody User user){
       Optional<User> updateUser = userDAO.findById(user.getId());
       if(updateUser.isPresent()){
           User userUpdate = updateUser.get();
           userUpdate.setName(user.getName());
           userUpdate.setLastName(user.getLastName());
           userUpdate.setEmail(user.getEmail());
           userUpdate.setPassword(user.getPassword());
           userUpdate.setCreationDate(user.getCreationDate());
           userUpdate.setCity(user.getCity());
           userUpdate.setProvince(user.getProvince());
           userUpdate.setCountry(user.getCountry());
           userUpdate.setType(user.getType());
           userDAO.save(userUpdate);
           return ResponseEntity.ok(userUpdate);
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}
