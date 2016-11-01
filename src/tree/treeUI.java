import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ButtonGroup;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class treeUI extends ds {

	private JPanel contentPane;
	private JTextField textField;
	private Binary_Search_Tree bst = new Binary_Search_Tree();
	private DrawTree box = new DrawTree();
	private JTextField textField_2;
	private int level = 0;

	public treeUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(114, 912, 105, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		box.setBackground(Color.WHITE);

		getContentPane().add(box);
		box.setSize(1600, 900);
		box.setLocation(0, 0);

		textField_2 = new JTextField("입력 값 : ");
		textField_2.setEditable(false);
		textField_2.setBounds(14, 915, 71, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(555, 914, 105, 27);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(251, 899, 268, 54);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("INSERT");
		rdbtnNewRadioButton_1.setBounds(24, 19, 77, 27);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.doClick();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("DELETE");
		rdbtnNewRadioButton.setBounds(134, 19, 81, 27);
		panel.add(rdbtnNewRadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textField.getText();
				if (rdbtnNewRadioButton_1.isSelected()) {
					if (bst.treeSearch(temp) == null) {
						bst.insert(temp);
						bst.TreeInput();
						level++;
						box.setbox(bst.TreeData, level);
					} else {
						JOptionPane.showMessageDialog(panel, "중복된 데이터가 존재합니다.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if(bst.treeSearch(temp)!=null){
					bst.delete(temp);
					bst.TreeInput();
					level--;
					box.setbox(bst.TreeData, level);
					}else{
						JOptionPane.showMessageDialog(panel, "존재하지 않는 데이터 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				repaint();
			}
		});

	}
}