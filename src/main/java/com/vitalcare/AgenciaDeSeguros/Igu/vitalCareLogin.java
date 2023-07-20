package com.vitalcare.AgenciaDeSeguros.Igu;

import com.vitalcare.AgenciaDeSeguros.Estructuras.ListaSimple;
import com.vitalcare.AgenciaDeSeguros.Estructuras.Pila;
import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;
import com.vitalcare.AgenciaDeSeguros.Logica.AseguradoMayor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vitalCareLogin {

    //Variables
    private Pila PilaAseguradoMayor = new Pila(45);
    private ListaSimple ListaAseguradoMenor = new ListaSimple();
    private Scene scene;

    //Elementos Graficos
    private Pane loginPane;
    private Pane dashboard;
    private PasswordField passwordField;
    private Button loginButton;

    public void initialize() {
        loginPane = new Pane();
        dashboard = new Pane();
        scene = new Scene(crearLoginPane());
    }

    private Pane crearLoginPane() {
        Image plataformaIngresar = new Image(getClass().getResourceAsStream("/imagenes/PantallaIngreso.png"));
        ImageView overlayImageView = new ImageView(plataformaIngresar);
        resizeImage(overlayImageView, 867, 610);
        loginPane.getChildren().add(overlayImageView);
        TextField usernameField = new TextField();
        usernameField.setLayoutX(599); //  X
        usernameField.setLayoutY(290); //  Y
        usernameField.setPrefSize(222, 33);
        loginPane.getChildren().add(usernameField);

        passwordField = new PasswordField();
        passwordField.setLayoutX(636); // X
        passwordField.setLayoutY(330); // Y
        passwordField.setPrefSize(185, 33);
        loginPane.getChildren().add(passwordField);

        loginButton = new Button("Login");
        loginButton.setLayoutX(570); //X
        loginButton.setLayoutY(435); //Y
        loginButton.setPrefSize(166, 40);
        loginPane.getChildren().add(loginButton);
        return loginPane;
    }

    public void aseguradoASalaDoctor(Asegurado asegurado) {
        if (asegurado.getEdad() > 60) {
            AseguradoMayor aseguradoMayor = new AseguradoMayor(
                    null,
                    0,
                    asegurado.getEdad(),
                    asegurado.getProvincia(),
                    asegurado.getDireccion(),
                    asegurado.getTelefono(),
                    asegurado.getCedula(),
                    asegurado.getNombre()
            );
            PilaAseguradoMayor.push(aseguradoMayor);
        } else {
            ListaAseguradoMenor.insertar(asegurado);
        }
    }

    public void resizeImage(ImageView imageView, double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
    }

    public void mostarMensaje(String tipo, String titulo, String mensaje) {
        if (tipo.equals("alerta")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
        } else if (tipo.equals("error")) {
            //Mensaje de error
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle(titulo);
            error.setHeaderText(null);
            error.setContentText(mensaje);
            error.showAndWait();
        }
    }

    public void verificarCredenciales() {

    }

    public Scene getScene() {
        return scene;
    }

}
