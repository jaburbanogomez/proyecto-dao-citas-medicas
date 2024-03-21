package DAO;

import java.util.List;

public interface InterfaceDAOCitas {

    public boolean insertar_cita(Object obj);

    public boolean eliminar_cita(Object obj);

    public boolean modificar_cita(Object obj);

    public List<?> seleccionarCita();

}
