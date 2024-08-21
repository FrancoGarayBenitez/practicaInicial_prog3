
package com.mycompany.practicainicial_prog3;

import java.util.Scanner;

public class PracticaInicial_Prog3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Factura factura = new Factura();
        
        System.out.println("Bienvenido, ingrese los siguientes datos: ");
        
        System.out.println("Ingrese la fecha de hoy: ");
        factura.setFecha(sc.nextLine());
        
        System.out.println("Ingrese el número de la factura: ");
        factura.setNroFactura(sc.nextLong());
        sc.nextLine();
        
        System.out.println("Ingrese la razón social: ");
        factura.setRazonSocialCliente(sc.nextLine());
        
        System.out.println("Ingrese el cuit: ");
        factura.setCuitCliente(sc.nextLong());    
        sc.nextLine();
        
        System.out.println("Seleccione un tipo de pago: C-TC-TD" );
        String tipoPago = sc.nextLine();
        while (!tipoPago.equals("C") && !tipoPago.equals("TC") && !tipoPago.equals("TD")) {            
            System.out.println("Tipo de pago incorrecto, ingrese nuevamente...");
            tipoPago = sc.nextLine();
        }
        factura.setTipoPago(tipoPago);
        
        System.out.println("Seleccione cantidad de artículos a facturar");
        int cantArticulos = sc.nextInt();
        while(cantArticulos <= 0){
            System.out.println("Incorrecto, la cantidad de artículos debe ser mayor a cero, ingrese de nuevo: ");
            cantArticulos = sc.nextInt();
        }
        sc.nextLine();
        
        // Seteando dimensión matriz
        factura.setItemsFactura(new String [cantArticulos][5]);
        
        System.out.println("---------");
        System.out.println("Artículos a facturar");
        CalculoFactura calculoFactura = new CalculoFactura();
        calculoFactura.mostrarArticulos();
        
        System.out.println("");
        int ingresos = 0;
            
        while (ingresos < cantArticulos) {
            System.out.println("Ingrese el código del artículo: ");
            String codigoIngresado = sc.nextLine();
            
            while (calculoFactura.verificarArticulo(codigoIngresado) == null) {
                System.out.println("El código ingresado es incorrecto, intente nuevamente: ");
                codigoIngresado = sc.nextLine();
            }
            String [] articuloEncontrado = calculoFactura.verificarArticulo(codigoIngresado);
            factura.agregarArticulo(articuloEncontrado, ingresos, sc);
            ingresos++;
        }
        
        factura.calcularMontoFinal(ingresos, tipoPago);
        
    }
}
