
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import org.sqlite.SQLiteConfig;

public class Conexion {
    private  String url;
    protected Connection conexion;
    
    public void Conectar() throws Exception{
        url="bd/estampitaMundial.db";
        try{
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config=new SQLiteConfig();
            config.enforceForeignKeys(true);
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url,config.toProperties());
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void cerrarConecion(){
        try{
            if(conexion!=null){
                if(!conexion.isClosed()){
                     conexion.close();
                }
            }
        }catch(Exception ex){
        }
    }
}
