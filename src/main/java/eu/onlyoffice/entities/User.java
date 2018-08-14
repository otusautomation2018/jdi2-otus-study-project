package eu.onlyoffice.entities;


import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.onlyoffice.data.CommonForTheSiteData;

import java.io.File;
import java.io.IOException;

public class User extends DataClass<User> {
    public String email;
    public String password;

    private static ObjectMapper mapper = new ObjectMapper();

    public static User createFromFile(String pathToFile){
        User result = null;
        try {
            result = mapper.readValue(new File(pathToFile), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result == null) {
            throw new NullPointerException("[OTUS-AUT-ERROR] :: " + User.class + " can't be read from the file :: " + pathToFile + ".");
        }
        return result;
    }
}
