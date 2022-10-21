
package pe.isil.parcialappjsp.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.isil.parcialappjsp.user.dao.mysql.MysqlConnection;
import pe.isil.parcialappjsp.user.model.User;

//codigo
public class UserDao {
    public int registerUser(User user) throws Exception{
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected = 0;
        
        String queryInsert = "INSERT INTO users (correo,nombre,apePaterno,apeMaterno,direccion,passwordd)" 
                + "VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(queryInsert);
        ps.setString(1, user.getCorreo());
        ps.setString(2, user.getNombre());
        ps.setString(3, user.getApePaterno());
        ps.setString(4, user.getApeMaterno());
        ps.setString(5, user.getDireccion());
        ps.setString(6, user.getPasswordd());
        
        rowsAffected = ps.executeUpdate();
        
        
        return rowsAffected;
        
    }
    
    
     public String updateUser(User user) throws Exception{
       String message= "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        
        PreparedStatement  ps = conn.prepareStatement("SELECT * FROM users where correo=?");
        ps.setString(1, user.getCorreo());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
        }
        
        if(count > 0 ){
            
            
            String queryUpdate = "UPDATE users SET  passwordd=?  WHERE correo=?";
       
            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
            psUpdate.setString(1, user.getPasswordd());
            psUpdate.setString(2, user.getCorreo());
        
            rowsAffected= psUpdate.executeUpdate();
            
            
            if(rowsAffected>0){
                message="Contraseña recuperada";
            }else{
                message="Ocurrio un error";
            }         
        }else{
            message="Usuario no existe";
        }
        
        return message;
        
    }
     
     public String sesionUser(User user) throws Exception{
       String message= "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int count=0;
        
        PreparedStatement  ps = conn.prepareStatement("SELECT * FROM users where correo=? and passwordd=?");
        ps.setString(1, user.getCorreo());
        ps.setString(2, user.getPasswordd());
        
        ResultSet rs =ps.executeQuery();
         
        while(rs.next()){
            count++;
        }
        if(count > 0 ){
            message="Bienvenido";    
        }else{
            message="Usuario no existe";
        }     
        return message;
        
    }
    
}


