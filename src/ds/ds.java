
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;

public class ds extends JFrame {

	private JPanel contentPane;
	static ds dsui;
	static stackUI sui;
	static treeUI tui;
	static listUI lui;
	static Gui gui;
	// private ButtonGroup buttonGroup = new ButtonGroup();

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		dsui = new ds();

	}

	public ds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(26, 47, 242, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("STACK");
		rdbtnNewRadioButton_1.setBounds(51, 7, 73, 27);
		
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					sui = new stackUI();
					sui.setVisible(true);
				}
				else{
					sui.setVisible(false);
				}
			}
		});

		JRadioButton rdbtnNewRadioButton = new JRadioButton("TREE");
		rdbtnNewRadioButton.setBounds(51, 38, 139, 27);
		//buttonGroup.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					tui = new treeUI();
					tui.setVisible(true);
				}
				else{
					tui.setVisible(false);
				}
			}
		});

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("LIST");
		rdbtnNewRadioButton_2.setBounds(51, 99, 139, 27);
		//buttonGroup.add(rdbtnNewRadioButton_2);
		panel.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_2.isSelected()) {
					lui=new listUI();
					lui.setVisible(true);
				}
				else{
					lui.setVisible(false);
				}
			}
		});

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("SORTING");
		rdbtnNewRadioButton_3.setBounds(51, 68, 139, 27);
		//buttonGroup.add(rdbtnNewRadioButton_3);
		panel.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_3.isSelected()) {					
					gui.frame = new Gui();
					gui.frame.setVisible(true);
				}
				else{
					gui.frame.setVisible(false);
					
				}
			}
		});
		setVisible(true);
	}
}
