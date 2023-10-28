package org.example;
import java.util.*;

class Producto {
    private String nombre;
    private int stock;
    private int codigoBarra;
    private int precio;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getCodigoBarra() { return codigoBarra; }
    public void setCodigoBarra(int codigoBarra) { this.codigoBarra = codigoBarra; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
}

class Usuario {
    private String nombreUsuario;
    private String nombreEmpresa;
    private String contraseña;

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}

class GestorDeUsuario {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void agregar(Usuario usuario) { listaUsuarios.add(usuario); }
    
    public void eliminar(Usuario usuario) { listaUsuarios.remove(usuario); }

}

class Inventario {
    private List<Producto> listaProductos = new ArrayList<>();

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProductoPorCodigo(int codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigoBarra() == codigo) {
                return producto;
            }
        }
        return null;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeUsuario gestorDeUsuario = new GestorDeUsuario();
        Inventario inventario = new Inventario();
        Usuario usuarioActual = null;

        while (true) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear usuario");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
            }

            if (usuarioActual != null) {
                while (true) {
                    System.out.println("1. Agregar producto al inventario");
                    System.out.println("2. Eliminar producto del inventario");
                    System.out.println("3. Buscar producto por nombre");
                    System.out.println("4. Buscar producto por código");
                    System.out.println("5. Cerrar sesión");
                    int subOpcion = scanner.nextInt();

                    switch (subOpcion) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            usuarioActual = null;
                            break;
                    }

                    if (usuarioActual == null) {
                        break;
                    }
                }
            }
        }
    }
}
