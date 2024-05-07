package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClientController;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtAddress;
	private JTextField txtGender;
	private JTextField txtSubject1;
	private JTextField txtSubject2;
	private JTextField txtSubject3;
	private JLabel labelID;
	private JTable tableData;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ClientView(ClientController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN SINH VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(343, 11, 365, 34);
		contentPane.add(lblNewLabel);
		
		labelID = new JLabel("ID ");
		labelID.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelID.setBounds(246, 74, 64, 15);
		contentPane.add(labelID);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(246, 111, 64, 14);
		contentPane.add(lblName);

		JLabel lblDateOfB = new JLabel("DATE OF BIRTH");
		lblDateOfB.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfB.setBounds(246, 155, 103, 14);
		contentPane.add(lblDateOfB);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(246, 198, 103, 14);
		contentPane.add(lblAddress);

		JLabel lblGern = new JLabel("GENDER");
		lblGern.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGern.setBounds(246, 242, 103, 14);
		contentPane.add(lblGern);

		JLabel lblSubject = new JLabel("SUBJECT 1");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject.setBounds(246, 288, 103, 14);
		contentPane.add(lblSubject);

		JLabel lblSubject_1 = new JLabel("SUBJECT 2");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1.setBounds(246, 338, 103, 14);
		contentPane.add(lblSubject_1);

		JLabel lblSubject_1_1 = new JLabel("SUBJECT 3");
		lblSubject_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1_1.setBounds(246, 387, 103, 14);
		contentPane.add(lblSubject_1_1);

		txtID = new JTextField();
		txtID.setBounds(357, 72, 437, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(357, 109, 437, 20);
		contentPane.add(txtName);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(357, 153, 437, 20);
		contentPane.add(txtDate);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(357, 196, 437, 20);
		contentPane.add(txtAddress);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(357, 240, 437, 20);
		contentPane.add(txtGender);

		txtSubject1 = new JTextField();
		txtSubject1.setColumns(10);
		txtSubject1.setBounds(357, 286, 437, 20);
		contentPane.add(txtSubject1);

		txtSubject2 = new JTextField();
		txtSubject2.setColumns(10);
		txtSubject2.setBounds(357, 336, 437, 20);
		contentPane.add(txtSubject2);

		txtSubject3 = new JTextField();
		txtSubject3.setColumns(10);
		txtSubject3.setBounds(359, 385, 435, 20);
		contentPane.add(txtSubject3);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setBounds(872, 71, 89, 23);
		btnSend.addActionListener(controller);
		contentPane.add(btnSend);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(872, 122, 89, 23);
		btnCancel.addActionListener(controller);
		contentPane.add(btnCancel);
		
		tableData = new JTable();
		tableData.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Full name", "Birth",
				"Address", "Gender", "Mark 1", "Mark 2", "Mark 3", "GPA"}));
		tableData.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableData.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableData.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableData.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableData.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableData.getColumnModel().getColumn(5).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(6).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(7).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(8).setPreferredWidth(5);
		tableData.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tableData);
		scrollPane.setBounds(114, 416, 886, 163);
		contentPane.add(scrollPane);
	}
	public void showMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	public void refreshData(ArrayList<Student> list) {
		DefaultTableModel model = (DefaultTableModel) tableData.getModel();
		model.setRowCount(0);
		if (list != null) {
			for (Student dataClient : list) {
				double m1 = dataClient.getMark1();
				double m2 = dataClient.getMark2();
				double m3 = dataClient.getMark3();
				double gpa = (m1 + m2 + m3) / 3;
				model.addRow(new Object[] { dataClient.getStudentID() + "",
						dataClient.getFullName() + "",
						dataClient.getDateOfBirth().getDayOfMonth() + "/"
								+ dataClient.getDateOfBirth().getMonthValue() + "/"
								+ dataClient.getDateOfBirth().getYear(),
						dataClient.getAddress().toString(),
						dataClient.getGender().toString(), m1, m2, m3, gpa });
			}
		} else {
			this.showMessage("No data to fresh!");
		}
		model.fireTableDataChanged();
	}
	public Student getInforClient() {
		String id = "";
		String name = "";
		String address = "";
		String gender = "";
		LocalDate birth = null;
		double mark1 = -1;
		double mark2 = -1;
		double mark3 = -1;
		if (!this.txtID.getText().isEmpty()) {
			id = this.txtID.getText().trim();
		} else {
			this.showMessage("Please enter ID!");
			return null;
		}
		if (!this.txtName.getText().isEmpty()) {
			name = this.txtName.getText().trim();
		} else {
			this.showMessage("Please enter name!");
			return null;
		}
		if (!this.txtDate.getText().isEmpty()) {
			String days = this.txtDate.getText().trim();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			birth = LocalDate.parse(days, formatter);
		} else {
			this.showMessage("Please enter date of birth!");
			return null;
		}
		if (!this.txtAddress.getText().isEmpty()) {
			address = this.txtAddress.getText().trim();
		} else {
			this.showMessage("Please enter address!");
			return null;
		}
		if (!this.txtGender.getText().isEmpty()) {
			gender = this.txtGender.getText().trim();
		} else {
			this.showMessage("Please enter gender!");
			return null;
		}
		if (!this.txtSubject1.getText().isEmpty()) {
			mark1 = Double.valueOf(this.txtSubject1.getText().trim());

		} else {
			this.showMessage("Please enter mark 1!");
			return null;
		}
		if (!this.txtSubject2.getText().isEmpty()) {
			mark2 = Double.valueOf(this.txtSubject2.getText().trim());
		} else {
			this.showMessage("Please enter mark 2!");
			return null;
		}
		if (!this.txtSubject3.getText().isEmpty()) {
			mark3 = Double.valueOf(this.txtSubject3.getText().trim());
		} else {
			this.showMessage("Please enter mark 3!");
			return null;
		}
		Student st = new Student(id, name, birth, address, gender, mark1, mark2, mark3);
		return st;
	}
	public void clearText() {
		this.txtID.setText("");
		this.txtName.setText("");
		this.txtDate.setText("");
		this.txtGender.setText("");
		this.txtAddress.setText("");
		this.txtSubject1.setText("");
		this.txtSubject2.setText("");
		this.txtSubject3.setText("");
	}
}
