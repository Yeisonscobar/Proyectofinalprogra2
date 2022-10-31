
package dao;

import interfaces.DAOUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Usuario;

public class DAOUsuarioImpl extends Conexion implements DAOUsuario{

    @Override
    public boolean registrar(Usuario us) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("INSERT INTO Usuario(nombre,apellido,user,contrasenia,correo) VALUES (?,?,?,?,?)");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUser());
            st.setString(4, us.getContrasenia());
            st.setString(5, us.getCorreo());
            st.executeUpdate();
            return true;
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        } 
    }

    @Override
    public boolean modificar(Usuario us) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("UPDATE Usuario SET nombre=?,apellido=?,user=?,contrasenia=?,correo=? WHERE id=?");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUser());
            st.setString(4, us.getContrasenia());
            st.setString(5, us.getCorreo());
            st.setInt(6, us.getId());
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
            PreparedStatement st=this.conexion.prepareStatement("DELETE FROM Usuario WHERE id=?");
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
    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Usuario us= new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("user"));
                us.setContrasenia(rs.getString("contrasenia"));
                 us.setCorreo(rs.getString("correo"));
                 usuarios.add(us);
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return usuarios;
    }

    @Override
    public Usuario login(String user, String contrasenia) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM usuario WHERE user=? and contrasenia=?");
            st.setString(1, user);
            st.setString(2, contrasenia);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                Usuario us= new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("user"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setCorreo(rs.getString("correo"));
                return us;
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return null;
    }
    
    @Override
    public Usuario obtenerUsuario(int id) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM usuario WHERE id=?");
            st.setInt(1, id);

            ResultSet rs=st.executeQuery();
            if(rs.next()){
                Usuario us= new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("user"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setCorreo(rs.getString("correo"));
                return us;
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return null;
    }

    @Override
    public boolean existeUsuario(Usuario us) throws Exception {
       try{
            this.Conectar();
            PreparedStatement st=this.conexion.prepareStatement("SELECT * FROM usuario WHERE user=?");
            st.setString(1, us.getUser());
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                return true;
            }
            rs.close();
            st.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.cerrarConecion();
        }
        return false;
    }
    
    
}
