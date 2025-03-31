package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Agencias {

	public String nombre;
	public String correo;
	public String telefono;
	public String direccion;
	public String web;
	public int idcompania;
	Conexion conector = new Conexion();
	
	
	
	public Agencias(String nombre, String correo, String telefono, String direccion, String web, int idcompania,
			Conexion conector) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.web = web;
		this.idcompania = idcompania;
		this.conector = conector;
	}


	public Agencias() {
		super();
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getIdcompania() {
		return idcompania;
	}
	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
	}
	
	
	
	public void create(String nombre, String correo, String telefono, String direccion, String web, int idcompania) {
		
		
		Connection dbConnection = null;
		PreparedStatement pst = null; 
		
		String script = "insert into tblagencias (nombre, direccion, telefono, correo, web, idcompania) values (?,?,?,?,?,?)";
		
		try {
			dbConnection = conector.conectarDB();
			pst = dbConnection.prepareStatement(script);
			
			pst.setString(1, nombre);
			pst.setString(2, direccion);
			pst.setString(3, telefono);
			pst.setString(4, correo);
			pst.setString(5, web);
			pst.setInt(6, idcompania);
			
			pst.executeUpdate();
			
			JOptionPane.showConfirmDialog(null, "registro con exito");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
