package com.example.trashapi.controllers;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TrashController {

    List<String> deadlySins = Arrays.asList("Lust", "Gluttony", "Greed", "Sloth", "Wrath", "Envy", "Pride");

    @GetMapping("/")
    public String frontpage() {
        return "hi there";
    }

    @GetMapping("/clock")
    public Date clock() {
        return new Date();
    }

    @GetMapping("/sins")
    public String deadlySin() {
        int sinNum = (int) ((Math.random() * 7) + 1)-1;
        return deadlySins.get(sinNum);
    }

    public String requestMappingTypeEndpoint(){
        return "Endpoint with Requeste mappping annotation";
    }

    @GetMapping("/sevendeadlysins/{sinNumber}")
    public String getADeadlySin(@PathVariable int sinNumber){
        System.out.println(sinNumber);
        try{
            return deadlySins.get(sinNumber);
        } catch (Exception error) {
            return "select a number";
        }
    }

    //Behøver ikke bruge try catch hvis det er en String
    @GetMapping("/trashData")
    public String trashData(@RequestParam String trash, @RequestParam(required = false) String otherTrash) {
            return trash + " ," + otherTrash;
    }

    @PostMapping("/rubbishbin")
    public String throwOutRubbish(@RequestBody String rubbish){
        System.out.println(rubbish);
        return "Everything went welasdgasl";
    }

}
