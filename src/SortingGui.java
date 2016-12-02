import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class SortingGui extends JFrame {
	FileUI Fui;
	Capture capture;
	public JPanel contentPane;
	private JTextField textField;
	public JPanel beginState;
	public JPanel panel;
	public JButton btnHelp;
	public JButton btnSortingStart;
	public JButton btnInput;
	public JButton btnRandom;
	public JButton btnDelete;
	static Sort sort;
	int inputValue;
	ButtonGroup group;
	private JPanel panel_1; // 라디오버튼 패널
	private JRadioButton rbtn_slow;
	private JRadioButton rbtn_std;
	private JRadioButton rbtn_fast;
	int threadSleepTime = 500;
	private JButton CaptureButton;
	private StringBuffer sb = new StringBuffer();
	private boolean mouseListenerIsActive = true;
	private JTextArea textArea;

	public SortingGui(int sortingWhat) {
		Fui = new FileUI();
		capture = new Capture();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1140, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uCD08\uAE30 \uBC30\uC5F4\r\n");
		lblNewLabel.setBounds(12, 10, 80, 27);
		contentPane.add(lblNewLabel);

		beginState = new JPanel();
		beginState.setBackground(Color.WHITE);
		beginState.setBounds(12, 34, 824, 65);
		contentPane.add(beginState);

		JLabel lblNewLabel_1 = new JLabel("\uC815\uB82C \uC0C1\uD0DC");
		lblNewLabel_1.setBounds(12, 109, 63, 27);
		contentPane.add(lblNewLabel_1);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 134, 824, 211);
		contentPane.add(panel);

		btnHelp = new JButton("\uB3C4 \uC6C0 \uB9D0");
		btnHelp.setFont(new Font("굴림", Font.BOLD, 15));
		btnHelp.setBounds(12, 398, 97, 42);
		contentPane.add(btnHelp);

		btnSortingStart = new JButton("\uC815 \uB82C \uC2DC \uC791");
		btnSortingStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 정렬 시작
				String speed = "";
				btnSortingStart.setEnabled(false);
				btnInput.setEnabled(false);
				btnDelete.setEnabled(false);
				btnRandom.setEnabled(false);
				if (rbtn_std.isSelected() == true) {
					threadSleepTime = 500;
					speed = "Standard";

				} else if (rbtn_slow.isSelected() == true) {

					threadSleepTime = 1000;
					speed = "Slow";

				} else {
					threadSleepTime = 0;
					speed = "Fast";
				}
				sb.append(speed + " Run\n");
				textArea.setText(sb.toString());
				sort.Run(threadSleepTime);
				// 예외처리 필요

			}
		});
		btnSortingStart.setEnabled(false);
		btnSortingStart.setFont(new Font("굴림", Font.BOLD, 15));
		btnSortingStart.setBounds(576, 401, 261, 39);
		contentPane.add(btnSortingStart);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("굴림", Font.BOLD, 18));
		textField.setBounds(119, 400, 116, 40);
		contentPane.add(textField);
		textField.setColumns(10);

		btnInput = new JButton("\uC785 \uB825");
		btnInput.addActionListener(new ActionListener() { // 입력
			public void actionPerformed(ActionEvent arg0) {
				
				try { // 입력값의 정상적인 정수변형 여부 파악
					inputValue = Integer.parseInt(textField.getText());

					sort.input(inputValue);
					sort.DrawPanel(sort.Arr, 50, 100, true);
					sb.append("INPUT\t\t" + Integer.toString(inputValue) + "\n");
					textArea.setText(sb.toString());
					btnDelete.setEnabled(true);
					btnSortingStart.setEnabled(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JPanel(), "INPUT ERROR", "Error", JOptionPane.ERROR_MESSAGE);
					sb.append("ERROR " + e.getMessage() + "\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}
				
			}
		});
		btnInput.setFont(new Font("굴림", Font.BOLD, 15));
		btnInput.setBounds(249, 355, 97, 85);
		contentPane.add(btnInput);

		btnRandom = new JButton("\uB79C \uB364");
		btnRandom.addActionListener(new ActionListener() { // 랜덤
			public void actionPerformed(ActionEvent e) {
				

				try {
					inputValue = Integer.parseInt(textField.getText());
					if (inputValue <= 0 || inputValue > 10) {
						sb.append("Randem Size OVER\t" + Integer.toString(inputValue) + "\n");
						textArea.setText(sb.toString());
					} else {
						sort.Random(inputValue);
						sort.DrawPanel(sort.Arr, 50, 100, true);
						sb.append("Randem Size\t" + Integer.toString(inputValue) + "\n");
						textArea.setText(sb.toString());
					}btnDelete.setEnabled(true);
					btnSortingStart.setEnabled(true);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(new JPanel(), "INPUT ERROR", "Error", JOptionPane.ERROR_MESSAGE);
					sb.append("ERROR " + ee.getMessage() + "\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}

			}
		});
		btnRandom.setFont(new Font("굴림", Font.BOLD, 15));
		btnRandom.setBounds(358, 355, 97, 85);
		contentPane.add(btnRandom);

		btnDelete = new JButton("\uC0AD \uC81C");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 삭제

				try {
					inputValue = Integer.parseInt(textField.getText());
					if (inputValue < 0 || inputValue >= 10) {
						sb.append("DELETE ERROR\t" + Integer.toString(inputValue) + "\n");
						textArea.setText(sb.toString());
					} else {
						sort.delete(inputValue);
						sort.DrawPanel(sort.Arr, 50, 100, true);
						sb.append("DELETE INDEX\t" + Integer.toString(inputValue) + "\n");
						textArea.setText(sb.toString());
					}
					if (sort.list.size() == 0) {
						btnDelete.setEnabled(false);
						btnSortingStart.setEnabled(false);
					}
				} catch (Exception eee) {
					sb.append("ERROR " + eee.getMessage() + "\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}

			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
		btnDelete.setBounds(467, 355, 97, 85);
		contentPane.add(btnDelete);

		panel_1 = new JPanel();
		panel_1.setBounds(576, 355, 262, 36);
		contentPane.add(panel_1);

		rbtn_slow = new JRadioButton("\uCC9C\uCC9C\uD788");
		panel_1.add(rbtn_slow);

		rbtn_std = new JRadioButton("\uD45C \uC900\r\n");
		rbtn_std.setSelected(true);
		panel_1.add(rbtn_std);

		rbtn_fast = new JRadioButton("\uBE60\uB974\uAC8C");
		panel_1.add(rbtn_fast);

		group = new ButtonGroup();
		group.add(rbtn_slow);
		group.add(rbtn_std);
		group.add(rbtn_fast);

		CaptureButton = new JButton("\uC774 \uBBF8 \uC9C0 \uC800 \uC7A5");
		CaptureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mouseClicked();
			}
		});
		CaptureButton.setFont(new Font("굴림", Font.BOLD, 15));
		CaptureButton.setBounds(12, 355, 223, 36);
		contentPane.add(CaptureButton);

		JLabel lblNewLabel_2 = new JLabel("\uC2E4\uD589 \uC774\uB825");
		lblNewLabel_2.setBounds(848, 16, 57, 15);
		contentPane.add(lblNewLabel_2);

		textArea = new JTextArea();
		textArea.setBounds(848, 34, 264, 406);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(848, 34, 264, 406);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);

		CreateSort(sortingWhat);
	}

	void CreateSort(int what) {
		switch (what) {
		case 1:
			sort = new BubbleSort(contentPane, beginState, panel, btnSortingStart, btnInput, btnDelete, btnRandom);
			break;
		case 2:
			sort = new InsertSort(contentPane, beginState, panel, btnSortingStart, btnInput, btnDelete, btnRandom);
			break;
		case 3:
			sort = new SelectedSort(contentPane, beginState, panel, btnSortingStart, btnInput, btnDelete, btnRandom);
			break;
		case 4:
			sort = new QuickSort(contentPane, beginState, panel, btnSortingStart, btnInput, btnDelete, btnRandom);
			break;
		}
	}

	public void mouseClicked() {
		mouseListenerIsActive = true;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (mouseListenerIsActive) {
					Fui.FileOpen();
					capture.captureScreenPart(Fui.getFilePath(), getX(), getY(), e.getX(), e.getY());
					stopMouseListner();
				}
			}
		});
	}

	public void stopMouseListner() {
		mouseListenerIsActive = false;
	}
}
