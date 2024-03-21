package DAO;

import DAO.ConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Dominio.Clinicas;

public class ClinicaDAO implements InterfaceDAOClinica {

    //variables
    Clinicas cln = new Clinicas();
    ConexionDB bd = new ConexionDB();
    List<Clinicas> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;

    @Override
    public boolean insertar_clinica(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cln = (Clinicas) obj;
        this.sql = "insert into clinicas (nombre_clinica, empleados, encargado) values (?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setString(1, this.cln.getNombClinica());
            this.pst.setInt(2, this.cln.getEmpleados());
            this.pst.setString(3, this.cln.getEncargado());

            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();

            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean eliminar_clinica(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cln = (Clinicas) obj;
        this.sql = "delete from clinicas where id_clinica = ?";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setInt(1, this.cln.getIdClinica());

            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Esta clinica no se puede borrar\nporque tiene citas pendientes\n(Clave Foranea) ");
            System.out.println("Excepciones controladas: " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean modificar_clinica(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cln = (Clinicas) obj;
        this.sql = "update clinicas set nombre_clinica=?, empleados=?, encargado=? where id_clinica=?";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setString(1, this.cln.getNombClinica());
            this.pst.setInt(2, this.cln.getEmpleados());
            this.pst.setString(3, this.cln.getEncargado());

            this.pst.setInt(4, this.cln.getIdClinica());

            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<?> seleccionarClinica() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.sql = "select * from clinicas";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(sql);//hara un seclect
            this.rs = this.pst.executeQuery();//guardar la ejecucion de la sentencia

            while (this.rs.next()) {
                data.add(new Clinicas(this.rs.getInt("id_clinica"),
                        this.rs.getString("nombre_clinica"),
                        this.rs.getInt("empleados"),
                        this.rs.getString("encargado")
                ));
            }
            this.con.close();
            this.rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
        }

        return this.data;

    }

}
