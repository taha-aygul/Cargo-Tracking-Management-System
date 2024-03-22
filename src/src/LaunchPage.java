import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LaunchPage implements ActionListener{
	JFrame frame=new JFrame();
	JButton loginButton=new JButton("Login");
	JButton regButton=new JButton("Register");
	JPanel loginPanel=new JPanel();
	JTextField email=new JTextField(); 
	JPasswordField password=new JPasswordField();
	JLabel emailLabel=new JLabel("Email:");
	JLabel passwordLabel=new JLabel("Password:");
	JComboBox emailBox;
	public LaunchPage(){
		
		String[] mails= {"@gmail.com","@outlook.com","@hotmail.com","@icloud.com"};
		emailBox=new JComboBox(mails);
		emailBox.setBounds(223, 127, 111, 27);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,450);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		loginButton.setForeground(SystemColor.textHighlight);
		loginButton.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		loginButton.setBounds(117, 239, 99, 41);
		loginButton.addActionListener(this);
		
		regButton.setForeground(SystemColor.textHighlight);
		regButton.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		regButton.setBounds(238, 239, 96, 41);
		
		regButton.addActionListener(this);
		
		regButton.setFocusable(false);
		loginButton.setFocusable(false);
		loginPanel.setBackground(SystemColor.activeCaption);
		loginPanel.setLayout(null);

		
		emailLabel.setBounds(117, 111, 54, 13);
		emailLabel.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		email.setBounds(117, 127, 96, 27);
		
		passwordLabel.setBounds(117, 177, 82, 13);
		passwordLabel.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		password.setBounds(117, 190, 96, 27);
		loginPanel.add(emailBox);
		loginPanel.add(emailLabel);
		loginPanel.add(passwordLabel);
		loginPanel.add(email);
		loginPanel.add(password);
		loginPanel.add(loginButton);
		loginPanel.add(regButton);
		
		frame.add(loginPanel);
		
		
	}   // ID  Name Surname  Type
	@Override
	public void actionPerformed(ActionEvent e) {
		Database db =Database.getInstance();
		System.out.println("aAAAAAAAAAAAAAAAAAAAAAa");
		if (e.getSource()==loginButton) {
			String mail=email.getText()+emailBox.getSelectedItem();
			 if(db.check(mail,password.getText())) {
					
				 	String[] a=db.getNameAndSurname(mail,password.getText());

				 	if(a[3].equals("0")||a[3].equals("1")) {
				 		 AdminMenu n=new AdminMenu(a[0],a[1],a[2],a[3]);
				 	}
				 	if(a[3].equals("2")) {
				 		CustomerMenu n=new CustomerMenu(a[0],a[1],a[2],a[3]);
				 	}
				 	if(a[3].equals("3")) {
				 		CourierMenu n=new CourierMenu(a[1],a[2],a[3],a[0]);
				 	}
					 JOptionPane.showMessageDialog(null,"Login Successful");
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Login Unsuccessful");
				 }
		}
		if(e.getSource()==regButton) {
			frame.dispose();
			registerWindowMenu regWindow=new registerWindowMenu();
		}
		
		
	}

	
}
