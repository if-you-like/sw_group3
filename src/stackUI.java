
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class stackUI extends SelectUI {
	FileUI Fui;
	Capture capture;
	private JPanel contentPane;
	private JTextField textField;
	private drawStack box = new drawStack();
	private int level = 0;
	private int count = 0;
	private int max=12;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField_4;

	private stack st;
	
	public stackUI() {
		Fui = new FileUI();
		capture = new Capture();

		st = new stack(max);


		setTitle("STACK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 736, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(11, 662, 449, 10);
		panel.setBackground(Color.RED);
		contentPane.add(panel);

		textField = new JTextField();
		textField.setBounds(474, 111, 84, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(474, 45, 84, 30);
		textField_1.setBackground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		box.setBounds(10, 12, 450, 660);
		box.setBackground(Color.WHITE);

		getContentPane().add(box);

		textField_2 = new JTextField("\uC785\uB825 \uAC12");
		textField_2.setBorder(null);
		textField_2.setBounds(474, 87, 71, 24);
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setCaretColor(Color.LIGHT_GRAY);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(473, 177, 218, 319);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(150, 150);
		scrollPane.setViewportView(textArea);

		btnNewButton_2 = new JButton("POP");
		btnNewButton_2.setBounds(586, 113, 105, 41);
		contentPane.add(btnNewButton_2);

		JTextField textField_3 = new JTextField("TOP");
		textField_3.setBackground(UIManager.getColor("Button.background"));
		textField_3.setBorder(null);
		textField_3.setBounds(474, 22, 42, 24);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField("HISTORY");
		textField_4.setBorder(null);
		textField_4.setSelectionColor(UIManager.getColor("Button.background"));
		textField_4.setCaretColor(UIManager.getColor("Button.background"));
		textField_4.setBackground(UIManager.getColor("Button.background"));
		textField_4.setBounds(474, 153, 71, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton CaptureButton = new JButton("\uC2A4\uD06C\uB9B0\uC0F7");
		CaptureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sui.mouseClicked();
			}
		});
		CaptureButton.setBounds(474, 523, 218, 57);
		contentPane.add(CaptureButton);

		JButton button = new JButton("\uB3C4\uC6C0\uB9D0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1 = new JButton("PUSH");
		btnNewButton_1.setBounds(586, 47, 105, 41);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {

				if (level > max-1) {
					JOptionPane.showMessageDialog(panel, "stack 높이 초과", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String temp = textField.getText();				
				if(temp.equals("")){
					JOptionPane.showMessageDialog(panel, "입력이 비었습니다.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}


				st.push(temp, level);
				level++;
				count++;
				box.setBox(level, st.node);
				textArea.append("COUNT : " + count + "   |   PUSH" + "   |   " + temp + "\n");
				re();
			}
		});
		button.setBounds(474, 592, 218, 57);
		contentPane.add(button);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level == 0) {
					JOptionPane.showMessageDialog(panel, "stact이 비어 삭제가 불가능", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				level--;
				count++;
				textArea.append("COUNT : " + count + "   |   POP   " + "   |   " + st.node[level] + "\n");
				st.pop(level);
				box.setBox(level, st.node);
				re();
			}
		});

	}

	public void re() {
		repaint();
		String t = String.valueOf(level - 1);
		textField_1.setText(t);
	}
	
	public void mouseClicked() {
		sui.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Fui.FileOpen();
				capture.captureScreenPart(Fui.getFilePath(), sui.getX(), sui.getY(), e.getX(), e.getY());
			}
		});
	}
}
