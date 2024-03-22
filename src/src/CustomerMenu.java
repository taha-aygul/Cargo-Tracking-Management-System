import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomerMenu extends JFrame {
	private JPanel contentPane;
	private JTextField txtNameSurname;
	private JTextField txtDate;
	public CustomerMenu(String ID, String name, String surname, String type){
		Database db=Database.getInstance();
		Dat date=Dat.getInstance();
		setVisible(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 551, 504);
		setResizable(false);
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
		
		JButton addCargo = new JButton("Add New Cargo");
		addCargo.setFocusable(false);
		addCargo.setBounds(37, 149, 226, 91);
		addCargo.setForeground(SystemColor.textHighlight);
		addCargo.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		addCargo.setBackground(Color.WHITE);
		contentPane.add(addCargo);
		
		JButton cargoSearch = new JButton("Cargo Search");
		cargoSearch.setFocusable(false);
		cargoSearch.setBounds(37, 250, 226, 91);
		cargoSearch.setForeground(SystemColor.textHighlight);
		cargoSearch.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		cargoSearch.setBackground(Color.WHITE);
		contentPane.add(cargoSearch);
		
		JButton cargoCancel = new JButton("Cargo Cancellation");
		cargoCancel.setFocusable(false);
		cargoCancel.setBounds(273, 149, 226, 91);
		cargoCancel.setForeground(SystemColor.textHighlight);
		cargoCancel.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		cargoCancel.setBackground(Color.WHITE);
		contentPane.add(cargoCancel);
		
		JButton ChangePassword = new JButton("Change Password");
		ChangePassword.setFocusable(false);
		ChangePassword.setBounds(150, 351, 226, 91);
		ChangePassword.setForeground(SystemColor.textHighlight);
		ChangePassword.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		ChangePassword.setBackground(Color.WHITE);
		contentPane.add(ChangePassword);
		
		
		
		JButton listCargo = new JButton("List Cargo");
		listCargo.setFocusable(false);
		listCargo.setFont(new Font("Verdana Pro", Font.BOLD, 16));
		listCargo.setBackground(Color.WHITE);
		listCargo.setForeground(SystemColor.textHighlight);
		listCargo.setBounds(273, 250, 226, 91);
		contentPane.add(listCargo);
		
		JLabel welcLbl = new JLabel("Welcome");
		welcLbl.setFont(new Font("Verdana", Font.BOLD, 12));
		welcLbl.setBounds(20, 41, 66, 13);
		contentPane.add(welcLbl);
		
		
		addCargo.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddCargoMenu addCargoMenu = new AddCargoMenu(name,surname,type,ID);
				
			}
		});
		
		
		cargoSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				CargoSearchMenu cSearch = new CargoSearchMenu(name,surname,type,ID);
				
			}
		});
		
		
		
		cargoCancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CargoCancelMenu cCancel = new CargoCancelMenu(name,surname,type,ID);
				
			}
		});
		ChangePassword.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ChangePasswordMenu changeP = new ChangePasswordMenu(name,surname,type,ID);
				
			}
		});
		
		listCargo.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				CargoListMenu cList = new CargoListMenu(name,surname,type,ID);
				
			}
		});
	}

}
