package org.example;

import java.util.*;

class Usuario {
    private final String nombreUsuario;
    private final String nombreEmpresa;
    private final String contrasena;
    private boolean sesionIniciada;

    public Usuario(String nombreUsuario, String nombreEmpresa, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.contrasena = contrasena;
        this.sesionIniciada = false;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }


    public void cerrarSesion() {
        sesionIniciada = false;
        System.out.println("Sesión cerrada. Hasta luego, " + nombreUsuario + "!");
    }

    public static Usuario registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();

        System.out.print("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();

        return new Usuario(nombreUsuario, nombreEmpresa, contrasena);
    }

    public void iniciarSesion(String nombreUsuario, String contrasena) {
        if (this.nombreUsuario.equals(this.nombreUsuario) && this.contrasena.equals(this.contrasena)) {
            sesionIniciada = true;
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + this.nombreUsuario + "!");
        } else {
            System.out.println("Datos incorrectos. Intente de nuevo.");
        }
    }
}
}
class GestorUsuario {
    private List<Usuario> listaUsuarios;
    private Usuario usuarioActual;

    public GestorUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void eliminar(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
            System.out.println("Nombre de la empresa: " + usuario.getNombreEmpresa());
            System.out.println("Contraseña: " + usuario.getContrasena());
            System.out.println("Sesión iniciada: " + usuario.isSesionIniciada());
            System.out.println("---------------");
        }
    }

    public void cerrarSesion() {
        if (usuarioActual != null) {
            usuarioActual.cerrarSesion();
            usuarioActual = null;
        }
    }

    public boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GestorUsuario gestor = new GestorUsuario();
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioActual = null;

        while (true) {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Cerrar sesión");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    usuarioActual = Usuario.registrarUsuario();
                    System.out.println("Registro exitoso.");
                    gestor.agregar(usuarioActual);
                    break;
                case 2:
                    if (usuarioActual == null || !usuarioActual.isSesionIniciada()) {
                        System.out.print("Ingrese su nombre de usuario: ");
                        String nombreUsuario = scanner.next();
                        System.out.print("Ingrese su contraseña: ");
                        String contrasena = scanner.next();
                        if (usuarioActual == null) {
                            usuarioActual = new Usuario("NombreTemporal", "EmpresaTemporal", "MailTemporal", "ContraseñaTemporal");
                        }
                        usuarioActual.iniciarSesion(nombreUsuario, contrasena);
                    } else {
                        System.out.println("Ya ha iniciado sesión como " + usuarioActual.getNombreUsuario() + ".");
                    }
                    break;
                case 3:
                    if (usuarioActual != null && usuarioActual.isSesionIniciada()) {
                        usuarioActual.cerrarSesion();
                    } else {
                        System.out.println("No ha iniciado sesión.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
