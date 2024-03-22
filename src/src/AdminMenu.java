

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameSurname;
	private JTextField txtDate;

	public AdminMenu(String ID, String name, String surname, String type) {
		
		Database db=Database.getInstance();
		Dat date=Dat.getInstance();
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		txtNameSurname = new JTextField();
		txtNameSurname.setForeground(Color.BLACK);
		txtNameSurname.setBackground(SystemColor.textHighlight);
		txtNameSurname.setEditable(false);
		String s=name+" "+surname;
		txtNameSurname.setText(s);
		txtNameSurname.setBounds(20, 66, 125, 34);
		contentPane.add(txtNameSurname);
		txtNameSurname.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setForeground(Color.BLACK);
		txtDate.setBackground(SystemColor.textHighlight);
		txtDate.setEditable(false);
		txtDate.setText("Date:"+date.getDate());
		txtDate.setBounds(407, 26, 108, 28);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		


		JButton addEmp = new JButton("Add New Employee");
		addEmp.setForeground(SystemColor.textHighlight);
		addEmp.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		addEmp.setBackground(Color.WHITE);
		addEmp.setBounds(30, 119, 226, 91);
		contentPane.add(addEmp);
		addEmp.setFocusable(false);
		
		JButton ListEmployees = new JButton("List Employees");
		ListEmployees.setForeground(SystemColor.textHighlight);
		ListEmployees.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		ListEmployees.setBackground(Color.WHITE);
		ListEmployees.setBounds(30, 230, 226, 91);
		contentPane.add(ListEmployees);
		ListEmployees.setFocusable(false);
		
		JButton DeleteEmployee = new JButton("Delete Employee");
		DeleteEmployee.setForeground(SystemColor.textHighlight);
		DeleteEmployee.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		DeleteEmployee.setBackground(Color.WHITE);
		DeleteEmployee.setBounds(281, 119, 226, 91);
		contentPane.add(DeleteEmployee);
		DeleteEmployee.setFocusable(false);
		
		JButton CargoSearch = new JButton("Cargo Search");
		CargoSearch.setForeground(SystemColor.textHighlight);
		CargoSearch.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		CargoSearch.setBackground(Color.WHITE);
		CargoSearch.setBounds(281, 230, 226, 91);
		contentPane.add(CargoSearch);
		CargoSearch.setFocusable(false);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 41, 66, 13);
		contentPane.add(lblNewLabel);
		
		
		JButton ChangePassword = new JButton("Change Password");
		ChangePassword.setForeground(SystemColor.textHighlight);
		ChangePassword.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		ChangePassword.setBackground(Color.WHITE);
		ChangePassword.setBounds(30, 345, 226, 95);
		contentPane.add(ChangePassword);
		ChangePassword.setFocusable(false);
		
		JButton ListCargo = new JButton("List Cargo");
		ListCargo.setForeground(SystemColor.textHighlight);
		ListCargo.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		ListCargo.setBackground(Color.WHITE);
		ListCargo.setBounds(281,345, 226, 95);
		contentPane.add(ListCargo);
		ListCargo.setFocusable(false);
		
		
		addEmp.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddEmployeeMenu addEmp = new AddEmployeeMenu(name,surname,type,ID);
				
				
			}
		});
		
		
		ListEmployees.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Queue<People> info=db.listAllEmployee("3");
				
				dispose();
				ListEmployeesMenu listEmp = new ListEmployeesMenu(info,name,surname,type,ID);
				
			}
		});
		
		
		
		DeleteEmployee.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteEmployeeMenu deleteEmp = new DeleteEmployeeMenu(name,surname,type,ID);
				
			}
		});
		
		
		CargoSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CargoSearchMenu CargoSea = new CargoSearchMenu(name,surname,type,ID);
			
			}
		});
		
		ChangePassword.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ChangePasswordMenu changeP = new ChangePasswordMenu(name,surname,type,ID);
				
			}
		});
		
		ListCargo.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				CargoListMenu cLsit = new CargoListMenu(name,surname,type,ID);
				
			}
		});
		
	}
}
