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

	public void create(int matricula, String marca, int puestos, String modelo, String numepromotor,
			String categoria, int idtipo) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblvehiculo (matricula, marca, puestos, modelo, numepromotor, categoria, idtipo) values (?,?,?,?,?,?,?,?)";

		try {
			dbConnection = conector.conectarDB();
			pst = dbConnection.prepareStatement(script);

			pst.setInt(1, matricula);
			pst.setString(2, marca);
			pst.setInt(3, puestos);
			pst.setString(4, modelo);
			pst.setString(5, numepromotor);
			pst.setString(6, categoria);
			pst.setInt(7, idtipo);

			pst.executeUpdate();

			JOptionPane.showConfirmDialog(null, "registro con exito");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int matricula) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "delete from tblvehiculo where matricula  = ?";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo
			pst.setInt(1, matricula);

			// confirmar la operacion
			int resp = JOptionPane.showConfirmDialog(null, "¿desea eliminar esta fila?");

			if (resp == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "fila eliminada");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(int matricula, String marca, int puestos, String modelo, String numepromotor,
			String categoria, int idtipo) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "update tblvehiculo set marca = ?, puestos = ?, modelo = ?, numepromotor = ?, categoria = ?, idtipo = ?  where matricula = ?;";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo

			pst.setString(1, marca);
			pst.setInt(2, puestos);
			pst.setString(3, modelo);
			pst.setString(4, numepromotor);
			pst.setString(5, categoria);
			pst.setInt(6, idtipo);
			pst.setInt(7, matricula);

			// confirmar la operacion
			int resp = JOptionPane.showConfirmDialog(null, "¿desea actualizar esta fila?");

			if (resp == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "fila actualizada");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}