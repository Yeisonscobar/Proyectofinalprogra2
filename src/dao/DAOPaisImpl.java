
package dao;

import interfaces.DAOAlbum;
import interfaces.DAOPais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Album;
import modelo.Pais;

public class DAOPaisImpl extends Conexion implements DAOPais{

    @Override
    public boolean registrar(Pais p) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("INSERT INTO pais(nombrePais,abrevPais,codPais,imagen,idAlbum) VALUES (?,?,?,?,?)");
            st.setString(1, p.getNombrePais());
            st.setString(2, p.getAbrevPais());
            st.setInt(3, p.getCodPais());
            st.setString(4, p.getImg());
            st.setInt(5, p.getIdAlbum());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Pais p) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("UPDATE pais SET nombrePais=?,abrevPais=?,codPais=?,imagen=?,idAlbum=? WHERE idPais=?");
            st.setString(1, p.getNombrePais());
            st.setString(2, p.getAbrevPais());
            st.setInt(3, p.getCodPais());
            st.setString(4, p.getImg());
            st.setInt(5, p.getIdAlbum());
            st.setInt(6, p.getIdPais());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
    }

    @Override
    public ArrayList<Pais> listar(int id) throws Exception {
        ArrayList<Pais> paises= new ArrayList<Pais>();
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM pais WHERE idAlbum=?");
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Pais pa= new Pais();
                pa.setIdPais(rs.getInt("idPais"));
                pa.setAbrevPais(rs.getString("abrevPais"));
                pa.setCodPais(rs.getInt("codPais"));
                pa.setIdAlbum(rs.getInt("idAlbum"));
                pa.setImg(rs.getString("imagen"));
                pa.setNombrePais(rs.getString("nombrePais"));
                paises.add(pa);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return paises;
    }
    
}
