

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class CargoListMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public CargoListMenu(String n, String s, String type, String ID) {
		Database db=Database.getInstance();
		setVisible(true);
		
		setBounds(100, 100, 604, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
	
		
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setFocusable(false);
		TurnBack.setBounds(422, 495, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(type.equals("1")) {
					AdminMenu a=new AdminMenu(ID,n,s,type);
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
		panel.setBounds(5, 95, 580, 390);
		contentPane.add(panel);
		panel.setLayout(null);
		String[] column={"cargoID", "Delivery Address", "Sent Address", "Recipient Name", "Sender Name","Shipping Date","Cargo Content"};
		String[][] info =db.listAllCargo(ID,type);
		table = new JTable();
		table.setModel(new DefaultTableModel(info,column));
		
		table.setBounds(10, 11, 560,350);
		table.enable(false);;
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10,11,560,350);
		panel.add(sp);
		JLabel lblNewLabel = new JLabel("Cargoes");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 14));
		lblNewLabel.setBounds(40, 68, 112, 23);
		contentPane.add(lblNewLabel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
	}

}
