

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Producto> inventario = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bienvenido a la aplicación de gestión de inventario");
            System.out.println("1. Registrar un producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarProducto() {
        System.out.println("Ingrese los datos del producto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción (opcional): ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("ID (código de barras): ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Producto producto = new Producto(nombre, descripcion, precio, codigoBarras, stock);
        inventario.put(codigoBarras, producto);

        System.out.println("Registro exitoso.");
    }

    private static void listarProductos() {
        System.out.println("Inventario de productos:");
        for (Producto producto : inventario.values()) {
            System.out.println(producto);
        }
    }
}

class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private String codigoBarras;
    private int stock;

    public Producto(String nombre, String descripcion, double precio, String codigoBarras, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigoBarras = codigoBarras;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Descripción: " + descripcion +
                ", Precio: " + precio +
                ", Código de Barras: " + codigoBarras +
                ", Stock: " + stock;
    }
}
