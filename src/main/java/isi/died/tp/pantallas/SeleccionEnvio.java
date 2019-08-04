package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class SeleccionEnvio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionEnvio window = new SeleccionEnvio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeleccionEnvio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Selección de Envío");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnS = new JButton("Insumos faltantes");
		btnS.setBounds(175, 40, 130, 40);
		frame.getContentPane().add(btnS);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(175, 112, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
