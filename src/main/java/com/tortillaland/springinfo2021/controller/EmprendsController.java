package com.tortillaland.springinfo2021.controller;

import com.tortillaland.springinfo2021.dto.OperationEmprend;
import com.tortillaland.springinfo2021.service.EmprendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emprends")
public class EmprendsController {
    
    private EmprendService emprendService;

    @Autowired
    public EmprendsController(EmprendService emprendService) {
        this.emprendService = emprendService;
    }

    @PostMapping
    public ResponseEntity<?> createEmprend(@Valid @RequestBody OperationEmprend operationEmprend) {
        return new ResponseEntity<>(emprendService.createEmprend(operationEmprend), HttpStatus.CREATED);
    }
}
