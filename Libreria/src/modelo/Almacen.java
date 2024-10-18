package modelo;

//Almacen : array de Libro, tamaño fijo inicial. 
public class Almacen {
    private int tamañoAlmacen=50; //fijo el tamaño inicial
    private Libro[] librosAlmacen;
    private int contadorLibros; //atributo auxiliar para contar los libros añadidos

    //Constructor
    public Almacen(int tamañoAlmacen){
        this.tamañoAlmacen=tamañoAlmacen;
        this.librosAlmacen=new Libro[tamañoAlmacen];
        this.contadorLibros=0;
    }

    //Getters
    public int getTamañoAlmacen(){
        return tamañoAlmacen;
    }
    public Libro[] getLibrosAlmacen(){
        return librosAlmacen;
    }
    public int getContadorLibros(){
        return contadorLibros;
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
        if (contadorLibros>=tamañoAlmacen){
            System.err.println("Error.Almacén lleno");
        } else {
            librosAlmacen[contadorLibros]=libro;
            contadorLibros++;
            System.out.println("Libro añadido con éxito");
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
        //quiero que me devuelva el valor con dos decimales
        return Math.round(valorTotal*100.0)/100.0;
    }
}
