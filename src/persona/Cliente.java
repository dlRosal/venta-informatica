package persona;

import producto.Producto;

public final class Cliente extends Persona {
    // Inicializamos los atributos
    private String direccion;
    private Producto[] historialCompra;

    // Constructores
    public Cliente(String nombre, String apellido, String dni, String direccion) {
        super(nombre, apellido, dni);
        this.direccion = direccion;
    }

    public Cliente(String nombre, String apellido, String dni, String direccion, Producto[] historialCompra) {
        super(nombre, apellido, dni);
        this.direccion = direccion;
        this.historialCompra = historialCompra;
    }

    //Métodos
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
    }

    @Override
    public boolean validarDni(String dni) {
        return super.validarDni(dni);
    }

    //Getters y Setters
    public Producto[] getHistorialCompra() {
        return historialCompra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
