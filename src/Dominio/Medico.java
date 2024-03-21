package Dominio;

public class Medico {

    private int id_medico;
    private String nombre_medico;
    private int id_especialidad;
    private int id_clinica;

    public Medico() {
    }

    public Medico(String nom) {
        this.nombre_medico = nom;
    }

    public Medico(int id_me) {
        this.id_medico = id_me;
    }

    public Medico(int id_medico, String nombre_medico, int id_especialidad, int id_clinica) {
        this.id_medico = id_medico;
        this.nombre_medico = nombre_medico;
        this.id_especialidad = id_especialidad;
        this.id_clinica = id_clinica;
    }

    public int getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(int id_clinica) {
        this.id_clinica = id_clinica;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombreMedico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre) {
        this.nombre_medico = nombre;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

}
