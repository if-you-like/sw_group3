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
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class treeUI extends SelectUI {

	private JPanel contentPane;
	private JTextField textField;
	private Binary_Search_Tree bst = new Binary_Search_Tree();
	private drawTree box = new drawTree();
	private JTextField textField_2;
	private int level = 0;
	private String[] abcd = new String[15];
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public treeUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(20, 888, 105, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		box.setBackground(Color.WHITE);

		getContentPane().add(box);
		box.setSize(1600, 800);
		box.setLocation(0, 0);

		textField_2 = new JTextField("\uC785\uB825 \uAC12");
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setBounds(20, 864, 71, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(261, 875, 105, 54);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(130, 864, 117, 77);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("INSERT");
		rdbtnNewRadioButton_1.setBounds(20, 8, 77, 27);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.doClick();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("DELETE");
		rdbtnNewRadioButton.setBounds(20, 42, 81, 27);
		panel.add(rdbtnNewRadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton);

		JToggleButton tglbtnBefore = new JToggleButton("BEFORE");
		tglbtnBefore.setBorder(null);
		tglbtnBefore.setBackground(UIManager.getColor("Button.background"));
		tglbtnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					box.setbox(abcd, level);
					repaint();
				} else {
					box.setbox(abcd, level - 1);
					repaint();
				}
			}
		});
		buttonGroup_1.add(tglbtnBefore);
		tglbtnBefore.setBounds(0, 798, 151, 43);
		contentPane.add(tglbtnBefore);

		JToggleButton tglbtnAfter = new JToggleButton("AFTER");
		tglbtnAfter.setBorder(null);
		tglbtnAfter.doClick();
		tglbtnAfter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					box.setbox(bst.TreeData, level-1);
					repaint();
				} else {
					box.setbox(bst.TreeData, level);
					repaint();
				}
			}
		});
		buttonGroup_1.add(tglbtnAfter);
		tglbtnAfter.setBounds(150, 798, 151, 43);
		contentPane.add(tglbtnAfter);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				react();
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
					// }
				} else {
					if (bst.treeSearch(temp) != null) {
						bst.delete(temp);
						bst.TreeInput();
						level--;
						box.setbox(bst.TreeData, level);
					} else {
						JOptionPane.showMessageDialog(panel, "존재하지 않는 데이터 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (bst.TreeDepth(bst.root) > 4) {
					JOptionPane.showMessageDialog(panel, "트리 깊이(4단계)를 초과하였습니다.", "Error", JOptionPane.ERROR_MESSAGE);
					bst.delete(temp);
					bst.TreeInput();
					level--;
					box.setbox(bst.TreeData, level);
				}
				repaint();
			}
		});
	}

	void react() {
		bst.TreeInput();
		abcd = new String[bst.TreeData.length];
		for (int i = 0; i < 15; i++) {
			abcd[i] = bst.TreeData[i];
		}
	}
}