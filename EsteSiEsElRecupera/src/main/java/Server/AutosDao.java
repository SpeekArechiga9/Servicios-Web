package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutosDao {
    static Connection con;
    static PreparedStatement pstm;
    static ResultSet rs;

    private static final String INSERT_AUTO = "INSERT INTO vehiculo(marca,modelo,color)VALUES(?,?,?);";

    private static final String GET_AUTO="SELECT * FROM vehiculo;";

    public static boolean generarCarro(String marca, String modelo, String color){
        try {
            con = ConnectionMySQL.getConnection();
            String query = INSERT_AUTO;
            pstm = con.prepareStatement(query);

            pstm.setString(1, marca);
            pstm.setString(2, modelo);
            pstm.setString(3, color);
            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            System.out.println("Error -> "+e);
            e.printStackTrace();
            return false;
        }finally {
            ConnectionMySQL.closeConnections(con,pstm);

        }

    }

    public static ArrayList<AutosBean> showAutos(){
        ArrayList<AutosBean> autos = new ArrayList<>();
        AutosBean bean = null;
        try{
            con = ConnectionMySQL.getConnection();
            String query=GET_AUTO;
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                bean = new AutosBean();
                bean.setNumSerie(rs.getInt("numero_serie"));
                bean.setMarca(rs.getString("marca"));
                bean.setModelo(rs.getString("modelo"));
                bean.setColor(rs.getString("color"));

                autos.add(bean);
            }
        }catch (SQLException e){
            System.out.println("Error -> "+e);
        }finally {
            ConnectionMySQL.closeConnections(con,pstm);
        }
        return autos;
    }
}
