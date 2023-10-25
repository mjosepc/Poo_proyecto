
public class Producto {
    private String nombre;
    private int stock;
    private int codigoBarra;
    private int precio;

    public Producto(String nombre, int stock, int codigoBarra, int precio){
        this.nombre = nombre;
        this.stock = stock;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getCodigoBarra(){
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public int getPrecio(){
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
