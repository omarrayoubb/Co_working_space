package com.example.co_working_space1;

import java.io.*;
import java.util.ArrayList;

public class FileManagment {
    public static ArrayList<Visitor> usrData = new ArrayList<Visitor>();
    public static ArrayList<Visitor> ReadUsers()
    {
        try
        {
            FileInputStream users = new FileInputStream("Users.txt");
            ObjectInputStream objusers = new ObjectInputStream(users);
            usrData = (ArrayList<Visitor>) objusers.readObject();
            return usrData;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void WriteUsers() {
        try {
            FileOutputStream fileUsr = new FileOutputStream("Users.txt");
            ObjectOutputStream objUsr = new ObjectOutputStream(fileUsr);
            objUsr.writeObject(usrData);
            objUsr.close();
            fileUsr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
