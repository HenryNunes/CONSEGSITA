package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    //public class Controller implements Initializable {

    @FXML
    private TextField fileName;

    public void openExplorer(ActionEvent actionEvent){
        // create a File chooser
        FileChooser file_chooser = new FileChooser();
        // get the file selected
        File file = file_chooser.showOpenDialog(Main.getMainScene().getWindow());
        if (file != null) {
            fileName.setText(file.getAbsolutePath() + "  selected");
        }
    }


    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldInteger(fileName);
        Constraints.setTextFieldMaxLength(txtName, 70);
        Constraints.setTextFieldDouble(txtBaseSalary);
        Constraints.setTextFieldMaxLength(txtEmail, 60);
        Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");

        initializeComboBoxDepartment();
    }*/

}
