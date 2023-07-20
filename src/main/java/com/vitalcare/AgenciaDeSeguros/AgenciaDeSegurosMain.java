package com.vitalcare.AgenciaDeSeguros;

import com.vitalcare.AgenciaDeSeguros.Igu.SalaPrincipal;
import com.vitalcare.AgenciaDeSeguros.Igu.vitalCareLogin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgenciaDeSegurosMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Se crea un Pane para usarse como rootPane
        Pane rootPane = new Pane();
        Scene scene = new Scene(rootPane);
        scene.getStylesheets().add(getClass().getResource("/css/design.css").toExternalForm());

        // Se crea un TabPane
        TabPane tabPane = new TabPane();
        tabPane.getStyleClass().add("custom-tab-pane");
        // Se crea un Tab para el pane SalaPrincipal
        Tab salaPrincipalTab = new Tab("Sala Principal");
        salaPrincipalTab.setClosable(false);//Hace que el Tab no se pueda cerrar 
        // Se crea un Pane para usarse como salaPrincipal
        SalaPrincipal salaPrincipal = new SalaPrincipal();
        Pane salaPrincipalPane = new Pane();
        salaPrincipal.initialize();
        salaPrincipalPane.getChildren().add(salaPrincipal.getScene().getRoot());
        salaPrincipalTab.setContent(salaPrincipalPane);
        // Se crea otro Tab para el pane VitalCarePlataforma
        Tab vitalCareLoginTab = new Tab("Plataforma");
        vitalCareLoginTab.setClosable(false);
        // Se crea un Pane para usarse como vcLogin
        vitalCareLogin vcLogin = new vitalCareLogin();
        Pane vcLoginPane = new Pane();
        vcLogin.initialize();
        vcLoginPane.getChildren().add(vcLogin.getScene().getRoot());
        vitalCareLoginTab.setContent(vcLoginPane);
        // Se agrega el Tab SalaPrincipal y vcLogin al TabPane
        tabPane.getTabs().add(salaPrincipalTab);
        tabPane.getTabs().add(vitalCareLoginTab);
        // Se agrega el TabPane al Pane rootPane
        rootPane.getChildren().add(tabPane);

        // Set the application window icon
        Image windowIcon = new Image(getClass().getResourceAsStream("/imagenes/LogoIcono.png"));
        primaryStage.getIcons().add(windowIcon);


        //Terminar el programa al cerrar la ventana
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            Platform.exit();
            System.exit(0);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("VitalCare");
        primaryStage.setWidth(858);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
