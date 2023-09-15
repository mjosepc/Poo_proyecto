import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;

    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getContrasena(){
        return contrasena;
    }
}

public class Registrarse{
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bienvenido a InventarioXpress");
            System.out.println("Registrarse, presione 1");
            System.out.println("Iniciar sesión, presione 2");
            System.out.println("Salir, presione 3");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    iniciosesion(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo");
                    scanner.close();
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
                    break;
            }
        }
    }
    private static void registrarUsuario(Scanner scanner){
        System.out.println("Ingrese un nombre de usuario");
        String nombreUsuario = scanner.next();
        System.out.println("Ingrese una contraseña segura");
        String contrasena = scanner.next();

        Usuario usuario = new Usuario(nombreUsuario, contrasena);
        usuarios.add(usuario);

        System.out.println("Registro exitoso");

    }
    private static void iniciosesion(Scanner scanner){
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.next();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.next();

        for (Usuario usuario: usuarios){
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)){
                System.out.println("Haz iniciado sesion, Bienvenido," + nombreUsuario);
                return;
            }
        }

        System.out.println("datos incorrectos, ingrese nuevamente");
    }
}
