package org.example;
import java.util.*;

class Producto {
    private String nombre;
    private int stock;
    private int codigoBarra;
    private double precio;

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

    public double getPrecio() {
        return precio; }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

class Usuario {
    private String nombreUsuario;
    private String nombreEmpresa;
    private String contraseña;

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

class GestorDeUsuario {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void agregar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void eliminar(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
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


    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                    usuarioActual = iniciarSesion(gestorDeUsuario);
                    break;
                case 2:
                    crearUsuario(gestorDeUsuario);
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
                            agregarProducto(inventario);
                            break;
                        case 2:
                            eliminarProducto(inventario);
                            break;
                        case 3:
                            buscarProductoPorNombre(inventario);
                            break;
                        case 4:
                            buscarProductoPorCodigo(inventario);
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

    static Usuario iniciarSesion(GestorDeUsuario gestorDeUsuario) {
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.next();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.next();

        Usuario usuario = gestorDeUsuario.buscarUsuarioPorNombre(nombreUsuario);

        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            return usuario;
        }

        System.out.println("Credenciales incorrectas.");
        return null;
    }

    static void crearUsuario(GestorDeUsuario gestorDeUsuario) {
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.next();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.next();
        System.out.println("Ingrese el nombre de su empresa:");
        String nombreEmpresa = scanner.next();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setNombreEmpresa(nombreEmpresa);

        gestorDeUsuario.agregar(nuevoUsuario);

        System.out.println("Usuario creado exitosamente.");
    }

    static void agregarProducto(Inventario inventario) {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.next();
        System.out.println("Ingrese el stock del producto:");
        int stock = scanner.nextInt();
        System.out.println("Ingrese el código de barras del producto:");
        int codigoBarra = scanner.nextInt();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();

        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setStock(stock);
        nuevoProducto.setCodigoBarra(codigoBarra);
        nuevoProducto.setPrecio(precio);

        inventario.getListaProductos().add(nuevoProducto);

        System.out.println("Producto agregado exitosamente.");
    }

    static void eliminarProducto(Inventario inventario) {
        System.out.println("Ingrese el código de barras del producto a eliminar:");
        int codigoBarra = scanner.nextInt();

        Producto productoAEliminar = null;

        for (Producto producto : inventario.getListaProductos()) {
            if (producto.getCodigoBarra() == codigoBarra) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            inventario.getListaProductos().remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("No se encontró el producto con el código de barras proporcionado.");
        }
    }

    static void buscarProductoPorNombre(Inventario inventario) {
        System.out.println("Ingrese el nombre del producto a buscar:");
        String nombre = scanner.next();

        Producto productoEncontrado = inventario.buscarProductoPorNombre(nombre);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.getNombre());
        } else {
            System.out.println("No se encontró el producto con el nombre proporcionado.");
        }
    }

    static void buscarProductoPorCodigo(Inventario inventario) {
        System.out.println("Ingrese el código de barras del producto a buscar:");
        int codigoBarra = scanner.nextInt();

        Producto productoEncontrado = inventario.buscarProductoPorCodigo(codigoBarra);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.getNombre());
        } else {
            System.out.println("No se encontró el producto con el código de barras proporcionado.");
        }
    }
}