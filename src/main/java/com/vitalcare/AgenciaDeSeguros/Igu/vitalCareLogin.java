package com.vitalcare.AgenciaDeSeguros.Igu;

import com.vitalcare.AgenciaDeSeguros.Estructuras.Pila;
import com.vitalcare.AgenciaDeSeguros.Logica.Administrador;
import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;
import com.vitalcare.AgenciaDeSeguros.Logica.AseguradoMayor;
import com.vitalcare.AgenciaDeSeguros.Logica.Empleado;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class vitalCareLogin {

    //Variables
    private static final Pila pilaAseguradoMayor = new Pila(45);
    private static final Pila pilaAseguradoMenor = new Pila(45);
    private boolean tipoUsuario;
    private boolean asegMayor = true;
    private Scene scene;

    //Elementos Graficos
    private Pane loginPane;
    private Pane dashboardPane;
    private TextField usernameField;
    private PasswordField passwordField;
    private SmoothButton loginButton;
    private Button btnCambiarTabla;
    private TableView<Asegurado> asegMenorTable = new TableView<>();
    private TableView<AseguradoMayor> asegMayorTable = new TableView<>();
    private final Label lblcredenIncorrectas = new Label();
    private final Label lblAsegMayores = new Label();
    private final Label lblAsegMenores = new Label();

    public void setAsegMayorTable(TableView<AseguradoMayor> asegMayorTable) {
        this.asegMayorTable = asegMayorTable;
    }

    public void initialize() {
        loginPane = loginPane();
        dashboardPane = dashboardPane();
        initializeStaticData();
        scene = new Scene(loginPane);
    }

    private void initializeStaticData() {
        // Se agrega un asegurado estatico para mostrarlo en la tabla de mayores siempre
        AseguradoMayor staticAsegMayor1 = new AseguradoMayor("Maria Rodriguez", 86413810, 68, "San José", "Escazú", 65317850, null, 204560851, "Carlos Bolaños");
        pilaAseguradoMayor.push(staticAsegMayor1);
        asegMayorTable.getItems().add(staticAsegMayor1);

        // Se agrega un asegurado estatico para mostrarlo en la tabla de menores siempre
        Asegurado staticAsegMenor2 = new Asegurado(28, "Cartago", "Turrialba", 86512318, null, 405690894, "Corina Fernandez");
        pilaAseguradoMenor.push(staticAsegMenor2);
        asegMenorTable.getItems().add(staticAsegMenor2);

    }

    private Pane loginPane() {
        Pane loginPane = new Pane();
        Image plataformaIngresar = new Image(getClass().getResourceAsStream("/imagenes/PantallaIngreso.png"));
        ImageView overlayImageView = new ImageView(plataformaIngresar);
        resizeImage(overlayImageView, 867, 610);
        loginPane.getChildren().add(overlayImageView);
        usernameField = new TextField();
        usernameField.setLayoutX(599);
        usernameField.setLayoutY(290);
        usernameField.setPrefSize(222, 33);
        loginPane.getChildren().add(usernameField);

        passwordField = new PasswordField();
        passwordField.setLayoutX(636);
        passwordField.setLayoutY(330);
        passwordField.setPrefSize(185, 33);
        loginPane.getChildren().add(passwordField);

        loginButton = new SmoothButton("Login");
        loginButton.getStyleClass().addAll("my-button", "secondary");
        loginButton.setLayoutX(563);
        loginButton.setLayoutY(435);
        loginButton.setPrefSize(166, 40);
        loginButton.setOnAction(e -> {
            verificarCredenciales();
        });
        loginPane.getChildren().add(loginButton);

        lblcredenIncorrectas.setText("Usuario o Contraseña Incorrectas");
        lblcredenIncorrectas.setLayoutX(534);
        lblcredenIncorrectas.setLayoutY(385);
        lblcredenIncorrectas.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        lblcredenIncorrectas.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);"
                + "-fx-border-radius: 3; "
                + "-fx-background-radius: 3;"
                + "-fx-text-fill: darkred;");
        lblcredenIncorrectas.setPadding(new Insets(7)); // Adjust padding to make background slightly larger
        lblcredenIncorrectas.setVisible(false);
        loginPane.getChildren().add(lblcredenIncorrectas);

        return loginPane;
    }

    private Pane dashboardPane() {

        Pane dashboardPane = new Pane();
        Image plataformaIngresar = new Image(getClass().getResourceAsStream("/imagenes/FondoSalaEspera.png"));
        ImageView overlayImageView = new ImageView(plataformaIngresar);
        resizeImage(overlayImageView, 867, 610);
        dashboardPane.getChildren().add(overlayImageView);

        Pane paneIzquierdo = new Pane();
        paneIzquierdo.setLayoutX(0);
        paneIzquierdo.setLayoutY(0);
        paneIzquierdo.setPrefWidth(175);
        paneIzquierdo.setPrefHeight(600);
        paneIzquierdo.setStyle("-fx-background-color: linear-gradient(to bottom, #005C77, #00A8E8);");
        dashboardPane.getChildren().add(paneIzquierdo);

        aseguradosTabla();
        asegMayorTable.setPrefSize(600, 400);
        asegMayorTable.setLayoutX(210);
        asegMayorTable.setLayoutY(98);
        asegMayorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        asegMenorTable.setPrefSize(600, 400);
        asegMenorTable.setLayoutX(210);
        asegMenorTable.setLayoutY(98);
        asegMenorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        btnCambiarTabla = new Button("Cambiar Tabla");
        btnCambiarTabla.setLayoutX(210);
        btnCambiarTabla.setLayoutY(20);
        btnCambiarTabla.setOnAction(e -> {
            if (asegMayor) {
                dashboardPane.getChildren().remove(asegMayorTable);
                dashboardPane.getChildren().add(asegMenorTable);
                lblAsegMayores.setVisible(false);
                lblAsegMenores.setVisible(true);
            } else {
                dashboardPane.getChildren().remove(asegMenorTable);
                dashboardPane.getChildren().add(asegMayorTable);
                lblAsegMayores.setVisible(true);
                lblAsegMenores.setVisible(false);
            }
            asegMayor = !asegMayor;
        });
        dashboardPane.getChildren().addAll(asegMayorTable, btnCambiarTabla);

        lblAsegMayores.setText("Asegurados Mayores de 60 años");
        lblAsegMayores.setLayoutX(210);
        lblAsegMayores.setLayoutY(78);
        lblAsegMayores.getStyleClass().add("titulo-label");
        dashboardPane.getChildren().add(lblAsegMayores);

        lblAsegMenores.setText("Asegurados Menores de 60 años");
        lblAsegMenores.setLayoutX(210);
        lblAsegMenores.setLayoutY(78);
        lblAsegMenores.setVisible(false);
        lblAsegMenores.getStyleClass().add("titulo-label");
        dashboardPane.getChildren().add(lblAsegMenores);
        


        return dashboardPane;
    }

    public void actualizarTabla() {
        if (!pilaAseguradoMayor.pilaVacia()) {
            Pila tempPilaAseguradoMayor = new Pila(45);
            Pila tempPilaAseguradoMenor = new Pila(45);
            // Se copian los datos de pilaAseguradoMayor a tempPilaAseguradoMayor
            while (!pilaAseguradoMayor.pilaVacia()) {
                AseguradoMayor aseguradoMayor = (AseguradoMayor) pilaAseguradoMayor.pop();
                tempPilaAseguradoMayor.push(aseguradoMayor);
            }
            // Se copian los datos de pilaAseguradoMenor a tempPilaAseguradoMenor
            while (!pilaAseguradoMenor.pilaVacia()) {
                Asegurado aseguradoMenor = (Asegurado) pilaAseguradoMenor.pop();
                tempPilaAseguradoMenor.push(aseguradoMenor);
            }
            // Se limpia los datos actuales que estan en la tabla
            asegMayorTable.getItems().clear();
            asegMenorTable.getItems().clear();
            // Se agregan los asegurados desde tempPilaAseguradoMayor a la tabla asegMayorTable y se regresan los datos a la pila inicial
            while (!tempPilaAseguradoMayor.pilaVacia()) {
                AseguradoMayor aseguradoMayor = (AseguradoMayor) tempPilaAseguradoMayor.pop();
                asegMayorTable.getItems().add(aseguradoMayor);
                pilaAseguradoMayor.push(aseguradoMayor);
            }
            // Se agregan los asegurados desde tempPilaAseguradoMenor a la tabla asegMenorTable y se regresan los datos a la pila inicial
            while (!tempPilaAseguradoMenor.pilaVacia()) {
                Asegurado aseguradoMenor = (Asegurado) tempPilaAseguradoMenor.pop();
                asegMenorTable.getItems().add(aseguradoMenor);
                pilaAseguradoMenor.push(aseguradoMenor);
            }
            asegMayorTable.refresh();
            asegMenorTable.refresh();
            System.out.println("Tabla actualizada");
            //rootPane.getScene().getWindow().sizeToScene();

        }
    }

    public void aseguradoASalaDoctor(Asegurado asegurado) {
        if (asegurado.getEdad() >= 60) {
            AseguradoMayor aseguradoMayor = new AseguradoMayor("",
                    0,
                    asegurado.getEdad(),
                    asegurado.getProvincia(),
                    asegurado.getDireccion(),
                    asegurado.getTelefono(),
                    null,
                    asegurado.getCedula(),
                    asegurado.getNombre());
            pilaAseguradoMayor.push(aseguradoMayor);
            System.out.println(aseguradoMayor.getEdad());
        } else {
            pilaAseguradoMenor.push(asegurado);
            System.out.println(asegurado.getEdad());
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

    public void verificarCredenciales() { // STEPH!! Se comenta parte del codigo para omitir el sign in y facilitar el desarrollo del codigo

//        String contrasenia = passwordField.getText();
//        String usuario = usernameField.getText();
//
//        if ((administrador1.getUsuario().equals(usuario) && administrador1.getContrasenia().equals(contrasenia))
//                || (administrador2.getUsuario().equals(usuario) && administrador2.getContrasenia().equals(contrasenia))
//                || (administrador3.getUsuario().equals(usuario) && administrador3.getContrasenia().equals(contrasenia))) {
//            tipoUsuario = true;
//            credencialesCorrectos();
//        } else if ((empleado1.getUsuario().equals(usuario) && empleado1.getContrasenia().equals(contrasenia))
//                || (empleado2.getUsuario().equals(usuario) && empleado2.getContrasenia().equals(contrasenia))
//                || (empleado3.getUsuario().equals(usuario) && empleado3.getContrasenia().equals(contrasenia))) {
//            tipoUsuario = false;
        credencialesCorrectos();

//        } else {
//            credenIncorrectas.setVisible(true);
//        }
    }

    public void credencialesCorrectos() {
        loginPane.getChildren().add(dashboardPane);
    }

    public void aseguradosTabla() {

        // TABLA MAYORES
        TableColumn cedulaColMayor = new TableColumn<AseguradoMayor, Integer>("Cédula");
        cedulaColMayor.setCellValueFactory(new PropertyValueFactory<AseguradoMayor, Integer>("cedula"));

        TableColumn nombreColMayor = new TableColumn<AseguradoMayor, String>("Nombre");
        nombreColMayor.setCellValueFactory(new PropertyValueFactory<AseguradoMayor, String>("nombre"));

        TableColumn edadColMayor = new TableColumn<AseguradoMayor, Integer>("Edad");
        edadColMayor.setCellValueFactory(new PropertyValueFactory<AseguradoMayor, Integer>("edad"));

        TableColumn provinciaColMayor = new TableColumn<AseguradoMayor, String>("Provincia");
        provinciaColMayor.setCellValueFactory(new PropertyValueFactory<AseguradoMayor, String>("provincia"));

        TableColumn telefonoColMayor = new TableColumn<AseguradoMayor, Integer>("Teléfono");
        telefonoColMayor.setCellValueFactory(new PropertyValueFactory<AseguradoMayor, Integer>("telefono"));

        // TABLA MENORES
        TableColumn cedulaColMenor = new TableColumn<Asegurado, Integer>("Cédula");
        cedulaColMenor.setCellValueFactory(new PropertyValueFactory<>("cedula"));

        TableColumn nombreColMenor = new TableColumn<Asegurado, String>("Nombre");
        nombreColMenor.setCellValueFactory(new PropertyValueFactory<Asegurado, String>("nombre"));

        TableColumn edadColMenor = new TableColumn<Asegurado, Integer>("Edad");
        edadColMenor.setCellValueFactory(new PropertyValueFactory<Asegurado, Integer>("edad"));

        TableColumn provinciaColMenor = new TableColumn<Asegurado, String>("Provincia");
        provinciaColMenor.setCellValueFactory(new PropertyValueFactory<Asegurado, String>("provincia"));

        TableColumn<Asegurado, Integer> telefonoColMenor = new TableColumn<>("Teléfono");
        telefonoColMenor.setCellValueFactory(new PropertyValueFactory<Asegurado, Integer>("telefono"));

        asegMayorTable.getColumns().addAll(cedulaColMayor, nombreColMayor, edadColMayor, provinciaColMayor, telefonoColMayor);
        asegMenorTable.getColumns().addAll(cedulaColMenor, nombreColMenor, edadColMenor, provinciaColMenor, telefonoColMenor);

    }

    public Scene getScene() {
        return scene;
    }

    //Simulación de base de datos de credenciales
    //=======================================================ADMINISTRADORES=======================================================
    private final Administrador administrador1 = new Administrador(true, "Cumplimiento normativo y políticas", true,
            "Jvargasc852", "123", 901150852, "Joseph Vargas");
    private final Administrador administrador2 = new Administrador(true, "Gestión estratégica y financiera", true,
            "Rdelgadoa650", "123", 11111111, "Rossanne Delgado");
    private final Administrador administrador3 = new Administrador(true, "Optimización de procesos", true,
            "Sspieringx902", "123", 11111111, "Stephanie Spiering");

    //=======================================================EMPLEADOS=============================================================
    private final Empleado empleado1 = new Empleado(true, "Especialista en reclamaciones médicas", true,
            "Aperezd624", "123", 30123456, "Ana Pérez");
    private final Empleado empleado2 = new Empleado(false, "Atención al cliente y consultas de seguros", true,
            "Mgarciar942", "123", 40876543, "Mario García");
    private final Empleado empleado3 = new Empleado(true, "Gestión de cobertura y beneficios", false,
            "Lmartinezc156", "123", 70543210, "Laura Martínez");

}
