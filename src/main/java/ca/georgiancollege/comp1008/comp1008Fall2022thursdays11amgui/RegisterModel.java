package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import java.nio.file.Files;
import java.nio.file.Path;

public class RegisterModel {

    private String username, password, confirmPassword;

    private static int MIN_LENGTH = 3;
    private static String tooShort = "is too short. At least 3 chars";
    public void process(String username, String password, String confirmPassword)
    throws Exception{
        /*
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
         */
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        createUser();
    }

    public void setUsername(String username) {
        if(username.length() < MIN_LENGTH)
            throw new IllegalArgumentException("Username "+ tooShort);
        this.username = username;
    }

    public void setPassword(String password) {
        if(password.length() < MIN_LENGTH)
            throw new IllegalArgumentException("Password "+ tooShort);
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        if(!password.equals(confirmPassword))
            throw new IllegalArgumentException("Passwords don't match");
        this.confirmPassword = confirmPassword;
    }

    public RegisterModel(){}

    public void process(){}

    private void createUser() throws Exception{

        Path rootPath = Path.of("src", "main", "resources",
                "ca","georgiancollege","comp1008","comp1008Fall2022thursdays11amgui"
                );

        Path dataPath = rootPath.resolve("data");

        if(!dataPath.toFile().exists()){
            Files.createDirectory(dataPath);
        }

        Path userTextFilePath = dataPath.resolve(username + ".txt");
        Files.writeString(userTextFilePath, password);

    }
}
