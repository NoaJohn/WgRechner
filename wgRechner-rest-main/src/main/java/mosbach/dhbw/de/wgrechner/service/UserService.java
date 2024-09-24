package mosbach.dhbw.de.wgrechner.service;


import mosbach.dhbw.de.wgrechner.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//Wichtig, damit Spring-Bean erstellt werden kann -> Also autowire
@Service
public class UserService {

    //Dummy User in HashMap zum Debuggen
    private static HashMap<String, User> userMap = new HashMap<>();
    static{
        User dummyUser = new User("Dummy", "Dummy@dummy.de", "DummyDummy");
        userMap.put(dummyUser.getUserId(), dummyUser);
    }

    //Methode um User in HashMap zu speichern
    public void saveUserInHashMap(User user){
        userMap.put(user.getUserId(),user);
    }

    //Methode um alle User aus HashMap abzugreifen und in einem String anzuzeigen -> Fürs Debuggen
    public String getAllUsersInHashMap(){
        StringBuilder resultOfHashMap = new StringBuilder(); // StringBuilder zum Speichern der Ausgaben

        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            String key = entry.getKey(); // Schlüssel aus HashMap
            User value = entry.getValue(); // Wert aus HashMap
            resultOfHashMap.append("Key: ").append(key).append(", Value: ").append(value).append("\n"); // Ausgabe zum StringBuilder hinzufügen
        }
        return resultOfHashMap.toString(); // Rückgabe des StringBuilders als ein String
    }



}
