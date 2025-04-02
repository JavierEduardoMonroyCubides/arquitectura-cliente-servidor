package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Promotor {

	
	public String nombre;
	public String apellido;
	public int tipodocumento; 
	public int documento;
	public String direccion; 
	public String correopersonal;
	public String correocorp;
	public String fechanacimiento; 
	public String telefono;
	public int idpromotor;
	Conexion conector = new Conexion();
	
	public Promotor(String nombre, String apellido, int tipodocumento, int documento, String direccion,
			String correopersonal, String correocorp, String fechanacimiento, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.direccion = direccion;
		this.correopersonal = correopersonal;
		this.correocorp = correocorp;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
	}
	
	
	public Promotor() {
		super();
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreopersonal() {
		return correopersonal;
	}
	public void setCorreopersonal(String correopersonal) {
		this.correopersonal = correopersonal;
	}
	public String getCorreocorp() {
		return correocorp;
	}
	public void setCorreocorp(String correocorp) {
		this.correocorp = correocorp;
	}
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void create(String nombre, String apellido, int tipodocumento, int documento, String direccion,
			String correopersonal, String correocorp, String fechanacimiento, String telefono) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tblpromotores (nombre, apellido, tipodocumento, documento, direccion, correopersonal, correocorp, fechanacimiento, telefono) values (?,?,?,?,?,?,?,?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setString(1, nombre);
				pst.setString(2, apellido);
				pst.setInt(3, tipodocumento);
				pst.setInt(4, documento);
				pst.setString(5, direccion);
				pst.setString(6, correopersonal);
				pst.setString(7, correocorp);
				pst.setString(8, fechanacimiento);
				pst.setString(9, telefono);
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	public void delete(int idpromotor) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tblpromotores where idpromotor  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idpromotor);
			
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
	
	public void update(int idpromotor ,String nombre, String apellido, int tipodocumento, int documento, String direccion,
			String correopersonal, String correocorp, String fechanacimiento, String telefono) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "update tblpromotores set nombre = ?, apellido = ?, tipodocumento = ?, documento = ?, direccion = ?, correopersonal = ?, correocorp = ?, fechanacimiento = ?, telefono = ?  where idpromotor = ?;";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
		
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setInt(3, tipodocumento);
			pst.setInt(4, documento);
			pst.setString(5, direccion);
			pst.setString(6, correopersonal);
			pst.setString(7, correocorp);
			pst.setString(8, fechanacimiento);
			pst.setString(9, telefono);
			pst.setInt(10, idpromotor);
			
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
