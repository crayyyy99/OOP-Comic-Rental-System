package gui;

import controller.UserController;
import model.User;
import java.util.ArrayList;
import java.sql.SQLException;
import exception.InputException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdEditUserDetailsDialog extends JDialog {
	private User selectedUser = new User();
	private JTextField idtxt1;
	private JTextField contacttxt1;
	private JTextField emailtxt1;
	private JTextField ictxt1;
	private JTextField nametxt1;
	private JTextField regDatetxt;
	private JTextField usernametxt1;
	private JPasswordField passwordtxt1;
	private JComboBox cmbpermission;
	
	public AdEditUserDetailsDialog(User user) {		
		selectedUser = user;
		
		getContentPane().setBackground(new Color(255, 255, 204));
		
		JLabel lblNewLabel = new JLabel("User ID:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		idtxt1 = new JTextField();
		idtxt1.setEditable(false);
		idtxt1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact No:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		contacttxt1 = new JTextField();
		contacttxt1.setEditable(false);
		contacttxt1.setColumns(20);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		
		emailtxt1 = new JTextField();
		emailtxt1.setEditable(false);
		emailtxt1.setColumns(100);
		
		JLabel lblNewLabel_5 = new JLabel("IC No:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		
		ictxt1 = new JTextField();
		ictxt1.setEditable(false);
		ictxt1.setColumns(12);
		
		JLabel lblNewLabel_6 = new JLabel("Name:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		
		nametxt1 = new JTextField();
		nametxt1.setEditable(false);
		nametxt1.setColumns(100);
		
		JLabel lblNewLabel_1 = new JLabel("Register Date:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		regDatetxt = new JTextField();
		regDatetxt.setEditable(false);
		regDatetxt.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Permission");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new SaveButtonListener());
		btnSave.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSave.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new CancelButtonListener());
		btnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancel.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		
		JLabel lblNewLabel_7 = new JLabel("Username:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 15));
		
		usernametxt1 = new JTextField();
		usernametxt1.setEditable(false);
		usernametxt1.setColumns(25);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 15));
		
		cmbpermission = new JComboBox();
		cmbpermission.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbpermission.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Admin"}));
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.addActionListener(new ResetPwdButtonListener());
		btnResetPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		btnResetPassword.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		
		passwordtxt1 = new JPasswordField();
		passwordtxt1.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnResetPassword)
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(usernametxt1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(passwordtxt1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(cmbpermission, 0, 277, Short.MAX_VALUE)
								.addComponent(contacttxt1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(emailtxt1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(ictxt1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(nametxt1, 0, 0, Short.MAX_VALUE)
								.addComponent(idtxt1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(regDatetxt, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
							.addGap(18)))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(nametxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(ictxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailtxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(contacttxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(regDatetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbpermission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(idtxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordtxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnResetPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setTitle("User Details");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 600);
		setLocationRelativeTo(null);
		
		if(user!= null)
			loadUserData(user);
				
	}
	
	public void loadUserData(User user) {
		idtxt1.setText(String.valueOf(user.getId()));
		contacttxt1.setText(user.getPhoneNo());
		emailtxt1.setText(user.getEmail());
		ictxt1.setText(user.getIcNo());
		nametxt1.setText(user.getName());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		regDatetxt.setText(user.getRegDate().format(formatter));
		
		usernametxt1.setText(user.getUsername());
		passwordtxt1.setText(user.getPassword());
		cmbpermission.setSelectedItem(user.getPermission());
		
	}
	
	
	private class ResetPwdButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{
	    	
	    	
	    	int x = JOptionPane.showConfirmDialog(null, "Are you confirm?", "Reset Password Confirmation", JOptionPane.YES_NO_OPTION);

        	if(x == JOptionPane.YES_OPTION)
        	{
          		selectedUser.setPassword("abcd1234");
        		
        		UserController userController = new UserController();
    	    	int result = -1;
    	    	try {
    				if(selectedUser.getId() == 0)
    					result = userController.insert(selectedUser);
    				else
    					result = userController.update(selectedUser);
    				
    				if (result == 1)
    				{
    					PopOutMsgBox.infoBox("Password has been reset.", "Reset Successful");
    					AdEditUserDetailsDialog.this.dispose();
    				}
    			} catch (InputException e1) {
    				e1.displayMessage();
    			}
    			catch (ClassNotFoundException | SQLException e1) {
    				e1.printStackTrace();
    			}
        	}
        	else {}

		}
	}
	
	private class SaveButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{
			selectedUser.setPermission((String) cmbpermission.getSelectedItem());
			selectedUser.setPassword("");
			
			UserController userController = new UserController();
	    	int result = -1;
	    	try {
				if(selectedUser.getId() == 0)
					result = userController.insert(selectedUser);
				else
					result = userController.update(selectedUser);
				
				if (result == 1)
				{
					PopOutMsgBox.infoBox("Record has been updated.", "Update Successful");
					AdEditUserDetailsDialog.this.dispose();
				}
			} catch (InputException e1) {
				e1.displayMessage();
			}
			catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class CancelButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{
	    	AdEditUserDetailsDialog.this.dispose();
		}
	}
	
	
}
