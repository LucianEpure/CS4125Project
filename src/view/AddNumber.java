package view;
/**
 * @author Lucian Epure 
 * @author Xiangkai Tang 5% implement of add number
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddNumber extends JFrame {

	private JPanel contentPane;
	private JTextField numberTF;
	private int accountSelectedRow;
	private int accountSelectedCol;
	private JTable accountsTable;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddNumber() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public AddNumber(JTable accountsTable,int selectedRow,int selectedCol){
		
		this.accountsTable = accountsTable;
		this.accountSelectedRow = accountsTable.getSelectedRow();
		this.accountSelectedCol = selectedCol;
		
		
		setTitle("Add Number");
		this.accountsTable = accountsTable;
		setBounds(100,100,225,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(10, 20, 66, 14);
		contentPane.add(lblNumber);
		
		numberTF = new JTextField();
		numberTF.setBounds(86, 20, 113, 20);
		contentPane.add(numberTF);
		numberTF.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(58, 80, 89, 23);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new DoneAddNumber(numberTF, accountsTable, selectedRow));
		
	}

}
