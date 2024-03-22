

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

public class AddCargoMenu extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField address;
	private JTextField city;

	private JTextField content;
	

	
	public AddCargoMenu(String name, String surname, String type, String ID) {
		Database db=Database.getInstance();
		Dat date=Dat.getInstance();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		
	
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setBounds(425, 495, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerMenu custo = new CustomerMenu(ID, name, surname,type);
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
		

		
		JLabel recipient_name = new JLabel("Recipient Name:");
		recipient_name.setBounds(135, 22, 114, 24);
		recipient_name.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(recipient_name);
		
		this.name = new JTextField();
		this.name.setBounds(135, 44, 114, 36);
		panel.add(this.name);
		this.name.setColumns(10);
		
		
		JLabel recipient_surname = new JLabel("Recipient Surname:");
		recipient_surname.setBounds(268, 22, 150, 24);
		recipient_surname.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(recipient_surname);
		
		this.surname = new JTextField();
		this.surname.setBounds(267, 44, 114, 36);
		this.surname.setColumns(10);
		panel.add(this.surname);

		JLabel delivery_address = new JLabel("Delivery Address:");
		delivery_address.setBounds(135, 87, 114, 24);
		delivery_address.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(delivery_address);


		JLabel delivery_address_description = new JLabel("(Street , Town , City , Apartment , Door)");
		delivery_address_description.setBounds(135, 98, 250, 24);
		delivery_address_description.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(delivery_address_description);

		address = new JTextField();
		address.setBounds(135, 120, 250, 54);
		address.setColumns(10);
		panel.add(address);

		JLabel cargo_content = new JLabel("Cargo Content:");
		cargo_content.setBounds(135, 174, 94, 24);
		cargo_content.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(cargo_content);
		
		
		content = new JTextField();
		content.setBounds(135, 195, 123, 36);
		content.setColumns(10);
		panel.add(content);
		
		

		JButton addCargoButton = new JButton("ADD CARGO");
		addCargoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender= name +" "+ surname;
				if(address.getText().length()!=0&& AddCargoMenu.this.name.getText().length()!=0&& AddCargoMenu.this.surname.getText().length()!=0&&content.getText().length()!=0) {


					String st=db.getAddress(ID, name, surname);
					Address add=db.getAddress2(st);
					String addre=add.getCity_name()+" "+add.getTown_name();


					if(db.addCargo(ID, address.getText(),  addre  , AddCargoMenu.this.name.getText(), AddCargoMenu.this.surname.getText(),sender,date.getDate(),content.getText())==1) {
						JOptionPane.showMessageDialog(null,"Add Successful");
					}
					else {
						 JOptionPane.showMessageDialog(null,"Add Unsuccessful");
					}
				}
				else {
					 JOptionPane.showMessageDialog(null,"Add Unsuccessful");
				}
				
			}
		});
		addCargoButton.setFocusable(false);
		addCargoButton.setBounds(192, 338, 148, 54);
		addCargoButton.setForeground(SystemColor.text);
		addCargoButton.setBackground(SystemColor.infoText);
		addCargoButton.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		panel.add(addCargoButton);
		
		JLabel lblNewLabel_3 = new JLabel("ADD CARGO");
		lblNewLabel_3.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblNewLabel_3.setBounds(26, 51, 152, 32);
		contentPane.add(lblNewLabel_3);
		
				
	}
}
