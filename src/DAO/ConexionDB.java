package DAO;

public class ConexionDB {

    private String driver;
    private String url;
    private String usuario;
    private String contrasena;

    public ConexionDB() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost/dao_citas";
        this.usuario = "root";
        this.contrasena = "";
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
