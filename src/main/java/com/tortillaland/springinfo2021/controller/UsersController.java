package com.tortillaland.springinfo2021.controller;

import com.tortillaland.springinfo2021.dao.UsersDAO;
import com.tortillaland.springinfo2021.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersDAO usersDAO;

    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(usersDAO.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde) {
        if (fechaDesde != null) {
            List<User> user = usersDAO.findByCreatedDateAfter(fechaDesde.atStartOfDay());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(usersDAO.findAll(), HttpStatus.OK);
    }
}
