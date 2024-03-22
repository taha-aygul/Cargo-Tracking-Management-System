

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CargoSearchMenu extends JFrame {

	private JPanel contentPane;
	private JTextField RecipientName;
	private JTextField RecipientSurname;
	private JTextField cargoID;
	private JTable table;

	
	public CargoSearchMenu(String name, String surname, String type, String ID) {
		Database db=Database.getInstance();
		
		setVisible(true);
		setBounds(100, 100, 604, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setFocusable(false);
		TurnBack.setBounds(425, 495, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				if(type.equals("0") ||type.equals("1")) {
					AdminMenu adminMenu = new AdminMenu(ID,name,surname,type);
				}
				if(type.equals("2")) {
					CustomerMenu custo = new CustomerMenu(ID,name,surname,type);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(TurnBack);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(26, 83, 537, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String[] column={"cargoID", "Delivery Address", "Sent Address", "Recipient Name", "Sender Name","Shipping Date","Cargo Content"};
		String[] row=new String[0];
		table = new JTable();
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		table.setBounds(5,250, 530, 50);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(5,250,530,50);
		panel.add(sp);
		table.setEnabled(false);
		
		
		RecipientName = new JTextField();
		RecipientName.setBounds(206, 31, 123, 36);
		panel.add(RecipientName);
		RecipientName.setColumns(10);
		
		RecipientSurname = new JTextField();
		RecipientSurname.setBounds(206,93, 123, 36);
		panel.add(RecipientSurname);
		RecipientSurname.setColumns(10);
		
		cargoID = new JTextField();
		cargoID.setBounds(206, 155, 123, 36);
		panel.add(cargoID);
		cargoID.setColumns(10);
		
		JLabel RecipientNameLbl = new JLabel("Recipient Name:");
		RecipientNameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		RecipientNameLbl.setBounds(206, 8, 105, 24);
		panel.add(RecipientNameLbl);
		JLabel RecipientSurnameLbl = new JLabel("Rec. Surname:");
		RecipientSurnameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		RecipientSurnameLbl.setBounds(206, 70, 105, 24);
		panel.add(RecipientSurnameLbl);
		
		JButton searchBtn = new JButton("SEARCH");
		searchBtn.setFocusable(false);
		searchBtn.setForeground(SystemColor.text);
		searchBtn.setBackground(SystemColor.infoText);
		searchBtn.setFont(new Font("Verdana Pro", Font.BOLD, 11));
		searchBtn.setBounds(193, 330, 148, 54);
		panel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=name+" "+surname;
				String[] query=db.getCargo(RecipientName.getText(),RecipientSurname.getText(),cargoID.getText(),s,type);
				if(query[0]!=null) {
					if(model.getRowCount()==1)
						model.removeRow(0);
					model.addRow(query);
				}
				else {
					JOptionPane.showMessageDialog(null,"No such cargo found.");
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel("Cargo ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(206, 132, 72, 24);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("SEARCH");
		lblNewLabel_3.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblNewLabel_3.setBounds(26, 51, 152, 32);
		contentPane.add(lblNewLabel_3);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		
		
	}

}
