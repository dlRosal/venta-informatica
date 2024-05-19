package producto;

public class Producto implements Comparable {
    // Inicializamos los atributos
    private String codigo, descripcion, marca, modelo, categoria;
    private double precio;

    //Constructor
    public Producto(String codigo, String descripcion, String marca, String modelo, String categoria, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.precio = precio;
    }

    //Interfaz Comparable
    @Override
    public int compareTo(Object objeto) {
        // Evaluamos si el objeto esta a "null"
        if(objeto==null) throw new IllegalArgumentException("No puede ser nulo");
        // Evaluamos si el objeto es una instancia de "Producto"
        if(!(objeto instanceof Producto)) throw new IllegalArgumentException("El parámetro ha de ser tipo Empleado");
        // Como en este caso el identificador es de tipo String, he usado el "compareto" de String
        return this.codigo.compareTo(((Producto)objeto).codigo);
    }

    //Getters y Setters
    public String getReferencia() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
