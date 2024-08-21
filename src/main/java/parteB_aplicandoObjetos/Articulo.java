
package parteB_aplicandoObjetos;

import java.util.ArrayList;

public class Articulo {
   private int codigo;
   private String denominacion;
   private double precio;
   private String unidadMedida;
   private ArrayList<DetalleFactura> detallesFacturas = new ArrayList<>();
   
    private String[][] articulos = {{"100", "Azucar", "20", "U"}, {"101", "Leche", "30", "U"},
    {"102", "Aceite", "50", "U"}, {"103", "Sal", "45", "U"}, {"104", " Fideos", "15", "U"},
    {"105", " Arroz", "28", "U"}, {"106", "Galletas", "26", "U"}, {"107", "Carne Molida", "220",
        "Kg"}, {"108", "Shampoo", "42", "U"}, {"109", "Queso Mantecoso", "178", "Kg"},
    {"110", "Jamon Cocido", "320", "Kg"}, {"111", "Naranjas", "80", "Kg"}};

    public Articulo() {
    }

    public Articulo(int codigo, String denominacion, double precio, String unidadMedida) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public ArrayList<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(ArrayList<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public void addDetalle(DetalleFactura detalle){
        this.detallesFacturas.add(detalle);
    }
    
        public void mostrarArticulos(){
        for(String[] articulo: articulos){
            System.out.println("Código:"+articulo[0]+ "\tDenominacion:"+articulo[1]+ "\tPrecio:"+articulo[2]
                    + "\tUnidad de medida:"+articulo[3]);
        }
    }
    
    public String [] verificarArticulo(String codigoIngresado){
        for(String [] articulo: articulos){
            if(codigoIngresado.equals(articulo[0])){
                return articulo;
            } 
        }
        return null;
    }
}
