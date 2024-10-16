package modelo;

//Autor : nombre, apellidos, premioPlaneta (booleano).
public class Autor {
    private String nombreAutor;
    private String apellidosAutor;
    private boolean premioPlaneta;

    //Constructor
    public Autor(String nombreAutor, String apellidosAutor,boolean premioPlaneta){
        this.nombreAutor=nombreAutor;
        this.apellidosAutor=apellidosAutor;
        this.premioPlaneta=premioPlaneta;
    }

    //Getters
    public String getNombreAutor(){
        return nombreAutor;
    }
    public String getApellidosAutor(){
        return apellidosAutor;
    }
    public boolean getPremioPlaneta(){
        return premioPlaneta;
    }

    //Setters
    public void setNombreAutor(String nombreAutor){
        this.nombreAutor=nombreAutor;
    }
    public void setApellidosAutor(String apellidosAutor){
        this.apellidosAutor=apellidosAutor;
    }
    public void setPremioPlaneta(boolean premioPlaneta){
        this.premioPlaneta=premioPlaneta;
    }

    //Método para poner el Nombre completo, es decir Nombre + Apellidos del autor
    public String nombreCompletoAutor(){
        return (this.nombreAutor+" "+this.apellidosAutor);
    }

    //

}
