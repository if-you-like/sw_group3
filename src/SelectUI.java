import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class SelectUI extends JFrame {

	private JPanel contentPane;
	static SelectUI dsui;
	static stackUI sui;
	static queueUI qui;
	static treeUI tui;
	static listUI lui;
	static SortingGui sorUI;

	Scanner sc = new Scanner(System.in);
	private JLabel lblNewLabel;
	private JPanel panel;

	public static void main(String[] args) {
		dsui = new SelectUI();

	}

	public SelectUI() {
		setForeground(Color.BLACK);
		setTitle("Select Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 320, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(24, 2, 254, 146);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("STACK");
		btnNewButton.setBounds(31, 29, 100, 27);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sui = new stackUI();
				sui.setVisible(true);
			}
		});
		JButton btnQueue = new JButton("QUEUE");
		btnQueue.setBounds(140, 29, 100, 27);
		panel.add(btnQueue);
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qui = new queueUI();
				qui.setVisible(true);
			}
		});

		JButton btnLinkedlist = new JButton("LinkedList");
		btnLinkedlist.setBounds(80, 68, 100, 27);
		panel.add(btnLinkedlist);
		btnLinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lui = new listUI();
				lui.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("B.S.T");
		btnNewButton_1.setBounds(31, 107, 100, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tui = new treeUI();
				tui.setVisible(true);
			}
		});

		JButton btnAvl = new JButton("A.V.L");
		btnAvl.setBounds(140, 107, 100, 27);
		panel.add(btnAvl);

		lblNewLabel = new JLabel("  DataStruckture");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lblNewLabel.setBounds(0, 0, 147, 27);
		panel.add(lblNewLabel);
		btnAvl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(24, 154, 254, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSorting = new JLabel("  Sorting");
		lblSorting.setBounds(0, -1, 89, 27);
		panel_1.add(lblSorting);
		lblSorting.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSorting.setBackground(Color.WHITE);
		lblSorting.setFont(new Font("±¼¸²", Font.PLAIN, 20));

		JButton btnNewButton_2 = new JButton("Bubble");
		btnNewButton_2.setBounds(26, 29, 100, 27);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorUI = new SortingGui(1);
				sorUI.setVisible(true);
			}
		});

		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(129, 29, 100, 27);
		panel_1.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorUI = new SortingGui(3);
				sorUI.setVisible(true);
			}
		});

		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(129, 68, 100, 27);
		panel_1.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorUI = new SortingGui(2);
				sorUI.setVisible(true);
			}
		});

		JButton btnQuick = new JButton("Quick");
		btnQuick.setBounds(26, 68, 100, 27);
		panel_1.add(btnQuick);
		setVisible(true);
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorUI = new SortingGui(4);
				sorUI.setVisible(true);
			}
		});
	}
}
