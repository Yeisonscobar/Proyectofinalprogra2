
package interfaces;

import java.util.ArrayList;
import modelo.Jugador;

public interface DAOJugador {
    public boolean registrar(Jugador j) throws Exception;
    public boolean modificar(Jugador j) throws Exception;
    public ArrayList<Jugador> listar(int idPais) throws Exception;
}
