
package parteB_aplicandoObjetos;

import java.util.ArrayList;

public class Cliente {
    private int numero;
    private String razonSocial;
    private long cuit;
    private ArrayList<Factura> facturas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int numero, String razonSocial, long cuit) {
        this.numero = numero;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    
    public void addFacturas(Factura factura){
        this.facturas.add(factura);
    }
    
    
}
