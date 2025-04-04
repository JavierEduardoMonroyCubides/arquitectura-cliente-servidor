package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controler.Conexion;

public class Paquete {

	public int iddestino;
	public int idorigen;
	public String fechaventa;
	public String horaventa;
	public String horasalida;
	public String fechaejecucion;
	public String observaciones;
	public int idagencia;
	public int matricula;
	public int idpromotor;
	public int idcliente;
	public int idmedio;
	public String precio;
	public int codigo;
	Conexion conector = new Conexion();

	public Paquete(int iddestino, int idorigen, String fechaventa, String horaventa, String horasalida,
			String fechaejecucion, String observaciones, int idagencia, int matricula, int idpromotor, int idcliente,
			int idmedio, String precio) {
		super();
		this.iddestino = iddestino;
		this.idorigen = idorigen;
		this.fechaventa = fechaventa;
		this.horaventa = horaventa;
		this.horasalida = horasalida;
		this.fechaejecucion = fechaejecucion;
		this.observaciones = observaciones;
		this.idagencia = idagencia;
		this.matricula = matricula;
		this.idpromotor = idpromotor;
		this.idcliente = idcliente;
		this.idmedio = idmedio;
		this.precio = precio;
	}

	public Paquete() {
		super();
	}

	public int getIddestino() {
		return iddestino;
	}

	public void setIddestino(int iddestino) {
		this.iddestino = iddestino;
	}

	public int getIdorigen() {
		return idorigen;
	}

	public void setIdorigen(int idorigen) {
		this.idorigen = idorigen;
	}

	public String getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(String fechaventa) {
		this.fechaventa = fechaventa;
	}

	public String getHoraventa() {
		return horaventa;
	}

	public void setHoraventa(String horaventa) {
		this.horaventa = horaventa;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	public String getFechaejecucion() {
		return fechaejecucion;
	}

	public void setFechaejecucion(String fechaejecucion) {
		this.fechaejecucion = fechaejecucion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdagencia() {
		return idagencia;
	}

	public void setIdagencia(int idagencia) {
		this.idagencia = idagencia;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdpromotor() {
		return idpromotor;
	}

	public void setIdpromotor(int idpromotor) {
		this.idpromotor = idpromotor;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdmedio() {
		return idmedio;
	}

	public void setIdmedio(int idmedio) {
		this.idmedio = idmedio;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public void create(int iddestino, int idorigen, String fechaventa, String horaventa, String horasalida,
			String fechaejecucion, String observaciones, int idagencia, int matricula, int idpromotor, int idcliente,
			int idmedio, String precio) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblpaquete (iddestino, idorigen, fechaventa, horaventa, horasalida, fechaejecucion, observaciones, idagencia, matricula, idpromotor, idcliente, idmedio, precio) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = conector.conectarDB();
			pst = dbConnection.prepareStatement(script);

			pst.setInt(1, iddestino);
			pst.setInt(2, idorigen);
			pst.setString(3, fechaventa);
			pst.setString(4, horaventa);
			pst.setString(5, horasalida);
			pst.setString(6, fechaejecucion);
			pst.setString(7, observaciones);
			pst.setInt(8, idagencia);
			pst.setInt(9, matricula);
			pst.setInt(10, idpromotor);
			pst.setInt(11, idcliente);
			pst.setInt(12, idmedio);
			pst.setString(13, precio);

			pst.executeUpdate();

			JOptionPane.showConfirmDialog(null, "registro con exito");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int codigo) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "delete from tblpaquete where codigo  = ?";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo
			pst.setInt(1, codigo);

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

	public void update(int codigo, int iddestino, int idorigen, String fechaventa, String horaventa, String horasalida,
			String fechaejecucion, String observaciones, int idagencia, int matricula, int idpromotor, int idcliente,
			int idmedio, String precio) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "update tblpaquete set iddestino = ?, idorigen = ?, fechaventa = ?, horaventa = ?, horasalida = ?, fechaejecucion = ?, observaciones = ?, idagencia = ?, matricula = ? ,idpromotor = ?, idcliente = ?, idmedio = ?, precio = ?  where codigo = ?;";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo

			pst.setInt(1, iddestino);
			pst.setInt(2, idorigen);
			pst.setString(3, fechaventa);
			pst.setString(4, horaventa);
			pst.setString(5, horasalida);
			pst.setString(6, fechaejecucion);
			pst.setString(7, observaciones);
			pst.setInt(8, idagencia);
			pst.setInt(9, matricula);
			pst.setInt(10, idpromotor);
			pst.setInt(11, idcliente);
			pst.setInt(12, idmedio);
			pst.setString(13, precio);
			
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
	
	public void readOne(int codigo, JTextField iddestino, JTextField idorigen, JTextField fechaventa, JTextField horaventa, JTextField horasalida,
			JTextField fechaejecucion, JTextField observaciones, JTextField idagencia, JTextField matricula, JTextField idpromotor, JTextField idcliente,
			JTextField idmedio, JTextField precio) {

		Connection dbConnection = null;
		PreparedStatement pst = null; // preparar la trx

		String script = "select * from tblpaquete where codigo = ?;";

		try {
			dbConnection = conector.conectarDB(); // abrir la conexion
			pst = dbConnection.prepareStatement(script); // abrir el buffer

			// parametrizar el campo
			pst.setInt(1, codigo);
			

			ResultSet rs = pst.executeQuery();//almacenar temporal
			
			while (rs.next()) {
				iddestino.setText(rs.getString(2));
				idorigen.setText(rs.getString(3));
				fechaventa.setText(rs.getString(4));
				horaventa.setText(rs.getString(5));
				horasalida.setText(rs.getString(6));
				fechaejecucion.setText(rs.getString(7));
				observaciones.setText(rs.getString(8));
				idagencia.setText(rs.getString(9));
				matricula.setText(rs.getString(10));
				idpromotor.setText(rs.getString(11));
				idcliente.setText(rs.getString(12));
				idmedio.setText(rs.getString(13));
				precio.setText(rs.getString(14));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
