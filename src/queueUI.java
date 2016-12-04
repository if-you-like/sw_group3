import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class queueUI extends SelectUI {
	FileUI Fui;
	Capture capture;
	private JPanel contentPane;
	private drawQueue box = new drawQueue();
	private JTextField textField;
	private queue qu;

	private int count = 0;
	private JLabel lblNewLabel_1;
	JButton CaptureButton;

	public queueUI() {
		Fui = new FileUI();
		capture = new Capture();

		qu = new queue();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 0, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		box.setBounds(0, 0, 884, 355);
		box.setBackground(Color.WHITE);

		getContentPane().add(box);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(14, 434, 196, 72);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Input Data");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 12, 116, 18);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(42, 38, 116, 24);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(235, 367, 270, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(908, 49, 249, 492);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(150, 150);
		scrollPane.setViewportView(textArea);

		JButton btnNewButton = new JButton("PUSH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textField.getText();

				if (temp.equals("")) {
					JOptionPane.showMessageDialog(panel, "입력이 비었습니다.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!qu.isFull()) {
					count++;
					qu.insert(temp);
					box.setBox(qu.data, true, temp, qu.head, qu.tail);
					textArea.append("COUNT : " + count + "   |   PUSH" + "   |   " + temp + "\n");
					repaint();
				} else {
					JOptionPane.showMessageDialog(panel, "queue is full", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(14, 12, 242, 72);
		panel_1.add(btnNewButton);

		JButton btnPop = new JButton("POP");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (qu.isEmpty()) {
					JOptionPane.showMessageDialog(panel, "큐가 비었습니다.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String temp = qu.delete();
				count++;
				box.setBox(qu.data, false, temp, qu.head, qu.tail);
				textArea.append("COUNT : " + count + "   |   POP" + "   |   " + temp + "\n");
				repaint();
			}
		});
		btnPop.setBounds(14, 90, 242, 72);
		panel_1.add(btnPop);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(614, 367, 270, 174);
		contentPane.add(panel_2);

		CaptureButton = new JButton("스크린샷");
		CaptureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				qui.mouseClicked();
			}
		});
		CaptureButton.setBounds(14, 12, 242, 72);
		panel_2.add(CaptureButton);

		JButton button_3 = new JButton("도움말");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(14, 96, 242, 72);
		panel_2.add(button_3);

		lblNewLabel_1 = new JLabel("\uC2E4\uD589\uC774\uB825");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setBounds(908, 12, 92, 25);
		contentPane.add(lblNewLabel_1);

	}

	public void mouseClicked() {
		qui.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Fui.FileOpen();
				capture.captureScreenPart(Fui.getFilePath(), qui.getX(), qui.getY(), e.getX(), e.getY());
			}
		});
	}
}
