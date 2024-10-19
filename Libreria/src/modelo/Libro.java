package modelo;


//Libro : Autor, título, año de publicación, número de páginas, precio. 
public class Libro {
    private Autor autorLibro;
    private String tituloLibro;
    private int anoPublicacion;
    private int numPaginasLibro;
    private double precioLibro;

    //Constructor
    public Libro(Autor autorLibro, String tituloLibro, int anoPublicacion, int numPaginasLibro, double precioLibro){
        this.autorLibro=autorLibro;
        this.tituloLibro=tituloLibro;
        this.anoPublicacion=anoPublicacion;
        this.numPaginasLibro=numPaginasLibro;
        this.precioLibro=precioLibro;
    }

    //Getters
    public Autor getAutorLibro(){
        return autorLibro;
    }
    public String getTituloLibro(){
        return tituloLibro;
    }
    public int getAnoPublicacion(){
        return anoPublicacion;
    }
    public int getNumeroPaginas(){
        return numPaginasLibro;
    }
    public double getPrecioLibro(){
        //para que se muestre siempre con dos decimales
        return Math.round(precioLibro*100.0)/100.0;
    }

    //Setters
    public void setAutorLibro(Autor autorLibro){
        this.autorLibro=autorLibro;
    }
    public void setTituloLibro(String tituloLibro){
        this.tituloLibro=tituloLibro;
    }
    public void setAnoPublicacion(int anoPublicacion){
        this.anoPublicacion=anoPublicacion;
    }
    public void setNumeroPaginas(int numPaginasLibro){
        this.numPaginasLibro=numPaginasLibro;
    }
    public void setPrecioLibro(double precioLibro){
        this.precioLibro=precioLibro;
    }

    //Método para calcular el tiempo de lectura en minutos de un libro
    public int calculoTiempoLecturaLibro(int tiempoLectura){
        return this.numPaginasLibro*tiempoLectura;
    }
}
