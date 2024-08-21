
package parteB_aplicandoObjetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class parteB_aplicandoObjetos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 1;
        int ingreso = 1;
        Cliente cliente = new Cliente();

        while (opcion == 1) {
            if (ingreso == 1) {
                // Pedir datos factura
                Factura facturaCreada = pedirDatosFactura(sc);
                // Pedir datos del cliente
                cliente = pedirDatosCliente(sc);
                // Artículos
                int cantArticulos = pedirDatosArticulos(sc, facturaCreada);
                //Calcular monto final
                facturaCreada.calcularMontoFinal(cantArticulos, facturaCreada.getTipoPago());
                
                facturaCreada.setCliente(cliente);
                cliente.addFacturas(facturaCreada);
                System.out.println("Factura creada correctamente.");

            } else if (ingreso > 1) {
                System.out.println("¿Desea utilizar el mismo cliente? 1-SI 2-NO");
                int repetirCliente = sc.nextInt();
                sc.nextLine();

                if (repetirCliente == 1) {
                    Factura nuevaFactura = pedirDatosFactura(sc);
                    int cantArticulos = pedirDatosArticulos(sc, nuevaFactura);
                    nuevaFactura.calcularMontoFinal(cantArticulos, nuevaFactura.getTipoPago());
                    nuevaFactura.setCliente(cliente);
                    cliente.addFacturas(nuevaFactura);  
                    System.out.println("Nueva factura agregada al cliente");
                    
                } else {
                    Factura nuevaFactura = pedirDatosFactura(sc);
                    Cliente nuevoCliente = pedirDatosCliente(sc);
                    int cantArticulos = pedirDatosArticulos(sc, nuevaFactura);
                    nuevaFactura.calcularMontoFinal(cantArticulos, nuevaFactura.getTipoPago());
                    nuevaFactura.setCliente(nuevoCliente);
                    nuevoCliente.addFacturas(nuevaFactura);
                    System.out.println("Nueva factura con nuevo cliente");
                }
            }

            ingreso++;
            System.out.println("¿Desea crear otra factura? 1-SI 2-NO");
            opcion = sc.nextInt();
        }
        
        System.out.println("MUCHAS GRACIAS !");
    }
    
    // Datos de la factura
    public static Factura pedirDatosFactura(Scanner sc) {   
        System.out.println("Bienvenido, ingrese los siguientes datos: ");
        Factura factura = new Factura();

        System.out.println("Ingrese la fecha - Formato DD/MM/YYYY");
        String fechaUsuario = sc.nextLine();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaFormateada = formatoFecha.parse(fechaUsuario);
            factura.setFecha(fechaFormateada);
        } catch (ParseException ex) {
            System.out.println("Error: Formato de fecha inválido.");
        }

        System.out.println("Letra de factura: ");
        String letraFactura = sc.nextLine();
        factura.setLetra(letraFactura);

        System.out.println("Número de factura: ");
        int numeroFactura = sc.nextInt();
        factura.setNumero(numeroFactura);
        sc.nextLine();

        System.out.println("Seleccione un tipo de pago: C-TC-TD");
        String tipoPago = sc.nextLine();
        while (!tipoPago.equals("C") && !tipoPago.equals("TC") && !tipoPago.equals("TD")) {
            System.out.println("Tipo de pago incorrecto, ingrese nuevamente...");
            tipoPago = sc.nextLine();
        }
        factura.setTipoPago(tipoPago);

        return factura;
    }
    
    // Datos del cliente
    public static Cliente pedirDatosCliente(Scanner sc){
        Cliente cliente = new Cliente();

        System.out.println("Número de cliente: ");
        int numeroCliente = sc.nextInt();
        cliente.setNumero(numeroCliente);
        sc.nextLine();

        System.out.println("Razón social: ");
        String razonSocial = sc.nextLine();
        cliente.setRazonSocial(razonSocial);

        System.out.println("CUIT: ");
        long cuitCliente = sc.nextLong();
        cliente.setCuit(cuitCliente);
        sc.nextLine();
        
        return cliente;
    }
    
    // Datos artículos
    public static int pedirDatosArticulos(Scanner sc, Factura factura) {
        System.out.println("Ingrese la cantidad de artículos: ");
        int cantArticulos = sc.nextInt();
        while (cantArticulos <= 0) {
            System.out.println("Incorrecto, la cantidad de artículos debe ser mayor a cero, ingrese de nuevo: ");
            cantArticulos = sc.nextInt();
        }
        sc.nextLine();
        
        //Setear dimension matriz factura
        factura.setItemsFactura(new String[cantArticulos][5]);
        
        //Mostrar artículos
        System.out.println("--------");
        Articulo articulo = new Articulo();
        articulo.mostrarArticulos();

        System.out.println("");
        int ingresos = 0;

        while (ingresos < cantArticulos) {
            System.out.println("Ingrese el código del artículo: ");
            String codigoIngresado = sc.nextLine();

            while (articulo.verificarArticulo(codigoIngresado) == null) {
                System.out.println("El código ingresado es incorrecto, intente nuevamente: ");
                codigoIngresado = sc.nextLine();
            }
            String[] articuloEncontrado = articulo.verificarArticulo(codigoIngresado);
            articulo.setCodigo(Integer.parseInt(articuloEncontrado[0]));
            articulo.setDenominacion(articuloEncontrado[1]);
            articulo.setPrecio(Double.parseDouble(articuloEncontrado[2]));
            articulo.setUnidadMedida(articuloEncontrado[3]);
            
            DetalleFactura detalle = factura.agregarArticulo(articuloEncontrado, ingresos, sc);
            detalle.setFactura(factura);
            detalle.setArticulo(articulo);
            factura.addDetalle(detalle);
            articulo.addDetalle(detalle);
            ingresos++;
        }
        
        return cantArticulos;
    }
    
}
