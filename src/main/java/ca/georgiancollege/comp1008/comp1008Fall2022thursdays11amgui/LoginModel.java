package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

public class LoginModel {

    //instance variables
    private String username, password;

    private static final String expectedUsername = "admin", getExpectedPassword = "pass";


    //methods
    public LoginModel(){}

    public void process(String username, String password){
        this.username = username;
        this.password = password;

        check();
    }

    public boolean validate(){
        return username.equals(expectedUsername) && password.equals(getExpectedPassword);
    }

    private void check(){
        if(!validate()){
            throw new IllegalArgumentException("Username and/or Password is incorrect");

        }


    }
}
