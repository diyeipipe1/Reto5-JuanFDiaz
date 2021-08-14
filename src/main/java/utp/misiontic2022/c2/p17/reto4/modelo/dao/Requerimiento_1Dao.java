package utp.misiontic2022.c2.p17.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p17.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    //4_3 Crea la consulta con el Connection y el Statement.
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        String sql = "SELECT Nombre||' '||Primer_Apellido AS Lider, Cargo, COUNT(*) AS '# Proyectos'FROM Lider l JOIN Proyecto p ON l.ID_Lider = p.ID_Lider WHERE p.Constructora LIKE 'Pegaso' GROUP BY l.ID_Lider ORDER BY Cargo, Lider;";
        try (
            Connection conn = JDBCUtilities.getConnection();
            Statement stms= conn.createStatement();
        ) {
            ResultSet rs = stms.executeQuery(sql);
            ArrayList<Requerimiento_1> req1list= new ArrayList<>();

            //4_4 Se hace un ciclo donde se crea un objeto Requerimiento_1 para cada resultado de la consulta
            //y este objeto se llena y añade a la lista de req1list. Se hace para todos y ese es el ArrayList
            //que se devuelve.
            while (rs.next()){
                Requerimiento_1 req1= new Requerimiento_1();
                req1.setNombre(rs.getString("Lider"));
                req1.setCargo(rs.getString("Cargo"));
                req1.setNumproyectos(rs.getInt("# Proyectos"));
                req1list.add(req1);
            }

            return req1list;

            
        }
    }
}