package com.example.co_working_space1;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import java.net.URL;
import java.util.ResourceBundle;

public class Users implements Initializable {

    String username, password, typee;
    String[] types = {"General", "Formal", "Instructor"};
    Stage stage = new Stage();
    Scene scene;

    Visitor vs = new Visitor();

    @FXML
    TextField user, newuser;

    @FXML
    PasswordField pass, newPassword;
    @FXML
    Button logg;
    @FXML
    Button register;
    @FXML
    ChoiceBox<String> type = new ChoiceBox<String>();


    public Users() {

    }

    public Users(Stage stage) {
        this.stage = stage;
    }

    public void log(ActionEvent event) {
        username = user.getText();
        password = pass.getText();
        Stage stage1 = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (vs.login(username, password) == 0) {

            System.out.println("User has logged in successfully");
            changeScene("hello.fxml", stage1);
        } else {
            System.out.println("Login failed");
        }
    }
    public void homePage(ActionEvent event)
    {
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (event.getSource() == logg)
        {
            changeScene("Login.fxml", stage);
        }
        else if (event.getSource() == register)
        {
            changeScene("Register.fxml", stage);
        }
    }

// method for changing scenes in user
    public void changeScene(String sceneName, Stage stage1) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root = (Parent) loader.load();
            Scene newScene = new Scene(root);
            stage1.setScene(newScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void reg(ActionEvent event) {
        boolean x = false;
            // store the user name and password
            username = newuser.getText();
            password = newPassword.getText();
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            // check this event is button or choiceBox (handling this event)
            if (event.getSource() == type) {
                typee = type.getValue();
            }
            typee = type.getSelectionModel().getSelectedItem();
            System.out.println(typee);

            if (vs.Register(username, password, typee) == 0) {
                System.out.println(username + password);
                x = true;
                System.out.println("User has regestired successifully");
            } else {
                System.out.println("user are not available");
            }
            if (x == false)
            {
                stage.getScene().getWindow();
                newuser.deleteText(0, username.length());
                newPassword.deleteText(0, password.length());
                type.setValue(null);
            }
            else {
                changeScene("Login.FXML", stage);
            }
    }

    // to implement the choiceBox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().addAll(types);
    }


}