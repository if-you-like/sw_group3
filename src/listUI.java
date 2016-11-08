import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class listUI extends SelectUI {

	private JPanel contentPane;
	private drawList box = new drawList();
	private String[] str = new String[20];
	private LinkedList ll = new LinkedList();
	private int level = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public listUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 1600, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(652, 454, 342, 83);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 29, 116, 24);
		panel_2.add(textField_2);

		JLabel lblOutput = new JLabel("INPUT :");
		lblOutput.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblOutput.setBounds(14, 30, 68, 18);
		panel_2.add(lblOutput);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("±¼¸²", Font.BOLD, 19));
		btnDelete.setBounds(223, 18, 105, 43);
		panel_2.add(btnDelete);

		box.setBackground(Color.WHITE);
		getContentPane().add(box);
		box.setSize(1182, 400);
		box.setLocation(43, 15);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(53, 454, 566, 83);
		contentPane.add(panel);
		panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 34, 116, 24);
		panel.add(textField_1);

		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 19));
		btnNewButton.setBounds(440, 21, 105, 46);
		panel.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(221, 12, 205, 59);
		panel.add(panel_3);
		panel_3.setLayout(null);

		textField = new JTextField();
		textField.setBounds(75, 20, 116, 24);
		panel_3.add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("INDEX");
		rdbtnNewRadioButton.setBounds(0, 20, 69, 27);
		panel_3.add(rdbtnNewRadioButton);

		JLabel lblInput = new JLabel("INPUT :");
		lblInput.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblInput.setBounds(14, 35, 79, 18);
		panel.add(lblInput);

		JLabel lblNewLabel = new JLabel("INSERT");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(65, 430, 99, 18);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(633, 434, 5, 103);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("DELETE");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(658, 427, 89, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uC2A4\uD06C\uB9B0\uC0F7");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1.setBounds(998, 427, 227, 49);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\uB3C4\uC6C0\uB9D0");
		button.setFont(new Font("±¼¸²", Font.BOLD, 20));
		button.setBounds(998, 488, 227, 49);
		contentPane.add(button);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String insert_1 = textField_1.getText();
				if (rdbtnNewRadioButton.isSelected()) {
					String insert_2 = textField.getText();
					if (Integer.parseInt(insert_2) > level) {
						JOptionPane.showMessageDialog(panel, "ÃÊ°úµÇ´Â ÀÎµ¦½º ÀÔ´Ï´Ù..", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						ll.insert(insert_1, Integer.parseInt(insert_2));
					}
				} else {
					ll.insert(insert_1);
				}
				level++;
				ll.display();
				box.setBox(level, ll.str);
				repaint();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String delete_1 = textField_2.getText();
				if (ll.delete(delete_1).equals("0")) {
					JOptionPane.showMessageDialog(panel, "ÀÎµ¦½º °Ë»ö°á°ú °ªÀÌ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					level--;
					ll.display();
					box.setBox(level, ll.str);
					repaint();
				}
				
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(1239, 73, 313, 464);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(150, 150);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("  \uC2E4\uD589\uC774\uB825");
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblNewLabel_2.setBounds(1240, 32, 110, 41);
		contentPane.add(lblNewLabel_2);

	}
}
