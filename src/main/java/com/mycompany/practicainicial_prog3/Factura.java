
package com.mycompany.practicainicial_prog3;

import java.util.Scanner;

public class Factura {
    private String fecha, razonSocialCliente, tipoPago;
    private long nroFactura, cuitCliente;
    private double montoTotalItems, recargo, montoFinal;
    private String [][] itemsFactura;

    public Factura() {
    }

    public Factura(String fecha, String razonSocialCliente, String tipoPago, long nroFactura, long cuitCliente, double montoTotalItems, double recargo, double montoFinal, String[][] itemsFactura) {
        this.fecha = fecha;
        this.razonSocialCliente = razonSocialCliente;
        this.tipoPago = tipoPago;
        this.nroFactura = nroFactura;
        this.cuitCliente = cuitCliente;
        this.montoTotalItems = montoTotalItems;
        this.recargo = recargo;
        this.montoFinal = montoFinal;
        this.itemsFactura = itemsFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazonSocialCliente() {
        return razonSocialCliente;
    }

    public void setRazonSocialCliente(String razonSocialCliente) {
        this.razonSocialCliente = razonSocialCliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public long getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public double getMontoTotalItems() {
        return montoTotalItems;
    }

    public void setMontoTotalItems(double montoTotalItems) {
        this.montoTotalItems = montoTotalItems;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(String[][] itemsFactura) {
        this.itemsFactura = itemsFactura;
    }
    
    public void agregarArticulo(String [] articulo, int posicion, Scanner sc){
        itemsFactura[posicion][0] = articulo[0];
        itemsFactura[posicion][1] = articulo[1];
        itemsFactura[posicion][2] = articulo[2];
        
        System.out.println("Ingrese la cantidad del ítem a facturar: ");
        double precioUnitario = Double.parseDouble(articulo[2]);
        int cantFacturar = sc.nextInt();
        double subTotal = precioUnitario * cantFacturar;
        itemsFactura[posicion][3] = String.valueOf(cantFacturar);
        
        if(articulo[3].equals("KG")){
            double cantFacturarDouble = sc.nextDouble();
            subTotal = precioUnitario * cantFacturarDouble; 
            itemsFactura[posicion][3] = String.valueOf(cantFacturarDouble);
        }
        sc.nextLine();
        
        itemsFactura[posicion][4] = String.valueOf(subTotal);
    }
    
    public void calcularMontoFinal(int filas, String tipoPago){
        // Suma de subtotales
        double totalItems = 0;
        
        for(int f=0; f<filas; f++){
            totalItems += Double.parseDouble(itemsFactura[f][4]);
        }
        
        //Recargo y Monto final
        double recargo = 0;
        double montoFinal = 0;
        
        if(tipoPago.equals("C")){
            montoFinal = totalItems;
        } else if(tipoPago.equals("TD")){
            recargo = 5 * totalItems / 100;
            montoFinal = totalItems + recargo;
        } else {
            recargo = 10 * totalItems / 100;
            montoFinal = totalItems + recargo;
        }
        
        mostrarMatriz(filas, totalItems, recargo, montoFinal);
    }
    
    public void mostrarMatriz(int filas, double totalItems, double recargo, double montoFinal){
        System.out.println("CÓDIGO - DENOMINACIÓN - PRECIO UNITARIO - CANTIDAD - SUBTOTAL ");
        for(int f=0; f<filas; f++){
            for(int c=0; c<5; c++){
                System.out.print(itemsFactura[f][c] + " - ");
            }
            System.out.println("");
        }
        System.out.println("TOTAL ÍTEMS = $" + totalItems);
        System.out.println("RECARGO = $" + recargo);
        System.out.println("MONTO FINAL = $" + montoFinal);
    }
   
}
