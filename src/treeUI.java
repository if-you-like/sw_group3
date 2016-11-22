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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class treeUI extends SelectUI {

	private JPanel contentPane;
	private JTextField textField;
	private Binary_Search_Tree bst = new Binary_Search_Tree();
	private AVLTree avl = new AVLTree();
	private drawTree box = new drawTree();
	private JTextField textField_2;
	private int count = 0;
	private int select = 0;
	private String[] treedata = new String[15];
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public treeUI(int select) {
		this.select = select;
		if (select == 1) {
			setTitle("Balanced Binary Search Tree");
		} else {
			setTitle("Binary Search Tree");
		}
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
		box.setLocation(14, 0);

		textField_2 = new JTextField("\uC785\uB825 \uAC12");
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setBounds(20, 864, 71, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(261, 853, 105, 65);
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
				box.setbox(treedata);
				repaint();
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
				if (select == 1) {
					box.setbox(avl.TreeData);
					repaint();
				} else {
					box.setbox(bst.TreeData);
					repaint();
				}
			}
		});
		buttonGroup_1.add(tglbtnAfter);
		tglbtnAfter.setBounds(150, 798, 151, 43);
		contentPane.add(tglbtnAfter);

		JButton btnNewButton_1 = new JButton("\uC2A4\uD06C\uB9B0\uC0F7");
		btnNewButton_1.setBounds(380, 844, 238, 65);
		contentPane.add(btnNewButton_1);

		JButton button = new JButton("\uB3C4\uC6C0\uB9D0");
		button.setBounds(707, 844, 238, 65);
		contentPane.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(1083, 812, 415, 129);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(150, 150);
		scrollPane.setViewportView(textArea);

		JLabel lblHistory = new JLabel(" HISTORY");
		lblHistory.setFont(new Font("굴림", Font.BOLD, 20));
		lblHistory.setBorder(null);
		lblHistory.setBounds(977, 810, 105, 131);
		contentPane.add(lblHistory);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textField.getText();
				if (select == 1) {// avl
					avlReact();
					if (rdbtnNewRadioButton_1.isSelected()) {
						if (avl.treeSearch(temp) == null) {
							avl.insert(temp);
							avl.TreeInput();
							count++;
							box.setbox(avl.TreeData);
							textArea.append("COUNT : " + count + "   |   INSERT" + "   |   " + temp + "\n");
						} else {
							JOptionPane.showMessageDialog(panel, "중복된 데이터가 존재합니다.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						if (avl.treeSearch(temp) != null) {
							avl.delete(temp);
							avl.TreeInput();
							count++;
							box.setbox(avl.TreeData);
							textArea.append("COUNT : " + count + "   |   DELTE" + "   |   " + temp + "\n");
						} else {
							JOptionPane.showMessageDialog(panel, "존재하지 않는 데이터 입니다.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					if (avl.TreeDepth(avl.root) > 4) {
						JOptionPane.showMessageDialog(panel, "트리 깊이(4단계)를 초과하였습니다.", "Error",
								JOptionPane.ERROR_MESSAGE);
						avl.delete(temp);
						avl.TreeInput();
						box.setbox(avl.TreeData);
					}
					repaint();

				} else {// bst
					bstReact();
					if (rdbtnNewRadioButton_1.isSelected()) {
						if (bst.treeSearch(temp) == null) {
							bst.insert(temp);
							bst.TreeInput();
							count++;
							box.setbox(bst.TreeData);
							textArea.append("COUNT : " + count + "   |   INSERT" + "   |   " + temp + "\n");
						} else {
							JOptionPane.showMessageDialog(panel, "중복된 데이터가 존재합니다.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						if (bst.treeSearch(temp) != null) {
							bst.delete(temp);
							bst.TreeInput();
							count++;
							box.setbox(bst.TreeData);
							textArea.append("COUNT : " + count + "   |   DELTE" + "   |   " + temp + "\n");
						} else {
							JOptionPane.showMessageDialog(panel, "존재하지 않는 데이터 입니다.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					if (bst.TreeDepth(bst.root) > 4) {
						JOptionPane.showMessageDialog(panel, "트리 깊이(4단계)를 초과하였습니다.", "Error",
								JOptionPane.ERROR_MESSAGE);
						bst.delete(temp);
						bst.TreeInput();
						box.setbox(bst.TreeData);
					}
					repaint();
				}
			}
		});
	}

	void bstReact() {
		bst.TreeInput();
		treedata = new String[bst.TreeData.length];
		for (int i = 0; i < 15; i++) {
			treedata[i] = bst.TreeData[i];
		}
	}

	void avlReact() {
		avl.TreeInput();
		treedata = new String[avl.TreeData.length];
		for (int i = 0; i < 15; i++) {
			treedata[i] = avl.TreeData[i];
		}
	}
}