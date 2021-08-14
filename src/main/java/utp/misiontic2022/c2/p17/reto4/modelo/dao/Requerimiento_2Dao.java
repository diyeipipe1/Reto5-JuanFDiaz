package utp.misiontic2022.c2.p17.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p17.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        String sql = "SELECT c.ID_MaterialConstruccion, mc.Nombre_Material, c.Cantidad, mc.Precio_Unidad, Cantidad*mc.Precio_Unidad AS Precio_Total FROM Compra c JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion WHERE ID_Proyecto IN (14, 20, 18, 36, 45, 48, 56) ORDER BY ID_Proyecto ASC, mc.Precio_Unidad DESC;"; 

        try (
            Connection conn= JDBCUtilities.getConnection();
            Statement stms= conn.createStatement();
        ) {
            ResultSet rs = stms.executeQuery(sql);
            ArrayList<Requerimiento_2> req2list= new ArrayList<>();

            while(rs.next()){
                Requerimiento_2 req2 = new Requerimiento_2();
                req2.setId_matconstruc(rs.getInt("ID_MaterialConstruccion"));
                req2.setNommaterial(rs.getString("Nombre_Material"));
                req2.setCantidad(rs.getInt("Cantidad"));
                req2.setPrecio_unit(rs.getInt("Precio_Unidad"));
                req2.setPrecio_total(rs.getInt("Precio_Total"));

                req2list.add(req2);
            }

            return req2list;
        }
    }
}