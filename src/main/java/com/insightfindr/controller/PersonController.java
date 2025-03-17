package com.insightfindr.controller;

import com.insightfindr.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class PersonController {

    @Autowired
    PersonServiceImpl service;
}
