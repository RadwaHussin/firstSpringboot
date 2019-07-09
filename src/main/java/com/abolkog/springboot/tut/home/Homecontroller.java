package com.abolkog.springboot.tut.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

    @RequestMapping(value = "/")
    public String greeting()
    {
        return "welcomeeee alll Welcome to SٍpringBoot tutorial";
    }

    @GetMapping(value = "/{name}")
    public String greetingWithName(@PathVariable String name)
    {
        return String.format("welcome %s to our SpringBoot application",name);
    }
}
