package bai1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class Bai1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	JButton okBtn;
	int errorCount = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1 frame = new Bai1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bai1() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("CaskaydiaMono NF", Font.PLAIN, 17));
		loginLabel.setBounds(195, 21, 60, 27);
		contentPane.add(loginLabel);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setFont(new Font("CaskaydiaMono NF", Font.PLAIN, 17));
		userLabel.setBounds(59, 78, 60, 27);
		contentPane.add(userLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("CaskaydiaMono NF", Font.PLAIN, 17));
		passwordLabel.setBounds(47, 129, 100, 27);
		contentPane.add(passwordLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		userNameTextField.setBounds(143, 81, 172, 25);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		okBtn = new JButton("OK");
		
		okBtn.setFocusable(false);
		okBtn.setFont(new Font("CaskaydiaMono NF", Font.PLAIN, 14));
		okBtn.setBounds(143, 183, 100, 37);
		okBtn.addActionListener(this);
		contentPane.add(okBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBounds(143, 132, 172, 25);
		contentPane.add(passwordField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn) {
			if(
					!"Adminuser".equals(userNameTextField.getText()) || 
					!"admin".equals(new String(passwordField.getPassword()))
			  ) {
				errorCount++;
				if(errorCount == 4) {
					JOptionPane.showMessageDialog(null, "Da sai qua 3 lan. Closing", "Error", JOptionPane.WARNING_MESSAGE);
					this.dispose();
					return;
				}
				JOptionPane.showMessageDialog(null, "Username hoac password sai", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				(new RegisterForm()).setVisible(true);
				this.dispose();
				
			}
		}
	}
}
