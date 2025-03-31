package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Compania {

	
	public String razonsocial;
	public String direccion;
	public String telefono;
	public String fechacreacion;
	public String correo;
	public String web;
	Conexion conector = new Conexion();
	
	public Compania(String razonsocial, String direccion, String telefono, String fechacreacion, String correo,
			String web) {
		super();
		this.razonsocial = razonsocial;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechacreacion = fechacreacion;
		this.correo = correo;
		this.web = web;
	}
	
	
	
	public Compania() {
		super();
	}



	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	
	public void create(String razonsocial, String direccion, String telefono, String fechacreacion, String correo,
			String web) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tblcompania (razonsocial, direccion, telefono, fechacreacion, correo, web) values (?,?,?,?,?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setString(1, razonsocial);
				pst.setString(2, direccion);
				pst.setString(3, telefono);
				pst.setString(4, fechacreacion);
				pst.setString(5, correo);
				pst.setString(6, web);
				
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
}
