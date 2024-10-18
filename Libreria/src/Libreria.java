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
        System.out.printf("Tamaño del nuevo almacen creado: %d \n",almacen1.getLibrosAlmacen().length);
    }
    //Método para opción 2
    private static void establecerRitmoLectura(){
        ritmoLectura=Esdia.readInt("Introduzca ritmo de lectura por minuto (páginas/minuto): ");
        System.out.printf("Ritmo de lectura establecido: %d páginas por minuto \n", ritmoLectura);

    }
    //Método para opción 3
    private static void añadirLibro(){
        //si el almacén no está creado,no puede añadir libro
        if (almacen1==null){
            System.err.println("Error. No se ha creado almacén para poder añadir el libro.");
            return;
        }
        //pedimos al usuario por pantalla que introduzca los datos del autor
        String nombre=Esdia.readString_ne("Introduzca nombre del autor: ");
        String apellidos=Esdia.readString_ne("Introduzca apellidos del autor: ");
        boolean premioPlanet=Esdia.yesOrNo("¿Ha obtenido el autor el premio Planeta");
        //creamos el Autor
        autor1 = new Autor(nombre,apellidos,premioPlanet);
        //pedimos al usuario por pantalla que introduzca los demás datos del libro
        String titulo=Esdia.readString_ne("Introduzca nombre del libro: ");
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
        //Calculemos los anchos máximos de cada columna
        int maxTitulo=6; //Como mínimo, título tiene 6 caracteres para ajustar a la tabla
        int maxAutor=5;
        int maxAno=15; //Lo máximo que va a tener es el Año Publicación, porque estamos en 2024
        int maxPlaneta=14; //Lo máximo que va a tener es el de Premio Planeta, la respuesta es Sí o No
        int maxPaginas=7;
        int maxTiempo=20; //Tiempo Lectura (min)
        int maxPrecio=6;
        for (int i=0;i<almacen1.getLibrosAlmacen().length;i++) {
            Libro libros=almacen1.getLibrosAlmacen()[i];
            if (libros!=null){
                //Para el título
                if(libros.getTituloLibro().length()>maxTitulo){
                    maxTitulo=libros.getTituloLibro().length();
                }
                //Para el autor
                if(libros.getAutorLibro().nombreCompletoAutor().length()>maxAutor){
                    maxAutor=libros.getAutorLibro().nombreCompletoAutor().length();
                }
                //Para las páginas
                String numPag=Integer.toString(libros.getNumeroPaginas());
                if(numPag.length()>maxPaginas){
                    maxPaginas=numPag.length();
                }
                //Para el tiempo de lectura
                String tiempoLect=Integer.toString(libros.calculoTiempoLecturaLibro(ritmoLectura));
                if(tiempoLect.length()>maxTiempo){
                    maxTiempo=tiempoLect.length();
                }
                //Para el precio
                String precioLib=Double.toString(libros.getPrecioLibro());
                if(precioLib.length()>maxPrecio){
                    maxPrecio=precioLib.length();
                }
            }
        }
        //Calculamos el ancho total de la tabla con los separadores y los |.
        int ANCHO_TOTAL=maxTitulo+maxAutor+maxAno+maxPlaneta+maxPaginas+maxTiempo+maxPrecio+21; 
      
        String barrita="-".repeat(ANCHO_TOTAL);
        String espacios=" ".repeat(ANCHO_TOTAL-21);

        //Construimos los formatos dinámicos para el contenido:
        String formatoTitulo="%-"+maxTitulo+"s"; //a la izquierda
        String formatoAutor="%-"+maxAutor+"s"; //a la izquierda
        String formatoAno="%-"+maxAno+"s"; //a la izquierda
        String formatoPremio="%-"+maxPlaneta+"s"; //a la izquierda
        String formatoPaginas="%"+maxPaginas+"s"; //centrado
        String formatoTiempo="%"+maxTiempo+"s"; //a la derecha
        String formatoPrecio="%"+maxPrecio+"s"; //a la derecha

        //Procedemos a mostrar la tabla:
        //si no está creado el almacén o no hay libros añadidos, no hay tabla que mostrar
        if(almacen1==null || almacen1.getTamañoAlmacen()==0){
            System.out.println("No hay tabla que mostrar porque no hay libros en el almacén.");
            return;
        }
        //Título y cabecera tabla
        System.out.println("|"+barrita+"|");
        System.out.println("| LIBROS EN EL ALMACÉN"+espacios+"|");
        System.out.println("|"+barrita+"|");
        System.out.printf("| "+ formatoTitulo + " | "+ formatoAno + " | " + formatoAutor +" | " + formatoPremio + " | "+formatoPaginas+" | "+formatoTiempo+" | "+formatoPrecio+"|\n","Título", "Año Publicación", "Autor", "Premio planeta", "Páginas","Tiempo lectura (min)","Precio");
        System.out.println("|"+barrita+"|");
        //Imprimimos por pantalla la información de cada libro
        for (Libro libro : almacen1.getLibrosAlmacen()) {
            if(libro!=null){
                //formateamos cada dato según ancho máximo
                String datosTitulo=String.format(formatoTitulo, libro.getTituloLibro());
                String datosAno=String.format(formatoAno, libro.getAnoPublicacion());
                String datosAutor=String.format(formatoAutor, libro.getAutorLibro().nombreCompletoAutor());
                String datosPremio=String.format(formatoPremio, libro.getAutorLibro().respuestaPremio());
                String datosPaginas=String.format(formatoPaginas, libro.getNumeroPaginas());
                String datosTiempo=String.format(formatoTiempo, libro.calculoTiempoLecturaLibro(ritmoLectura));
                String datosPrecio=String.format(formatoPrecio, libro.getPrecioLibro());
                //imprimir por pantalla
                System.err.println("| "+ datosTitulo + " | "+ datosAno + " | " + datosAutor + " | " + datosPremio + " | "+datosPaginas+" | "+datosTiempo+" | "+datosPrecio+" €|");
            }else{
                System.err.println("No hay información de libros en esta posición.");
            }
        }
        System.out.println("|"+barrita+"|");
        System.out.println("| Tiempo de lectura total del almacén:"+" ".repeat(ANCHO_TOTAL-maxPrecio-maxTiempo-43)+String.format(formatoTiempo,almacen1.tiempoLecturaTotal(ritmoLectura))+"min | "+" ".repeat(maxPrecio)+"|");
        System.out.println("| Valor total del almacén:"+" ".repeat(ANCHO_TOTAL-maxPrecio-27)+String.format(formatoPrecio,almacen1.valorTotalAlmacen())+" €|");
        System.out.println("|"+barrita+"|");
    }
}
