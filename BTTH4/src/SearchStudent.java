import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchStudent extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mssvTextField;
	private JTextField nameTextField;
	private JCheckBox mssvCB;
	private JCheckBox tenCB;
	private JButton cancelBtn;
	private JButton okBtn;
	private DatabaseFrame ST; 

	/**
	 * Create the frame.
	 */
	public SearchStudent(DatabaseFrame studentTable) {
		ST = studentTable;
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(20, 30, 393, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(33, 0, 3, 2);
		panel.add(label);
		
		JLabel mssvLabel = new JLabel("MSSV");
		mssvLabel.setBounds(33, 12, 85, 29);
		panel.add(mssvLabel);
		mssvLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		mssvCB = new JCheckBox("");
		mssvCB.setBounds(83, 15, 29, 23);
		panel.add(mssvCB);
		
		JLabel nameLabel = new JLabel("Tên");
		nameLabel.setBounds(33, 54, 85, 31);
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tenCB = new JCheckBox("");
		tenCB.setBounds(83, 57, 21, 27);
		panel.add(tenCB);
		
		mssvTextField = new JTextField();
		mssvTextField.setBounds(116, 14, 254, 25);
		panel.add(mssvTextField);
		mssvTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(116, 60, 254, 25);
		panel.add(nameTextField);
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		okBtn.setFocusable(false);
		okBtn.setBounds(219, 105, 61, 29);
		panel.add(okBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setFocusable(false);
		cancelBtn.setBounds(292, 105, 78, 29);
		cancelBtn.addActionListener(this);
		panel.add(cancelBtn);
		
		JLabel lblThngTinTm = new JLabel("Thông tin tìm kiếm");
		lblThngTinTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThngTinTm.setBounds(23, 0, 156, 29);
		contentPane.add(lblThngTinTm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn)
		this.dispose();
		else {
			if(mssvCB.isSelected() && tenCB.isSelected()) {
				try {
					ResultSet rs = ST.getStatement().executeQuery(
							"SELECT * FROM SINHVIEN"
							+" WHERE MASV = '" + mssvTextField.getText() + "' AND HOTEN = N'" + nameTextField.getText() + "'"
							);
					ST.loadRsToTable(rs);
					this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (mssvCB.isSelected()) {
				try {
					ResultSet rs = ST.getStatement().executeQuery(
							"SELECT * FROM SINHVIEN"
							+" WHERE MASV = '" + mssvTextField.getText() + "'"
							);
					ST.loadRsToTable(rs);
					this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (tenCB.isSelected()) {
				try {
					ResultSet rs = ST.getStatement().executeQuery(
							"SELECT * FROM SINHVIEN"
							+" WHERE HOTEN = N'" + nameTextField.getText() + "'"
							);
					ST.loadRsToTable(rs);
					this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else 
				this.dispose();
		}
		
	}
}
