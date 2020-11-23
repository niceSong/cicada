package org.tyytogetheyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.tyytogetheyy.exception.TestException;
import org.tyytogetheyy.service.TestService;

@Controller
public class TestController {

    @Autowired
    TestException testException;

    @Autowired
    TestService testService;

    @GetMapping(value = "/test")
    public void test(){
        throw testException.fuckException("You throw cicada exception successfully");
    }

}
