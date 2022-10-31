
package interfaces;

import java.util.ArrayList;
import modelo.Pais;


public interface DAOPais {
    public boolean registrar(Pais p) throws Exception;
    public boolean modificar(Pais p) throws Exception;
    public ArrayList<Pais> listar(int id) throws Exception;
}
