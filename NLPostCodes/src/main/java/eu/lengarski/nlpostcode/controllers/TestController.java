package eu.lengarski.nlpostcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/test")
public class TestController {


    @GetMapping
    public String getData() {
        return "hello world";
    }


}

