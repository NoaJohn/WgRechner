package mosbach.dhbw.de.wgrechner.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    public MappingController(
    ) {}

    @GetMapping("/auth")
    public String getAuth() {
        return "I am alive.";
    }

    @GetMapping("/tasks")
    public String getTasks() {
        return "Answer wrong. TODO!";
    }



}