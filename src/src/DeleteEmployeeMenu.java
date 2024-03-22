

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DeleteEmployeeMenu extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField employee_id;
	private JLabel delEmpLbl;
	
	public DeleteEmployeeMenu(String na, String surna, String type, String ID) {
		Database db=Database.getInstance();
		setVisible(true);
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(25, 81, 489, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setFocusable(false);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminMenu adminMenu = new AdminMenu(ID,na,surna,type);
			}
		});
		TurnBack.setBounds(375, 414, 140, 43);
		contentPane.add(TurnBack);
		
		
		name = new JTextField();
		name.setBounds(179, 41, 123, 36);
		panel.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(179, 112, 123, 36);
		panel.add(surname);
		surname.setColumns(10);
		
		employee_id = new JTextField();
		employee_id.setBounds(179, 186, 123, 36);
		panel.add(employee_id);
		employee_id.setColumns(10);
		
		JButton delete = new JButton("DELETE EMPLOYEE");
		delete.setFocusable(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(db.delete(name.getText(),surname.getText(),employee_id.getText(),"3")==1) {
					 JOptionPane.showMessageDialog(null,"Delete Successful");
				}
				else
					 JOptionPane.showMessageDialog(null, "Delete Unsuccessful");
				
			}
		});
		delete.setForeground(SystemColor.text);
		delete.setBackground(SystemColor.infoText);
		delete.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		delete.setBounds(154, 257, 176, 54);
		panel.add(delete);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLbl.setBounds(179, 18, 72, 24);
		panel.add(nameLbl);
		
		JLabel surnameLbl = new JLabel("Surname:");
		surnameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		surnameLbl.setBounds(179, 89, 72, 24);
		panel.add(surnameLbl);
		
		JLabel empIDLbl = new JLabel("Employee ID:");
		empIDLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		empIDLbl.setBounds(179, 163, 101, 24);
		panel.add(empIDLbl);
		
		delEmpLbl = new JLabel("DELETE EMPLOYEE");
		delEmpLbl.setForeground(SystemColor.desktop);
		delEmpLbl.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		delEmpLbl.setBackground(new Color(0, 0, 0));
		delEmpLbl.setBounds(36, 37, 144, 34);
		contentPane.add(delEmpLbl);
		
		
	}

}
