package com.vitalcare.AgenciaDeSeguros.Igu;

import com.vitalcare.AgenciaDeSeguros.Estructuras.ListaSimple;
import com.vitalcare.AgenciaDeSeguros.Estructuras.Pila;
import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class vitalCareLogin {

    //Variables
    private Pila aseguradoMayor = new Pila(45);
    private ListaSimple aseguradoMenor = new ListaSimple();
    private Scene scene;

    public void initialize() {
        Pane rootPane = new Pane();
        Image plataformaIngresar = new Image(getClass().getResourceAsStream("/imagenes/PantallaIngreso.png"));
        ImageView overlayImageView = new ImageView(plataformaIngresar);
        resizeImage(overlayImageView, 867, 610);
        rootPane.getChildren().add(overlayImageView);

        scene = new Scene(rootPane);
    }

    public void aseguradoASalaDoctor(Asegurado asegurado) {
        if (asegurado.getEdad() > 60) {
            aseguradoMayor.push(asegurado);
        } else {
            aseguradoMenor.insertar(asegurado);
        }
    }

    public void resizeImage(ImageView imageView, double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
    }

    public Scene getScene() {
        return scene;
    }

}
