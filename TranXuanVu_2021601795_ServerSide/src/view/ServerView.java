package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ServerController;
import dao.ClientDao;
import model.DataClient;
import model.ListDataClient;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ServerView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtID;
	public JTextField txtName;
	public JTextField txtDate;
	public JTextField txtAddress;
	public JTextField txtGender;
	public JTextField txtSubject1;
	public JTextField txtSubject2;
	public JTextField txtSubject3;
	public JTable tableData;
	public JMenuBar menuBar;
	public JMenu menuFile;
	public JMenuItem menuSave;
	public JMenuItem menuOpen;
	public JButton btnAdd;
	public JButton btnEdit;
	public JButton btnDelete;
	public JButton btnClear;
	public JButton btnSortByName;
	public JButton btnSortBygpa;

	public ServerView(ServerController controler) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 552);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		menuSave = new JMenuItem("Save");
		menuFile.add(menuSave);
		menuSave.addActionListener(controler);

		menuOpen = new JMenuItem("Open");
		menuFile.add(menuOpen);
		menuOpen.addActionListener(controler);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 46, 64, 15);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(31, 83, 64, 14);
		contentPane.add(lblName);

		JLabel lblDateOfB = new JLabel("DATE OF BIRTH");
		lblDateOfB.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfB.setBounds(31, 127, 103, 14);
		contentPane.add(lblDateOfB);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(31, 170, 103, 14);
		contentPane.add(lblAddress);

		JLabel lblGern = new JLabel("GENDER");
		lblGern.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGern.setBounds(31, 214, 103, 14);
		contentPane.add(lblGern);

		JLabel lblSubject = new JLabel("SUBJECT 1");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject.setBounds(31, 260, 103, 14);
		contentPane.add(lblSubject);

		JLabel lblSubject_1 = new JLabel("SUBJECT 2");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1.setBounds(31, 310, 103, 14);
		contentPane.add(lblSubject_1);

		JLabel lblSubject_1_1 = new JLabel("SUBJECT 3");
		lblSubject_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1_1.setBounds(31, 359, 103, 14);
		contentPane.add(lblSubject_1_1);

		txtID = new JTextField();
		txtID.setBounds(142, 44, 144, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(142, 81, 144, 20);
		contentPane.add(txtName);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(142, 125, 144, 20);
		contentPane.add(txtDate);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(142, 168, 144, 20);
		contentPane.add(txtAddress);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(142, 212, 144, 20);
		contentPane.add(txtGender);

		txtSubject1 = new JTextField();
		txtSubject1.setColumns(10);
		txtSubject1.setBounds(142, 258, 144, 20);
		contentPane.add(txtSubject1);

		txtSubject2 = new JTextField();
		txtSubject2.setColumns(10);
		txtSubject2.setBounds(142, 308, 144, 20);
		contentPane.add(txtSubject2);

		txtSubject3 = new JTextField();
		txtSubject3.setColumns(10);
		txtSubject3.setBounds(144, 357, 144, 20);
		contentPane.add(txtSubject3);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(controler);
		btnAdd.setBounds(30, 406, 89, 23);
		contentPane.add(btnAdd);

		btnEdit = new JButton("EDIT");
		btnEdit.setBounds(198, 406, 89, 23);
		btnEdit.addActionListener(controler);
		contentPane.add(btnEdit);

		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(30, 457, 89, 23);
		btnDelete.addActionListener(controler);
		contentPane.add(btnDelete);

		btnClear = new JButton("CLEAR");
		btnClear.setBounds(198, 457, 89, 23);
		btnClear.addActionListener(controler);
		contentPane.add(btnClear);

		tableData = new JTable();
		tableData.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Full name", "Birth",
				"Address", "Gender", "Mark 1", "Mark 2", "Mark 3", "GPA", "IP", "Time" }));
		tableData.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableData.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableData.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableData.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableData.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableData.getColumnModel().getColumn(5).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(6).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(7).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(8).setPreferredWidth(5);
		tableData.getColumnModel().getColumn(9).setPreferredWidth(50);
		tableData.getColumnModel().getColumn(10).setPreferredWidth(30);
		tableData.setFillsViewportHeight(true);
		tableData.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (SwingUtilities.isLeftMouseButton(e)) {
					int row = tableData.rowAtPoint(e.getPoint());
					if (row >= 0) {
						showDataRow(row);
					}
				}

			}
		});
		JScrollPane scrollPane = new JScrollPane(tableData);
		scrollPane.setBounds(300, 44, 802, 327);
		contentPane.add(scrollPane);

		btnSortByName = new JButton("Sort by name");
		btnSortByName.setBounds(383, 431, 152, 23);
		btnSortByName.addActionListener(controler);
		contentPane.add(btnSortByName);

		btnSortBygpa = new JButton("Sort by gpa");
		btnSortBygpa.setBounds(860, 431, 152, 23);
		btnSortBygpa.addActionListener(controler);
		contentPane.add(btnSortBygpa);
	}

	public void showMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	public void refreshData(ArrayList<DataClient> list) {
		DefaultTableModel model = (DefaultTableModel) tableData.getModel();
		model.setRowCount(0);
		if (list != null) {
			for (DataClient dataClient : list) {
				double m1 = dataClient.getInforStu().getMark1();
				double m2 = dataClient.getInforStu().getMark2();
				double m3 = dataClient.getInforStu().getMark3();
				String formattedDate = String.format("%02d/%02d/%d",
				        dataClient.getInforStu().getDateOfBirth().getDayOfMonth(),
				        dataClient.getInforStu().getDateOfBirth().getMonthValue(),
				        dataClient.getInforStu().getDateOfBirth().getYear());
				double gpa = (m1 + m2 + m3) / 3;
				model.addRow(new Object[] { dataClient.getInforStu().getStudentID() + "",
						dataClient.getInforStu().getFullName() + "",
						formattedDate,
						dataClient.getInforStu().getAddress().toString(),
						dataClient.getInforStu().getGender().toString(), m1, m2, m3, gpa,
						dataClient.getIp().getHostAddress(),
						dataClient.getTime().getHour() + " : " + dataClient.getTime().getMinute() + "" });
			}
		} else {
			this.showMessage("No data to fresh!");
		}
		model.fireTableDataChanged();
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

	public void showDataRow(int row) {
		DefaultTableModel model = (DefaultTableModel) tableData.getModel();
// 	"ID", "Full name", "Birth", "Address", "Gender", "Mark 1", "Mark 2", "Mark 3", "GPA", "IP", "Time"
		String id = model.getValueAt(row, 0).toString();
		String name = model.getValueAt(row, 1).toString();
		String birth = model.getValueAt(row, 2).toString();
		String address = model.getValueAt(row, 3).toString();
		String sex = model.getValueAt(row, 4).toString();
		String mark1 = model.getValueAt(row, 5).toString();
		String mark2 = model.getValueAt(row, 6).toString();
		String mark3 = model.getValueAt(row, 7).toString();
		this.txtID.setText(id);
		this.txtName.setText(name);
		this.txtDate.setText(birth);
		this.txtGender.setText(sex);
		this.txtAddress.setText(address);
		this.txtSubject1.setText(mark1);
		this.txtSubject2.setText(mark2);
		this.txtSubject3.setText(mark3);
	}

	public DataClient getInforClient() {
		DataClient client = null;
//	 	"ID", "Full name", "Birth", "Address", "Gender", "Mark 1", "Mark 2", "Mark 3", "GPA", "IP", "Time"
		String id = "";
		String name = "";
		String address = "";
		String gender = "";
		LocalDate birth = null;
		double mark1 = -1;
		double mark2 = -1;
		double mark3 = -1;
		InetAddress ipAddress = null;
		try {
			ipAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDateTime time = null;

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
		time = LocalDateTime.now();
		Student st = new Student(id, name, birth, address, gender, mark1, mark2, mark3);
		client = new DataClient(st, ipAddress, time);
		return client;
	}

	public void addData(ListDataClient c) {
		DataClient client = this.getInforClient();
		if (client != null) {
			if (c.addStudent(client)) {
				ArrayList<DataClient> cl = c.getClients();
				for (DataClient dataClient : cl) {
					System.out.println(dataClient);
				}
				this.refreshData(c.getClients());
				this.clearText();
				this.showMessage("Add new infor client successed!");
			} else {
				this.showMessage("Information exist!");
			}
		} else {
			this.showMessage("Errol give data client");
		}
	}

	public void updateData(ListDataClient c) {
		String id = this.txtID.getText().toString().trim();
		DataClient dc = c.findStudent(id);
		if(dc!= null)
		{
			dc.getInforStu().setFullName(this.txtName.getText().trim());
			
			String days = this.txtDate.getText().trim();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dc.getInforStu().setDateOfBirth(LocalDate.parse(days, formatter));
			
			dc.getInforStu().setAddress(this.txtAddress.getText().trim());
			dc.getInforStu().setGender(this.txtGender.getText().trim());
			dc.getInforStu().setMark1(Double.valueOf(this.txtSubject1.getText().trim()));
			dc.getInforStu().setMark2(Double.valueOf(this.txtSubject2.getText().trim()));
			dc.getInforStu().setMark3(Double.valueOf(this.txtSubject3.getText().trim()));
			c.deleteStudent(id);
			c.addStudent(dc);
			this.refreshData(c.getClients());
			this.clearText();
			this.showMessage("Update data successed!");
		}
		else
		{
			this.showMessage("ID not exist!");
		}
	}

	public void deleteData(ListDataClient c) {
		String id = this.txtID.getText().toString();
		if (id.isEmpty()) {
			this.showMessage("Please enter ID!");
		} else {
			if (c.deleteStudent(id)) {
				this.refreshData(c.getClients());
				this.clearText();
				this.showMessage("Delete successed!");
			} else {
				this.showMessage("Errol delete because not find data client!");
			}
		}
	}
	public void sortByName(ListDataClient c)
	{
		c.sortByName();
		this.refreshData(c.getClients());
	}
	public void sortByGPA(ListDataClient c)
	{
		c.sortByGPA();
		this.refreshData(c.getClients());
	}
	public void makeOpenFile(ClientDao cd)
	{
		JFileChooser fc = new JFileChooser();
		int val = fc.showOpenDialog(this);
		if(val == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			cd.openFile(file.getAbsolutePath());
			this.refreshData(cd.getListClients().getClients());
		}
	}
	public void makeSaveFile(ClientDao cd)
	{
		JFileChooser fc = new JFileChooser();
		int val = fc.showSaveDialog(this);
		if(val == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			cd.saveFile(file.getAbsolutePath());
			this.showMessage("Save file successed!");
		}
	}
	
}
