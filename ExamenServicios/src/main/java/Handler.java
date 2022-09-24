import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Handler {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    public boolean generarCurp(String curp, String nombre, String primerApellido, String segundoApellido, String sexo, String edoNacimiento, String fecNacimiento){
        boolean flag = false;
        try{
            con = ConexionMySQL.getConnection();
            pstm = con.prepareCall("INSERT INTO `ciudadanos` (curp = ?, Nombre = ?, primer_apellido = ?, segundo_apellido = ?, sexo = ?, edo_nacimiento = ?, fecha_nacimiento = ?) VALUES (?,?,?,?,?,?,?);");
            pstm.setString(1,curp);
            pstm.setString(2,nombre);
            pstm.setString(3,primerApellido);
            pstm.setString(4,segundoApellido);
            pstm.setString(5,sexo);
            pstm.setString(6,edoNacimiento);
            pstm.setString(7,fecNacimiento);

            flag = pstm.executeUpdate() == 1;
        }catch (SQLException e){
            System.out.println("Error -> "+e.getMessage());
        }finally {
            ConexionMySQL.closeConnections(con,pstm);
        }
        return flag;
    }
}
