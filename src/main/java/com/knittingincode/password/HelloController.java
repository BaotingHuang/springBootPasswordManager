package com.knittingincode.password;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alisaarnold on 1/18/18.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWorld (@RequestParam(required = false, value = "name") String name ){
        if(name == null) {
            return "Hello World!";
        } else {
            return "Hello " + name + "?!";
        }
    }

    @GetMapping("/{you}")
    public String helloYou (@PathVariable("you") String you){
        return "Hello " + you;

    }

}
