package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controler.Conexion;

public class Vehiculo {

	public int matricula;
	public int placa; 
	public String marca;
	public int puestos;
	public String modelo;
	public String numepromotor;
	public String categoria;
	public int idtipo;
	Conexion conector = new Conexion();
	
	public Vehiculo(int matricula, int placa, String marca, int puestos, String modelo, String numepromotor,
			String categoria, int idtipo) {
		super();
		this.matricula = matricula;
		this.placa = placa;
		this.marca = marca;
		this.puestos = puestos;
		this.modelo = modelo;
		this.numepromotor = numepromotor;
		this.categoria = categoria;
		this.idtipo = idtipo;
	}
	public Vehiculo() {
		super();
	}

	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPuestos() {
		return puestos;
	}

	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}

	public String getModelo() {
		return modelo;
	}

	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumepromotor() {
		return numepromotor;
	}

	public void setNumepromotor(String numepromotor) {
		this.numepromotor = numepromotor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdtipo() {
		return idtipo;
	}
	
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public void create(int matricula, int placa, String marca, int puestos, String modelo, String numepromotor,
			String categoria, int idtipo) {
			
			
			Connection dbConnection = null;
			PreparedStatement pst = null; 
			
			String script = "insert into tblvehiculo (matricula, placa, marca, puestos, modelo, numepromotor, categoria, idtipo) values (?,?,?,?,?,?,?,?)";
			
			try {
				dbConnection = conector.conectarDB();
				pst = dbConnection.prepareStatement(script);
				
				pst.setInt(1, matricula);
				pst.setInt(2, placa);
				pst.setString(3, marca);
				pst.setInt(4, puestos);
				pst.setString(5, modelo);
				pst.setString(6, numepromotor);
				pst.setString(7, categoria);
				pst.setInt(8, idtipo);
				
				pst.executeUpdate();
				
				JOptionPane.showConfirmDialog(null, "registro con exito");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
}