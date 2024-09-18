package mosbach.dhbw.de.tasks.controller;

import mosbach.dhbw.de.tasks.controller.model.MessageAnswer;
import mosbach.dhbw.de.tasks.controller.model.TokenTask;
import org.springframework.http.MediaType;
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

    @PostMapping(
            path = "/tasks",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )

    @GetMapping("/tasks")
    public MessageAnswer createTask(@RequestBody TokenTask tokenTask) {
        Double gradeDouble = Double.parseDouble(tokenTask.getTask().getGrade());
        String answer = "You were a bit lazy";
        if (gradeDouble < 2.3)
            answer = "ok, you habe learned.";
        return
                new MessageAnswer("Task created." + answer);
    }
}