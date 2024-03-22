

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
public class CargoCancelMenu extends JFrame {
	private JPanel contentPane;
	private JTextField cargoID, name, surname;
	

	
	public CargoCancelMenu(String n, String s, String type, String ID) {
		Database db=Database.getInstance();
		setVisible(true);
		setBounds(100, 100, 604, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setBounds(425, 495, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerMenu custo = new CustomerMenu(ID,n,s,type);
			}
		});
		TurnBack.setFocusable(false);
		contentPane.setLayout(null);
		contentPane.add(TurnBack);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(26, 83, 537, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cargo ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(208, 204, 72, 24);
		panel.add(lblNewLabel_1);
		
		cargoID = new JTextField();
		
		cargoID.setBounds(208, 226, 114, 36);
		panel.add(cargoID);
		cargoID.setColumns(10);
				
		JLabel recipient_name = new JLabel("Name:");
		recipient_name.setBounds(208, 42, 114, 24);
		recipient_name.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(recipient_name);
		
		name = new JTextField();
		name.setBounds(208, 62, 114, 36);
		name.setEditable(false);
		name.setText(n);
		panel.add(name);
		name.setColumns(10);
		
		
		JLabel recipient_surname = new JLabel("Surname:");
		recipient_surname.setBounds(209, 119, 113, 24);
		recipient_surname.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(recipient_surname);
		
		surname = new JTextField();
		surname.setBounds(208, 141, 114, 36);
		surname.setColumns(10);
		surname.setEditable(false);
		surname.setText(s);
		panel.add(surname);
		
		
		JLabel cargoLbl = new JLabel("Cargo Cancelation");
		cargoLbl.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		cargoLbl.setBounds(26, 51, 152, 32);
		contentPane.add(cargoLbl);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setFocusable(false);
		cancelBtn.setForeground(SystemColor.text);
		cancelBtn.setBackground(SystemColor.infoText);
		cancelBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		cancelBtn.setBounds(190, 309, 148, 54);
		panel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender=n+" "+s;
				if(cargoID.getText()!=null) {
					if(db.cancelCargo(sender,cargoID.getText())==1) {
						 JOptionPane.showMessageDialog(null,"Cancel Successful");
					}
					else {
						 JOptionPane.showMessageDialog(null,"Cancel Unsuccessful");
					}
				}
				else {
					 JOptionPane.showMessageDialog(null,"Cancel Unsuccessful");
				}
				
			}
		});
	}

}
