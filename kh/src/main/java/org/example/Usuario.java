package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Usuario {
    private final String nombre;
    private final String contrasena;

    private final String nombreEmpresa;

    private final String mailEmpresa;
    private boolean sesionIniciada;

    public Usuario(String nombre, String contrasena, String nombreEmpresa, String mailEmpresa) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.nombreEmpresa = nombreEmpresa;
        this.mailEmpresa = mailEmpresa;

        this.sesionIniciada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getMailEmpresa() {
        return mailEmpresa;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void iniciarSesion() {
        sesionIniciada = true;
    }

    public void cerrarSesion() {
        sesionIniciada = false;
    }

    public static Usuario registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();
        System.out.print("Ingrese el mail/gmail de la empresa: ");
        String mailEmpresa = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();

        return new Usuario(nombre, nombreEmpresa, mailEmpresa, contrasena);
    }

    public static Usuario iniciarSesion(Map<String, Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(nombre) && usuarios.get(nombre).getContrasena().equals(contrasena)) {
            Usuario usuario = usuarios.get(nombre);
            usuario.iniciarSesion();
            return usuario;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, Usuario> usuarios = new HashMap<>();
        Usuario usuarioActual = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Cerrar sesión");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    Usuario nuevoUsuario = registrarUsuario();
                    usuarios.put(nuevoUsuario.getNombre(), nuevoUsuario);
                    System.out.println("Registro exitoso.");
                }
                case 2 -> {
                    if (usuarioActual != null && usuarioActual.isSesionIniciada()) {
                        System.out.println("Ya ha iniciado sesión como " + usuarioActual.getNombre() + ".");
                    } else {
                        usuarioActual = iniciarSesion(usuarios);
                        if (usuarioActual != null) {
                            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual.getNombre() + "!");
                            System.out.println("Empresa: " + usuarioActual.getNombreEmpresa());
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos. Intente de nuevo.");
                        }
                    }
                }
                case 3 -> {
                    if (usuarioActual != null) {
                        usuarioActual.cerrarSesion();
                        System.out.println("Cierre de sesión exitoso.");
                    } else {
                        System.out.println("No ha iniciado sesión.");
                    }
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
