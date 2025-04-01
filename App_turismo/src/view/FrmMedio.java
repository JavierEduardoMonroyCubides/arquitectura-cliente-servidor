package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import model.Medio;

public class FrmMedio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtIdTipoMedio;
	private JTextField txtIdMedio;
	Medio cr = new Medio();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMedio frame = new FrmMedio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMedio() {
		setTitle("Medio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(108, 74, 86, 20);
		contentPane.add(txtNombre);
		
		txtIdTipoMedio = new JTextField();
		txtIdTipoMedio.setColumns(10);
		txtIdTipoMedio.setBounds(108, 105, 86, 20);
		contentPane.add(txtIdTipoMedio);
		
		JButton btnNewButton = new JButton("guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cr.create(txtNombre.getText(),Integer.parseInt(txtIdTipoMedio.getText()));
			}
		});
		btnNewButton.setBounds(236, 74, 112, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(54, 77, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorreo = new JLabel("idtipomedio:");
		lblCorreo.setBounds(38, 108, 60, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblIdmedio = new JLabel("IdMedio:");
		lblIdmedio.setBounds(53, 46, 60, 14);
		contentPane.add(lblIdmedio);
		
		txtIdMedio = new JTextField();
		txtIdMedio.setColumns(10);
		txtIdMedio.setBounds(108, 43, 86, 20);
		contentPane.add(txtIdMedio);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdMedio.getText()));
			}
		});
		btnEliminar.setBounds(236, 30, 112, 34);
		contentPane.add(btnEliminar);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtIdMedio.getText()), txtNombre.getText(),Integer.parseInt(txtIdTipoMedio.getText()));
			}
		});
		btnUpdate.setBounds(236, 122, 112, 34);
		contentPane.add(btnUpdate);
	}

}
