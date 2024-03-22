

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListEmployeesMenu extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	

	public ListEmployeesMenu(Queue<People> info, String name, String surname, String type, String ID) {
		setVisible(true);
		
		setBounds(100, 100, 551, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		JButton TurnBack = new JButton("Turn Back <-");
		TurnBack.setFocusable(false);
		TurnBack.setBounds(375, 414, 140, 43);
		TurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminMenu adminMenu = new AdminMenu(ID,name,surname,type);
			
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(TurnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.WHITE);
		panel.setBounds(26, 57, 489, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		String[] column=new String[] {"ID","NAME", "SURNAME", "PHONE"};
		String[] row =new String[0];
		
		
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		
		table.setModel(model);
		 Iterator iterator = info.iterator();
		while(iterator.hasNext()) {
			People a=(People)iterator.next();
			String[] b= {a.getID(),a.getName(),a.getSurname(),a.getPhone()};
			model.addRow(b);
			
		}
		table.setBounds(10, 11, 469, 325);
		table.enable(false);;
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10,11,469,325);
		panel.add(sp);

		
		JLabel empLbl = new JLabel("Employees");
		empLbl.setFont(new Font("Verdana Pro", Font.BOLD, 14));
		empLbl.setBounds(26, 24, 112, 23);
		contentPane.add(empLbl);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
	}
}
