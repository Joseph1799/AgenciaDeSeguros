package com.vitalcare.AgenciaDeSeguros.Igu;

import com.vitalcare.AgenciaDeSeguros.Estructuras.Pila;
import com.vitalcare.AgenciaDeSeguros.Logica.Administrador;
import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;
import com.vitalcare.AgenciaDeSeguros.Logica.AseguradoMayor;
import com.vitalcare.AgenciaDeSeguros.Logica.Doctor;
import com.vitalcare.AgenciaDeSeguros.Logica.Empleado;
import com.vitalcare.AgenciaDeSeguros.Logica.ExpedienteAsegurado;
import com.vitalcare.AgenciaDeSeguros.Logica.Seguro;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class vitalCareLogin {

    //Variables
    private static final Pila pilaAseguradoMayor = new Pila(45);
    private static final Pila pilaAseguradoMenor = new Pila(45);
    private static final Pila pilaDoctores = new Pila(100);
    private static final Pila pilaEmpleados = new Pila(100);
    private boolean tipoUsuario;
    private boolean asegMayor = true;
    private Scene scene;
    TextField txtCedula = new TextField();
    TextField txtNombre = new TextField();

    //Instancias
    private final ExpedienteAsegurado expediente = new ExpedienteAsegurado();

    //Elementos Graficos
    private Pane loginPane;
    private Pane dashboardPane;
    private Pane doctoresPane = new Pane();
    private Pane empleadosPane = new Pane();
    private Pane aseguradosPane = new Pane();
    private TextField usernameField;
    private PasswordField passwordField;
    private SmoothButton loginButton;
    private Button btnCambiarTabla;
    private Button btnMostrarDoctores;
    private Button btnMostrarEmpleados;
    private Button btnMostrarAsegurados;
    private Button btnCerrarSesion;
    private TableView<Asegurado> asegMenorTable = new TableView<>();
    private TableView<AseguradoMayor> asegMayorTable = new TableView<>();
    private TableView<Doctor> doctoresTable = new TableView<>();
    private TableView<Empleado> empleadosTable = new TableView<>();
    private final Label lblcredenIncorrectas = new Label();
    private final Label lblAsegMayores = new Label();
    private final Label lblAsegMenores = new Label();
    TextField txtEdad = new TextField();
    TextField txtProvincia = new TextField();
    TextField txtTelefono = new TextField();
    TextField txtDireccion = new TextField();
    TextField txtTelPariente = new TextField();
    TextField txtNomPariente = new TextField();
    TextField txtMonto = new TextField();
    TextArea txtObservaciones = new TextArea();

    public void setAsegMayorTable(TableView<AseguradoMayor> asegMayorTable) {
        this.asegMayorTable = asegMayorTable;
    }

    public void setAsegMenorTable(TableView<Asegurado> asegMenorTable) {
        this.asegMayorTable = asegMayorTable;
    }

    public void initialize() {
        loginPane = loginPane();
        dashboardPane = dashboardPane();
        initializeStaticData();
        scene = new Scene(loginPane);
    }

    private void initializeStaticData() {
        agregarEmpleados();
        // Se agrega un asegurado estatico para mostrarlo en la tabla de mayores siempre
        expediente.nuevoExpediente();
        int idExpediente = expediente.getIdExpediente();
        System.out.println(expediente.getIdExpediente());
        Seguro staticSeguro = new Seguro(true, 150000);
        LocalDate fechaHoy = LocalDate.now();
        ExpedienteAsegurado staticExpediente = new ExpedienteAsegurado(staticSeguro,
                "Realizó una consulta médica por problemas respiratorios recurrentes. "
                + "Se le diagnosticó con asma leve y se le prescribió un inhalador preventivo para usarlo diariamente.",
                fechaHoy, idExpediente);
        AseguradoMayor staticAsegMayor1 = new AseguradoMayor("Maria Rodriguez", 86413810, 68, "San José", "Escazú", 65317850, staticExpediente, 204560851, "Carlos Bolaños");
        pilaAseguradoMayor.push(staticAsegMayor1);
        asegMayorTable.getItems().add(staticAsegMayor1);

        // Se agrega un asegurado estatico para mostrarlo en la tabla de menores siempre
        expediente.nuevoExpediente();
        idExpediente = expediente.getIdExpediente();
        Seguro staticSeguro2 = new Seguro(true, 150000);
        ExpedienteAsegurado staticExpediente2 = new ExpedienteAsegurado(staticSeguro2, "Se sometió a una"
                + " cirugía menor para la extracción de la vesícula biliar debido a la presencia de cálculos. "
                + "La operación fue exitosa y no hubo complicaciones.",
                fechaHoy, idExpediente);
        Asegurado staticAsegMenor2 = new Asegurado(28, "Cartago", "Turrialba", 86512318, staticExpediente2, 405690894, "Corina Fernandez");
        pilaAseguradoMenor.push(staticAsegMenor2);
        asegMenorTable.getItems().add(staticAsegMenor2);

        // DATOS ESTATICOS DE DOCTORES
        Doctor doctor1 = new Doctor("Cardiología", 12, "Doctor en Medicina", 50123456, "Dr. Roberto Sánchez");
        pilaDoctores.push(doctor1);
        doctoresTable.getItems().add(doctor1);
        Doctor doctor2 = new Doctor("Neurología", 15, "Doctor en Medicina", 50123457, "Dra. Andrea Jiménez");
        pilaDoctores.push(doctor2);
        doctoresTable.getItems().add(doctor2);
        Doctor doctor3 = new Doctor("Pediatría", 8, "Doctor en Medicina", 50123458, "Dra. Luisa Fernández");
        pilaDoctores.push(doctor3);
        doctoresTable.getItems().add(doctor3);
        Doctor doctor4 = new Doctor("Dermatología", 10, "Doctor en Medicina", 50123459, "Dr. Mario Vargas");
        pilaDoctores.push(doctor4);
        doctoresTable.getItems().add(doctor4);
        Doctor doctor5 = new Doctor("Gastroenterología", 14, "Doctor en Medicina", 50123460, "Dra. Patricia Solís");
        pilaDoctores.push(doctor5);
        doctoresTable.getItems().add(doctor5);
        Doctor doctor6 = new Doctor("Ortopedia", 20, "Doctor en Medicina", 50123461, "Dr. Felipe Mora");
        pilaDoctores.push(doctor6);
        doctoresTable.getItems().add(doctor6);
        Doctor doctor7 = new Doctor("Endocrinología", 9, "Doctor en Medicina", 50123462, "Dra. Carla Rojas");
        pilaDoctores.push(doctor7);
        doctoresTable.getItems().add(doctor7);

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

        // --------PANE IZQUIERDO-------
        Pane paneIzquierdo = new Pane();
        paneIzquierdo.setLayoutX(0);
        paneIzquierdo.setLayoutY(0);
        paneIzquierdo.setPrefWidth(175);
        paneIzquierdo.setPrefHeight(600);
        paneIzquierdo.setStyle("-fx-background-color: linear-gradient(to bottom, #005C77, #00A8E8);");
        dashboardPane.getChildren().add(paneIzquierdo);

        btnMostrarDoctores = new Button("Doctores");
        btnMostrarDoctores.getStyleClass().addAll("my-button", "primary");
        btnMostrarDoctores.setPrefWidth(111);
        btnMostrarDoctores.setLayoutX(33);
        btnMostrarDoctores.setLayoutY(110);
        btnMostrarDoctores.setOnAction(e -> {
            doctoresPane.setVisible(true);
            empleadosPane.setVisible(false);
            aseguradosPane.setVisible(false);
        });
        paneIzquierdo.getChildren().add(btnMostrarDoctores);

        btnMostrarEmpleados = new Button("Empleados");
        btnMostrarEmpleados.getStyleClass().addAll("my-button", "primary");
        btnMostrarEmpleados.setPrefWidth(111);
        btnMostrarEmpleados.setLayoutX(33);
        btnMostrarEmpleados.setLayoutY(180);
        btnMostrarEmpleados.setOnAction(e -> {
            empleadosPane.setVisible(true);
            doctoresPane.setVisible(false);
            aseguradosPane.setVisible(false);
        });
        paneIzquierdo.getChildren().add(btnMostrarEmpleados);

        btnMostrarAsegurados = new Button("Asegurados");
        btnMostrarAsegurados.getStyleClass().addAll("my-button", "primary");
        btnMostrarAsegurados.setPrefWidth(111);
        btnMostrarAsegurados.setLayoutX(33);
        btnMostrarAsegurados.setLayoutY(250);
        btnMostrarAsegurados.setOnAction(e -> {
            aseguradosPane.setVisible(true);
            empleadosPane.setVisible(false);
            doctoresPane.setVisible(false);
        });
        paneIzquierdo.getChildren().add(btnMostrarAsegurados);

        btnCerrarSesion = new Button("Cerrar Sesión");
        btnCerrarSesion.getStyleClass().addAll("my-button", "primary");
        btnCerrarSesion.setPrefWidth(125);
        btnCerrarSesion.setLayoutX(25);
        btnCerrarSesion.setLayoutY(480);
        btnCerrarSesion.setOnAction(e -> {
            loginPane.getChildren().remove(dashboardPane);
        });
        paneIzquierdo.getChildren().add(btnCerrarSesion);
        // -------FIN PANE IZQUIERDO-------

        doctoresPane(dashboardPane);
        empleadosPane(dashboardPane);
        aseguradosPane(dashboardPane);

        return dashboardPane;
    }

    private void doctoresPane(Pane dashboardPane) {
        doctoresPane.setLayoutX(175);
        doctoresPane.setLayoutY(0);
        doctoresPane.setPrefWidth(670);
        doctoresPane.setPrefHeight(600);
        doctoresPane.setVisible(false);
        dashboardPane.getChildren().add(doctoresPane);

        doctoresTabla();
        doctoresTable.setPrefSize(600, 400);
        doctoresTable.setLayoutX(30);
        doctoresTable.setLayoutY(98);
        doctoresTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        doctoresPane.getChildren().add(doctoresTable);

        Label lblDocTitulo = new Label();
        labelPropiedades(doctoresPane, lblDocTitulo, 30, 50, "Tabla de Doctores Registrados", 23);

    }

    private void empleadosPane(Pane dashboardPane) {
        empleadosPane.setLayoutX(175);
        empleadosPane.setLayoutY(0);
        empleadosPane.setPrefWidth(670);
        empleadosPane.setPrefHeight(600);
        empleadosPane.setVisible(false);
        dashboardPane.getChildren().add(empleadosPane);

        empleadosTabla();
        empleadosTable.setPrefSize(600, 400);
        empleadosTable.setLayoutX(30);
        empleadosTable.setLayoutY(98);
        empleadosTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        empleadosPane.getChildren().add(empleadosTable);

        Label lblEmpTitulo = new Label();
        labelPropiedades(empleadosPane, lblEmpTitulo, 30, 50, "Tabla de Empleados Registrados", 23);

    }

    private void aseguradosPane(Pane dashboardPane) {
        aseguradosPane.setLayoutX(175);
        aseguradosPane.setLayoutY(0);
        aseguradosPane.setPrefWidth(670);
        aseguradosPane.setPrefHeight(600);
        dashboardPane.getChildren().add(aseguradosPane);

        aseguradosTabla();
        asegMayorTable.setPrefSize(600, 400);
        asegMayorTable.setLayoutX(30);
        asegMayorTable.setLayoutY(98);
        asegMayorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        asegMayorTable.setRowFactory(tv -> {
            TableRow<AseguradoMayor> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    AseguradoMayor aseuradoMayor = row.getItem();
                    ventanaEmergenteAsegurado(aseuradoMayor, null);
                }
            });
            return row;
        });
        asegMenorTable.setPrefSize(600, 400);
        asegMenorTable.setLayoutX(30);
        asegMenorTable.setLayoutY(98);
        asegMenorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        asegMenorTable.setRowFactory(tv -> {
            TableRow<Asegurado> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Asegurado aseuradoMenor = row.getItem();
                    ventanaEmergenteAsegurado(null, aseuradoMenor);
                }
            });
            return row;
        });

        btnCambiarTabla = new Button("Cambiar Tabla");
        btnCambiarTabla.getStyleClass().addAll("my-button", "secondary");
        btnCambiarTabla.setLayoutX(30);
        btnCambiarTabla.setLayoutY(20);
        btnCambiarTabla.setOnAction(e -> {
            if (asegMayor) {
                aseguradosPane.getChildren().remove(asegMayorTable);
                aseguradosPane.getChildren().add(asegMenorTable);
                lblAsegMayores.setVisible(false);
                lblAsegMenores.setVisible(true);
            } else {
                aseguradosPane.getChildren().remove(asegMenorTable);
                aseguradosPane.getChildren().add(asegMayorTable);
                lblAsegMayores.setVisible(true);
                lblAsegMenores.setVisible(false);
            }
            asegMayor = !asegMayor;
        });
        aseguradosPane.getChildren().addAll(asegMayorTable, btnCambiarTabla);

        lblAsegMayores.setText("Asegurados Mayores de 60 años");
        lblAsegMayores.setLayoutX(30);
        lblAsegMayores.setLayoutY(78);
        lblAsegMayores.getStyleClass().add("titulo-label");
        aseguradosPane.getChildren().add(lblAsegMayores);

        lblAsegMenores.setText("Asegurados Menores de 60 años");
        lblAsegMenores.setLayoutX(30);
        lblAsegMenores.setLayoutY(78);
        lblAsegMenores.setVisible(false);
        lblAsegMenores.getStyleClass().add("titulo-label");
        aseguradosPane.getChildren().add(lblAsegMenores);
    }

    private void ventanaEmergenteAsegurado(AseguradoMayor aseguradoMayor, Asegurado aseguradoMenor) {
        Stage stage = new Stage();
        stage.setTitle("Expediente del Asegurado");
        Pane rootPane = new Pane();

        // Imagen de Fondo
        Image imgVentanaEmergente = new Image(getClass().getResourceAsStream("/imagenes/FondoSalaEspera.png"));
        ImageView overlayImageView = new ImageView(imgVentanaEmergente);
        resizeImage(overlayImageView, 867, 610);
        rootPane.getChildren().add(overlayImageView);

        Image imgExpediente = new Image(getClass().getResourceAsStream("/imagenes/Expediente.png"));
        ImageView imgViewExpediente = new ImageView(imgExpediente);
        resizeImage(imgViewExpediente, 500, 550);
        rootPane.getChildren().add(imgViewExpediente);

        // NOMBRE
        Label lblNombre = new Label();
        labelPropiedades(rootPane, lblNombre, 15, 105, "Nombre", 14);
        lblNombre.setStyle("-fx-text-fill: white;");
        txtNombre.setLayoutX(15);
        txtNombre.setLayoutY(123);
        if (aseguradoMenor == null) {
            txtNombre.setText(aseguradoMayor.getNombre());
        } else {
            txtNombre.setText(aseguradoMenor.getNombre());
        }
        rootPane.getChildren().add(txtNombre);

        // CEDULA
        Label lblCedula = new Label();
        labelPropiedades(rootPane, lblCedula, 15, 155, "Cédula", 14);
        lblCedula.setStyle("-fx-text-fill: white;");
        txtCedula.setLayoutX(15);
        txtCedula.setLayoutY(173);
        if (aseguradoMenor == null) {
            txtCedula.setText(Integer.toString(aseguradoMayor.getCedula()));
        } else {
            txtCedula.setText(Integer.toString(aseguradoMenor.getCedula()));
        }
        rootPane.getChildren().add(txtCedula);

        // EDAD
        Label lblEdad = new Label();
        labelPropiedades(rootPane, lblEdad, 15, 205, "Edad", 14);
        lblEdad.setStyle("-fx-text-fill: white;");
        txtEdad.setLayoutX(15);
        txtEdad.setLayoutY(223);
        if (aseguradoMenor == null) {
            txtEdad.setText(Integer.toString(aseguradoMayor.getEdad()));
        } else {
            txtEdad.setText(Integer.toString(aseguradoMenor.getEdad()));
        }
        rootPane.getChildren().add(txtEdad);

        // PROVINCIA
        Label lblProvincia = new Label();
        labelPropiedades(rootPane, lblProvincia, 15, 255, "Provincia", 14);
        lblProvincia.setStyle("-fx-text-fill: white;");
        txtProvincia.setLayoutX(15);
        txtProvincia.setLayoutY(273);
        if (aseguradoMenor == null) {
            txtProvincia.setText(aseguradoMayor.getProvincia());
        } else {
            txtProvincia.setText(aseguradoMenor.getProvincia());
        }
        rootPane.getChildren().add(txtProvincia);

        // TELEFONO
        Label lblTelefono = new Label();
        labelPropiedades(rootPane, lblTelefono, 15, 305, "Número de teléfono", 14);
        lblTelefono.setStyle("-fx-text-fill: white;");
        txtTelefono.setLayoutX(15);
        txtTelefono.setLayoutY(323);
        if (aseguradoMenor == null) {
            txtTelefono.setText(Integer.toString(aseguradoMayor.getTelefono()));
        } else {
            txtTelefono.setText(Integer.toString(aseguradoMenor.getTelefono()));
        }
        rootPane.getChildren().add(txtTelefono);

        // DIRECCION
        Label lblDireccion = new Label();
        labelPropiedades(rootPane, lblDireccion, 15, 355, "Dirección Exacta", 14);
        lblDireccion.setStyle("-fx-text-fill: white;");
        txtDireccion.setLayoutX(15);
        txtDireccion.setLayoutY(373);
        if (aseguradoMenor == null) {
            txtDireccion.setText(aseguradoMayor.getDireccion());
        } else {
            txtDireccion.setText(aseguradoMenor.getDireccion());
        }
        rootPane.getChildren().add(txtDireccion);

        if (aseguradoMenor == null) {
            // TELEFONO DEL PARIENTE
            Label lblTelPariente = new Label();
            labelPropiedades(rootPane, lblTelPariente, 15, 405, "Télefono del Pariente", 14);
            lblTelPariente.setStyle("-fx-text-fill: white;");
            txtTelPariente.setLayoutX(15);
            txtTelPariente.setLayoutY(423);
            txtTelPariente.setText(Integer.toString(aseguradoMayor.getNumPariente()));
            rootPane.getChildren().add(txtTelPariente);

            // NOMBRE DEL PARIENTE
            Label lblNomPariente = new Label();
            labelPropiedades(rootPane, lblNomPariente, 15, 455, "Nombre del Pariente", 14);
            lblNomPariente.setStyle("-fx-text-fill: white;");
            txtNomPariente.setLayoutX(15);
            txtNomPariente.setLayoutY(473);
            txtNomPariente.setText(aseguradoMayor.getNomPariene());
            rootPane.getChildren().add(txtNomPariente);
        }

        Label lblnumExpediente = new Label();
        lblnumExpediente.setStyle("-fx-text-fill: white;");
        if (asegMayor) {
            String idSeguro = String.valueOf(aseguradoMayor.getExpediente().getIdExpediente());
            labelPropiedades(rootPane, lblnumExpediente, 307, 30, idSeguro, 33);
        } else {
            String idSeguro = String.valueOf(aseguradoMenor.getExpediente().getIdExpediente());
            labelPropiedades(rootPane, lblnumExpediente, 310, 25, idSeguro, 35);
        }

        Label lblFecha = new Label();
        labelPropiedades(rootPane, lblFecha, 205, 105, "Fecha de Creación:", 14);
        lblFecha.setStyle("-fx-text-fill: white;");
        Label lblFecha2 = new Label();
        lblFecha2.setStyle("-fx-text-fill: white;");
        if (asegMayor) {
            labelPropiedades(rootPane, lblFecha2, 205, 123, String.valueOf(aseguradoMayor.getExpediente().getFecha()), 13);
        } else {
            labelPropiedades(rootPane, lblFecha2, 205, 123, String.valueOf(aseguradoMenor.getExpediente().getFecha()), 13);
        }

        Label lblEstado = new Label();
        Label lblEstado2 = new Label();
        boolean estadoExpediente = true;
        if (asegMayor && aseguradoMayor.getExpediente().getSeguro() == null) {
            Seguro seguro = new Seguro(true, 0);
            aseguradoMayor.getExpediente().setSeguro(seguro);
            estadoExpediente = aseguradoMayor.getExpediente().getSeguro().isEstado();
        } else if (!asegMayor && aseguradoMenor.getExpediente().getSeguro() == null) {
            Seguro seguro = new Seguro(true, 0);
            aseguradoMenor.getExpediente().setSeguro(seguro);
            estadoExpediente = aseguradoMenor.getExpediente().getSeguro().isEstado();
        }
        String estado = "";
        if (estadoExpediente) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        labelPropiedades(rootPane, lblEstado, 205, 155, "Estado:", 14);
        lblEstado.setStyle("-fx-text-fill: white;");
        labelPropiedades(rootPane, lblEstado2, 205, 173, estado, 13);
        lblEstado2.setStyle("-fx-text-fill: white;");

        Label lblMonto = new Label();
        labelPropiedades(rootPane, lblMonto, 205, 205, "Monto", 14);
        lblMonto.setStyle("-fx-text-fill: white;");
        txtMonto.setLayoutX(205);
        txtMonto.setLayoutY(223);
        txtMonto.setFont(new Font(13));
        if (asegMayor) {
            txtMonto.setText(String.valueOf(aseguradoMayor.getExpediente().getSeguro().getMonto()));
        } else {
            txtMonto.setText(String.valueOf(aseguradoMenor.getExpediente().getSeguro().getMonto()));
        }
        rootPane.getChildren().add(txtMonto);

        Label lblObservaciones = new Label();
        labelPropiedades(rootPane, lblObservaciones, 205, 255, "Observaciones", 14);
        lblObservaciones.setStyle("-fx-text-fill: white;");
        txtObservaciones.setLayoutX(205);
        txtObservaciones.setLayoutY(273);
        txtObservaciones.setPrefSize(165, 175);
        txtObservaciones.setWrapText(true);
        txtObservaciones.setFont(new Font(13));
        if (asegMayor) {
            txtObservaciones.setText(aseguradoMayor.getExpediente().getObservaciones());
        } else {
            txtObservaciones.setText(aseguradoMenor.getExpediente().getObservaciones());
        }
        rootPane.getChildren().add(txtObservaciones);

        Button btnGuardarCambios = new Button("Guardar");
        btnGuardarCambios.getStyleClass().addAll("my-button", "secondary");
        if (asegMayor) {
            btnGuardarCambios.setLayoutX(240);
            btnGuardarCambios.setLayoutY(470);
        } else {
            btnGuardarCambios.setLayoutX(150);
            btnGuardarCambios.setLayoutY(500);
        }
        btnGuardarCambios.setOnAction(e -> {
            if (asegMayor) {
                modificarAsegurado(aseguradoMayor, null);
            } else {
                modificarAsegurado(null, aseguradoMenor);
            }
        });
        rootPane.getChildren().add(btnGuardarCambios);

        // Crear la escena y establecerla en el escenario
        Scene scene = new Scene(rootPane, 388, 550);

        scene.getStylesheets().add(getClass().getResource("/css/design.css").toExternalForm());
        stage.setScene(scene);

        // Mostrar la ventana emergente
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getScene().getRoot().requestFocus();
        stage.show();
    }

    public void modificarAsegurado(AseguradoMayor aseguradoMayor, Asegurado aseguradoMenor) {
        int edad = 0;
        int telefono = 0;
        int cedula = 0;
        int numPariente = 0;
        int monto = 0;
        boolean datosValidos = true;
        try {
            edad = Integer.parseInt(txtEdad.getText());
            telefono = Integer.parseInt(txtTelefono.getText());
            cedula = Integer.parseInt(txtCedula.getText());
            monto = Integer.parseInt(txtMonto.getText());
            if (asegMayor) {
                numPariente = Integer.parseInt(txtTelPariente.getText());
            }
        } catch (NumberFormatException e) {
            mostarMensaje("error", "¡Error!", "Por favor verifique nuevamente los datos ingresados");
            datosValidos = false;
        }
        String nombre = txtNombre.getText();
        String provincia = txtProvincia.getText();
        String direccion = txtDireccion.getText();
        String nomPariente = "";
        String observaciones = txtObservaciones.getText();
        if (asegMayor) {
            nomPariente = txtNomPariente.getText();
        }

        if (datosValidos) {
            if (asegMayor) {
                aseguradoMayor.setEdad(edad);
                aseguradoMayor.setProvincia(provincia);
                aseguradoMayor.setDireccion(direccion);
                aseguradoMayor.setTelefono(telefono);
                aseguradoMayor.setCedula(cedula);
                aseguradoMayor.setNombre(nombre);
                aseguradoMayor.setNomPariene(nomPariente);
                aseguradoMayor.setNumPariente(numPariente);
                aseguradoMayor.getExpediente().setObservaciones(observaciones);
                aseguradoMayor.getExpediente().getSeguro().setMonto(monto);
            } else {
                aseguradoMenor.setEdad(edad);
                aseguradoMenor.setProvincia(provincia);
                aseguradoMenor.setDireccion(direccion);
                aseguradoMenor.setTelefono(telefono);
                aseguradoMenor.setCedula(cedula);
                aseguradoMenor.setNombre(nombre);
                aseguradoMenor.getExpediente().setObservaciones(observaciones);
                aseguradoMenor.getExpediente().getSeguro().setMonto(monto);
            }
            mostarMensaje("alerta", "Asegurado Modificado", "Cambios guardados exitosamente!");
            actualizarTabla();
        }
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
        }
    }

    public void aseguradoASalaDoctor(Asegurado asegurado) {
        if (asegurado.getEdad() >= 60) {
            AseguradoMayor aseguradoMayor = new AseguradoMayor("",
                    000,
                    asegurado.getEdad(),
                    asegurado.getProvincia(),
                    asegurado.getDireccion(),
                    asegurado.getTelefono(),
                    asegurado.getExpediente(),
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

        String contrasenia = passwordField.getText();
        String usuario = usernameField.getText();

        if ((administrador1.getUsuario().equals(usuario) && administrador1.getContrasenia().equals(contrasenia))
                || (administrador2.getUsuario().equals(usuario) && administrador2.getContrasenia().equals(contrasenia))
                || (administrador3.getUsuario().equals(usuario) && administrador3.getContrasenia().equals(contrasenia))) {
            tipoUsuario = true;
            btnMostrarAsegurados.setVisible(true);
            btnMostrarDoctores.setVisible(true);
            btnMostrarEmpleados.setVisible(true);
            credencialesCorrectos();
        } else if ((empleado1.getUsuario().equals(usuario) && empleado1.getContrasenia().equals(contrasenia))
                || (empleado2.getUsuario().equals(usuario) && empleado2.getContrasenia().equals(contrasenia))
                || (empleado3.getUsuario().equals(usuario) && empleado3.getContrasenia().equals(contrasenia))) {
            tipoUsuario = false;
            btnMostrarAsegurados.setVisible(false);
            btnMostrarDoctores.setVisible(false);
            btnMostrarEmpleados.setVisible(false);
            credencialesCorrectos();

        } else {
            lblcredenIncorrectas.setVisible(true);
        }
    }

    public void credencialesCorrectos() {
        loginPane.getChildren().add(dashboardPane);
        lblcredenIncorrectas.setVisible(false);
        passwordField.setText("");
        usernameField.setText("");
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

    public void doctoresTabla() {
        // TABLA MAYORES
        TableColumn cedulaColumna = new TableColumn<Doctor, Integer>("Cédula");
        cedulaColumna.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("cedula"));

        TableColumn nombreColumna = new TableColumn<Doctor, String>("Nombre");
        nombreColumna.setCellValueFactory(new PropertyValueFactory<Doctor, String>("nombre"));

        TableColumn especialidadColumna = new TableColumn<Doctor, String>("Especialidad");
        especialidadColumna.setCellValueFactory(new PropertyValueFactory<Doctor, String>("especialidad"));

        TableColumn aniosExpColumna = new TableColumn<Doctor, Integer>("Años de Experiencia");
        aniosExpColumna.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("aniosExperiencia"));

        TableColumn tituloColumna = new TableColumn<Doctor, String>("Título");
        tituloColumna.setCellValueFactory(new PropertyValueFactory<Doctor, String>("titulo"));

        doctoresTable.getColumns().addAll(cedulaColumna, nombreColumna, especialidadColumna, aniosExpColumna, tituloColumna);
    }

    public void empleadosTabla() {
        // TABLA MAYORES
        TableColumn cedulaColumna = new TableColumn<Empleado, Integer>("Cédula");
        cedulaColumna.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("cedula"));

        TableColumn nombreColumna = new TableColumn<Empleado, String>("Nombre");
        nombreColumna.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));

        TableColumn tipoEmpleadoColumna = new TableColumn<Empleado, String>("Tipo de Empleado");
        tipoEmpleadoColumna.setCellValueFactory(new PropertyValueFactory<Empleado, String>("tipoEmpleado"));

        TableColumn usuarioColumna = new TableColumn<Empleado, Integer>("Nombre de Usuario");
        usuarioColumna.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("usuario"));

        empleadosTable.getColumns().addAll(cedulaColumna, nombreColumna, tipoEmpleadoColumna, usuarioColumna);
    }

    private void labelPropiedades(Pane infoPane, Label label, double layoutX, double layoutY, String text, double tamanio) {
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setText(text);
        Font font = Font.font("Arial", FontWeight.BOLD, tamanio);
        label.setFont(font);
        if (infoPane.getChildren().contains(label)) {
            infoPane.getChildren().remove(label);
        }

        infoPane.getChildren().add(label);
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
    private final Empleado empleado1 = new Empleado("Básico", "Especialista en reclamaciones médicas", true,
            "Aperezd624", "123", 30123456, "Ana Pérez");
    private final Empleado empleado2 = new Empleado("Básico", "Atención al cliente y consultas de seguros", true,
            "Mgarciar942", "123", 40876543, "Mario García");
    private final Empleado empleado3 = new Empleado("Experto", "Gestión de cobertura y beneficios", false,
            "Lmartinezc156", "123", 70543210, "Laura Martínez");
    private final Empleado empleado4 = new Empleado("Básico", "Especialista en ventas", true, "Jrodriguezm123", "123", 40123457, "Juan Rodríguez");
    private final Empleado empleado5 = new Empleado("Experto", "Gestión de siniestros", false, "Cramosl789", "123", 50234567, "Carolina Ramos");
    private final Empleado empleado6 = new Empleado("Básico", "Atención telefónica", true, "Dgutierrezg456", "123", 60345678, "Diego Gutiérrez");
    private final Empleado empleado7 = new Empleado("Experto", "Auditoría de reclamaciones", false, "Mfernandezf147", "123", 70456789, "Marta Fernández");
    private final Empleado empleado8 = new Empleado("Básico", "Soporte técnico", true, "Jgomezp753", "123", 80567890, "Javier Gómez");
    private final Empleado empleado9 = new Empleado("Experto", "Control de fraude", false, "Pgonzalezh963", "123", 90678901, "Patricia González");
    private final Empleado empleado10 = new Empleado("Básico", "Gestión de cuentas", true, "Lruizj852", "123", 10078902, "Luis Ruiz");
    private final Empleado empleado11 = new Empleado("Básico", "Asistencia en línea", true, "Rvargasz321", "123", 10189023, "Raquel Vargas");
    private final Empleado empleado12 = new Empleado("Experto", "Evaluación de riesgos", false, "Tmoralesw214", "123", 11290134, "Tomás Morales");
    private final Empleado empleado13 = new Empleado("Básico", "Gestión de contratos", true, "Naguilart456", "123", 12301245, "Natalia Aguilar");
    private final Empleado empleado14 = new Empleado("Experto", "Dirección financiera", false, "Olopezy985", "123", 13412356, "Óscar López");
    private final Empleado empleado15 = new Empleado("Básico", "Relaciones públicas", true, "Ialvaradok852", "123", 14523467, "Isabel Alvarado");
    private final Empleado empleado16 = new Empleado("Experto", "Administración de sistemas", false, "Earauzol147", "123", 15634578, "Esteban Arauz");
    private final Empleado empleado17 = new Empleado("Básico", "Estrategia de ventas", true, "Ubrenesp963", "123", 16745689, "Ursula Brenes");
    private final Empleado empleado18 = new Empleado("Experto", "Desarrollo de productos", false, "Vsalazarc412", "123", 17856790, "Víctor Salazar");
    private final Empleado empleado19 = new Empleado("Básico", "Marketing y publicidad", true, "Wtorresm852", "123", 18967801, "Walter Torres");
    private final Empleado empleado20 = new Empleado("Experto", "Gestión de calidad", false, "Xgonzálezn753", "123", 19078912, "Xiomara González");

    private void agregarEmpleados() {
        Empleado[] empleados = {
            empleado1, empleado2, empleado3, empleado4, empleado5, empleado6, empleado7, empleado8,
            empleado9, empleado10, empleado11, empleado12, empleado13, empleado14, empleado15,
            empleado16, empleado17, empleado18, empleado19, empleado20
        };

        for (Empleado empleado : empleados) {
            pilaEmpleados.push(empleado);
            empleadosTable.getItems().add(empleado);
        }
    }

}
