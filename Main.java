import java.util.*;

class Producto {
    private String nombre;
    private int stock;
    private int codigoBarra;
    private int precio;

    public Producto(String nombre, int stock, int codigoBarra, int precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
    }

    // Métodos setter y getter para los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}

class Usuario {
    private String nombreUsuario;
    private String nombreEmpresa;
    private int contrasena;

    public Usuario(String nombreUsuario, String nombreEmpresa, int contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.contrasena = contrasena;

    }

    public String getNombre() {
        return nombreUsuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }


    public static Usuario registrarse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();
        return new Usuario(nombre, contrasena, nombreEmpresa);
    }

    public static Usuario iniciarSesion(Map<String, Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(nombre) && usuarios.get(nombre).getContrasena().equals(contrasena)) {
            return usuarios.get(nombre);
        } else {
            return null;
        }
    }

}

class Calculadora {
    private int precio;
    private int numeroVenta;

    public Calculadora(int precio, int numeroVenta) {
        this.precio = precio;
        this.numeroVenta = numeroVenta;
    }
    public int calcularProducto(){
        return precio * numeroVenta;
    }

}

class Registro {
    private String fecha;
    private String nombreProducto;


    public Registro(String fecha, String nombreProducto){
        this.fecha= fecha;
        this.nombreProducto = nombreProducto;
    }
    public void generarVentasDia(Calculadora calculadora) {

    }
}

class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public Producto buscarProductos(String nombre){

    }
    public void modificarProducto(){

    }

    public void agregarProducto(){

    }

    public void eliminarProducto(){

    }
    public void mostrarProductos(){

    }
}

class Venta{
    String fechaVenta;
    int productoVendido;

    int cantidad;
    int montoTotal;

}

class HistorialVentas{
    String entradaProducto;
    String salidaProducto;

    int ventas;
    int compras;
    int cambioStock;

}
class GestorUsuario{
    public void agregar(){

    }
    public void eliminar(){

    }
    public void gestionCuentasUsuario(){

    }

}
class GestorInventario{

}
public class Main {
    public static void main(String[] args) {
        Map<String, Usuario> usuarios = new HashMap<>();
        Usuario usuarioActual;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    Usuario nuevoUsuario = registrarse();
                    usuarios.put(nuevoUsuario.getNombre(), nuevoUsuario);
                    System.out.println("Registro exitoso.");
                }
                case 2 -> {
                    usuarioActual = iniciarSesion(usuarios);
                    if (usuarioActual != null) {
                        System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual.getNombre() + "!");
                        System.out.println("Empresa: " + usuarioActual.getNombreEmpresa());
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos. Intente de nuevo.");
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
