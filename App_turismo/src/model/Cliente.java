package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Cliente {

	public int tipodocumento;
	public int documento ;
	public String nombre;
	public String apellidos;
	public String eps ;
	public String alergias; 
	public String fechanacimiento;
	public String correo;
	public String estadocivil;
	public String direccion ;
	public String telefonico ;
	public int idcliente;
	Conexion conector = new Conexion();
	
	public Cliente(int tipodocumento, int documento, String nombre, String apellidos, String eps, String alergias,
			String fechanacimiento, String correo, String estadocivil, String direccion, String telefonico) {
		super();
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.eps = eps;
		this.alergias = alergias;
		this.fechanacimiento = fechanacimiento;
		this.correo = correo;
		this.estadocivil = estadocivil;
		this.direccion = direccion;
		this.telefonico = telefonico;
	}
	
	
	
	public Cliente() {
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefonico() {
		return telefonico;
	}
	public void setTelefonico(String telefonico) {
		this.telefonico = telefonico;
	}
	
	public void create(int tipodocumento, int documento, String nombre, String apellidos, String eps, String alergias,
		String fechanacimiento, String correo, String estadocivil, String direccion, String telefonico) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; 
		
		String script = "insert into tblcliente (tipodocumento, documento, nombre, apellidos, eps, alergias, fechanacimiento, correo, estadocivil, direccion, telefonico) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			dbConnection = conector.conectarDB();
			pst = dbConnection.prepareStatement(script);
			
			pst.setInt(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombre);
			pst.setString(4, apellidos);
			pst.setString(5, eps);
			pst.setString(6, alergias);
			pst.setString(7, fechanacimiento);
			pst.setString(8, correo);
			pst.setString(9, estadocivil);
			pst.setString(10, direccion);
			pst.setString(11, telefonico);
			
			pst.executeUpdate();
			
			JOptionPane.showConfirmDialog(null, "registro con exito");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int idcliente) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "delete from tblcliente where idcliente  = ?";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion 
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
			pst.setInt(1, idcliente);
			
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
	
	public void update(int idcliente, int tipodocumento, int documento, String nombre, String apellidos, String eps, String alergias,
			String fechanacimiento, String correo, String estadocivil, String direccion, String telefonico) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx
		
		String script = "update tblcliente set tipodocumento = ?, documento = ?, nombre = ?, apellidos = ?, eps = ?, alergias = ?, fechanacimiento = ?, correo = ?, estadocivil = ?, direccion = ?, telefonico = ?  where idcliente = ?;";
		
		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer
			
			//parametrizar el campo
		
			pst.setInt(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombre);
			pst.setString(4, apellidos);
			pst.setString(5, eps);
			pst.setString(6, alergias);
			pst.setString(7, fechanacimiento);
			pst.setString(8, correo);
			pst.setString(9, estadocivil);
			pst.setString(10, direccion);
			pst.setString(11, telefonico);
			pst.setInt(12, idcliente);
			
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