package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Conexion;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmAccesoAlSistema;
	private JTextField usuario_txt;
	private JTextField password_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAccesoAlSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoAlSistema = new JFrame();
		frmAccesoAlSistema.getContentPane().setBackground(Color.CYAN);
		frmAccesoAlSistema.setBackground(Color.BLUE);
		frmAccesoAlSistema.setTitle("acceso al sistema");
		frmAccesoAlSistema.setBounds(100, 100, 450, 300);
		frmAccesoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoAlSistema.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(120, 40, 70, 14);
		frmAccesoAlSistema.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(120, 105, 70, 14);
		frmAccesoAlSistema.getContentPane().add(lblNewLabel_1);
		
		usuario_txt = new JTextField();
		usuario_txt.setBounds(225, 37, 86, 20);
		frmAccesoAlSistema.getContentPane().add(usuario_txt);
		usuario_txt.setColumns(10);
		
		password_txt = new JTextField();
		password_txt.setBounds(225, 102, 86, 20);
		frmAccesoAlSistema.getContentPane().add(password_txt);
		password_txt.setColumns(10);
		
		JButton btnreset = new JButton("reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("boton del reset pulsado");
				usuario_txt.setText("");
				password_txt.setText("");
			}
		});
		btnreset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnreset.setBounds(52, 179, 89, 23);
		frmAccesoAlSistema.getContentPane().add(btnreset);
		
		JButton btnlogin = new JButton("login");
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("boton del login pulsado");
				acceder();
			}
		});
		btnlogin.setBounds(291, 179, 89, 23);
		frmAccesoAlSistema.getContentPane().add(btnlogin);
	}
	private void acceder() {
		System.out.println("metodo acceder");
		Connection miconexion =new Conexion().conectar();
		
		String consulta="SELECT * FROM user WHERE username=? AND password=?";//consulta parametrica
		
		try {
			PreparedStatement ps=miconexion.prepareStatement(consulta);
			ps.setString(1, usuario_txt.getText());
			ps.setString(2, password_txt.getText());
			ResultSet rs=ps.executeQuery();
			//System.out.println(rs.next());
			if(rs.next()) {
				System.out.println("trueee");
				Principal p=new Principal();
				p.setVisible(true);;
				
			}else {
				JOptionPane.showMessageDialog(null, "datos incorrectos");
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
