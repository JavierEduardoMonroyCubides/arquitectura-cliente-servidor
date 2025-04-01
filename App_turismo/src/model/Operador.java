package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Operador {

	
	public int tipodocumento;
	public int documento;
	public String nombre; 
	public String apellido; 
	public String direccion;
	public String correo;
	public String telefono;
	public int matricula;
	public int idoperador;
	Conexion conector = new Conexion();
	
	public Operador(int tipodocumento, int documento, String nombre, String apellido, String direccion, String correo,
			String telefono, int matricula) {
		super();
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.matricula = matricula;
	}
	
	
	
	public Operador() {
		super();
	}



	public int getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(int tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void create(int tipodocumento, int documento, String nombre, String apellido, String direccion, String correo,
			String telefono, int matricula) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tbloperador (tipodocumento, documento, nombre, apellido, direccion, correo, telefono, matricula) values (?,?,?,?,?,?,?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setInt(1, tipodocumento);
				pst.setInt(2, documento);
				pst.setString(3, nombre);
				pst.setString(4, apellido);
				pst.setString(5, direccion);
				pst.setString(6, correo);
				pst.setString(7, telefono);
				pst.setInt(8, matricula);
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	public void delete(int idoperador) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tbloperador where idoperador  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idoperador);
			
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
	
	
	public void update(int idoperador ,int tipodocumento, int documento, String nombre, String apellido, String direccion, String correo,
			String telefono, int matricula) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "update tbloperador set tipodocumento = ?, documento = ?, nombre = ?, apellido = ?, direccion = ?, correo = ?, telefono = ?, matricula = ?  where idoperador = ?;";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
		
			pst.setInt(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombre);
			pst.setString(4, apellido);
			pst.setString(5, direccion);
			pst.setString(6, correo);
			pst.setString(7, telefono);
			pst.setInt(8, matricula);
			pst.setInt(9, idoperador);
			
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
}
