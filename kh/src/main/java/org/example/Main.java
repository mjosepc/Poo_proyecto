package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(); // Crea una instancia de la clase Menu
        menu.mostrarMenu(); // Llama al método mostrarMenu para mostrar el menú
    }
}

public class Producto {
    // Atributos
    private String nombre;
    private int stock;
    private int codigoBarra;
    private int precio;

    // Constructor
    public Producto(String nombre, int stock, int codigoBarra, int precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
    }

    // Métodos get y set para cada atributo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String nombreEmpresa;
    private String contraseña;

    // Constructor
    public Usuario(String nombreUsuario, String nombreEmpresa, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this contraseña = contraseña;
    }

    // Métodos get y set para cada atributo
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

public class GestorUsuario {
    // Atributo
    private List<Usuario> listaUsuarios;

    // Constructor
    public GestorUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }

    // Método para crear un usuario
    public void crearUsuario(String nombreUsuario, String nombreEmpresa, String contraseña) {
        Usuario nuevoUsuario = new Usuario(nombreUsuario, nombreEmpresa, contraseña);
        listaUsuarios.add(nuevoUsuario);
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    // Métodos get y set para el atributo listaUsuarios
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}

public class Menu {
    // Atributo
    private GestorUsuario gestorUsuario;

    // Constructor
    public Menu() {
        this.gestorUsuario = new GestorUsuario();
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contraseña = scanner.nextLine();
                    if (gestorUsuario.iniciarSesion(nombreUsuario, contraseña)) {
                        System.out.println("Inicio de sesión exitoso!");
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese su nombre de usuario: ");
                    nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el nombre de su empresa: ");
                    String nombreEmpresa = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    contraseña = scanner.nextLine();
                    gestorUsuario.crearUsuario(nombreUsuario, nombreEmpresa, contraseña);
                    System.out.println("Cuenta creada exitosamente!");
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}

