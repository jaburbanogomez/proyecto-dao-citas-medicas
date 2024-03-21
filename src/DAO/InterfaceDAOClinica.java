package DAO;

import java.util.List;

public interface InterfaceDAOClinica {

    public boolean insertar_clinica(Object obj);

    public boolean eliminar_clinica(Object obj);

    public boolean modificar_clinica(Object obj);

    public List<?> seleccionarClinica();

}
