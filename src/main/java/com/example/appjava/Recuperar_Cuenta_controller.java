package com.example.appjava;

import com.example.appjava.DAO.UsuarioDAOimplement;
import com.example.appjava.Jbcrip.jbcrip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Recuperar_Cuenta_controller {
    @FXML
    private Button button;
    @FXML
    private TextField clavenueva;
    @FXML
    private TextField correoeditar;
    @FXML
    private Label mensaje;

    private static final UsuarioDAOimplement usuarioDAOimplement = UsuarioDAOimplement.getintance();


    public void onclick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene2 = new Scene(parent);
        stage.setTitle("Inicio");
        stage.setScene(scene2);
        stage.show();
    }

    public void Actualizar(ActionEvent actionEvent) {
        usuarioDAOimplement.actualizar(correoeditar.getText(), jbcrip.hashear(clavenueva.getText()));
        mensaje.setVisible(true);
    }
}
