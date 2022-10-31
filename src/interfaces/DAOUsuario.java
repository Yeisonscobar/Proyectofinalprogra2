
package interfaces;

import java.util.ArrayList;
import modelo.Usuario;

public interface DAOUsuario {
    
    public Usuario login(String user, String contrasenia) throws Exception;
    public boolean registrar(Usuario us) throws Exception;
    public boolean modificar(Usuario us) throws Exception;
    public boolean eliminar(int id) throws Exception;
    public ArrayList<Usuario> listar() throws Exception;
    public boolean existeUsuario(Usuario us) throws Exception;
    public Usuario obtenerUsuario(int id) throws Exception;
}
