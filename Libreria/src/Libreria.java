/*Autor: Sara Alonso de la Iglesia */

import com.coti.tools.Esdia;
import modelo.Libro;
import modelo.Autor;
import modelo.Almacen;

public class Libreria {
    public static void main(String[] args) throws Exception {
/*
|--------------------------------------------------------| 
| MIS LIBROS                                            | 
|-------------------------------------------------------| 
    1) Nuevo almacén de libros 
    2) Establecer ritmo de lectura (páginas por minuto) 
    3) Añadir un nuevo libro al almacén 
    4) Mostrar información actual de libros 
    5) Salir (se borrará toda la información) 
|-------------------------------------------------------| 
Seleccione una opción (1-5):  */
    //Menú con opciones
    int opcion;
    System.out.println("|----------------------------------------------------------|");
    System.out.println("| MIS LIBROS                                                ");
    System.out.println("|----------------------------------------------------------|");
    System.out.println("    1) Nuevo almacén de libros.");
    System.out.println("    2) Establecer ritmo de lectura (páginas por minuto).");
    System.out.println("    3) Añadir nuevo libro al almacén.");
    System.out.println("    4) Mostrar información actual de libros.");
    System.out.println("    5) Salir (Se borrará toda la información).");
    System.out.println("|----------------------------------------------------------|");
    do{
        opcion=Esdia.readInt("Seleccione una opción(1-5): ");
        switch (opcion) {
            case 1:
                nuevoAlmacen();
                break;
            case 2:
                establecerRitmoLectura();
                break;
            case 3:
                añadirLibro();
                break;
            case 4:
                mostrarInfoLibros();
                break;
            case 5:
                System.out.println("Saliendo del almacén. ¡Adiós!");
                break;
            default: 
                System.out.println("Opción no válida.");
        }
    }while(opcion!=5);

    }

    //Método para opción 1
    private static void nuevoAlmacen(){
        int tamañoNuevoAlmacen= Esdia.readInt("Inserte el tamaño del nuevo almacén: ");
        Almacen almacen1=new Almacen(tamañoNuevoAlmacen, null);
        System.out.printf("Tamaño del nuevo almacen creado: %d",almacen1.getLibrosAlmacen().length);
    }
    //Método para opción 2
    private static void establecerRitmoLectura(){
        int ritmoLectura=Esdia.readInt("Introduzca ritmo de lectura por minuto (páginas/minuto): ");
        libros.calculoTiempoLecturaLibro(ritmoLectura);

    }
    //Método para opción 3
    private static void añadirLibro(){

    }
    //Método para opción 4
    private static void mostrarInfoLibros(){

    }
}
