package com.ritesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //System.out.println("Hello World");
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java","Golang","Typescript","Python"),
                new Person("Ritesh", 23,25000)
        );
        return response;
    }
    record Person(String name, int age, int savings){

    }
    record GreetResponse(
            String greet,
            List<String> FavProgLang,
            Person person
            ){
    }
}
