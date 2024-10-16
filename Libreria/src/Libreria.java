/*Autor: Sara Alonso de la Iglesia */

import com.coti.tools.Esdia;
import modelo.Libro;
import modelo.Autor;
import modelo.Almacen;

public class Libreria {
    private static Almacen almacen1;
    private static Autor autor1;
    private static Libro libro1;
    private static int ritmoLectura=1; //por defecto es 1 página por minuto
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
        almacen1=new Almacen(tamañoNuevoAlmacen);
        System.out.printf("Tamaño del nuevo almacen creado: %d",almacen1.getLibrosAlmacen().length);
    }
    //Método para opción 2
    private static void establecerRitmoLectura(){
        ritmoLectura=Esdia.readInt("Introduzca ritmo de lectura por minuto (páginas/minuto): ");
        System.out.printf("Ritmo de lectura establecido: %d páginas por minuto", ritmoLectura);

    }
    //Método para opción 3
    private static void añadirLibro(){
        //si el almacén no está creado,no puede añadir libro
        if (almacen1==null){
            System.err.println("Error. No se ha creado almacén para poder añadir el libro.");
            return;
        }
        //pedimos al usuario por pantalla que introduzca los datos del autor
        String nombre=Esdia.readString("Introduzca nombre del autor: ");
        String apellidos=Esdia.readString("Introduzca apellidos del autor: ");
        boolean premioPlanet=Esdia.yesOrNo("¿Ha obtenido el autor el premio Planeta? (y/n): ");
        //creamos el Autor
        autor1 = new Autor(nombre,apellidos,premioPlanet);
        //pedimos al usuario por pantalla que introduzca los demás datos del libro
        String titulo=Esdia.readString("Introduzca nombre del libro: ");
        int añoPublicar=Esdia.readInt("Introduzca año de publicación del libro: ");
        int paginas=Esdia.readInt("Introduzca páginas del libro: ");
        double precio=Esdia.readDouble("Introduzca precio del libro: ");
        //creamos el Libro
        libro1 = new Libro(autor1,titulo,añoPublicar,paginas,precio);
        // Lo último que nos queda por hacer es añadir el libro al almacén
        almacen1.añadirLibro(libro1);
    }

    //Método para opción 4
    private static void mostrarInfoLibros(){

    }
}
