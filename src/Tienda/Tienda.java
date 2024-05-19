package Tienda;

import persona.Cliente;
import persona.Vendedor;
import producto.Producto;
import venta.Venta;
import xml.MiXML;

import java.time.LocalDateTime;

/**
 * Clase Principal del proyecto que ejecuta los métodos de las diferentes clases, equivale a la Clase Test
 * @author Rosal
 * @version 7.8
 */
public class Tienda {

    public static void main(String[] args) {
        // Creación de un cliente con sus detalles personales
        Cliente cliente = new Cliente("Juan", "Perez", "12345678A", "Calle Falsa 123");

        // Creación de un vendedor con sus detalles personales y su salario
        Vendedor vendedor = new Vendedor("Ana", "Garcia", "87654321B", 2500);

        // Creación de productos que se van a vender en la tienda
        Producto portatil = new Producto("001", "Laptop", "HP", "Envy", "Electrónica", 1200.00);
        Producto raton = new Producto("002", "Mouse", "Logitech", "MX Master", "Periféricos", 89.91);
        Producto teclado = new Producto("003", "Teclado", "Corsair", "K95", "Periféricos", 103.94);
        Producto ordenador = new Producto("004", "Ordenador", "MSI", "Gaming", "Ordenador", 750.95);


        // Arreglo de productos que forman parte de una venta
        Producto[] productos = {portatil, raton, teclado, ordenador};
        // Cantidades de cada producto vendido
        Integer[] cantidades = {1, 2, 1, 1};

        // Creación de una venta con sus detalles
        Venta venta = new Venta(1, LocalDateTime.now(), cliente, vendedor, productos, cantidades);

        // Validación del DNI del cliente y muestra de información
        if (cliente.validarDni(cliente.getDni())) {
            System.out.println("DNI correcto");
        } else {
            System.out.println("DNI incorrecto");
        }
        cliente.mostrarInformacion();

        // Validación del DNI del vendedor y muestra de información
        if (vendedor.validarDni(vendedor.getDni())) {
            System.out.println("DNI correcto");
        } else {
            System.out.println("DNI incorrecto");
        }
        vendedor.mostrarInformacion();

        // Registro de la venta en el sistema
        Venta.registroVenta(venta);

        System.out.println("\nGenerando archivo XML...");
        // Guardar la venta en un archivo XML
        String archivoPath = "venta.xml";
        MiXML miXML = new MiXML();
        miXML.guardarVentaEnXML(venta, archivoPath);

        System.out.println("\nLeyendo archivo XML...");
        // Leer y mostrar la venta desde el archivo XML
        MiXML.leerVentaDesdeXML(archivoPath);
    }
}
