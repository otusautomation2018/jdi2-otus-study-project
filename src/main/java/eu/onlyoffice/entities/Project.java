package eu.onlyoffice.entities;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Project extends DataClass<Project> {
    public String title;
    public String description;
    public String manager;
    public String[] tags;
    public boolean isPrivate = true;

    private static ObjectMapper mapper = new ObjectMapper();

    public static Project createFromFile(String pathToFile){
        Project result = null;
        try {
            result = mapper.readValue(new File(pathToFile), Project.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result == null) {
            throw new NullPointerException("[OTUS-AUT-ERROR] :: " + Project.class + " can't be read from the file :: " + pathToFile + ".");
        }
        return result;
    }
}
