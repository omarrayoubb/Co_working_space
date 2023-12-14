package com.example.co_working_space1;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitor extends person {
    private String type;
    private int id = 0;

    public Visitor(String username, String password, String type, int id) {
        super(username, password);
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visitor() {
    }

    @Override
    public int login(String username, String password) {

        while (true) {
            for (Visitor i : FileManagment.usrData) {
                System.out.println(i.getUsername() + " " + i.getType());
                if (username.equalsIgnoreCase(i.getUsername()) && password.equals(i.getPassword())) {
                    this.setPassword(i.getPassword());
                    this.setUsername(i.getUsername());
                    id = i.id;
                    type = i.type;
                    System.out.println("User has logged in Successfully");
                    return 0;
                }
            }
        }
    }

    public int Register(String userName, String Password, String type) {

       // String userName, Password, Type;

        // int check = 0;
        for (Visitor i: FileManagment.usrData)
        {
            System.out.println(i.getUsername());
        }
        int id, i = 0;
            //constraints
            if (userName.equalsIgnoreCase("admin")) {
                System.out.println("Please Enter a valid username");
                return (-3);
            }
            if (userName.isEmpty()) {
                System.out.println("Username field is required");
                return (-2);

            }
            if (Password.isEmpty())
            {
                System.out.println("password field is required");
                return -1;

            }
            if (checkPassword(Password) == false)
            {
                return -1;
            }
        // Create the user
        this.setUsername(userName);
        this.setPassword(Password);
        this.type = type;
        FileManagment.usrData.add(this);
        //this.id = id;
        return 0;

    }

    public boolean checkPassword(String password) {
        String Password = password;
        boolean x = false, y = false, z = false, checkPasswordd = false;

        if (Password.length() <= 6) {
            System.out.println("Please write a strong password");
            return checkPasswordd;
        }
        // check = 0;
        for (int i = 0; i < Password.length(); i += 1) {

            if (Password.charAt(i) >= (int) 'A' && Password.charAt(i) <= (int) 'Z') ;
            {
                x = true;
            }
            if (Password.charAt(i) >= (int) '0' && Password.charAt(i) <= (int) '9') {
                y = true;
            } else if (Password.charAt(i) >= (int) 'a' && Password.charAt(i) <= (int) 'z') {
                z = true;
            }
                /*
                if (x == true && y == true && z == true)
                {
                    break;
                }
                 */
        }
        if (x == false || y == false || z == false) {
            System.out.println("Please Enter A strong Password that contains upper and lower case letters and numbers and symbols");
            return checkPasswordd;
        }
        checkPasswordd = true;
        return checkPasswordd;

    }
    /*
    public boolean checkUsername(String name)
    {
        if (name.isEmpty())
            return false;
        else if (name.equalsIgnoreCase("admin"))
        {
            System.out.println("Please Enter a valid username");
            return false;
        }
    }

       */
}
