package modelo;

//Almacen : array de Libro, tamaño fijo inicial. 
public class Almacen {
    private int tamañoAlmacen=50;
    private Libro[] librosAlmacen;

    private int contadorLibros=0;

    //Constructor
    public Almacen(int tamañoAlmacen){
        this.tamañoAlmacen=tamañoAlmacen;
        this.librosAlmacen=new Libro[tamañoAlmacen];
    }

    //Getters
    public int getTamañoAlmacen(){
        return tamañoAlmacen;
    }
    public Libro[] getLibrosAlmacen(){
        return librosAlmacen;
    }

    //Setters
    public void setTamañoAlmacen(int tamañoAlmacen){
        this.tamañoAlmacen=tamañoAlmacen;
    }
    public void setLibrosAlmacen(Libro[] librosAlmacen){
        this.librosAlmacen=librosAlmacen;
    }

    //Método para añadir libro al almacén en posiciones vacías
    public void añadirLibro(Libro libro){
        if (contadorLibros<tamañoAlmacen){
            librosAlmacen[contadorLibros]=libro;
            contadorLibros++;
             System.out.println("Libro añadido con éxito");
        } else {
            System.err.println("Error.Almacén lleno");
        }
    }

    //Método para calcular el tiempo de lectura total del almacén
    public int tiempoLecturaTotal(int tiempoLectura){
        int tiempoTotal=0;
        for (Libro libro : librosAlmacen) {
            //si el libro está vacío, no se van a añadir las páginas, porque no las tiene
            if(libro!=null){
                tiempoTotal+=libro.calculoTiempoLecturaLibro(tiempoLectura);
            }
        }
        return tiempoTotal;
    }

    //Método para calcular el valor total del almacén
    public double valorTotalAlmacen(){
        double valorTotal=0.0;
        for (Libro libro : librosAlmacen) {
            //si el libro está vacío, no se va a añadir su precio, porque no lo tiene
            if(libro!=null){ 
                valorTotal+=libro.getPrecioLibro();
            }
        }
        return valorTotal;
    }

}
