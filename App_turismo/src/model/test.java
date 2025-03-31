package model;

import javax.swing.JOptionPane;

import controler.Conexion;

public class test {
	
	public static void main(String[] args) {
		Conexion test = new Conexion();
		if (test.conectarDB() !=null) {
			JOptionPane.showConfirmDialog(null, "conectado a la BD");
		
		}else {
			JOptionPane.showConfirmDialog(null, "no conectado a la BD");
		}
	}
}
