package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class TipoTransporte {

	
	public String nombre;
	public String observacion;
	public int idtipo;
	Conexion conector =  new Conexion();
	
	public TipoTransporte(String nombre, String observacion) {
		super();
		this.nombre = nombre;
		this.observacion = observacion;
	}
	
	
	public TipoTransporte() {
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
			
			String script = "insert into tbltipotransporte (nombre, observacion) values (?,?)";
			
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
	
	public void delete(int idtipo) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tbltipotransporte where idtipo  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idtipo);
			
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
