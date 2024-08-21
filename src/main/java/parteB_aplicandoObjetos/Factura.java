
package parteB_aplicandoObjetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Factura {
    private String letra;
    private int numero;
    private double recargo;
    private String tipoPago;
    private double totalItems, totalFinal;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<DetalleFactura> detallesFacturas = new ArrayList<>();
    private String [][] itemsFactura;

    public String[][] getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(String[][] itemsFactura) {
        this.itemsFactura = itemsFactura;
    }

    public Factura() {
    }

    public Factura(String letra, int numero, double recargo, String tipoPago, double totalItems, double totalFinal, Date fecha, Cliente cliente) {
        this.letra = letra;
        this.numero = numero;
        this.recargo = recargo;
        this.tipoPago = tipoPago;
        this.totalItems = totalItems;
        this.totalFinal = totalFinal;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(ArrayList<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(double totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void addDetalle(DetalleFactura detalle){
        this.detallesFacturas.add(detalle);
    }
    
    public DetalleFactura agregarArticulo(String[] articulo, int posicion, Scanner sc) {
        itemsFactura[posicion][0] = articulo[0];
        itemsFactura[posicion][1] = articulo[1];
        itemsFactura[posicion][2] = articulo[2];
        
        String cantidadAFact=null;
        
        System.out.println("Ingrese la cantidad a facturar: ");
        if (articulo[3].equalsIgnoreCase("U")) {
            System.out.println("Ingrese un numero entero");
            cantidadAFact = sc.nextLine();

            while (cantidadAFact.contains(".") & isInteger(cantidadAFact) == false) {
                System.out.println("El numero ingresado no es un entero, intente nuevamente: ");
                cantidadAFact = sc.nextLine();
            }
            
        } else if (articulo[3].equalsIgnoreCase("KG")) {
            System.out.println("Ingrese un numero decimal: ");
            cantidadAFact = sc.nextLine();

            while (!cantidadAFact.contains(".") || !isDouble(cantidadAFact)) {
                System.out.println("No es un numero decimal, intente nuevamente: ");
                cantidadAFact = sc.nextLine();
            }
            
        }
        
        itemsFactura[posicion][3] = cantidadAFact;
        
        DetalleFactura detalle = new DetalleFactura();
        detalle.setCantidad(Double.parseDouble(cantidadAFact));
        
        double precioUnitario = Double.parseDouble(articulo[2]);
        double subTotal = precioUnitario * Double.parseDouble(cantidadAFact);
        
        detalle.setSubtotal(subTotal);
        itemsFactura[posicion][4] = String.valueOf(subTotal);

        return detalle;      
    }
    
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void calcularMontoFinal(int filas, String tipoPago) {
        // Suma de subtotales
        double totalItems = 0;

        for (int f = 0; f < filas; f++) {
            totalItems += Double.parseDouble(itemsFactura[f][4]);
        }

        //Recargo y Monto final
        double recargo = 0;
        double montoFinal = 0;

        if (tipoPago.equals("C")) {
            montoFinal = totalItems;
        } else if (tipoPago.equals("TD")) {
            recargo = 5 * totalItems / 100;
            montoFinal = totalItems + recargo;
        } else {
            recargo = 10 * totalItems / 100;
            montoFinal = totalItems + recargo;
        }

        mostrarMatriz(filas, totalItems, recargo, montoFinal);
    }
    
    public void mostrarMatriz(int filas, double totalItems, double recargo, double montoFinal) {
        System.out.println("CÓDIGO - DENOMINACIÓN - PRECIO UNITARIO - CANTIDAD - SUBTOTAL ");
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(itemsFactura[f][c] + " - ");
            }
            System.out.println("");
        }
        System.out.println("TOTAL ÍTEMS = $" + totalItems);
        System.out.println("RECARGO = $" + recargo);
        System.out.println("MONTO FINAL = $" + montoFinal);
    }
    
}
