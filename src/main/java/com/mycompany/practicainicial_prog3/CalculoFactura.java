
package com.mycompany.practicainicial_prog3;

public class CalculoFactura {
    private String [][] articulos = {{"100","Azucar", "20", "U"} , {"101","Leche" , "30" , "U"} ,
    {"102","Aceite", "50" , "U"} , {"103","Sal", "45" , "U"} , {"104"," Fideos", "15" , "U"} ,
    {"105"," Arroz", "28" , "U"} , {"106","Galletas", "26" , "U"} , {"107","Carne Molida", "220" ,
    "Kg"} , {"108","Shampoo", "42" , "U"} , {"109","Queso Mantecoso", "178" , "Kg"} ,
    {"110","Jamon Cocido", "320" , "Kg"} , {"111","Naranjas", "80" , "Kg"}};
    
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
