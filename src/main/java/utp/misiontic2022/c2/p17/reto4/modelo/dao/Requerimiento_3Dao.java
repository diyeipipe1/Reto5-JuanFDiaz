package utp.misiontic2022.c2.p17.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p17.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao { 
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        String sql= "WITH preciosproyectos AS(SELECT ID_Proyecto, Cantidad*mc.Precio_Unidad AS Precio_Total FROM Compra c JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion) SELECT ID_Proyecto, Ciudad, Clasificacion, SUM(Precio_Total) AS Costo_Proyecto FROM preciosproyectos pp NATURAL JOIN Proyecto p WHERE Ciudad LIKE 'Pereira' OR Ciudad LIKE 'Sta. Rosa de Cabal' GROUP BY p.ID_Proyecto HAVING Costo_Proyecto > 87000 ORDER BY Ciudad, Clasificacion;";

        try (
            Connection conn = JDBCUtilities.getConnection();
            Statement stms= conn.createStatement();
        ) {
            ResultSet rs= stms.executeQuery(sql);
            ArrayList<Requerimiento_3> req3list= new ArrayList<>();


            while(rs.next())
            {   
                Requerimiento_3 req3= new Requerimiento_3();
                req3.setId_proyecto(rs.getInt("ID_Proyecto")); 
                req3.setCiudad(rs.getString("Ciudad"));
                req3.setClasificacion(rs.getString("Clasificacion"));
                req3.setCosto_proyecto(rs.getInt("Costo_Proyecto"));

                req3list.add(req3);
            }

            return req3list;
            
        } 

    }
}