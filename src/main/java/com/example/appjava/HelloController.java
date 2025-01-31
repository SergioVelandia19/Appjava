package com.example.appjava;

import com.example.appjava.DAO.UsuarioDAOimplement;
import com.example.appjava.Jbcrip.jbcrip;
import com.example.appjava.entidad.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private VBox vbox;
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Clave;
    @FXML
    private TextField Correo;
    @FXML
    private GridPane pane;
    @FXML
    private Button ingresar;
    @FXML
    private void btnCerrar_Click(ActionEvent e) throws IOException {
        cerrarVentana(e);
    }

    private static final UsuarioDAOimplement usuarioDAOimplement = UsuarioDAOimplement.getintance();

    //Ingresar datos a la bd
    public void ingresar() {
        try{

            String correo_usurio = Correo.getText();
            String nombre_usuario = Nombre.getText();
            String clave  = Clave.getText();
            if (correo_usurio != null && nombre_usuario != null && clave != null){
                usuarioDAOimplement.Agregar(new Usuario(correo_usurio,nombre_usuario, jbcrip.hashear(clave)));
            }else {
                System.out.println("Error");
            }
            Correo.setText(" ");
            Nombre.setText(" ");
            Clave.setText(" ");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    public static void cerrarVentana(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Informacion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),470,340);
        Stage stage = new Stage();
        scene.getStylesheets().add(HelloController.class.getResource("Informacion.css").toExternalForm());
        stage.setTitle("Velmon");
        stage.setScene(scene);
        stage.show();
        Node source = (Node) e.getSource();     //Me devuelve el elemento al que hice click
        Stage stage1 = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage1.close();//Me cierra la ventana
    }




    public void Recuperarcuenta(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Recuperar-Cuenta.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),470,340);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("SecondStyles.css").toExternalForm());
        stage.setTitle("Recupera tu cuenta");
        stage.setScene(scene);
        stage.show();


    }

    public void IniciarSesion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Iniciar-Sesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),480,340);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("IniciarSesion.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}