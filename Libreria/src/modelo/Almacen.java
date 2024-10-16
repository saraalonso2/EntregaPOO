package modelo;

//Almacen : array de Libro, tamaño fijo inicial. 
public class Almacen {
    private int tamañoAlmacen=50;
    private Libro[] librosAlmacen;

    //Constructor
    public Almacen(int tamañoAlmacen, Libro[] librosAlmacen){
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

}
