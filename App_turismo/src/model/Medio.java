package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controler.Conexion;

public class Medio {

	
	public String nombre;
	public int idtipomedio;
	public int idmedio;
	Conexion conector = new Conexion();
	
	public Medio(String nombre, int idtipomedio) {
		super();
		this.nombre = nombre;
		this.idtipomedio = idtipomedio;
	}
	
	public Medio() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdtipomedio() {
		return idtipomedio;
	}
	public void setIdtipomedio(int idtipomedio) {
		this.idtipomedio = idtipomedio;
	}
	
	public void create(String nombre, int idtipomedio) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tblmedio (nombre, idtipomedio) values (?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setString(1, nombre);
				pst.setInt(2, idtipomedio);
				
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	public void delete(int idmedio) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tblmedio where idmedio  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idmedio);
			
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
	
	public void update(int idmedio ,String nombre, int idtipomedio) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "update tblmedio set nombre = ?, idtipomedio = ? where idmedio = ?;";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
		
			pst.setString(1, nombre);
			pst.setInt(2, idtipomedio);
			pst.setInt(3, idmedio);
			
			// confirmar la operacion
			int resp = JOptionPane.showConfirmDialog(null, "¿desea actualizar esta fila?");
			
			if(resp == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "fila actualizada");
			}
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readOne(int idmedio,JTextField nombre, JTextField idtipomedio) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "select * from tblmedio where idmedio = ?;";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo
			pst.setInt(1, idmedio);
			

			ResultSet rs = pst.executeQuery();//almacenar temporal
			
			while (rs.next()) {
				nombre.setText(rs.getString(2));
				idtipomedio.setText(rs.getString(3));
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
