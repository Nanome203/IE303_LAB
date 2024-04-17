package bai1;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegisterForm extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextArea addressTextArea;
	JButton btnClose;
	JButton okButton;
	
	String[] courses = {
			"Web Application Developer", 
			"Database Administrator", 
			"Network Administrator", 
			"Windows Application Developer"
			};
	String[] timeSlot = {
			"7:00 – 9:00",
			"9:00 – 11:00",
			"11:00 – 1:00",
			"1:00 – 3:00",
			"3:00 – 5:00",
	};


	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setTitle("Register");
		getContentPane().setBackground(new Color(223, 223, 223));
		setBounds(100, 100, 710, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Accept Student Data");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(250, 21, 284, 41);
		getContentPane().add(title);
		
		JLabel nameLabel = new JLabel("Name *");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameLabel.setBounds(51, 96, 64, 34);
		getContentPane().add(nameLabel);
		
		JLabel ageLabel = new JLabel("Age *");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ageLabel.setBounds(51, 145, 64, 34);
		getContentPane().add(ageLabel);
		
		JLabel addressLabel = new JLabel("Address *");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addressLabel.setBounds(51, 213, 74, 34);
		getContentPane().add(addressLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nameTextField.setBounds(133, 102, 473, 28);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ageTextField.setColumns(10);
		ageTextField.setBounds(133, 151, 473, 28);
		getContentPane().add(ageTextField);
		
		addressTextArea = new JTextArea();
		addressTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressTextArea.setBounds(135, 194, 471, 72);
		getContentPane().add(addressTextArea);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		genderLabel.setBounds(140, 277, 91, 29);
		getContentPane().add(genderLabel);
		
		JLabel courseLabel = new JLabel("Course");
		courseLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		courseLabel.setBounds(51, 396, 64, 34);
		getContentPane().add(courseLabel);
		
		JComboBox<String> courseSelect = new JComboBox<String>(courses);
		courseSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		courseSelect.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		courseSelect.setBounds(133, 400, 473, 29);
		getContentPane().add(courseSelect);
		
		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBackground(new Color(223, 223, 223));
		maleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		maleRadioButton.setBounds(208, 319, 64, 23);
		getContentPane().add(maleRadioButton);
		
		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBackground(new Color(223, 223, 223));
		femaleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		femaleRadioButton.setBounds(370, 319, 74, 23);
		getContentPane().add(femaleRadioButton);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(maleRadioButton);
		btnGroup.add(femaleRadioButton);
		
		JList<String> timeSelectJList = new JList<String>(timeSlot);
		timeSelectJList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeSelectJList.setVisibleRowCount(4);;
		JScrollPane scrollPane = new JScrollPane(timeSelectJList);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(133, 452, 473, 86);
		getContentPane().add(scrollPane);
		
		JLabel lblFacilities = new JLabel("Facilities");
		lblFacilities.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFacilities.setBounds(133, 560, 91, 29);
		getContentPane().add(lblFacilities);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Library");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBackground(new Color(223, 223, 223));
		chckbxNewCheckBox.setBounds(208, 592, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxComputerDrome = new JCheckBox("Computer Drome");
		chckbxComputerDrome.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxComputerDrome.setBackground(new Color(223, 223, 223));
		chckbxComputerDrome.setBounds(370, 592, 145, 23);
		getContentPane().add(chckbxComputerDrome);
		
		okButton = new JButton("OK");
		okButton.setFocusable(false);
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		okButton.setBounds(355, 648, 89, 34);
		okButton.addActionListener(this);
		getContentPane().add(okButton);
		
		btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(528, 648, 89, 34);
		btnClose.addActionListener(this);
		getContentPane().add(btnClose);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnClose) {
			this.dispose();
		} else if(e.getSource() == okButton) {
			if(
					nameTextField.getText().equals("") || 
					ageTextField.getText().equals("") ||
					addressTextArea.getText().equals("")
			  ) {
				JOptionPane.showMessageDialog(null, "Chua nhap du cac truong bat buoc", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Luu du lieu thanh cong", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
