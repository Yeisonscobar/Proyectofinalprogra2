
package dao;

import interfaces.DAOAlbum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Album;

public class DAOAlbumImpl extends Conexion implements DAOAlbum{

    @Override
    public boolean registrar(Album a) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("INSERT INTO album(nombreAlbum,anio,id) VALUES (?,?,?)");
            st.setString(1, a.getNombre());
            st.setInt(2, a.getAnio());
            st.setInt(3, a.getIdUsuario());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Album a) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("UPDATE album SET nombreAlbum=?,anio=? WHERE idAlbum=?");
            st.setString(1, a.getNombre());
            st.setInt(2, a.getAnio());
            st.setInt(3, a.getIdAlbum());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }           
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("DELETE FROM album WHERE idAlbum=?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion(); 
        }  
    }

    @Override
    public ArrayList<Album> listar(int id) throws Exception {
        ArrayList<Album> albunes= new ArrayList<Album>();
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM album WHERE id=?");
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Album al= new Album();
                al.setIdAlbum(rs.getInt("idAlbum"));
                al.setIdUsuario(rs.getInt("id"));
                al.setNombre(rs.getString("nombreAlbum"));
                al.setAnio(rs.getInt("anio"));
                albunes.add(al);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return albunes;
    }
    
}
