package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class TipoMedio {

	
	public String nombre;
	public String observacion;
	public int idtipomedio;
	Conexion conector = new Conexion();
	
	public TipoMedio(String nombre, String observacion) {
		super();
		this.nombre = nombre;
		this.observacion = observacion;
	}
	
	
	public TipoMedio() {
		super();
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public void create(String nombre, String observacion) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tbltipomedio (nombre, observacion) values (?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setString(1, nombre);
				pst.setString(2, observacion);
				
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	public void delete(int idtipomedio) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tbltipomedio where idtipomedio  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idtipomedio);
			
			// confirmar la operacion
			int resp = JOptionPane.showConfirmDialog(null, "¿desea eliminar esta fila?");
			
			if(resp == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "fila eliminada");
			}
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}