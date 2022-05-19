package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureModel {
	
	public static ProcedureModel instance = null;
	public static Connection connection;
	
	public static ProcedureModel getInstance() {
		if(instance == null)
		{
			instance = new ProcedureModel();
			connection = DBConnection.getInstance().getConnection();
		}
		return instance;
	}
	
	public static <T> ResultSet executeProcedure(String procedura, T... lista) {

		CallableStatement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.prepareCall(procedura);
			int i = 1;
			for (T object : lista) {
				stm.setObject(i++, object);
			}
			stm.execute();
			rs = stm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
