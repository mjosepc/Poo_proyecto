package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestorUsuario {
    private List<Usuario> listaUsuarios;
    ///comentario

    public GestorUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void eliminar(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public void listaUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
            System.out.println("Nombre de la empresa: " + usuario.getNombreEmpresa());
            System.out.println("Contraseña: " + usuario.getContrasena());
            System.out.println("Sesión iniciada: " + usuario.isSesionIniciada());
            System.out.println("---------------");
        }
    }

    public Usuario iniciarSesion(String nombre, String contrasena) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                usuario.iniciarSesion();
                return usuario;
            }
        }
        return null;
    }

    public void cerrarSesion(Usuario usuario) {
        if (usuario != null) {
            usuario.cerrarSesion();
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
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    if (!gestor.existeUsuario(nuevoUsuario.getNombreUsuario())) {
                        gestor.agregar(nuevoUsuario);
                        System.out.println("Registro exitoso.");
                    } else {
                        System.out.println("El nombre de usuario ya está en uso. Intente con otro.");
                    }
                }
                case 2 -> {
                    if (usuarioActual != null && usuarioActual.isSesionIniciada()) {
                        System.out.println("Ya ha iniciado sesión como " + usuarioActual.getNombreUsuario() + ".");
                    } else {
                        System.out.print("Ingrese su nombre de usuario: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        String contrasena = scanner.nextLine();

                        usuarioActual = gestor.iniciarSesion(nombre, contrasena);

                        if (usuarioActual != null) {
                            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual.getNombreUsuario() + "!");
                            System.out.println("Empresa: " + usuarioActual.getNombreEmpresa());
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos. Intente de nuevo.");
                        }
                    }
                }

            }
        }
    }
}