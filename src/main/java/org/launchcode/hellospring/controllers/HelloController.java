package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller // This class represents a web controller via the Controller annotation
public class HelloController {

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);// (1st param needs to match up with <p th:text="{greeting}" >Hello, Spring!</p> in hello.html, 2nd param is line 13 - what we want to say
        return "hello";
    }

    @RequestMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String heloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Chris");
        names.add("Kaitlyn");
        names.add("Bob");
        model.addAttribute("names", names);
        return "hello-list";
    }

}