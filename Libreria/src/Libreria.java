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
                anadirLibro();
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
    }

    }
}
