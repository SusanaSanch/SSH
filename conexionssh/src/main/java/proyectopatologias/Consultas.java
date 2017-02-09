package proyectopatologias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Consultas {
	
	private static final String CONSULTA_PATOLOGIA_ID = "SELECT * FROM Patologias WHERE id_patol = ";
	private static final String CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID = "SELECT * FROM Sintomas WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ";
	
	public static PatologiaDTO buscarPatologiaID(int id, Connection conn, Statement stmt, ResultSet rset) throws SQLException
	{
		PatologiaDTO patologia = null;
		rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
		while (rset.next())
		{
			patologia = new PatologiaDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), buscarSintomasPatologiaID(id, conn));
		}
		
		return patologia;
	}
	
	public static List<Sintoma> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<Sintoma> lista_sintomas = new ArrayList<Sintoma>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		Sintoma sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (rset2.next())
	    {
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new Sintoma(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		
		if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		return lista_sintomas;
	}

}
