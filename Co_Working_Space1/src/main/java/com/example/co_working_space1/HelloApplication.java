package com.example.co_working_space1;
import java.io.File;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Co-Working Space");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    /*
        Visitor v = new Visitor("Omar", "20102003Omar", "Formal", 1);
        ArrayList<Visitor> usrData = new ArrayList<Visitor>();
        usrData.add(v);
        FileManagment.WriteUsers(usrData);

       */

        FileManagment.ReadUsers();
        for (Visitor s : FileManagment.usrData)
        {
            System.out.println(s.getUsername() + " " + s.getPassword() + " " + s.getType());
        }
        launch();
        FileManagment.WriteUsers();

    }
}