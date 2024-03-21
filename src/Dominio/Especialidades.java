package Dominio;

public class Especialidades {

    private int id_especialidades;
    private String nombreEspec;

    public Especialidades() {
    }

    
    
    
    public Especialidades(String nom_s) {
        this.nombreEspec=nom_s;
    }

    
    
    
    public Especialidades(int id_esp) {
        this.id_especialidades = id_esp;
    }

    public Especialidades(int id_especialidades, String nombreEspec) {
        this.id_especialidades = id_especialidades;
        this.nombreEspec = nombreEspec;
    }

    public String getNombreEspec() {
        return nombreEspec;
    }

    public void setNombreEspec(String nombreEspec) {
        this.nombreEspec = nombreEspec;
    }

    public int getId_especialidades() {
        return id_especialidades;
    }

    public void setId_especialidades(int id_especialidades) {
        this.id_especialidades = id_especialidades;
    }

}
