package bai2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class StudentManagement extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mssvTextField;
	private JTextField nameTextField;
	private JButton cancelBtn;
	private JButton exitBtn;
	private JButton openFileBtn;
	private JButton saveCurrentFileBtn;
	private JButton saveNewFileBtn;
	private JButton fileBtn;
	private JButton databaseBtn;
	private JButton addBtn;
	private JButton clearBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private SimpleDateFormat dateFormat;
	private JFormattedTextField birthdayTextField;
	private JTable dssv;
	private JButton huySuaBtn;
	private JButton luuSuaBtn;
	private String inputMSSV = "";
	private String inputTenSV = "";
	private String inputDate = "";
	private String currentFileDir = "";
	private String newFileDirString = "";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement frame = new StudentManagement();
					frame.setResizable(false);
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
	public StudentManagement() {
		setTitle("Quản lý sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel quanLySinhVien = new JPanel();
		quanLySinhVien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		quanLySinhVien.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 1, true), "Qu\u1EA3n l\u00FD sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 15), new Color(0, 0, 0)));
		quanLySinhVien.setBounds(49, 41, 651, 226);
		contentPane.add(quanLySinhVien);
		quanLySinhVien.setLayout(null);
		
		JLabel mssvLabel = new JLabel("Mã số sinh viên:");
		mssvLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		mssvLabel.setBounds(40, 32, 115, 24);
		quanLySinhVien.add(mssvLabel);
		
		JLabel nameLabel = new JLabel("Tên sinh viên:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(40, 76, 115, 24);
		quanLySinhVien.add(nameLabel);
		
		JLabel dateOfBirth = new JLabel("Ngày sinh:");
		dateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateOfBirth.setBounds(40, 119, 115, 24);
		quanLySinhVien.add(dateOfBirth);
		
		mssvTextField = new JTextField();
		mssvTextField.setBounds(170, 36, 361, 24);
		quanLySinhVien.add(mssvTextField);
		mssvTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(170, 78, 361, 24);
		quanLySinhVien.add(nameTextField);
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		birthdayTextField = new JFormattedTextField(dateFormat);
		birthdayTextField.setBounds(170, 121, 361, 24);
		quanLySinhVien.add(birthdayTextField);
		
		JLabel birthdayFormatLabel = new JLabel("(dd/mm/yyyy)");
		birthdayFormatLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		birthdayFormatLabel.setBounds(537, 119, 110, 24);
		quanLySinhVien.add(birthdayFormatLabel);
		
		addBtn = new JButton("Thêm");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean allFieldsValid = validateInputFields();
				if (allFieldsValid) {
					DefaultTableModel model = (DefaultTableModel)dssv.getModel();
					if(!isInTable(inputMSSV, model)) {
						model.addRow(new Object[] {inputMSSV,inputTenSV,inputDate});
						mssvTextField.setText("");
						nameTextField.setText("");
						birthdayTextField.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Ma so sinh vien da ton tai", "Thong Bao", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		addBtn.setEnabled(false);
		addBtn.setFocusable(false);
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addBtn.setBounds(170, 168, 74, 35);
		quanLySinhVien.add(addBtn);
		
		editBtn = new JButton("Sửa");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)dssv.getModel();
				int selectedRow = dssv.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Ban chua chon sinh vien de sua","Thong bao", JOptionPane.WARNING_MESSAGE);
					return;
				}
				mssvTextField.setText(model.getValueAt(selectedRow, 0).toString());
				nameTextField.setText(model.getValueAt(selectedRow, 1).toString());
				birthdayTextField.setText(model.getValueAt(selectedRow, 2).toString());
				editBtn.setEnabled(false);
				addBtn.setVisible(false);
				clearBtn.setVisible(false);
				huySuaBtn.setVisible(true);
				luuSuaBtn.setVisible(true);
			}
		});
		editBtn.setEnabled(false);
		editBtn.setFocusable(false);
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		editBtn.setBounds(360, 167, 74, 35);
		quanLySinhVien.add(editBtn);
		
		deleteBtn = new JButton("Xoá");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)dssv.getModel();
				int selectedRow = dssv.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Ban chua chon sinh vien de xoa","Thong bao", JOptionPane.WARNING_MESSAGE);
					return;
				}
				model.removeRow(selectedRow);
			}
		});
		deleteBtn.setFocusable(false);
		deleteBtn.setEnabled(false);
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBounds(457, 167, 74, 35);
		quanLySinhVien.add(deleteBtn);
		
		JLabel mssvFormatLabel = new JLabel("(8-digit number)");
		mssvFormatLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		mssvFormatLabel.setBounds(537, 36, 133, 24);
		quanLySinhVien.add(mssvFormatLabel);
		
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mssvTextField.setText("");
				nameTextField.setText("");
				birthdayTextField.setText("");
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		clearBtn.setFocusable(false);
		clearBtn.setEnabled(false);
		clearBtn.setBounds(264, 168, 74, 35);
		quanLySinhVien.add(clearBtn);
		
		huySuaBtn = new JButton("Huỷ");
		huySuaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mssvTextField.setText("");
				nameTextField.setText("");
				birthdayTextField.setText("");
				editBtn.setEnabled(true);
				addBtn.setVisible(true);
				clearBtn.setVisible(true);
				huySuaBtn.setVisible(false);
				luuSuaBtn.setVisible(false);
				dssv.clearSelection();
			}
		});
		huySuaBtn.setVisible(false);
		huySuaBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		huySuaBtn.setFocusable(false);
		huySuaBtn.setBounds(170, 168, 74, 35);
		quanLySinhVien.add(huySuaBtn);
		
		luuSuaBtn = new JButton("Lưu");
		luuSuaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) dssv.getModel();
				int selectedRow = dssv.getSelectedRow();
				String tempMSSVString = mssvTextField.getText();
				String tempDateString = birthdayTextField.getText();
				boolean isValidMSSV = validateMSSV(tempMSSVString);
				boolean isValidDate = validateDate(tempDateString, dateFormat);
				if(!isValidMSSV) {
					JOptionPane.showMessageDialog(null, "Ma so sinh vien khong hop le", "Thong bao", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!isValidDate) {
					JOptionPane.showMessageDialog(null, "Ngay sinh chua dung dinh dang", "Thong bao", JOptionPane.ERROR_MESSAGE);
					return;
				}
				model.setValueAt(tempMSSVString, selectedRow, 0);
				model.setValueAt(nameTextField.getText(), selectedRow, 1);
				model.setValueAt(tempDateString, selectedRow, 2);
				mssvTextField.setText("");
				nameTextField.setText("");
				birthdayTextField.setText("");
				editBtn.setEnabled(true);
				addBtn.setVisible(true);
				clearBtn.setVisible(true);
				huySuaBtn.setVisible(false);
				luuSuaBtn.setVisible(false);
				if(!currentFileDir.equals(""))
					saveCurrentFileBtn.setEnabled(true);
				
			}
		});
		luuSuaBtn.setVisible(false);
		luuSuaBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luuSuaBtn.setFocusable(false);
		luuSuaBtn.setBounds(264, 168, 74, 35);
		quanLySinhVien.add(luuSuaBtn);
		
		JPanel danhSachSinhVien = new JPanel();
		danhSachSinhVien.setLayout(null);
		danhSachSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		danhSachSinhVien.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 1, true), "Danh s\u00E1ch sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 15), new Color(0, 0, 0)));
		danhSachSinhVien.setBounds(49, 301, 651, 149);
		contentPane.add(danhSachSinhVien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 631, 117);
		danhSachSinhVien.add(scrollPane);
		
		dssv = new JTable();
		scrollPane.setViewportView(dssv);
		dssv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1ED1 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "Ng\u00E0y sinh"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -6157505994313689257L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		dssv.getColumnModel().getColumn(0).setResizable(false);
		dssv.getColumnModel().getColumn(1).setResizable(false);
		dssv.getColumnModel().getColumn(2).setResizable(false);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFocusable(false);
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitBtn.setBounds(617, 524, 74, 35);
		exitBtn.addActionListener(this);
		contentPane.add(exitBtn);
		
		openFileBtn = new JButton("Mở File");
		openFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(new File("."));
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					currentFileDir = fileChooser.getSelectedFile().getAbsolutePath();
					dssv.setModel(readFileToTableModel(currentFileDir));
				}
			}
		});
		openFileBtn.setVisible(false);
		openFileBtn.setFocusable(false);
		openFileBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		openFileBtn.setBounds(49, 524, 83, 35);
		contentPane.add(openFileBtn);
		
		saveCurrentFileBtn = new JButton("Lưu");
		saveCurrentFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!currentFileDir.equals("")) {
					exportToFile(dssv, currentFileDir);
					JOptionPane.showMessageDialog(null, "Da luu nhung thay doi vao file dang mo", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
					saveCurrentFileBtn.setEnabled(false);
				}
			}
		});
		saveCurrentFileBtn.setVisible(false);
		saveCurrentFileBtn.setEnabled(false);
		saveCurrentFileBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		saveCurrentFileBtn.setBounds(155, 524, 83, 35);
		contentPane.add(saveCurrentFileBtn);
		
		saveNewFileBtn = new JButton("Lưu Mới");
		saveNewFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser =  new JFileChooser(new File("."));
				int response = fileChooser.showSaveDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					newFileDirString = fileChooser.getSelectedFile().getAbsolutePath();
					if(isAlreadyExist(newFileDirString)) {
						int yesNoResponse = JOptionPane.showConfirmDialog(null, "File da ton tai. Ban co muon ghi de?", "Thong bao", JOptionPane.YES_NO_OPTION);
						if (yesNoResponse == 0) {
							JOptionPane.showMessageDialog(null, "Da ghi de thanh cong", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
							exportToFile(dssv, newFileDirString);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Da luu file thanh cong", "Thong bao", JOptionPane.INFORMATION_MESSAGE);
						exportToFile(dssv, newFileDirString);
					}
				}
			}
		});
		saveNewFileBtn.setVisible(false);
		saveNewFileBtn.setFocusable(false);
		saveNewFileBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		saveNewFileBtn.setBounds(262, 524, 97, 35);
		contentPane.add(saveNewFileBtn);
		
		cancelBtn = new JButton("Huỷ");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtn.setEnabled(false);
				clearBtn.setEnabled(false);
				editBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				openFileBtn.setVisible(false);
				saveCurrentFileBtn.setVisible(false);
				saveNewFileBtn.setVisible(false);
				fileBtn.setVisible(true);
				databaseBtn.setVisible(true);
				cancelBtn.setVisible(false);
			}
		});
		cancelBtn.setVisible(false);
		cancelBtn.setFocusable(false);
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		cancelBtn.setBounds(377, 524, 83, 35);
		contentPane.add(cancelBtn);
		
		fileBtn = new JButton("File");
		fileBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		fileBtn.setFocusable(false);
		fileBtn.setBounds(49, 524, 83, 35);
		fileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBtn.setEnabled(true);
				clearBtn.setEnabled(true);
				editBtn.setEnabled(true);
				deleteBtn.setEnabled(true);
				openFileBtn.setVisible(true);
				saveCurrentFileBtn.setVisible(true);
				saveNewFileBtn.setVisible(true);
				fileBtn.setVisible(false);
				databaseBtn.setVisible(false);
				cancelBtn.setVisible(true);
			}
		});
		contentPane.add(fileBtn);
		
		databaseBtn = new JButton("CSDL");
		databaseBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		databaseBtn.setFocusable(false);
		databaseBtn.setBounds(155, 524, 83, 35);
		contentPane.add(databaseBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitBtn) {
			this.dispose();
		}
	}
	
	
	
	
	
	//Check if mssv in the table
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
	//Check if all fields have valid values
	private boolean validateInputFields() {
		inputMSSV = mssvTextField.getText();
		inputTenSV = nameTextField.getText();
		inputDate = birthdayTextField.getText();
		boolean isValidMSSV = validateMSSV(inputMSSV);
		boolean isValidDate = validateDate(inputDate,dateFormat);
		if (inputMSSV.equals("") && inputTenSV.equals("") && inputDate.equals("")) {
			JOptionPane.showMessageDialog(null, "Ma so sinh vien, ten, ngay thang khong duoc de trong", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (!inputMSSV.equals("") && inputTenSV.equals("") && inputDate.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui long nhap ten va ngay sinh", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (inputMSSV.equals("") && !inputTenSV.equals("") && inputDate.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui long nhap ma so sinh vien va ngay sinh", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (inputMSSV.equals("") && inputTenSV.equals("") && !inputDate.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui long nhap ma so sinh vien va ten", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (inputMSSV.equals("") || inputTenSV.equals("") || inputDate.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui long nhap truong con lai", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!isValidMSSV) {
			JOptionPane.showMessageDialog(null, "Ma so sinh vien khong hop le", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!isValidDate) {
			JOptionPane.showMessageDialog(null, "Ngay sinh chua dung dinh dang", "Thong bao", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	//Check whether entered birthday is valid or not
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
	
	
	//Check whether MSSV is valid or not
	private boolean validateMSSV(String inputMSSV) {
		
        try {
            // Attempt to parse the date entered by the user
        	int mssv = Integer.parseInt(inputMSSV);
        	if (10000000 <= mssv && mssv <= 99999999) 
        		return true;
        	return false;
        	
        } catch (NumberFormatException ex) {
            // Parsing exception indicates an invalid date input
        	return false;
        }
	}
	
	
    public static boolean exportToFile(JTable table, String filePath) {
        try {
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            FileWriter csvWriter = new FileWriter(filePath);

            // Write column headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                csvWriter.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    csvWriter.write(",");
                }
            }
            csvWriter.write("\n");

            // Write data rows
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object cellValue = model.getValueAt(row, col);
                    csvWriter.write(cellValue.toString());
                    if (col < model.getColumnCount() - 1) {
                        csvWriter.write(",");
                    }
                }
                csvWriter.write("\n");
            }

            csvWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	 public static DefaultTableModel readFileToTableModel(String filePath) {
	        DefaultTableModel tableModel = new DefaultTableModel();
	        List<String[]> dataRows = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] rowData = line.split(","); // Customize delimiter if needed
	                dataRows.add(rowData);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (!dataRows.isEmpty()) {
	            String[] columnNames = dataRows.get(0);
	            tableModel.setColumnIdentifiers(columnNames);

	            for (int i = 1; i < dataRows.size(); i++) {
	                tableModel.addRow(dataRows.get(i));
	            }
	        }

	        return tableModel;
	    }
	 
	 
	  public boolean isAlreadyExist(String FilePath) {
		  File file =  new File(FilePath);
		  if (file.exists()) {
	            return true;
	        } 
		  return false;
	  }
}


