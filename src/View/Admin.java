package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.AdminModel;
import Controller.Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField nhaptk;
	private JPasswordField nhapmk;
	Dao dao = new Dao();
	private JToggleButton btShowandHide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Admin admin = new Admin();
			admin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setTitle("Đăng Nhập / Đăng Kí");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblngNhpAdmin = new JLabel("Quản Lý Bệnh Nhân");
		lblngNhpAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhpAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblngNhpAdmin.setBounds(0, 21, 436, 52);
		contentPane.add(lblngNhpAdmin);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 105, 112, 34);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u ");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setBounds(25, 218, 112, 34);
		contentPane.add(lblMtKhu);

		nhaptk = new JTextField();
		nhaptk.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhaptk.setBounds(25, 149, 388, 43);
		contentPane.add(nhaptk);
		nhaptk.setColumns(10);

		nhapmk = new JPasswordField();
		nhapmk.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhapmk.setBounds(25, 262, 388, 43);
		contentPane.add(nhapmk);

		JButton btnDangnhap = new JButton("Đăng Nhập");
		btnDangnhap.setForeground(new Color(102, 153, 255));
		btnDangnhap.setBackground(new Color(102, 153, 255));
		btnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = nhaptk.getText();
				String password = nhapmk.getText();
				try {
					Connection connection = (Connection) DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;databaseName=CuoiKi2;user=sa;password=20112003");
					PreparedStatement st = (PreparedStatement) connection
							.prepareStatement("Select account, password from admin where account=? and password=?");
					st.setString(1, userName);
					st.setString(2, password);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						dispose();
						new AdminView().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản đăng nhập không đúng", "Thông Báo",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDangnhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangnhap.setBounds(25, 388, 156, 52);
		contentPane.add(btnDangnhap);
		
		JButton btnngK = new JButton("Đăng Kí");
		btnngK.setForeground(new Color(102, 153, 255));
		btnngK.setBackground(new Color(102, 153, 255));
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminModel adminModel = getModel();
				String mess = dao.add(adminModel);
				if (validateForm()) {
					try {
						dao.add(adminModel);
						JOptionPane.showMessageDialog(null, mess, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					clear();
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnngK.setBounds(251, 388, 162, 52);
		contentPane.add(btnngK);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 321, 102, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/img/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 436, 463);
		contentPane.add(lblNewLabel_1);
		
		btShowandHide = new JToggleButton("Showpass");
		btShowandHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btShowandHide.isSelected()) {
					nhapmk.setEchoChar((char) 0);
					btShowandHide.setText("Hidepass");
				} else {
					nhapmk.setEchoChar('\u25cf');
					btShowandHide.setText("Showpass");
				}
			}
		});
		panel.setLayout(null);
		btShowandHide.setHorizontalAlignment(SwingConstants.LEADING);
		btShowandHide.setBounds(0, 0, 101, 34);
		btShowandHide.setForeground(new Color(102, 153, 255));
		btShowandHide.setBackground(Color.WHITE);
		btShowandHide.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		panel.add(btShowandHide);
	}
	
	public boolean validateForm() {
		if (nhaptk.getText().isEmpty() || nhapmk.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public void clear() {
		nhaptk.setText("");
		nhapmk.setText("");
	}
	
	private AdminModel getModel() {
		AdminModel adminModel = new AdminModel();
		adminModel.setAccount(nhaptk.getText());
		adminModel.setPassword(nhapmk.getText());
		return adminModel;
	}
}
