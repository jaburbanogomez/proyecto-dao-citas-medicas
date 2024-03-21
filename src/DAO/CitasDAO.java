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
import Dominio.Citas;
import Dominio.Clinicas;
import Dominio.Medico;

public class CitasDAO implements InterfaceDAOCitas {

    //variables
    Citas citas = new Citas();
    ConexionDB bd = new ConexionDB();
    List<Citas> data = new ArrayList<>();
    List<Clinicas> data2 = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;

    @Override
    public boolean insertar_cita(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        citas = (Citas) obj;
        this.sql = "insert into citas (nombres_paciente,apellidos_paciente,genero,edad,fecha_cita,hora_cita,id_clinica,nombre_medico,especialidad) values (?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setString(1, this.citas.getNombresPaciente());
            this.pst.setString(2, this.citas.getApellidosPaciente());
            this.pst.setString(3, String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());
            this.pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());
            this.pst.setInt(7, this.citas.getIdClinica().getIdClinica());
            this.pst.setString(8, this.citas.getMedico());
            this.pst.setString(9, this.citas.getEspecialidad());

            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "La clinica seleccionada no existe");
            System.out.println("Excepciones controladas: " + e.getMessage());

            return false;
        }

    }

    @Override
    public boolean eliminar_cita(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        citas = (Citas) obj;
        this.sql = "delete from citas where id_citas=?";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setInt(1, this.citas.getCodigo());

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
    public boolean modificar_cita(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        citas = (Citas) obj;
        this.sql = "update citas set nombres_paciente=?,apellidos_paciente=?,genero=?,edad=?,fecha_cita=?,hora_cita=?,id_clinica=? where id_citas=?";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(this.sql);

            this.pst.setString(1, this.citas.getNombresPaciente());
            this.pst.setString(2, this.citas.getApellidosPaciente());
            this.pst.setString(3, String.valueOf(this.citas.getGenero()));
            this.pst.setInt(4, this.citas.getEdad());
            this.pst.setDate(5, this.citas.getFechCita());
            this.pst.setString(6, this.citas.getHoraCita());
            this.pst.setInt(7, this.citas.getIdClinica().getIdClinica());
            this.pst.setInt(8, this.citas.getCodigo());

            int filas = this.pst.executeUpdate();//para ver cuantas filas hay afectadas en la base de datos
            this.con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            // e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<?> seleccionarCita() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.sql = "SELECT * FROM citas c join clinicas cl ON(c.id_clinica= cl.id_clinica )";

        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(sql);//hara un seclect
            this.rs = this.pst.executeQuery();//guardar la ejecucion de la sentencia

            while (this.rs.next()) {
                data.add(new Citas(this.rs.getInt("id_citas"),
                        this.rs.getString("nombres_paciente"),
                        this.rs.getString("apellidos_paciente"),
                        this.rs.getString("genero").charAt(0),
                        this.rs.getInt("edad"),
                        this.rs.getDate("fecha_cita"),
                        this.rs.getString("hora_cita"),
                        this.rs.getString("especialidad"),
                        this.rs.getString("nombre_medico"),
                        new Clinicas(this.rs.getString("nombre_clinica"))
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

    public List<?> seleccionarTabla() {
        this.sql = "select * from clinicas";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
            this.pst = this.con.prepareStatement(sql);//hara un seclect
            this.rs = this.pst.executeQuery();//guardar la ejecucion de la sentencia

            while (this.rs.next()) {
                data2.add(new Clinicas(this.rs.getInt("id_clinica"),
                        this.rs.getString("nomb_clinica"),
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
