package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBBDD extends Conexion {
	
	public String verificarPassword (String usuario) throws ClassNotFoundException, SQLException {
		//Declaramos las variables
		String sql="call abogados.verificarPassword(?);";
		//Declaramos un resultset
		CallableStatement st;
		//Hacemos ahora el resultset
		ResultSet rs;
		String password = null;
		
		//Abrir la conexi�n y decimos que la propague (primera opci�n)
		abrirConexion();
		
		//obtener el comando
		st = miConexion.prepareCall(sql);
		//Asignar el valor al par�metro de entrada
		
		st.setString(1, usuario);
		//Ejecutar el comando
		
		rs = st.executeQuery();
		
		if (rs.next()) {
			password = rs.getNString("password"); //Este es el que coincide con nuestra BBDD
				
		}
		//Cerramos la conexi�n
		cerrarConexion();
		//Devolvemos la password
		return password;
		
		
	}

}
