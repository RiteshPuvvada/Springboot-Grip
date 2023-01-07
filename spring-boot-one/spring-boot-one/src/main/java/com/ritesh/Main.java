package com.ritesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //System.out.println("Hello World");
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }
    record GreetResponse(String greet){
    }
}
