
package dao;

import interfaces.DAOJugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Jugador;
import modelo.Pais;


public class DAOJugadorImpl extends Conexion implements DAOJugador{

    @Override
    public boolean registrar(Jugador j) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("INSERT INTO jugador(idPais,codJug,nombre,posicion,edad,imagen) VALUES (?,?,?,?,?,?)");
            st.setInt(1, j.getCodPais());
            st.setInt(2, j.getCod());
            st.setString(3, j.getNombre());
            st.setString(4,j.getPosicion());
            st.setInt(5, j.getEdad());
            st.setString(6, j.getImagen());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Jugador j) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("UPDATE jugador SET idPais=?,codJug=?,nombre=?,posicion=?,edad=?,imagen=? WHERE idJugador=?");
            st.setInt(1, j.getCodPais());
            st.setInt(2, j.getCod());
            st.setString(3, j.getNombre());
            st.setString(4,j.getPosicion());
            st.setInt(5, j.getEdad());
            st.setString(6, j.getImagen());
            st.setInt(7, j.getCodJugador());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
    }



    @Override
    public ArrayList<Jugador> listar(int idPais) throws Exception {
        ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM jugador WHERE idPais=?");
            st.setInt(1, idPais);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Jugador ju= new Jugador();
                ju.setCodJugador(rs.getInt("idJugador"));
                ju.setCod(rs.getInt("codJug"));
                ju.setCodPais(rs.getInt("idPais"));
                ju.setEdad(rs.getInt("edad"));
                ju.setImagen(rs.getString("imagen"));
                ju.setNombre(rs.getString("nombre"));
                ju.setPosicion(rs.getString("posicion"));

                jugadores.add(ju);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return jugadores;
    }
    
}
