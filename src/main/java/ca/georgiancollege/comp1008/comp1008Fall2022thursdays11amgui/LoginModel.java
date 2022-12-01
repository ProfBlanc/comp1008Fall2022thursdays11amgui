package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginModel {

    //instance variables
    private String username, password;

    private static final String expectedUsername = "admin", getExpectedPassword = "pass";


    //methods
    public LoginModel(){}

    public void process(String username, String password) throws Exception{
        this.username = username;
        this.password = password;

        //check();
        checkPart2();
    }

    public boolean validate(){
        return username.equals(expectedUsername) && password.equals(getExpectedPassword);
    }

    private void check(){
        if(!validate()){
            throw new IllegalArgumentException("Username and/or Password is incorrect");

        }


    }

    private void checkPart2() throws Exception{

       Path rootPath = Path.of("src", "main", "resources",
                "ca","georgiancollege","comp1008","comp1008Fall2022thursdays11amgui"
        );

        Path dataPath = rootPath.resolve("data");

        if(!dataPath.toFile().exists()){
            Files.createDirectory(dataPath);
        }

        Path userPath = dataPath.resolve(username + ".txt");

        try{
            String content = Files.readString(userPath);
            if(!content.equals(password))
                throw new IllegalArgumentException("Invalid password");
        }
        catch (IOException e){
            throw new Exception("Username " + username + " " +
                    "does not exists");
        }


    }
}
