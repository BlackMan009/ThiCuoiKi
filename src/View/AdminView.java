package View;

import java.awt.BorderLayout;
import Model.benhnhan;
import Server.IServer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.ui.RefineryUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import Controller.Dao;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfphone;
	private JTextField tftype;
	private JTextField tfdepartment;
	private JTextField tfroom;
	private JTextField tfbed;
	private JTextField tfaddress;
	private JScrollPane scrollPane;
	private JTable tbManager;
	private JLabel lblNewLabel_1_4_9;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnXa;
	private JButton btnSa;
	private JButton btnClearForm;
	private DefaultTableModel defaul;
	private String stt_acc;
	benhnhan benhnhan = new benhnhan();
	Dao dao = new Dao();
	private JPanel panel_3;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JDateChooser birthday;
	private JDateChooser dayin;
	private IServer iServer;
	private JButton btnThngK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            AdminView adminView = new AdminView();
            adminView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * Create the frame.
	 */
	public AdminView() {
		init();
		FillDataTable();
		try {
			iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			JOptionPane.showMessageDialog(null, "Đã kết nối với server", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chưa kết nối với server", "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}
	}
		public void init() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(268, 10, 518, 41);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u1EE8ng D\u1EE5ng Qu\u1EA3n L\u00FD B\u1EC7nh Nh\u00E2n N\u1ED9i Tr\u00FA");
		lblNewLabel.setBounds(0, 0, 518, 41);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 655, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00E3 b\u1EC7nh nh\u00E2n");
		lblNewLabel_1_4.setBounds(10, 10, 102, 23);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_4_1 = new JLabel("T\u00EAn b\u1EC7nh nh\u00E2n");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_1.setBounds(293, 10, 102, 23);
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_2.setBounds(293, 43, 102, 23);
		panel.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_3.setBounds(10, 43, 102, 23);
		panel.add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Ng\u00E0y nh\u1EADp vi\u1EC7n");
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_4.setBounds(10, 76, 102, 23);
		panel.add(lblNewLabel_1_4_4);
		
		JLabel lblNewLabel_1_4_5 = new JLabel("Lo\u1EA1i b\u1EC7nh");
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_5.setBounds(293, 76, 102, 23);
		panel.add(lblNewLabel_1_4_5);
		
		JLabel lblNewLabel_1_4_6 = new JLabel("Khoa b\u1EC7nh");
		lblNewLabel_1_4_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_6.setBounds(293, 109, 102, 23);
		panel.add(lblNewLabel_1_4_6);
		
		JLabel lblNewLabel_1_4_7 = new JLabel("Ph\u00F2ng b\u1EC7nh");
		lblNewLabel_1_4_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_7.setBounds(10, 109, 102, 23);
		panel.add(lblNewLabel_1_4_7);
		
		JLabel lblNewLabel_1_4_8 = new JLabel("S\u1ED1 gi\u01B0\u1EDDng b\u1EC7nh");
		lblNewLabel_1_4_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_8.setBounds(10, 142, 102, 23);
		panel.add(lblNewLabel_1_4_8);
		
		tfid = new JTextField();
		tfid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfid.setBounds(122, 10, 108, 23);
		panel.add(tfid);
		tfid.setColumns(10);
		
		tfname = new JTextField();
		tfname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfname.setColumns(10);
		tfname.setBounds(405, 11, 239, 23);
		panel.add(tfname);
		
		tfphone = new JTextField();
		tfphone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfphone.setColumns(10);
		tfphone.setBounds(405, 44, 239, 23);
		panel.add(tfphone);
		
		tftype = new JTextField();
		tftype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tftype.setColumns(10);
		tftype.setBounds(405, 77, 239, 23);
		panel.add(tftype);
		
		tfdepartment = new JTextField();
		tfdepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfdepartment.setColumns(10);
		tfdepartment.setBounds(405, 110, 239, 23);
		panel.add(tfdepartment);
		
		tfroom = new JTextField();
		tfroom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfroom.setColumns(10);
		tfroom.setBounds(122, 110, 108, 23);
		panel.add(tfroom);
		
		tfbed = new JTextField();
		tfbed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfbed.setColumns(10);
		tfbed.setBounds(122, 145, 108, 23);
		panel.add(tfbed);
		
		lblNewLabel_1_4_9 = new JLabel("Quên quán");
		lblNewLabel_1_4_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_9.setBounds(293, 142, 102, 23);
		panel.add(lblNewLabel_1_4_9);
		
		tfaddress = new JTextField();
		tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfaddress.setColumns(10);
		tfaddress.setBounds(405, 145, 239, 23);
		panel.add(tfaddress);
		
		birthday = new JDateChooser();
		birthday.setBounds(122, 43, 108, 23);
		panel.add(birthday);
		
		dayin = new JDateChooser();
		dayin.setBounds(122, 76, 108, 23);
		panel.add(dayin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 966, 362);
		tbManager = new JTable();
		tbManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tbManager.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						int Username = tbManager.rowAtPoint(e.getPoint());
						stt_acc = tbManager.getValueAt(Username, 0).toString();
						benhnhan benhnhan = dao.getAccountUsername(stt_acc);
						setModel(benhnhan);
					}
				});
			}
		});
		tbManager.setModel(new DefaultTableModel(
				new Object[][] { {} },
				new String[] {
						"Mã bệnh nhân", "Tên bệnh nhân", "Số điện thoại", "Ngày sinh", "Ngày nhập viện", "Loại bệnh", "Phòng bệnh", "Khoa bệnh", "Số giường bệnh","Quê quán"
				}));
		scrollPane.setViewportView(tbManager);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBounds(692, 61, 284, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				benhnhan benhnhan = getModel();
				String mess = dao.add(benhnhan);
				if (validateForm()) {
					try {
						dao.add(benhnhan);
						JOptionPane.showMessageDialog(null, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						FillDataTable();
						clearform();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(24, 10, 115, 34);
		panel_1.add(btnNewButton);
		
		btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mess = dao.del(stt_acc);

				int op = JOptionPane.showConfirmDialog(null, "Muốn xóa tài khoản này không ?", "Delete",
						JOptionPane.YES_NO_OPTION);

				if (op == JOptionPane.YES_OPTION) {
					try {
						dao.del(stt_acc);
						JOptionPane.showConfirmDialog(null, mess, "Thông báo", JOptionPane.CANCEL_OPTION);
					} catch (Exception o) {
						o.printStackTrace();
					}
					FillDataTable();
					clearform();
				}
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXa.setBounds(149, 10, 115, 34);
		panel_1.add(btnXa);
		
		btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					benhnhan model = getModel();
					String mess = dao.edit(model);
					try {
						dao.edit(model);
						JOptionPane.showMessageDialog(null, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						FillDataTable();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				}
				clearform();

			}
		});
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSa.setBounds(24, 54, 115, 34);
		panel_1.add(btnSa);
		
		btnClearForm = new JButton("Clear Form");
		btnClearForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearform(); 
			}
		});
		btnClearForm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClearForm.setBounds(149, 54, 115, 34);
		panel_1.add(btnClearForm);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FillDataTable();;
			}
		});
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoadTable.setBounds(24, 98, 115, 34);
		panel_1.add(btnLoadTable);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 153, 255));
		panel_3.setBounds(227, 142, 37, 34);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(AdminView.class.getResource("/img/Search.png")));
		lblNewLabel_2.setBounds(0, 0, 37, 34);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = textField.getText();
				search(searchString);
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(24, 142, 201, 34);
		panel_1.add(textField);
		
		btnThngK = new JButton("Thống kê");
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						LineChart_AWT chart = new LineChart_AWT("Thống kê", "Thống kê số bệnh nhân nội trú trong tháng");
						chart.pack();
						RefineryUtilities.centerFrameOnScreen(chart);
						chart.setVisible(true);
					} catch (Exception e1) {
					}
			}
		});
		btnThngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThngK.setBounds(149, 98, 115, 34);
		panel_1.add(btnThngK);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 986, 643);
		contentPane.add(lblNewLabel_1);
	}
    
	public void clearform() {
		tfid.setText("");
		  tfname.setText("");
		  tfphone.setText("");
		  tftype.setText("");
		  tfdepartment.setText("");
		  tfroom.setText("");;
		  tfbed.setText("");
		  tfaddress.setText("");
	}
	
	public benhnhan getModel() {
		benhnhan.setId(tfid.getText());
		benhnhan.setName(tfname.getText());
		benhnhan.setPhone(tfphone.getText());
		benhnhan.setBirthday(birthday.getDate());
		benhnhan.setDayin(dayin.getDate());
		benhnhan.setType(tftype.getText());
		benhnhan.setRoom(tfroom.getText());
		benhnhan.setDepartment(tfdepartment.getText());
		benhnhan.setBed(tfbed.getText());
		benhnhan.setAddress(tfaddress.getText());
		return benhnhan;
	}

	public void setModel(benhnhan benhnhan) {
		tfid.setText(benhnhan.getId());
		tfname.setText(benhnhan.getName());
		tfphone.setText(String.valueOf(benhnhan.getPhone()));
		birthday.setDate(benhnhan.getBirthday());
		dayin.setDate(benhnhan.getDayin());
		tftype.setText(benhnhan.getType());
		tfroom.setText(benhnhan.getRoom());
		tfdepartment.setText(benhnhan.getDepartment());
		tfbed.setText(String.valueOf(benhnhan.getBed()));
		tfaddress.setText(benhnhan.getAddress());
	}
	
	public void FillDataTable() {
		defaul = (DefaultTableModel) tbManager.getModel();
		defaul.setRowCount(0);
		for (benhnhan benhnhan : dao.getAllAccount()) {
			Object dataRow[] = new Object[10];
			dataRow[0] = benhnhan.getId();
			dataRow[1] = benhnhan.getName();
			dataRow[2] = benhnhan.getPhone();
			dataRow[3] = benhnhan.getBirthday();
			dataRow[4] = benhnhan.getDayin();
			dataRow[5] = benhnhan.getType();
			dataRow[6] = benhnhan.getRoom();
			dataRow[7] = benhnhan.getDepartment();
			dataRow[8] = benhnhan.getBed();
			dataRow[9] = benhnhan.getAddress();
			defaul.addRow(dataRow);
		}
	}
	
	public boolean validateForm() {
		if (tfid.getText().isEmpty() || tfname.getText().isEmpty() || tfphone.getText().isEmpty()
				|| tftype.getText().isEmpty() || tfroom.getText().isEmpty() || tfdepartment.getText().isEmpty()
				|| tfbed.getText().isEmpty() || tfaddress.getText().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void search(String str) {
		defaul = (DefaultTableModel) tbManager.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(defaul);
		tbManager.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
}
