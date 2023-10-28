import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Clase Producto
public class Producto {
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

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getCodigoBarra() { return codigoBarra; }
    public void setCodigoBarra(int codigoBarra) { this.codigoBarra = codigoBarra; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
}

// Clase Usuario
public class Usuario {
    private String nombreUsuario;
    private String nombreEmpresa;
    private String contraseña;

    public Usuario(String nombreUsuario, String nombreEmpresa, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}

// Clase GestorUsuario
public class GestorUsuario {
    private List<Usuario> listaUsuarios;

    public GestorUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }

    public void crearUsuario(String nombreUsuario, String nombreEmpresa, String contraseña) {
        Usuario nuevoUsuario = new Usuario(nombreUsuario, nombreEmpresa, contraseña);
        listaUsuarios.add(nuevoUsuario);
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public List<Usuario> getListaUsuarios() { return listaUsuarios; }
    public void setListaUsuarios(List<Usuario> listaUsuarios) { this.listaUsuarios = listaUsuarios; }
}

// Clase Menu
public class Menu {
    private GestorUsuario gestorUsuario;

    public Menu() {
        this.gestorUsuario = new GestorUsuario();
    }

    // Método para mostrar el menú
    // Nota: Este método requiere interacción del usuario, por lo que no funcionará en este entorno.
}

// Clase Registro
public class Registro {
    private String fecha;
    private Producto nombreProducto;

    public Registro(String fecha, Producto nombreProducto) {
        this.fecha = fecha;
        this.nombreProducto = nombreProducto;
    }

    // Método para agregar a un CSV
    // Nota: Este método requiere acceso al sistema de archivos, por lo que no funcionará en este entorno.
}