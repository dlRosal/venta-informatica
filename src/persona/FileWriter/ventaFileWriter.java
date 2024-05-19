package persona.FileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ventaFileWriter {
    public static void main(String[] args) {
        double precio1 = 1450.90, precio2 = 789.85, precio3 = 889.45, precio4 = 900.20, precio5 = 324.90, precio6 = 487.20;
        String especificaciones = "", precio = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- BIENVENIDO A PALMATEC --");
        System.out.println("Indiquenos que tipo de ordenador desea: ");
        String tipoOrdenador = scanner.nextLine();
        if (tipoOrdenador.equalsIgnoreCase("Gaming")) {
            System.out.println("HA SELECCIONADO EL TIPO DE ORDENADOR GAMING! LISTO PARA JUGAR?");
            System.out.println("Cual de todos los ordenadores desea:");
            System.out.println("Seleccione una opción (1-3):");
            System.out.println("1. Ordenador Gaming. Opción de precio más alto");
            System.out.println("2. Ordenador Gaming. Opción de precio más bajo");
            System.out.println("3. Ordenador Gaming. Opción mejor relación calidad / precio");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    especificaciones = ("\nIntel Core i9-13400K 3.8 GHz\n" +
                            "MSI TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz  32GB\n" +
                            "Kingston SN770 2TB NVMe SSD\n" +
                            "ASUS Dual GeForce RTX 4090 EVO OC \n" +
                            "MarsGaming PSU PRO 850W 80+ Bronze");
                    precio = String.valueOf(precio1);
                    break;
                case 2:
                    especificaciones =("\nIntel Core i5-10600K 4.1 GHz\n" +
                            "ASUS TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz  8GB\n" +
                            "Kingston SN770 500GB NVMe SSD\n" +
                            "Nvidia Dual GeForce RTX 2060 EVO OC \n" +
                            "MarsGaming PSU PRO 650W 80+ Bronze");
                    precio = String.valueOf(precio2);
                    break;
                case 3:
                    especificaciones = ("\nIntel Core i7-12400F 2.5 GHz\n" +
                            "ASUS TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz  16GB\n" +
                            "Kingston SN770 1TB NVMe SSD\n" +
                            "ASUS Dual GeForce RTX 3070 EVO OC \n" +
                            "MarsGaming PSU PRO 750W 80+ Bronze");
                    precio = String.valueOf(precio3);
                    break;
                default:
                    especificaciones = ("SOLAMENTE TENEMOS DISPONIBLES TRES ORDENADORES.");

            }
            try {
                FileWriter writer = new FileWriter("C:\\Users\\Rosalillo\\Desktop\\presupuesto.txt");
                writer.write("Especificaciones: " + especificaciones + "\n");
                writer.write("Precio: " + precio + " euros\n");
                writer.close();
                System.out.println("Se ha creado el archivo 'especificaciones_ordenador.txt' con éxito.\n ABRE EL ARCHIVO PARA VER PRECIO Y LAS ESPECICIFACIONES DEL ORDENADOR ELEGIDO");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al crear el archivo.");
                e.printStackTrace();
            }
        } else if (tipoOrdenador.equalsIgnoreCase("Oficina")) {
            System.out.println("HA ELEGIDO LA OPCIÓN DE ORDENADORES DE OFICINA.");
            System.out.println("Cual de todos los ordenadores desea:");
            System.out.println("Seleccione una opción (1-3):");
            System.out.println("1. Ordenador de Oficina. Opción de precio más alto");
            System.out.println("2. Ordenador de Oficina. Opción de precio más bajo");
            System.out.println("3. Ordenador de Oficina. Opción mejor relación calidad / precio");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    especificaciones = ("\nIntel Core i7-13700 2.5 GHz\n" +
                            "ASUS TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz  32GB\n" +
                            "Kingston SN770 2TB NVMe SSD\n" +
                            "MarsGaming PSU PRO 850W 80+ Bronze");
                    precio = String.valueOf(precio4);

                    break;
                case 2:
                    especificaciones = ("\nIntel Core i3-9700 2.5 GHz\n" +
                            "ASUS TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz 8GB\n" +
                            "Kingston SN770 500TB NVMe SSD\n" +
                            "MarsGaming PSU PRO 650W 80+ Bronze");
                    precio = String.valueOf(precio5);

                    break;
                case 3:
                    especificaciones = ("\nIntel Core i5-10400K 4.1 GHz\n" +
                            "ASUS TUF GAMING B650-PLUS\n" +
                            "HyperX  DDR4 3200MHz  16GB\n" +
                            "Kingston SN770 1TB NVMe SSD\n" +
                            "MarsGaming PSU PRO 750W 80+ Bronze");
                    precio = String.valueOf(precio6);
                    break;

                default:
                    System.out.println("SOLAMENTE TENEMOS DISPONIBLES TRES ORDENADORES.");
            }
                    try {
                        FileWriter writer = new FileWriter("C:\\Users\\Rosalillo\\Desktop\\presupuesto.txt");
                        writer.write("Especificaciones: " + especificaciones + "\n");
                        writer.write("Precio: " + precio + " euros\n");
                        writer.close();
                        System.out.println("Se ha creado el archivo 'especificaciones_ordenador.txt' con éxito.");
                    } catch (IOException e) {
                        System.out.println("Ha ocurrido un error al crear el archivo.\n ABRE EL ARCHIVO PARA VER PRECIO Y LAS ESPECICIFACIONES DEL ORDENADOR ELEGIDO");
                        e.printStackTrace();
                    }

        }else {
            System.out.println("Ese tipo de ordenador aún no lo tenemos tienda. \n A CONTINUACIÓN ESCRIBA UNA SUGERENCIA PARA TENERLA EN CUENTA.");
            String sugerencia = scanner.nextLine();
            System.out.println("MUCHAS GRACIAS POR SU OPINIÓN. Tendremos en cuenta su sugerencia --> " + sugerencia);
            System.out.println("-- SALIENDO DE PALMATEC --");
        }
    }
}