package mosbach.dhbw.de.wgrechner.controller;


import mosbach.dhbw.de.wgrechner.dto.RegUserDTO;
import mosbach.dhbw.de.wgrechner.dto.SingleMessageDTO;
import mosbach.dhbw.de.wgrechner.model.User;
import mosbach.dhbw.de.wgrechner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    //Injektion von Spring -> Kann mehrere Instanzen erstellen -> besser als static oder manuelle erstellung!!
    //SPring verwaltete Lebensdauer usw. -> sehr cool
    //Stellt alle Methoden und Informationen aus UserService bereit
    @Autowired
    private UserService userService;

    //Registrierungsvorgang und Abspreichern des Users mit Antwort
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> registerUser(@RequestBody RegUserDTO regUserDTO) {
        User userExtracted = new User(regUserDTO.getUsername(),regUserDTO.getEMail(),regUserDTO.getPassword());
        userService.saveUserInHashMap(userExtracted);
        return new ResponseEntity<SingleMessageDTO>(new SingleMessageDTO("User created successfully!"), HttpStatus.OK);
    }

    //HashMap und dessen User abfragen und anzeigen
    @GetMapping
    public ResponseEntity<?> getAllUsersInHashMap() {
        return new ResponseEntity<SingleMessageDTO>(new SingleMessageDTO(userService.getAllUsersInHashMap()), HttpStatus.OK);
    }
}
