package persona.baseJavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JavaFx extends Application {

    private persona.baseJavaFX.basePalmatec basePalmatec = new basePalmatec();

    @Override
    public void start(Stage ventanaPrincipal) {

        StackPane root = new StackPane();
        //Configuración del botón para obtener información de diferentes categorías.
        Button botonFiltrar = new Button("Buscar Información");
        botonFiltrar.setOnAction(e -> {
            TextField nombreOrdenadorInput = new TextField();
            Button botonBuscar = new Button("Buscar");
            VBox buscador = new VBox(10);
            buscador.setAlignment(Pos.CENTER);
            buscador.getChildren().addAll(new Label("Ingrese el tipo del ordenador para obtener información:"), nombreOrdenadorInput, botonBuscar);
            Scene escenaBuscar = new Scene(buscador, 400, 150);
            Stage stageBuscar = new Stage();
            stageBuscar.setScene(escenaBuscar);
            stageBuscar.setTitle("Información Ordenadores");
            stageBuscar.show();
            botonBuscar.setOnAction(event -> {
                //Configuración del if para que disitinguir las categorías.
                String nombreOrdenador = nombreOrdenadorInput.getText();
                if (nombreOrdenador.equalsIgnoreCase("Gaming")) {
                    stageBuscar.setScene(new Scene(new Label("Los ordenadores gaming brindan una experiencia de juego inmersiva y fluida,\n " +
                            "con hardware de alto rendimiento que garantiza gráficos excepcionales y tiempos de respuesta rápidos.\n" +
                            "Los precios actuales de los ORDENADORES EN STOCK son:  \n" +
                            "1- 1550€ 2- 1780€ 3- 980€ "), 560, 70));
                } else if (nombreOrdenador.equalsIgnoreCase("Oficina")) {
                    stageBuscar.setScene(new Scene(new Label("\n" +
                            "Los ordenadores de oficina son para tareas diarias de trabajo, como procesamiento de\n " +
                            "texto y correo electrónico, con un rendimiento confiable y eficiente.\n" +
                            "AHORA MISMO NO TENEMOS STOCK DISPONIBLE "), 520, 70));
                } else {
                    stageBuscar.setScene(new Scene(new Label("Ese tipo de ordenador no lo manejamos. Proximamente habrá NOVEDADES!"), 410, 50));
                }

            });
        });
        //Configuración del botón para ver todos los Ordenadores.
        Button botonVerPC = new Button("Ver Todos los Ordenadores");
        botonVerPC.setOnAction(e -> {
            VBox todosOrdenadores = new VBox(10);
            todosOrdenadores.setAlignment(Pos.CENTER);
            Label nuestrosOrdenadores = new Label("Todos nuestros ordenadores");
            Image img1 = new Image(getClass().getResourceAsStream("img1.png"));
            ImageView ordenadorUno = new ImageView(img1);
            ordenadorUno.setFitWidth(550);
            ordenadorUno.setFitHeight(200);
            Image img2 = new Image(getClass().getResourceAsStream("img2.png"));
            ImageView ordenadorDos = new ImageView(img2);
            ordenadorDos.setFitWidth(550);
            ordenadorDos.setFitHeight(200);
            Image img3 = new Image(getClass().getResourceAsStream("img3.png"));
            ImageView ordenadorTres = new ImageView(img3);
            ordenadorTres.setFitWidth(550);
            ordenadorTres.setFitHeight(220);
            todosOrdenadores.getChildren().addAll(nuestrosOrdenadores, ordenadorUno, ordenadorDos, ordenadorTres);
            //Este es el botón para volver atrás.
            Button volverBoton = new Button("Volver");
            volverBoton.setOnAction(event -> ventanaPrincipal.setScene(root.getScene()));
            todosOrdenadores.getChildren().add(volverBoton);
            Scene escena3 = new Scene(todosOrdenadores, 1520, 920);
            ventanaPrincipal.setScene(escena3);
            escena3.getStylesheets().add(getClass().getResource("fondoImagen.css").toExternalForm());
        });

        // Botón para registrar un cliente
        Button botonRegistrarCliente = new Button("Registro");
        botonRegistrarCliente.setOnAction(e -> {
            TextField dniInput = new TextField();
            TextField nombreInput = new TextField();
            TextField apellidosInput = new TextField();
            TextField edadInput = new TextField();
            TextField telefonoInput = new TextField();
            Button botonGuardar = new Button("Guardar");
            Button botonCancelar = new Button("Cancelar");
            Button botonModificar = new Button("Modificar");
            Button botonBorrar = new Button("Borrar");

            GridPane registroCliente = new GridPane();
            registroCliente.setAlignment(Pos.CENTER);
            registroCliente.setHgap(5);
            registroCliente.setVgap(10);

            registroCliente.addRow(0, new Label("DNI:"), dniInput);
            registroCliente.addRow(1, new Label("Nombre:"), nombreInput);
            registroCliente.addRow(2, new Label("Apellidos:"), apellidosInput);
            registroCliente.addRow(3, new Label("Edad:"), edadInput);
            registroCliente.addRow(4, new Label("Teléfono:"), telefonoInput);
            registroCliente.add(botonGuardar, 0, 5);
            registroCliente.add(botonCancelar, 1, 5);
            registroCliente.add(botonModificar, 2, 5);
            registroCliente.add(botonBorrar, 3,5);
            Scene escenaRegistro = new Scene(registroCliente, 600, 300);
            escenaRegistro.getStylesheets().add(getClass().getResource("estiloCliente.css").toExternalForm());
            Stage stageRegistro = new Stage();
            stageRegistro.setScene(escenaRegistro);
            stageRegistro.setTitle("Registro de Cliente");
            stageRegistro.show();

            botonGuardar.setOnAction(event -> {
                String dni = dniInput.getText();
                String nombre = nombreInput.getText();
                String apellidos = apellidosInput.getText();
                String edadText = edadInput.getText();
                String telefono = telefonoInput.getText();

                if (dni.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || edadText.isEmpty() || telefono.isEmpty()) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Por favor, complete todos los campos.");
                    alerta.showAndWait();
                } else {
                    basePalmatec.añadirCliente(dni, nombre, apellidos, Integer.parseInt(edadText), telefono);
                    stageRegistro.close();
                }
            });

            botonCancelar.setOnAction(event -> {
                stageRegistro.close();
            });

            botonModificar.setOnAction(event -> {
                TextField dniBusquedaInput = new TextField();
                Button buscarButton = new Button("Buscar");

                HBox buscarBox = new HBox(10, new Label("DNI del cliente a modificar:"), dniBusquedaInput, buscarButton);
                buscarBox.setAlignment(Pos.CENTER);

                VBox modificarBox = new VBox(10, buscarBox);
                modificarBox.setAlignment(Pos.CENTER);

                Stage stageBusqueda = new Stage();
                Scene escenaBusqueda = new Scene(modificarBox, 500, 100);
                escenaBusqueda.getStylesheets().add(getClass().getResource("estiloCliente.css").toExternalForm());
                stageBusqueda.setScene(escenaBusqueda);
                stageBusqueda.setTitle("Buscar Cliente por DNI");
                stageBusqueda.show();

                buscarButton.setOnAction(buscarEvent -> {
                    String dni = dniBusquedaInput.getText();

                    if (dni.isEmpty()) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Error");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Por favor, ingrese un DNI.");
                        alerta.showAndWait();
                    } else {
                        int clientId = basePalmatec.obtenerIDconDNI(dni);

                        if (clientId == -1) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Error");
                            alerta.setHeaderText(null);
                            alerta.setContentText("No existe ningún cliente con ese DNI");
                            alerta.showAndWait();
                        } else {
                            TextField nuevoDniInput = new TextField();
                            TextField nuevoNombreInput = new TextField();
                            TextField nuevosApellidosInput = new TextField();
                            TextField nuevaEdadInput = new TextField();
                            TextField nuevoTelefonoInput = new TextField();
                            Button botonGuardarModificacion = new Button("Guardar");
                            Button botonCancelarModificacion = new Button("Cancelar");
                            GridPane modificarCliente = new GridPane();
                            modificarCliente.setAlignment(Pos.CENTER);
                            modificarCliente.setHgap(10);
                            modificarCliente.setVgap(10);

                            modificarCliente.addRow(0, new Label("Nuevo DNI:"), nuevoDniInput);
                            modificarCliente.addRow(1, new Label("Nuevo Nombre:"), nuevoNombreInput);
                            modificarCliente.addRow(2, new Label("Nuevos Apellidos:"), nuevosApellidosInput);
                            modificarCliente.addRow(3, new Label("Nueva Edad:"), nuevaEdadInput);
                            modificarCliente.addRow(4, new Label("Nuevo Teléfono:"), nuevoTelefonoInput);
                            modificarCliente.add(botonGuardarModificacion, 0, 5);
                            modificarCliente.add(botonCancelarModificacion, 1, 5);

                            Scene escenaModificar = new Scene(modificarCliente, 500, 400);
                            escenaModificar.getStylesheets().add(getClass().getResource("estiloCliente.css").toExternalForm());
                            stageBusqueda.close();
                            Stage stageModificar = new Stage();
                            stageModificar.setScene(escenaModificar);
                            stageModificar.setTitle("Modificar Cliente");
                            stageModificar.show();

                            botonGuardarModificacion.setOnAction(modifyEvent -> {
                                String nuevoDni = nuevoDniInput.getText();
                                String nuevoNombre = nuevoNombreInput.getText();
                                String nuevosApellidos = nuevosApellidosInput.getText();
                                String nuevaEdadText = nuevaEdadInput.getText();
                                String nuevoTelefono = nuevoTelefonoInput.getText();

                                if (nuevoDni.isEmpty() || nuevoNombre.isEmpty() || nuevosApellidos.isEmpty() || nuevaEdadText.isEmpty() || nuevoTelefono.isEmpty()) {
                                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                                    alerta.setTitle("Error");
                                    alerta.setHeaderText(null);
                                    alerta.setContentText("Por favor, complete todos los campos.");
                                    alerta.showAndWait();
                                } else {
                                    basePalmatec.modificarCliente(clientId, nuevoDni, nuevoNombre, nuevosApellidos, Integer.parseInt(nuevaEdadText), nuevoTelefono);
                                    stageModificar.close();
                                }
                            });

                            botonCancelarModificacion.setOnAction(modifyEvent -> {
                                stageModificar.close();
                            });
                        }
                    }
                });
            });
            botonBorrar.setOnAction(event -> {
                TextField dniBorrarInput = new TextField();
                Button botonConfirmarBorrar = new Button("Confirmar");

                VBox borrarBox = new VBox(10, new Label("DNI del cliente a borrar:"), dniBorrarInput, botonConfirmarBorrar);
                borrarBox.setAlignment(Pos.CENTER);

                Stage stageBorrar = new Stage();
                Scene escenaBorrar = new Scene(borrarBox, 400, 150);
                escenaBorrar.getStylesheets().add(getClass().getResource("estiloCliente.css").toExternalForm());
                stageBorrar.setScene(escenaBorrar);
                stageBorrar.setTitle("Borrar Cliente");
                stageBorrar.show();

                botonConfirmarBorrar.setOnAction(borrarEvent -> {
                    String dni = dniBorrarInput.getText();

                    if (dni.isEmpty()) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Error");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Por favor, ingrese un DNI.");
                        alerta.showAndWait();
                    } else {
                        int clientId = basePalmatec.obtenerIDconDNI(dni);

                        if (clientId == -1) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Error");
                            alerta.setHeaderText(null);
                            alerta.setContentText("No existe ningún cliente con ese DNI");
                            alerta.showAndWait();
                        } else {
                            basePalmatec.borrarCliente(clientId);
                            stageBorrar.close();
                        }
                    }
                });
            });
        });
        //Botón para salir.
        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(e -> ventanaPrincipal.close());

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        Label titulo = new Label("Información Ordenadores");
        titulo.getStyleClass().add("titulo");
        vbox.getChildren().addAll(titulo);
        vbox.getChildren().addAll(botonFiltrar, botonVerPC, botonRegistrarCliente, botonSalir);

        root.getChildren().add(vbox);

        Scene escena = new Scene(root, 1520, 920);
        escena.getStylesheets().add(getClass().getResource("fondoImagen.css").toExternalForm());

        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("Información Ordenadores");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}