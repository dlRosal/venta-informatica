package persona;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Persona es la clase padre, molde y comportamiento de las distintas clases hijos del proyecto, que son Cliente y Vendedor
 * @author Rosalillo
 * @version 1.0
 */
public abstract class Persona {
    // Inicializamos los atributos
    protected String nombre, apellido, dni;
    protected static Logger logger;

    // Constructor
    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Métodos
    public void mostrarInformacion(){
        System.out.println("\n---Datos Personales---" +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDNI: " + dni + "\n");

    }
    //Expresión Regular
    public boolean validarDni(String dni) {
        String regex = "\\d{8}[A-HJ-NP-TV-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dni);
        return matcher.matches();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public static Logger getLogger() {
        return logger;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static void setLogger(Logger logger) {
        Persona.logger = logger;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
