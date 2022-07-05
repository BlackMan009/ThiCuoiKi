package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import Server.ServerIMP;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ServerGui extends JFrame {

	private JPanel contentPane;
	private ServerIMP iServer;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JToggleButton btShowandHide;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGui frame = new ServerGui();
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
	public ServerGui() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Server Service");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 286, 60);
		contentPane.add(lblNewLabel);		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 84, 276, 68);
		lblNewLabel_1.setForeground(Color.GREEN);
		contentPane.add(lblNewLabel_1);
		
		btShowandHide = new JToggleButton("Start Server");
		btShowandHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btShowandHide.isSelected()) {
					try {
						iServer = new ServerIMP();
						LocateRegistry.createRegistry(1099);
						Naming.rebind("rmi://localhost:1099/db", iServer);
						lblNewLabel_1.setText("Server is running now .....");
					} catch (Exception e1) {				
					}
					btShowandHide.setText("Stop Server");
				} else {
					System.exit(0);
				}
			}
		});
		contentPane.setLayout(null);
		btShowandHide.setBounds(62, 219, 150, 34);
		btShowandHide.setForeground(Color.BLACK);
		btShowandHide.setBackground(Color.WHITE);
		btShowandHide.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		contentPane.add(btShowandHide);
	}
}
