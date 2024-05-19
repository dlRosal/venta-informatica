package persona;

import venta.Venta;


public final class Vendedor extends Persona {
    // Inicializamos los atributos
    private double salario;
    private Venta[] ventas;

    // Constructores
    public Vendedor(String nombre, String apellido, String dni, double salario) {
        super(nombre, apellido, dni);
        this.salario = salario;
    }

    public Vendedor(String nombre, String apellido, String dni, double salario, Venta[] ventas) {
        super(nombre, apellido, dni);
        this.salario = salario;
        this.ventas = ventas;
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
    public Venta[] getVentas() {
        return ventas;
    }

    public double getSalario() {
        return salario;
    }
}