
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CourierMenu extends JFrame {

	private JPanel contentPane;
	private JTextField cargoID;
	private JTable table;
	private JTextField txtDate;
	private JTextField txtNameSurname;
	private JTextField RecipientName;
	private JTextField RecipientSurname;
	public CourierMenu(String name, String surname, String type, String ID) {
		
		Database db=Database.getInstance();
		Dat date=Dat.getInstance();
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
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
		
		JPanel panel = new JPanel();
		
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(5, 83, 546, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cargoID = new JTextField();
		cargoID.setBounds(200, 60, 123, 36);
		panel.add(cargoID);
		cargoID.setColumns(10);
		
		RecipientName = new JTextField();
		RecipientName.setBounds(200, 130, 123, 36);
		panel.add(RecipientName);
		RecipientName.setColumns(10);
		
		RecipientSurname = new JTextField();
		RecipientSurname.setBounds(200,200, 123, 36);
		panel.add(RecipientSurname);
		RecipientSurname.setColumns(10);
		
		
		
		JLabel RecipientNameLbl = new JLabel("Recipient Name:");
		RecipientNameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		RecipientNameLbl.setBounds(200, 100, 105, 24);
		panel.add(RecipientNameLbl);
		
		JLabel RecipientSurnameLbl = new JLabel("Rec. Surname:");
		RecipientSurnameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		RecipientSurnameLbl.setBounds(200,170, 105, 24);
		
		panel.add(RecipientSurnameLbl);
		
		JLabel cargoIDLbl = new JLabel("Cargo ID:");
		cargoIDLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		cargoIDLbl.setBounds(200, 31, 72, 24);
		panel.add(cargoIDLbl);
		String[] column={"cargoID", "Delivery Address", "Sent Address", "Recipient Name", "Sender Name","Shipping Date","Cargo Content"};
		String[] row=new String[0];
		table = new JTable();
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		table.setBounds(0,260, 530, 50);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0,260,530,50);
		panel.add(sp);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		JButton searchBtn = new JButton("SEARCH");
		searchBtn.setFocusable(false);
		searchBtn.setForeground(SystemColor.text);
		searchBtn.setBackground(SystemColor.infoText);
		searchBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		searchBtn.setBounds(200, 320, 120, 40);
		panel.add(searchBtn);
		
		JButton searchAllBtn = new JButton("SEARCH ALL");
		searchAllBtn.setFocusable(false);
		searchAllBtn.setForeground(SystemColor.text);
		searchAllBtn.setBackground(SystemColor.infoText);
		searchAllBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		searchAllBtn.setBounds(35, 320, 120, 40);
		panel.add(searchAllBtn);
		
		JButton changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setFocusable(false);
		changePasswordBtn.setBounds(350,350, 165, 25);
		panel.add(changePasswordBtn);
		changePasswordBtn.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		changePasswordBtn.setForeground(SystemColor.textHighlight);
		
		changePasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangePasswordMenu changeP = new ChangePasswordMenu(name,surname,type,ID);
				
				
			}
		});
		
		searchAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CargoListMenu cLsit = new CargoListMenu(name,surname,type,ID);
				
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=name+" "+surname;
				String[] query =db.getCargo(RecipientName.getText(),RecipientSurname.getText(),cargoID.getText(),s,type);
				if(query[0]!=null) {
					if(model.getRowCount()==1)
						model.removeRow(0);
					model.addRow(query);
					
					 JOptionPane.showMessageDialog(null,"Search Successful");
				}
				else {
					 JOptionPane.showMessageDialog(null,"Search Unccessful");
				}
				
			}
		});
		
		
		
	}
}
