import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddEmployeeMenu extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField phone;
	private JTextField email;
	private JPasswordField password;
	private JComboBox emailBox;
	
	
	public AddEmployeeMenu(String n, String s, String type, String ID) {
		Database db=Database.getInstance();
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminMenu a=new AdminMenu(ID,n,s,type);
				
			}
		});
		TurnBack.setFocusable(false);
		TurnBack.setBounds(375, 414, 140, 43);
		contentPane.add(TurnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(26, 83, 489, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String[] mails= {"@gmail.com","@outlook.com","@hotmail.com","@icloud.com"};
		emailBox=new JComboBox(mails);
		
		name = new JTextField();
		name.setBounds(80, 41, 123, 36);
		panel.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(80, 112, 123, 36);
		panel.add(surname);
		surname.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(80, 186, 123, 36);
		panel.add(phone);
		phone.setColumns(10);
		
		email = new JTextField();
		email.setBounds(250, 41, 123, 36);
		panel.add(email);
		email.setColumns(10);
		emailBox.setBounds(380,41,100,30);
		panel.add(emailBox);
		password = new JPasswordField();
		password.setBounds(250, 112, 123, 36);
		panel.add(password);
		password.setColumns(10);
		
		JButton addEmpBtn = new JButton("ADD EMPLOYEE");
		addEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length()!=0&&surname.getText().length()!=0&&phone.getText().length()!=0&&email.getText().length()!=0&&password.getText().length()!=0) {
					if(db.addPeople(name.getText(),"0",surname.getText(),3,"+90"+phone.getText(),email.getText()+emailBox.getSelectedItem(),password.getText())==1) {
						 JOptionPane.showMessageDialog(null,"Add Successful");
					}
					else if(db.addPeople(name.getText(),"0",surname.getText(),3,phone.getText(),email.getText()+emailBox.getSelectedItem(),password.getText())==2){
						JOptionPane.showMessageDialog(null,"This email already exists.");
					}
					else {
						JOptionPane.showMessageDialog(null,"Add Unuccessful.");
					}
				}
				else {
					 JOptionPane.showMessageDialog(null,"Add Unsuccessful");
				}
			}
			
		});
		addEmpBtn.setFocusable(false);
		addEmpBtn.setForeground(SystemColor.text);
		addEmpBtn.setBackground(SystemColor.infoText);
		addEmpBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		addEmpBtn.setBounds(169, 257, 148, 54);
		panel.add(addEmpBtn);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLbl.setBounds(80, 18, 72, 24);
		panel.add(nameLbl);
		
		JLabel surnameLbl = new JLabel("Surname:");
		surnameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		surnameLbl.setBounds(80, 89, 72, 24);
		panel.add(surnameLbl);
		
		JLabel phoneLbl = new JLabel("Phone Number:");
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		phoneLbl.setBounds(80, 163, 101, 24);
		panel.add(phoneLbl);
		
		JLabel mailLbl = new JLabel("Email:");
		mailLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		mailLbl.setBounds(250, 18, 101, 24);
		panel.add(mailLbl);
		
		JLabel passwordLbl = new JLabel("Password:");
		passwordLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLbl.setBounds(250, 89, 101, 24);
		panel.add(passwordLbl);
		
		JLabel addEmpLbl = new JLabel("ADD NEW EMPLOYEE");
		addEmpLbl.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		addEmpLbl.setBounds(26, 41, 152, 32);
		contentPane.add(addEmpLbl);
				
		
	}
}
