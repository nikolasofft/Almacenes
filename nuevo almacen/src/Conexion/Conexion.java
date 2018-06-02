
package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL="jdbc:mysql://localhost:3306/almacen";
    private static final String USER="root";
    private static final String PASSWORD="1234";

    
    
    public Connection getConexion(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL, USER, PASSWORD);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
            
        }
        return con;
    }
}
