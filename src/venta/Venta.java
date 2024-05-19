package venta;

import persona.Cliente;
import persona.Vendedor;
import producto.Producto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Venta implements Comparable {
    // Inicializamos los atributos
    private int id;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Vendedor vendedor;
    private Producto[] arrayProductos = new Producto[3];
    private Integer[] arrayCantidad = new Integer[3];
    protected static Logger logger;

    //Constructor
    public Venta(int id, LocalDateTime fecha, Cliente cliente, Vendedor vendedor, Producto[] arrayProductos, Integer[] arrayCantidad) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.arrayProductos = arrayProductos;
        this.arrayCantidad = arrayCantidad;
    }

    //Método estático
    public static void registroVenta(Venta venta) {
        System.out.println("Venta registrada: " + venta);
    }

    // Método para guardar la venta en XML usando la clase MiXML
    public void guardarVentaEnXML(String archivoPath) {
        xml.MiXML xmlUtil = new xml.MiXML();
        xmlUtil.guardarVentaEnXML(this, archivoPath);
    }

    //Interfaz Comparable
    @Override
    public int compareTo(Object objeto) {
        // Evaluamos si el objeto esta a "null"
        if(objeto==null) throw new IllegalArgumentException("No puede ser nulo");
        // Evaluamos si el objeto es una instancia de "Venta"
        if(!(objeto instanceof Venta)) throw new IllegalArgumentException("Debe de ser del tipo Venta");
        // Comparamos si la factura pasada es mayor(1), menor(-1) o son iguales (0)
        if(((Venta)objeto).getId()==this.getId()) {
            // Si son iguales devolvemos un 0
            return 0;
        } else if(((Venta)objeto).getId()<this.getId()) {
            // Si el objeto pasado tiene un id menor devolvemos un -1
            return -1;
        } else {
            // Si el objeto pasado tiene un id mayor devolvemos un 1.
            return 1;
        }
    }
    //Getters y Setters
    public Producto[] getArrayProductos() {
        return arrayProductos;
    }

    public Integer[] getArrayCantidad() {
        return arrayCantidad;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                '}';
    }
}

