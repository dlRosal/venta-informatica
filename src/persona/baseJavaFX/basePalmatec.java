package persona.baseJavaFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class basePalmatec {

    private static final String URL = "jdbc:mysql://localhost:3306/palmatec";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void añadirCliente(String dni, String nombre, String apellidos, int edad, String telefono) {
        String query = "INSERT INTO cliente (dni, nombre, apellidos, edad, telefono) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement insertar = conn.prepareStatement(query)) {
            insertar.setString(1, dni);
            insertar.setString(2, nombre);
            insertar.setString(3, apellidos);
            insertar.setInt(4, edad);
            insertar.setString(5, telefono);
            insertar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarCliente(int id, String dni, String nombre, String apellidos, int edad, String telefono) {
        String query = "UPDATE cliente SET dni = ?, nombre = ?, apellidos = ?, edad = ?, telefono = ? WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement actualizar = conn.prepareStatement(query)) {
            actualizar.setString(1, dni);
            actualizar.setString(2, nombre);
            actualizar.setString(3, apellidos);
            actualizar.setInt(4, edad);
            actualizar.setString(5, telefono);
            actualizar.setInt(6, id);
            actualizar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerIDconDNI(String dni) {
        String query = "SELECT id FROM cliente WHERE dni = ?";
        int id = -1;

        try (Connection conn = connect(); PreparedStatement consulta = conn.prepareStatement(query)) {
            consulta.setString(1, dni);
            ResultSet documentacion = consulta.executeQuery();

            if (documentacion.next()) {
                id = documentacion.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;

    }
    public void borrarCliente(int id) {
        String consulta = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement borrar = conn.prepareStatement(consulta)) {
            borrar.setInt(1, id);
            borrar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}