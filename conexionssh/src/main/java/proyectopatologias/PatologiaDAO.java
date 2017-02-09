package proyectopatologias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatologiaDAO {
	public static PatologiaDTO buscarPatologiaID(int id, Connection conn, Statement stmt) throws SQLException
	{
		ResultSet rset = null;
		PatologiaDTO patologia = null;
		rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
		while (rset.next())
		{
			patologia = new PatologiaDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), buscarSintomasPatologiaID(id, conn));
		}
		
		return patologia;
	}
	
	public static List<SintomaDTO> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		SintomaDTO sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (rset2.next())
	    {
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new SintomaDTO(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		
		if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		return lista_sintomas;
	}
}
