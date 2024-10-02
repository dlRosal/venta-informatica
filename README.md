# VentaInformatica

**VentaInformatica** es un proyecto de gestión de ventas desarrollado en Java. Proporciona funcionalidades para gestionar productos, clientes, vendedores y el inventario de una tienda, integrando estilos mediante CSS para mejorar la experiencia del usuario.

## Características

- **Gestión de productos**: Añade, edita y elimina productos de la tienda.
- **Gestión de clientes y vendedores**: Maneja la información de los clientes y vendedores que interactúan con la tienda.
- **Control de inventario**: Revisa el stock de productos y su disponibilidad.
- **Exportación de datos**: Los datos pueden ser exportados en formato XML.
- **Interfaz estilizada**: El proyecto usa CSS (como `fondoImagen.css` y `estiloCliente.css`) para mejorar la presentación visual.

## Requisitos

- **Java 11** o superior
- Un IDE compatible como **IntelliJ IDEA** o **Eclipse**
- [JavaFX](https://openjfx.io/) para la interfaz gráfica de usuario (GUI)

## Instalación

1. Clona el repositorio desde GitHub:
    ```bash
    git clone https://github.com/LedLas0r/ventaInformatica.git
    ```

2. Abre el proyecto en tu IDE de preferencia (Eclipse, IntelliJ, etc.).

3. Asegúrate de que las dependencias necesarias estén correctamente configuradas, como JavaFX.

4. Compila y ejecuta el proyecto:
    ```
    javac Main.java
    java Main
    ```

## Estructura del Proyecto

```bash
ventaInformatica/
│
├── src/
│   ├── logger/            # Gestión de logs
│   ├── persona/           # Gestión de personas (clientes, vendedores)
│   ├── producto/          # Gestión de productos
│   ├── Tienda/            # Clases relacionadas con la tienda
│   ├── venta/             # Clases relacionadas con las ventas
│   └── xml/               # Exportación a XML
│
├── styles/
│   ├── fondoImagen.css     # Estilo para fondos de pantalla
│   └── estiloCliente.css   # Estilo específico para clientes
│
├── out/                   # Archivos compilados
│
├── README.md              # Documentación del proyecto
└── .gitignore             # Archivos y carpetas a ignorar por Git
