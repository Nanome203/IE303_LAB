import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DatabaseFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mssvInput;
	private JTextField svNameInput;
	private JFormattedTextField birthInput;
	private JTextField mathInput;
	private JTextField physicsInput;
	private JTextField chemistryInput;
	private JTable dssv;
	private SimpleDateFormat dateFormat;
	private JButton openCSDL_Btn;
	private JButton exitBtn;
	private JButton searchBtn;
	private JButton clearSearch;
	private String inputMSSV = "";
	private String inputTenSV = "";
	private String inputDate = "";
	private String inputMath = "";
	private String inputPhysics = "";
	private String inputChemistry = "";
	private Statement statement;
	private String selectedMSSV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseFrame frame = new DatabaseFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatabaseFrame() {
		setResizable(false);
		setTitle("Quản lý sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel svInfoLabel = new JLabel("Thông tin sinh viên");
		svInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		svInfoLabel.setBounds(21, 11, 136, 24);
		contentPane.add(svInfoLabel);
		
		JPanel svInfoPanel = new JPanel();
		svInfoPanel.setBackground(new Color(221, 221, 221));
		svInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		svInfoPanel.setBounds(21, 46, 748, 230);
		contentPane.add(svInfoPanel);
		svInfoPanel.setLayout(null);
		
		JLabel mssvLabel = new JLabel("Mã số sinh viên:");
		mssvLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mssvLabel.setBounds(21, 11, 135, 32);
		svInfoPanel.add(mssvLabel);
		
		JLabel svNameLabel = new JLabel("Tên sinh viên:");
		svNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		svNameLabel.setBounds(21, 77, 135, 32);
		svInfoPanel.add(svNameLabel);
		
		JLabel birthLabel = new JLabel("Ngày sinh:");
		birthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		birthLabel.setBounds(21, 135, 135, 32);
		svInfoPanel.add(birthLabel);
		
		JLabel mathLabel = new JLabel("Điểm Toán:");
		mathLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mathLabel.setBounds(403, 11, 79, 32);
		svInfoPanel.add(mathLabel);
		
		JLabel physicsLabel = new JLabel("Điểm Lý:");
		physicsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		physicsLabel.setBounds(403, 77, 79, 32);
		svInfoPanel.add(physicsLabel);
		
		JLabel chemistryLabel = new JLabel("Điểm Hoá:");
		chemistryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chemistryLabel.setBounds(403, 135, 79, 32);
		svInfoPanel.add(chemistryLabel);
		
		mssvInput = new JTextField();
		mssvInput.setBounds(153, 17, 214, 24);
		svInfoPanel.add(mssvInput);
		mssvInput.setColumns(10);
		
		svNameInput = new JTextField();
		svNameInput.setColumns(10);
		svNameInput.setBounds(153, 85, 214, 24);
		svInfoPanel.add(svNameInput);
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		birthInput = new JFormattedTextField(dateFormat);
		birthInput.setColumns(10);
		birthInput.setBounds(153, 143, 214, 24);
		svInfoPanel.add(birthInput);
		
		mathInput = new JTextField();
		mathInput.setColumns(10);
		mathInput.setBounds(496, 17, 214, 24);
		svInfoPanel.add(mathInput);
		
		physicsInput = new JTextField();
		physicsInput.setColumns(10);
		physicsInput.setBounds(496, 85, 214, 24);
		svInfoPanel.add(physicsInput);
		
		chemistryInput = new JTextField();
		chemistryInput.setColumns(10);
		chemistryInput.setBounds(496, 143, 214, 24);
		svInfoPanel.add(chemistryInput);
		
		JButton addBtn = new JButton("Thêm ");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean allFieldsValid = validateInputFields();
				if (allFieldsValid) {
					DefaultTableModel model = (DefaultTableModel)dssv.getModel();
					if(!isInTable(inputMSSV, model)) {
//						model.addRow(new Object[] {inputMSSV,inputTenSV,inputDate});
						try {
							Float dtb = (Float.parseFloat(inputMath) + Float.parseFloat(inputPhysics) + Float.parseFloat(inputChemistry))/3;
							statement.executeUpdate("insert into SINHVIEN "
									+ "values('"+inputMSSV+"', N'"+inputTenSV+"', N'"+inputDate
									+"', "+inputMath+","+inputPhysics+","+inputChemistry+","
									+ String.format("%.1f", dtb)+")");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu vào database", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
							loadRsToTable(rs);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
						mssvInput.setText("");
						svNameInput.setText("");
						birthInput.setText("");
						mathInput.setText("");
						physicsInput.setText("");
						chemistryInput.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Mã số sinh viên đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		addBtn.setFocusable(false);
		addBtn.setEnabled(false);
		addBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		addBtn.setBounds(366, 187, 89, 32);
		svInfoPanel.add(addBtn);
		
		JButton changeBtn = new JButton("Sửa");
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model = (DefaultTableModel) dssv.getModel();
				if(dssv.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
					return;
				}
				boolean allFieldsValid = validateInputFields();
				if (allFieldsValid) {
						try {
							Float dtb = (Float.parseFloat(inputMath) + Float.parseFloat(inputPhysics) + Float.parseFloat(inputChemistry))/3;
							int count = statement.executeUpdate("UPDATE SINHVIEN "
									+ "SET HOTEN = N'" + inputTenSV + "'" 
									+ ", NGSINH = '" + inputDate + "'"
									+ ", DIEMTOAN = '" + inputMath + "'"
									+ ", DIEMLY = " + inputPhysics
									+ ", DIEMHOA = " + inputChemistry
									+ ", DIEMTB = " + String.format("%.1f", dtb)
									+ ", MASV = '" + inputMSSV + "'"
									+ "WHERE MASV = " + selectedMSSV);
							if(count > 0) {
								ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
								loadRsToTable(rs);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Mã số sinh viên đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
							loadRsToTable(rs);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
							return;
						}
						mssvInput.setText("");
						svNameInput.setText("");
						birthInput.setText("");
						mathInput.setText("");
						physicsInput.setText("");
						chemistryInput.setText("");
				}
			}
		});
		changeBtn.setFocusable(false);
		changeBtn.setEnabled(false);
		changeBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		changeBtn.setBounds(496, 187, 89, 32);
		svInfoPanel.add(changeBtn);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dssv.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xoá", "Thông báo", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int res = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá " + svNameInput.getText() + " không?","Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (res == JOptionPane.YES_OPTION) {
					try {
						int count = statement.executeUpdate("DELETE FROM SINHVIEN WHERE MASV = '" + selectedMSSV + "'");
						if (count > 0) {
							ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
							loadRsToTable(rs);
							mssvInput.setText("");
							svNameInput.setText("");
							birthInput.setText("");
							mathInput.setText("");
							physicsInput.setText("");
							chemistryInput.setText("");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Không thể xoá dòng đã chọn", "Thông báo", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		deleteBtn.setFocusable(false);
		deleteBtn.setEnabled(false);
		deleteBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		deleteBtn.setBounds(621, 187, 89, 32);
		svInfoPanel.add(deleteBtn);
		
		JPanel svListPanel = new JPanel();
		svListPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		svListPanel.setBackground(new Color(221, 221, 221));
		svListPanel.setBounds(21, 321, 748, 158);
		contentPane.add(svListPanel);
		svListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 728, 136);
		svListPanel.add(scrollPane);
		
		dssv = new JTable();
		dssv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MSSV", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "To\u00E1n", "L\u00FD", "Ho\u00E1", "\u0110TB"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		dssv.getColumnModel().getColumn(3).setPreferredWidth(77);
		dssv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = dssv.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) dssv.getModel();
				selectedMSSV = model.getValueAt(selectedRow, 0).toString();
				String ten = model.getValueAt(selectedRow, 1).toString();
				String ngaySinh = model.getValueAt(selectedRow, 2).toString();
				String toan = model.getValueAt(selectedRow, 3).toString();
				String ly = model.getValueAt(selectedRow, 4).toString();
				String hoa = model.getValueAt(selectedRow, 5).toString();
				
				mssvInput.setText(selectedMSSV);
				svNameInput.setText(ten);
				birthInput.setText(ngaySinh);
				mathInput.setText(toan);
				physicsInput.setText(ly);
				chemistryInput.setText(hoa);
				
				}
		});
		scrollPane.setViewportView(dssv);
		
		JLabel svListLabel = new JLabel("Danh sách sinh viên");
		svListLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		svListLabel.setBounds(21, 286, 136, 24);
		contentPane.add(svListLabel);
		
		openCSDL_Btn = new JButton("Mở CSDL");
		openCSDL_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://localhost:1433;database=QLSV;";
					String user = "sa";
					String pass = "Password.1";
					Connection con = DriverManager.getConnection(url,user,pass);
					if(con!= null)
						System.out.println("Kết nối thành công");
					statement = con.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
					loadRsToTable(rs);
					openCSDL_Btn.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Mở dữ liệu trong CSDL thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					addBtn.setEnabled(true);
					changeBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					searchBtn.setEnabled(true);
					clearSearch.setEnabled(true);
				} catch (Exception e2) {
					System.out.println("Có lỗi xảy ra!");
				}
			}
		});
		openCSDL_Btn.setFocusable(false);
		openCSDL_Btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		openCSDL_Btn.setBounds(21, 524, 98, 32);
		contentPane.add(openCSDL_Btn);
		
		searchBtn = new JButton("Tìm kiếm");
		searchBtn.addActionListener(this);
		searchBtn.setFocusable(false);
		searchBtn.setEnabled(false);
		searchBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		searchBtn.setBounds(146, 524, 98, 32);
		contentPane.add(searchBtn);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFocusable(false);
		exitBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		exitBtn.setBounds(671, 531, 98, 32);
		exitBtn.addActionListener(this);
		contentPane.add(exitBtn);
		
		clearSearch = new JButton("Xoá kết quả tìm kiếm");
		clearSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = statement.executeQuery("SELECT * FROM SINHVIEN");
					loadRsToTable(rs);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		clearSearch.setEnabled(false);
		clearSearch.setFont(new Font("SansSerif", Font.PLAIN, 14));
		clearSearch.setFocusable(false);
		clearSearch.setBounds(475, 531, 172, 32);
		contentPane.add(clearSearch);
	}
	
	public void loadRsToTable(final ResultSet rs) throws SQLException {
		DefaultTableModel model = (DefaultTableModel) dssv.getModel();
		model.setRowCount(0);
		
		while(rs.next()) {
			model.addRow(new Object[] {
					rs.getString("MASV"),
					rs.getString("HOTEN"),
					rs.getString("NGSINH"),
					rs.getFloat("DIEMTOAN"),
					rs.getFloat("DIEMLY"),
					rs.getFloat("DIEMHOA"),
					rs.getFloat("DIEMTB")
			});
		}
		}

	
	private boolean validateInputFields() {
		inputMSSV = mssvInput.getText();
		inputTenSV = svNameInput.getText();
		inputDate = birthInput.getText();
		inputMath = mathInput.getText();
		inputPhysics = physicsInput.getText();
		inputChemistry = chemistryInput.getText();
		
		boolean isValidMSSV = validateMSSV(inputMSSV);
		boolean isValidDate = validateDate(inputDate,dateFormat);
		boolean isValidMathScore = validateFloat(inputMath);
		boolean isValidPhysicsScore = validateFloat(inputPhysics);
		boolean isValidChemistryScore = validateFloat(inputChemistry);
		
		if (
				inputMSSV.equals("") || inputTenSV.equals("") || inputDate.equals("") || 
				inputMath.equals("") || inputPhysics.equals("") || inputChemistry.equals("")
				) 
		{
			JOptionPane.showMessageDialog(null, "Vui lòng không được bỏ trống các ô thông tin", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if(!isValidMSSV) {
			JOptionPane.showMessageDialog(null, "Mã số sinh viên không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!isValidDate) {
			JOptionPane.showMessageDialog(null, "Ngày sinh chưa đúng định dạng", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!isValidMathScore || !isValidPhysicsScore || !isValidChemistryScore) {
			JOptionPane.showMessageDialog(null, "Điểm toán hoặc lý hoặc hoá không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
private boolean validateMSSV(String inputMSSV) {
		
	return inputMSSV.compareTo("00000000") >= 0 && inputMSSV.compareTo("99999999") <= 0;
	}

private boolean validateDate(String inputDate, SimpleDateFormat dateFormat) {
	
    try {
        // Attempt to parse the date entered by the user
    	Date parsedDate = new Date(dateFormat.parse(inputDate).getTime()); 
    	 if (inputDate.equals(dateFormat.format(parsedDate))) {
             return true;
         } else {
             return false;
         }
    } catch (ParseException ex) {
        // Parsing exception indicates an invalid date input
    	return false;
    }
}

private boolean validateFloat(String inputNum) {
	try {
		float result = Float.parseFloat(inputNum);
		if(result >= 0 && result <= 10)
			return true;
		return false;
	} catch (Exception e) {
		return false;
	}
}

private boolean isInTable(String mssv, DefaultTableModel table) {
	int rowCount = table.getRowCount();
	if (rowCount == 0) {
		return false;
	}
	for(int row =0 ; row < rowCount; ++row) {
		if (mssv.equals(table.getValueAt(row, 0).toString())) {
			return true;
		}
	}
	return false;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == exitBtn) {
		this.dispose();
	}
	else {
		SearchStudent dialog = new SearchStudent(this);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
}

public Statement getStatement() {
	return statement;
}
}
