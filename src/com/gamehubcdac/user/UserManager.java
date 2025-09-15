package com.gamehubcdac.user;

import java.util.HashMap;

public class UserManager {
//    Register User
//➔ Input: Username, Email
//➔ Validation: Username must be unique
//➔ Output: Confirmation message

    public void registerUser(HashMap<String,String> users, String username, String email){
            users.put(username, email);
            System.out.println(username+" registered with email "+email);
    }




//● View Users
//➔ Output: List of all registered users

    public void viewUsers(HashMap<String, String> users) {

        System.out.println(users);
    }


}
