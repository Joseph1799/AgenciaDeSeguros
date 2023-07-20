package com.vitalcare.AgenciaDeSeguros.Igu;

import com.vitalcare.AgenciaDeSeguros.Estructuras.Cola;
import com.vitalcare.AgenciaDeSeguros.Logica.Asegurado;
import com.vitalcare.AgenciaDeSeguros.Logica.Cajero;
import java.util.Random;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SalaPrincipal {

    //Instancias
    private final Cajero cajero = new Cajero();
    private final vitalCareLogin vcLogin = new vitalCareLogin();
    //private ControlDoctores controlDoc = new ControlDoctores();
    //Variables
    private int numImagen = 1;
    private int cantidadAtendidos = 0;
    private boolean atenderAsegurados = true;
    private final Cola pacientesEnEspera = new Cola(45);
    private Scene scene;

    //Elementos gráficos
    private final Label lblAseguradosAcumulados = new Label();
    private final Label lblInfoNombre1 = new Label();
    private final Label lblInfoCedulda1 = new Label();
    private final Label lblInfoEdad1 = new Label();
    private final Label lblInfoTelefono1 = new Label();
    private final Label lblInfoNombre2 = new Label();
    private final Label lblInfoCedulda2 = new Label();
    private final Label lblInfoEdad2 = new Label();
    private final Label lblInfoTelefono2 = new Label();
    private final Label lblInfoNombre3 = new Label();
    private final Label lblInfoCedulda3 = new Label();
    private final Label lblInfoEdad3 = new Label();
    private final Label lblInfoTelefono3 = new Label();
    private final Label lblAsegAtendidos = new Label();
    private final ImageView paciente1ImgView = new ImageView();
    private final ImageView paciente2ImgView = new ImageView();
    private final ImageView paciente3ImgView = new ImageView();
    private final ImageView pacEsperandoImgView = new ImageView();
    private SmoothButton btnPedirDatos1;
    private SmoothButton btnPedirDatos2; 
    private SmoothButton btnPedirDatos3;
    private SmoothButton btnGuardarDatos;
    private SmoothButton btnLiberar1;
    private SmoothButton btnLiberar2;
    private SmoothButton btnLiberar3;
    private Button btnInfo1;
    private Button btnInfo2;
    private Button btnInfo3;
    TextField txtCedula = new TextField();
    TextField txtNombre = new TextField();
    TextField txtEdad = new TextField();
    TextField txtProvincia = new TextField();
    TextField txtTelefono = new TextField();
    TextArea txtDireccion = new TextArea();
    private final Pane ingresarDatosPane = new Pane();
    private final Pane infoAsegurado1Pane = new Pane();
    private final Pane infoAsegurado2Pane = new Pane();
    private final Pane infoAsegurado3Pane = new Pane();

    public void initialize() {
        Pane rootPane = new Pane();
        Image backgroundImage = new Image(getClass().getResourceAsStream("/imagenes/FondoSalaEspera.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        rootPane.getChildren().add(backgroundImageView);

        Image cajeros = new Image(getClass().getResourceAsStream("/imagenes/Cajeros.png"));
        ImageView overlayImageView = new ImageView(cajeros);
        overlayImageView.setLayoutX(67);
        overlayImageView.setLayoutY(57);
        rootPane.getChildren().add(overlayImageView);

        // Se preparan las posiciones de las imagenes de los pacientes
        paciente1ImgView.setLayoutX(180);
        paciente1ImgView.setLayoutY(60);
        rootPane.getChildren().add(paciente1ImgView);

        paciente2ImgView.setLayoutX(420);
        paciente2ImgView.setLayoutY(60);
        rootPane.getChildren().add(paciente2ImgView);

        paciente3ImgView.setLayoutX(650);
        paciente3ImgView.setLayoutY(60);
        rootPane.getChildren().add(paciente3ImgView);

        pacEsperandoImgView.setLayoutX(775);
        pacEsperandoImgView.setLayoutY(2);
        rootPane.getChildren().add(pacEsperandoImgView);
        Image image = new Image(getClass().getResourceAsStream("/imagenes/PacientesBg.png"));
        resizeImage(pacEsperandoImgView, 70, 70);
        pacEsperandoImgView.setImage(image);

        // Se agrega un Label para mostrar los pacientes en espera
        labelPropiedades(rootPane, lblAseguradosAcumulados, 778.5, 18, "", 28);
        lblAsegAtendidos.setLayoutX(778.5);
        lblAsegAtendidos.setLayoutX(18);
        lblAseguradosAcumulados.setMinSize(60, 30);
        lblAseguradosAcumulados.setAlignment(Pos.CENTER);

        // Se asignan las funciones y posiciones de los botones
        btnPedirDatos1 = new SmoothButton("Pedir Datos");
        btnPedirDatos1.getStyleClass().addAll("my-button", "primary");
        btnPedirDatos1.setVisible(false);
        btnPedirDatos1.setLayoutX(135);
        btnPedirDatos1.setLayoutY(20);
        rootPane.getChildren().add(btnPedirDatos1);
        btnPedirDatos1.setOnAction(e -> {
            if (!ingresarDatosPane.isVisible()) {
                ingresarDatosPane.setLayoutX(100);
                ingresarDatosPane.setLayoutY(150);
                ingresarDatosPane.setVisible(true);
                btnPedirDatos1.setVisible(false);
                cajero.setNumCajero(1);
            } else {
                mostarMensaje("alerta", "¡Atención!", "Solo puede ingresar los datos de un asegurado a la vez");
            }
        });

        btnPedirDatos2 = new SmoothButton("Pedir Datos");
        btnPedirDatos2.getStyleClass().addAll("my-button", "primary");
        btnPedirDatos2.setVisible(false);
        btnPedirDatos2.setLayoutX(370);
        btnPedirDatos2.setLayoutY(20);
        rootPane.getChildren().add(btnPedirDatos2);
        btnPedirDatos2.setOnAction(e -> {
            if (!ingresarDatosPane.isVisible()) {
                ingresarDatosPane.setLayoutX(330);
                ingresarDatosPane.setLayoutY(150);
                ingresarDatosPane.setVisible(true);
                btnPedirDatos2.setVisible(false);
                cajero.setNumCajero(2);
            } else {
                mostarMensaje("alerta", "¡Atención!", "Solo puede ingresar los datos de un asegurado a la vez");
            }
        });

        btnPedirDatos3 = new SmoothButton("Pedir Datos");
        btnPedirDatos3.getStyleClass().addAll("my-button", "primary");
        btnPedirDatos3.setVisible(false);
        btnPedirDatos3.setLayoutX(600);
        btnPedirDatos3.setLayoutY(20);
        rootPane.getChildren().add(btnPedirDatos3);
        btnPedirDatos3.setOnAction(e -> {
            if (!ingresarDatosPane.isVisible()) {
                ingresarDatosPane.setLayoutX(565);
                ingresarDatosPane.setLayoutY(150);
                ingresarDatosPane.setVisible(true);
                btnPedirDatos3.setVisible(false);
                cajero.setNumCajero(3);
            } else {
                mostarMensaje("alerta", "¡Atención!", "Solo puede ingresar los datos de un asegurado a la vez");
            }
        });

        btnLiberar1 = new SmoothButton("Liberar");
        btnLiberar1.getStyleClass().addAll("my-button", "secondary");
        btnLiberar1.setVisible(false);
        btnLiberar1.setLayoutX(145);
        btnLiberar1.setLayoutY(20);
        rootPane.getChildren().add(btnLiberar1);
        btnLiberar1.setOnAction(e -> {
            Asegurado aseguradoAtendido = (Asegurado) cajero.getCajero1().pop();
            vcLogin.aseguradoASalaDoctor(aseguradoAtendido);
            paciente1ImgView.setVisible(false);
            btnLiberar1.setVisible(false);
            btnPedirDatos1.setVisible(false);
            btnInfo1.setVisible(false);
            cantidadAtendidos++;
            lblAsegAtendidos.setText("");
            lblAsegAtendidos.setText(String.valueOf(cantidadAtendidos));
        });

        btnLiberar2 = new SmoothButton("Liberar");
        btnLiberar2.getStyleClass().addAll("my-button", "secondary");
        btnLiberar2.setVisible(false);
        btnLiberar2.setLayoutX(382);
        btnLiberar2.setLayoutY(20);
        rootPane.getChildren().add(btnLiberar2);
        btnLiberar2.setOnAction(e -> {
            Asegurado aseguradoAtendido = (Asegurado) cajero.getCajero2().pop();
            vcLogin.aseguradoASalaDoctor(aseguradoAtendido);
            paciente2ImgView.setVisible(false);
            btnLiberar2.setVisible(false);
            btnPedirDatos2.setVisible(false);
            btnInfo2.setVisible(false);
            cantidadAtendidos++;
            lblAsegAtendidos.setText("");
            lblAsegAtendidos.setText(String.valueOf(cantidadAtendidos));
        });

        btnLiberar3 = new SmoothButton("Liberar");
        btnLiberar3.getStyleClass().addAll("my-button", "secondary");
        btnLiberar3.setVisible(false);
        btnLiberar3.setLayoutX(618);
        btnLiberar3.setLayoutY(20);
        rootPane.getChildren().add(btnLiberar3);
        btnLiberar3.setOnAction(e -> {
            Asegurado aseguradoAtendido = (Asegurado) cajero.getCajero3().pop();
            vcLogin.aseguradoASalaDoctor(aseguradoAtendido);
            paciente3ImgView.setVisible(false);
            btnLiberar3.setVisible(false);
            btnPedirDatos3.setVisible(false);
            btnInfo3.setVisible(false);
            cantidadAtendidos++;
            lblAsegAtendidos.setText("");
            lblAsegAtendidos.setText(String.valueOf(cantidadAtendidos));
        });

        btnInfo1 = new Button(" i ");
        btnInfo1.setVisible(false);
        btnInfo1.setLayoutX(113);
        btnInfo1.setLayoutY(22);
        btnInfo1.setShape(new Circle(12));
        btnInfo1.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
        rootPane.getChildren().add(btnInfo1);
        btnInfo1.setOnMouseEntered(e -> {
            btnInfo1.setStyle("-fx-background-color: rgb(37, 150, 190); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado1Pane.setVisible(true);
        });
        btnInfo1.setOnMouseExited(e -> {
            btnInfo1.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado1Pane.setVisible(false);
        });

        btnInfo2 = new Button(" i ");
        btnInfo2.setVisible(false);
        btnInfo2.setLayoutX(350);
        btnInfo2.setLayoutY(22);
        btnInfo2.setShape(new Circle(12));
        btnInfo2.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
        rootPane.getChildren().add(btnInfo2);
        btnInfo2.setOnMouseEntered(e -> {
            btnInfo2.setStyle("-fx-background-color: rgb(37, 150, 190); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado2Pane.setVisible(true);
        });
        btnInfo2.setOnMouseExited(e -> {
            btnInfo2.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado2Pane.setVisible(false);
        });

        btnInfo3 = new Button(" i ");
        btnInfo3.setVisible(false);
        btnInfo3.setLayoutX(587);
        btnInfo3.setLayoutY(22);
        btnInfo3.setShape(new Circle(12));
        btnInfo3.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
        rootPane.getChildren().add(btnInfo3);
        btnInfo3.setOnMouseEntered(e -> {
            btnInfo3.setStyle("-fx-background-color: rgb(37, 150, 190); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado3Pane.setVisible(true);
        });
        btnInfo3.setOnMouseExited(e -> {
            btnInfo3.setStyle("-fx-background-color: rgb(21,76,121); -fx-text-fill: white; -fx-border-width: 1px; -fx-font-weight: bold;");
            infoAsegurado3Pane.setVisible(false);
        });

        // MOSTRAR INFORMACION PANE 1
        infoAsegurado1Pane.setPrefWidth(300);
        infoAsegurado1Pane.setPrefHeight(140);
        infoAsegurado1Pane.setLayoutX(82);
        infoAsegurado1Pane.setLayoutY(55);
        infoAsegurado1Pane.setVisible(false);
        //Se crea y agrega la imagen info1ImgView al Pane1
        ImageView info1ImgView = new ImageView();
        Image info1 = new Image(getClass().getResourceAsStream("/imagenes/PInfo1.png"));
        info1ImgView = new ImageView(info1);
        rootPane.getChildren().add(infoAsegurado1Pane);
        infoAsegurado1Pane.getChildren().add(info1ImgView);

        // MOSTRAR INFORMACION PANE 2
        infoAsegurado2Pane.setPrefWidth(300);
        infoAsegurado2Pane.setPrefHeight(140);
        infoAsegurado2Pane.setLayoutX(312);
        infoAsegurado2Pane.setLayoutY(55);
        infoAsegurado2Pane.setVisible(false);
        //Se crea y agrega la imagen info1ImgView al Pane1
        ImageView info2ImgView = new ImageView();
        Image info2 = new Image(getClass().getResourceAsStream("/imagenes/PInfo2.png"));
        info2ImgView = new ImageView(info2);
        rootPane.getChildren().add(infoAsegurado2Pane);
        infoAsegurado2Pane.getChildren().add(info2ImgView);

        // MOSTRAR INFORMACION PANE 3
        infoAsegurado3Pane.setPrefWidth(300);
        infoAsegurado3Pane.setPrefHeight(140);
        infoAsegurado3Pane.setLayoutX(348);
        infoAsegurado3Pane.setLayoutY(55);
        infoAsegurado3Pane.setVisible(false);
        //Se crea y agrega la imagen info1ImgView al Pane1
        ImageView info3ImgView = new ImageView();
        Image info3 = new Image(getClass().getResourceAsStream("/imagenes/PInfo3.png"));
        info3ImgView = new ImageView(info3);
        rootPane.getChildren().add(infoAsegurado3Pane);
        infoAsegurado3Pane.getChildren().add(info3ImgView);

        //INGRESAR DATOS PANE
        // Se asignan los valores del Pane donde se ingresan los datos de los pacientes
        ingresarDatosPane.setVisible(false);
        ingresarDatosPane.setPrefWidth(180);
        ingresarDatosPane.setPrefHeight(345);
        // Se le da un color celeste con una opacidad de 0.8
        Color lightBlue = new Color(0.6784, 0.8471, 0.902, 0.8); // Light blue with opacity 0.5
        BackgroundFill backgroundFill = new BackgroundFill(lightBlue, null, null);
        Background background = new Background(backgroundFill);
        ingresarDatosPane.setBackground(background);
        // Se le agrega un borde con un color
        Color borderColor = Color.CADETBLUE;
        BorderStroke borderStroke = new BorderStroke(borderColor, BorderStrokeStyle.SOLID, null, new BorderWidths(2), new Insets(5));
        Border border = new Border(borderStroke);
        ingresarDatosPane.setBorder(border);
        rootPane.getChildren().add(ingresarDatosPane);
        // Se añaden los elementos necesarios al Pane ingresarDatosPane
        // txtCEDULA
        txtCedula.setLayoutX(15);
        txtCedula.setLayoutY(10);
        txtCedula.setPrefSize(150, 15);
        txtCedula.setPromptText("Cédula");
        ingresarDatosPane.getChildren().add(txtCedula);
        txtCedula.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtCedula.setPromptText("Cédula");
            } else {
                txtCedula.setPromptText("");
            }
        });
        // txtNOMBRE
        txtNombre.setLayoutX(15);
        txtNombre.setLayoutY(45);
        txtNombre.setPrefSize(150, 15);
        txtNombre.setPromptText("Nombre");
        ingresarDatosPane.getChildren().add(txtNombre);
        txtNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtNombre.setPromptText("Nombre");
            } else {
                txtNombre.setPromptText("");
            }
        });
        // txtEDAD
        txtEdad.setLayoutX(15);
        txtEdad.setLayoutY(80);
        txtEdad.setPrefSize(150, 15);
        txtEdad.setPromptText("Edad");
        ingresarDatosPane.getChildren().add(txtEdad);
        txtEdad.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtEdad.setPromptText("Edad");
            } else {
                txtEdad.setPromptText("");
            }
        });
        //txtPROVINCIA
        txtProvincia.setLayoutX(15);
        txtProvincia.setLayoutY(115);
        txtProvincia.setPrefSize(150, 15);
        txtProvincia.setPromptText("Provincia");
        ingresarDatosPane.getChildren().add(txtProvincia);
        txtProvincia.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtProvincia.setPromptText("Provincia");
            } else {
                txtProvincia.setPromptText("");
            }
        });
        //txtTELEFONO
        txtTelefono.setLayoutX(15);
        txtTelefono.setLayoutY(150);
        txtTelefono.setPrefSize(150, 15);
        txtTelefono.setPromptText("Número de teléfono");
        ingresarDatosPane.getChildren().add(txtTelefono);
        txtTelefono.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtTelefono.setPromptText("Número de teléfono");
            } else {
                txtTelefono.setPromptText("");
            }
        });
        // txtDIRECCION
        txtDireccion.setLayoutX(15);
        txtDireccion.setLayoutY(185);
        txtDireccion.setPromptText("Dirección exacta");
        txtDireccion.setPrefSize(150, 100);
        txtDireccion.setWrapText(true);
        ingresarDatosPane.getChildren().add(txtDireccion);
        txtDireccion.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                txtDireccion.setPromptText("Dirección exacta");
            } else {
                txtDireccion.setPromptText("");
            }
        });
        //btnGUARDARDATOS   
        btnGuardarDatos = new SmoothButton("Guardar");
        btnGuardarDatos.getStyleClass().addAll("my-button", "primary");
        btnGuardarDatos.setLayoutX(24);
        btnGuardarDatos.setLayoutY(295);
        btnGuardarDatos.setPrefSize(130, 30);
        ingresarDatosPane.getChildren().add(btnGuardarDatos);
        btnGuardarDatos.setOnAction(e -> {
            asignarDatosAsegurado();
        });

        // Se inician los hilos 
        hiloIniciarDia();
        hiloPasarAsegurado();

        scene = new Scene(rootPane);
    }

    public void hiloIniciarDia() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 45; i++) {
                    Asegurado aseguradoVacio = new Asegurado();
                    pacientesEnEspera.insertarCola(aseguradoVacio);
                    int cantPacientes = pacientesEnEspera.cantidadDatosCola();
                    Platform.runLater(() -> {
                        lblAseguradosAcumulados.setText(String.valueOf(cantPacientes));
                    });
                    int delay = random.nextInt(15001);
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hilo.start();
    }

    public void hiloPasarAsegurado() {
        Thread hilo = new Thread(() -> {
            while (true) {
                if (!pacientesEnEspera.colaVacia()) {
                    if (atenderAsegurados) {
                        if (cajero.getCajero1().pilaVacia() && !pacientesEnEspera.colaVacia()) {
                            Asegurado aseguradoVacio = (Asegurado) pacientesEnEspera.obtenerInicioCola();
                            pacientesEnEspera.eliminarCola();
                            cajero.getCajero1().push(aseguradoVacio);
                            Platform.runLater(() -> {
                                asignarImagen(paciente1ImgView);
                                paciente1ImgView.setVisible(true);
                                btnPedirDatos1.setVisible(true);
                            });
                        }
                        if (cajero.getCajero2().pilaVacia() && !pacientesEnEspera.colaVacia()) {
                            Asegurado aseguradoVacio = (Asegurado) pacientesEnEspera.obtenerInicioCola();
                            pacientesEnEspera.eliminarCola();
                            cajero.getCajero2().push(aseguradoVacio);
                            Platform.runLater(() -> {
                                asignarImagen(paciente2ImgView);
                                paciente2ImgView.setVisible(true);
                                btnPedirDatos2.setVisible(true);
                                // ingresarDatosPane.setLayoutX(numImagen);
                                // ingresarDatosPane.setLayoutY(numImagen);
                            });
                        }
                        if (cajero.getCajero3().pilaVacia() && !pacientesEnEspera.colaVacia()) {
                            Asegurado aseguradoVacio = (Asegurado) pacientesEnEspera.obtenerInicioCola();
                            pacientesEnEspera.eliminarCola();
                            cajero.getCajero3().push(aseguradoVacio);
                            Platform.runLater(() -> {
                                asignarImagen(paciente3ImgView);
                                paciente3ImgView.setVisible(true);
                                btnPedirDatos3.setVisible(true);
                            });
                        }
                        int cantPacientes = pacientesEnEspera.cantidadDatosCola();
                        Platform.runLater(() -> {
                            lblAseguradosAcumulados.setText(String.valueOf(cantPacientes));
                        });
                    }
                }
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hilo.start();
    }

    public void asignarImagen(ImageView imageView) {
        Image image = new Image(getClass().getResourceAsStream("/imagenes/Paciente" + numImagen + ".png"));
        imageView.setImage(image); // Assign the image to the ImageView
        numImagen++;
        if (numImagen == 12) {
            numImagen = 1;
        }
    }

    public void mostarMensaje(String tipo, String titulo, String mensaje) {
        if (tipo.equals("alerta")) {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
        } else if (tipo.equals("error")) {
            //Mensaje de error
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle(titulo);
            error.setHeaderText(null);
            error.setContentText(mensaje);
            error.showAndWait();
        }
    }

    public void asignarDatosAsegurado() {
        //Este metodo se encarga de asignarle los atributos al asegurado vacio el cual fue pasado de la cola de espera al cajero disponible
        boolean datosValidos = true;
        int edad = 0;
        int telefono = 0;
        int cedula = 0;
        /*Se verifica que edad, telefono y cedula contengan caracteres numericos, de lo contrario se muestra un mensaje de error.
        Posteriormente se obtienen los datos almacenados en cada JTextArea*/
        try {
            edad = Integer.parseInt(txtEdad.getText());
            telefono = Integer.parseInt(txtTelefono.getText());
            cedula = Integer.parseInt(txtCedula.getText());
        } catch (NumberFormatException e) {
            mostarMensaje("error", "¡Error!", "Por favor verifique nuevamente los datos ingresados");
            datosValidos = false;
        }
        String nombre = txtNombre.getText();
        String provincia = txtProvincia.getText();
        String direccion = txtDireccion.getText();

        //Se verifica que las casillas no esten vacias
        if (provincia.equals("") || direccion.equals("") || nombre.equals("")) {
            mostarMensaje("error", "¡Error!", "El formulario debe estar completo");
            datosValidos = false;
        }

        //Si todo esta correcto, se procede a asignarle los datos al asegurado creado con el constructor vacio
        if (datosValidos) {
            /*La manera en la que se comprueba a cual asegurado de que numero de cajero es al que se le
             asignaran los atributos, es hace por medio de la variable "numCajero". A esta variable se 
            le asigna el numero de cajero cuando el JButton "Pedir Datos" es precionado. Esto nos permite
            controlar el switch que esta a continuacion, esto a su vez declarando dicha variable (numCajero)
            de manera global*/
            switch (cajero.getNumCajero()) {
                case 1:
                    //Se optiene al asegurado por medio de un pop
                    Asegurado aseguradoVacio = (Asegurado) cajero.getCajero1().pop();
                    aseguradoVacio.setEdad(edad);
                    aseguradoVacio.setProvincia(provincia);
                    aseguradoVacio.setDireccion(direccion);
                    aseguradoVacio.setTelefono(telefono);
                    aseguradoVacio.setCedula(cedula);
                    aseguradoVacio.setNombre(nombre);
                    //Devolvemos el asegurado al cajero pero ya con sus atributos asignados
                    cajero.getCajero1().push(aseguradoVacio);
                    //Se muestra el boton liberar para dar paso al siguiente asegurado cuando este sea presionado
                    btnLiberar1.setVisible(true);
                    btnPedirDatos1.setVisible(false);
                    btnInfo1.setVisible(true);
                    //Se muestran los datos en la seccion de informacion
                    labelPropiedades(infoAsegurado1Pane, lblInfoNombre1, 88, 39, aseguradoVacio.getNombre(), 12);
                    labelPropiedades(infoAsegurado1Pane, lblInfoCedulda1, 20, 66, String.valueOf(cedula), 13);
                    labelPropiedades(infoAsegurado1Pane, lblInfoEdad1, 20, 81, String.valueOf(edad), 13);
                    labelPropiedades(infoAsegurado1Pane, lblInfoTelefono1, 20, 98, String.valueOf(telefono), 13);
                    break;
                case 2:
                    aseguradoVacio = (Asegurado) cajero.getCajero2().pop();
                    aseguradoVacio.setEdad(edad);
                    aseguradoVacio.setProvincia(provincia);
                    aseguradoVacio.setDireccion(direccion);
                    aseguradoVacio.setTelefono(telefono);
                    aseguradoVacio.setCedula(cedula);
                    aseguradoVacio.setNombre(nombre);
                    cajero.getCajero2().push(aseguradoVacio);
                    //Se muestra el boton liberar para dar paso al siguiente asegurado
                    btnLiberar2.setVisible(true);
                    btnPedirDatos2.setVisible(false);
                    btnInfo2.setVisible(true);
                    labelPropiedades(infoAsegurado2Pane, lblInfoNombre2, 95, 39, aseguradoVacio.getNombre(), 12);
                    labelPropiedades(infoAsegurado2Pane, lblInfoCedulda2, 25, 60, String.valueOf(cedula), 13);
                    labelPropiedades(infoAsegurado2Pane, lblInfoEdad2, 25, 81, String.valueOf(edad), 13);
                    labelPropiedades(infoAsegurado2Pane, lblInfoTelefono2, 25, 98, String.valueOf(telefono), 13);
                    break;
                case 3:
                    aseguradoVacio = (Asegurado) cajero.getCajero3().pop();
                    aseguradoVacio.setEdad(edad);
                    aseguradoVacio.setProvincia(provincia);
                    aseguradoVacio.setDireccion(direccion);
                    aseguradoVacio.setTelefono(telefono);
                    aseguradoVacio.setCedula(cedula);
                    aseguradoVacio.setNombre(nombre);
                    cajero.getCajero3().push(aseguradoVacio);
                    //Se muestra el boton liberar para dar paso al siguiente asegurado
                    btnLiberar3.setVisible(true);
                    btnPedirDatos3.setVisible(false);
                    btnInfo3.setVisible(true);
                    labelPropiedades(infoAsegurado3Pane, lblInfoNombre3, 25, 39, aseguradoVacio.getNombre(), 12);
                    labelPropiedades(infoAsegurado3Pane, lblInfoCedulda3, 25, 60, String.valueOf(cedula), 13);
                    labelPropiedades(infoAsegurado3Pane, lblInfoEdad3, 25, 81, String.valueOf(edad), 13);
                    labelPropiedades(infoAsegurado3Pane, lblInfoTelefono3, 25, 98, String.valueOf(telefono), 13);
                    break;
            }

            //Se oculta el JFrame interno
            ingresarDatosPane.setVisible(false);

            //Se borran los datos ingresados en los campos de texto
            txtCedula.setText("");
            txtNombre.setText("");
            txtProvincia.setText("");
            txtDireccion.setText("");
            txtEdad.setText("");
            txtTelefono.setText("");

        }
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

    public void resizeImage(ImageView imageView, double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
    }

    public Scene getScene() {
        return scene;
    }

}
