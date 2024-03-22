
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

public class ChangePasswordMenu extends JFrame {

	private JPanel contentPane;
	private JTextField oldPass;
	private JTextField newPass;
	private JTextField newPass2;

	
	public ChangePasswordMenu(String n, String s, String type, String ID) {
		Database db=Database.getInstance();
		setVisible(true);
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setFocusable(false);
		TurnBack.setBounds(375, 414, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(type.equals("1")) {
					AdminMenu adminMenu = new AdminMenu(ID,n,s,type);
				}
				if(type.equals("2")) {
					CustomerMenu custo = new CustomerMenu(ID,n,s,type);
				}
				if(type.equals("3")) {
					CourierMenu co=new CourierMenu(n,s,type,ID);
				}
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(TurnBack);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(26, 83, 489, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		oldPass = new JTextField();
		oldPass.setBounds(179, 41, 123, 36);
		panel.add(oldPass);
		oldPass.setColumns(10);

		newPass = new JTextField();
		newPass.setBounds(179, 113, 123, 36);
		panel.add(newPass);
		newPass.setColumns(10);

		newPass2 = new JTextField();
		newPass2.setBounds(179, 181, 123, 36);
		panel.add(newPass2);
		newPass2.setColumns(10);
		
		JButton applyBtn = new JButton("Apply Changes");
		applyBtn.setFocusable(false);
		applyBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(newPass.getText().length()>3&&newPass.getText().equals(newPass2.getText())&&
						db.changePass(newPass.getText(),oldPass.getText(),ID,n,s)==1) {
						
					JOptionPane.showMessageDialog(null,"Change Successful");
				}
				else {
					JOptionPane.showMessageDialog(null,"Change Unuccessful");
				}
						
			}
		});
		applyBtn.setForeground(SystemColor.text);
		applyBtn.setBackground(SystemColor.infoText);
		applyBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		applyBtn.setBounds(169, 238, 148, 54);
		panel.add(applyBtn);
		
		JLabel oldPassLbl = new JLabel("Old Password:");
		oldPassLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		oldPassLbl.setBounds(179, 18, 105, 24);
		panel.add(oldPassLbl);
		
		JLabel newPassLbl = new JLabel("New Password:");
		newPassLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		newPassLbl.setBounds(179, 90, 107, 24);
		panel.add(newPassLbl);
		
		JLabel cPassLbl = new JLabel("Confirm Password:");
		cPassLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		cPassLbl.setBounds(179, 159, 123, 24);
		panel.add(cPassLbl);
		
		
		JLabel cBtnLbl = new JLabel("CHANGE A PASSWORD");
		cBtnLbl.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		cBtnLbl.setBounds(26, 41, 173, 32);
		contentPane.add(cBtnLbl);
	}
}
