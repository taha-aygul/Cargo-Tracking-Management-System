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

public class registerWindowMenu implements ActionListener {
	JFrame frame=new JFrame();
	JButton regButton=new JButton("Register");
	JButton backButton=new JButton("Back");
	JPanel loginPanel=new JPanel();
	JTextField name=new JTextField();
	JTextField surName=new JTextField();
	JTextField phone=new JTextField();
	JTextField email=new JTextField();
	JTextField street=new JTextField();
	JTextField town=new JTextField();
	JTextField city=new JTextField();
	JTextField apartment=new JTextField();
	JTextField door=new JTextField();
	JPasswordField password=new JPasswordField();
	JPasswordField password2=new JPasswordField();
	JLabel nameLabel=new JLabel("Name:");
	JLabel surNameLabel=new JLabel("Surname:");
	JLabel passwordLabel=new JLabel("Password:");
	JLabel passwordLabel2=new JLabel("Password:");
	JLabel phoneLabel=new JLabel("Phone:");
	JLabel emailLabel=new JLabel("Email:");
	JLabel typeLabel=new JLabel("User type:");
	JLabel streetLabel=new JLabel("Street Name:");
	JLabel townLabel=new JLabel("Town Name:");
	JLabel cityLabel=new JLabel("City Name:");
	JLabel apaLabel=new JLabel("Apt. Name:");
	JLabel doorLabel=new JLabel("Door No:");
	JComboBox typeBox;
	JComboBox phoneBox;
	JComboBox emailBox;
	registerWindowMenu(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,750);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		String[] types= {"Customer","Courier"};
		typeBox= new JComboBox(types);
		
		String[] country_codes= {"+90"};
		phoneBox= new JComboBox(country_codes);
		
		String[] mails= {"@gmail.com","@outlook.com","@hotmail.com","@icloud.com"};
		emailBox=new JComboBox(mails);
		
		regButton.setForeground(SystemColor.textHighlight);
		regButton.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		regButton.setBounds(400,500,90,30);
		regButton.addActionListener(this);
		regButton.setFocusable(false);
		
		backButton.setForeground(SystemColor.textHighlight);
		backButton.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		backButton.setBounds(300,500,90,30);
		backButton.addActionListener(this);
		
		typeBox.setBounds(150,450,90,30);
		phoneBox.setBounds(110,350,50,30);
		emailBox.setBounds(240,400,100,30);
		
		loginPanel.setBackground(SystemColor.activeCaption);
		loginPanel.setLayout(null);
		
		phoneLabel.setBounds(30,300,125,125);
		phoneLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		
		phone.setBounds(170,350,100,30);
		
		
		emailLabel.setBounds(30,350,125,125);
		emailLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		
		email.setBounds(130,400,100,30);
		
		typeLabel.setBounds(30,400,125,125);
		typeLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		
		streetLabel.setBounds(330,100,125,125);
		streetLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		street.setBounds(480,150,100,30);
		
		townLabel.setBounds(330,150,125,125);
		townLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		town.setBounds(480,200,100,30);
		
		cityLabel.setBounds(330,200,125,125);
		cityLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		city.setBounds(480,250,100,30);
		
		apaLabel.setBounds(330,250,125,125);
		apaLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		apartment.setBounds(480,300,100,30);
		
		doorLabel.setBounds(330,300,125,125);
		doorLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		door.setBounds(480,350,100,30);
		
		nameLabel.setBounds(30,100,125,125);
		nameLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		name.setBounds(150,150,100,30);
		
		
		surNameLabel.setBounds(30,150,125,125);
		surNameLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		surName.setBounds(150,200,100,30);
		passwordLabel.setBounds(30,200,125,125);
		passwordLabel.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		passwordLabel2.setBounds(30,250,125,125);
		passwordLabel2.setFont(new Font("Verdana Pro", Font.BOLD, 20));
		password.setBounds(150,250,100,30);
		password2.setBounds(150,300,100,30);
		loginPanel.add(nameLabel);
		loginPanel.add(passwordLabel);
		loginPanel.add(name);
		loginPanel.add(password);
		loginPanel.add(phone);
		loginPanel.add(email);
		loginPanel.add(surName);
		loginPanel.add(passwordLabel2);
		loginPanel.add(password2);
		loginPanel.add(regButton);
		loginPanel.add(backButton);
		loginPanel.add(typeBox);
		loginPanel.add(phoneBox);
		loginPanel.add(emailBox);
		loginPanel.add(phoneLabel);
		loginPanel.add(emailLabel);
		loginPanel.add(typeLabel);
		loginPanel.add(surNameLabel);
		loginPanel.add(streetLabel);
		loginPanel.add(street);
		loginPanel.add(townLabel);
		loginPanel.add(town);
		loginPanel.add(cityLabel);
		loginPanel.add(city);
		loginPanel.add(apaLabel);
		loginPanel.add(apartment);
		loginPanel.add(doorLabel);
		loginPanel.add(door);
		frame.add(loginPanel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Database db =Database.getInstance();
		if(e.getSource()==regButton) {
			if(street.getText().length()!=0&&town.getText().length()!=0&&city.getText().length()!=0&&apartment.getText().length()!=0&&door.getText().length()!=0) {
				if(password.getText().length()!=0&&password2.getText().length()!=0&&name.getText().length()!=0&&surName.getText().length()!=0
						&&phone.getText().length()==10&&email.getText().length()!=0) {
					if(password.getText().equals(password2.getText())) {
						String phoneno=phoneBox.getSelectedItem()+phone.getText();
						String mail=email.getText()+emailBox.getSelectedItem();
						if(db.addPeople(name.getText(),"0",surName.getText(),typeBox.getSelectedIndex()+2,phoneno,mail,password.getText())==1) {
							 db.addAddress(street.getText(),town.getText(),city.getText(),apartment.getText(),door.getText());
							 JOptionPane.showMessageDialog(null,"Register Successful.");
							 String addid=db.getAddressID(street.getText(),town.getText(),city.getText(),apartment.getText(),door.getText());
							 String[] info=db.getNameAndSurname(email.getText()+emailBox.getSelectedItem(),password.getText());
							 db.changeAID(info[0],addid);
						}
						else if(db.addPeople(name.getText(),"0",surName.getText(),typeBox.getSelectedIndex()+1,phoneno,mail,password.getText())==2){
							JOptionPane.showMessageDialog(null,"This email already exists.");
						}
						else {
							JOptionPane.showMessageDialog(null,"Register Unuccessful.");
						}
						
					}
					else {
						 JOptionPane.showMessageDialog(null,"Register Unuccessful.\nPasswords are not the same.");
					}
				}
				else {
					 JOptionPane.showMessageDialog(null,"Register Unuccessful.");
				}
			}
			else {
				 JOptionPane.showMessageDialog(null,"Register Unuccessful.");
			}
		
			
		}
		
		if(e.getSource()==backButton) {
			frame.dispose();
			LaunchPage launch=new LaunchPage();
		}
		
		
	}
}
