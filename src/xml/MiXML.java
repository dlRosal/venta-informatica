package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import org.w3c.dom.NodeList;
import venta.Venta;

public class MiXML {

    //Generar archivo XML
    public void guardarVentaEnXML(Venta venta, String archivoPath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Venta");
            doc.appendChild(rootElement);

            // Añadir elementos de la venta
            rootElement.appendChild(crearElemento(doc, "id", String.valueOf(venta.getId())));
            rootElement.appendChild(crearElemento(doc, "fecha", venta.getFecha().toString()));

            // Información del cliente
            Element clienteElement = doc.createElement("Cliente");
            clienteElement.appendChild(crearElemento(doc, "nombre", venta.getCliente().getNombre()));
            clienteElement.appendChild(crearElemento(doc, "apellido", venta.getCliente().getApellido()));
            clienteElement.appendChild(crearElemento(doc, "dni", venta.getCliente().getDni()));
            rootElement.appendChild(clienteElement);

            // Información del vendedor
            Element vendedorElement = doc.createElement("Vendedor");
            vendedorElement.appendChild(crearElemento(doc, "nombre", venta.getVendedor().getNombre()));
            vendedorElement.appendChild(crearElemento(doc, "apellido", venta.getVendedor().getApellido()));
            vendedorElement.appendChild(crearElemento(doc, "dni", venta.getVendedor().getDni()));
            rootElement.appendChild(vendedorElement);

            // Productos
            Element productosElement = doc.createElement("Productos");
            for (int i = 0; i < venta.getArrayProductos().length; i++) {
                Element productoElement = doc.createElement("Producto");
                productoElement.appendChild(crearElemento(doc, "codigo", venta.getArrayProductos()[i].getReferencia()));
                productoElement.appendChild(crearElemento(doc, "descripcion", venta.getArrayProductos()[i].getDescripcion()));
                productoElement.appendChild(crearElemento(doc, "cantidad", venta.getArrayCantidad()[i].toString()));
                productosElement.appendChild(productoElement);
            }
            rootElement.appendChild(productosElement);

            // Escribir el contenido en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoPath));

            transformer.transform(source, result);

            System.out.println("Venta guardada en: " + archivoPath);

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

    private Element crearElemento(Document doc, String nombre, String valor) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(valor));
        return elemento;
    }


    //Metodo de Manipulacion de XML
    public static void leerVentaDesdeXML(String archivoPath) {
        try {
            File archivoXML = new File(archivoPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            System.out.println("Elemento raíz: " + root.getNodeName());

            NodeList nList = doc.getElementsByTagName("Venta");

            for (int i = 0; i < nList.getLength(); i++) {
                Element ventaElement = (Element) nList.item(i);

                System.out.println("ID: " + obtenerValorElemento("id", ventaElement));
                System.out.println("Fecha: " + obtenerValorElemento("fecha", ventaElement));

                Element clienteElement = (Element) ventaElement.getElementsByTagName("Cliente").item(0);
                System.out.println("\n---Cliente---");
                System.out.println("Nombre: " + obtenerValorElemento("nombre", clienteElement));
                System.out.println("Apellido: " + obtenerValorElemento("apellido", clienteElement));
                System.out.println("DNI: " + obtenerValorElemento("dni", clienteElement));

                Element vendedorElement = (Element) ventaElement.getElementsByTagName("Vendedor").item(0);
                System.out.println("\n---Vendedor---");
                System.out.println("Nombre: " + obtenerValorElemento("nombre", vendedorElement));
                System.out.println("Apellido: " + obtenerValorElemento("apellido", vendedorElement));
                System.out.println("DNI: " + obtenerValorElemento("dni", vendedorElement));

                NodeList productosList = ventaElement.getElementsByTagName("Producto");
                System.out.println("\n---Productos---");
                for (int j = 0; j < productosList.getLength(); j++) {
                    Element productoElement = (Element) productosList.item(j);
                    System.out.println("Codigo: " + obtenerValorElemento("codigo", productoElement));
                    System.out.println("Descripción: " + obtenerValorElemento("descripcion", productoElement));
                    System.out.println("Cantidad: " + obtenerValorElemento("cantidad", productoElement));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String obtenerValorElemento(String tag, Element elemento) {
        NodeList nodeList = elemento.getElementsByTagName(tag).item(0).getChildNodes();
        return nodeList.item(0).getNodeValue();
    }

}
