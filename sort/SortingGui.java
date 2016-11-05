package sw_group3;

import java.awt.EventQueue;

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
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class SortingGui extends JFrame {

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
	private JPanel panel_1; // ������ư �г�
	private JRadioButton rbtn_slow;
	private JRadioButton rbtn_std;
	private JRadioButton rbtn_fast;
	int threadSleepTime = 500;
	private JButton btnImage;
	private StringBuffer sb = new StringBuffer();
	private String sumText = "";
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingGui frame = new SortingGui(4);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortingGui(int sortingWhat) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnHelp.setFont(new Font("����", Font.BOLD, 15));
		btnHelp.setBounds(12, 398, 97, 42);
		contentPane.add(btnHelp);

		btnSortingStart = new JButton("\uC815 \uB82C \uC2DC \uC791");
		btnSortingStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ���� ����

				btnSortingStart.setEnabled(false);
				btnInput.setEnabled(false);
				btnDelete.setEnabled(false);
				btnRandom.setEnabled(false);
				if (rbtn_std.isSelected() == true) {

					threadSleepTime = 500;

				} else if (rbtn_slow.isSelected() == true) {

					threadSleepTime = 1000;

				} else {
					threadSleepTime = 0;

				}
				sort.Run(threadSleepTime);
				// ����ó�� �ʿ�

			}
		});
		btnSortingStart.setEnabled(false);
		btnSortingStart.setFont(new Font("����", Font.BOLD, 15));
		btnSortingStart.setBounds(576, 401, 261, 39);
		contentPane.add(btnSortingStart);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("����", Font.BOLD, 18));
		textField.setBounds(119, 400, 116, 40);
		contentPane.add(textField);
		textField.setColumns(10);

		btnInput = new JButton("\uC785 \uB825");
		btnInput.addActionListener(new ActionListener() { // �Է�
			public void actionPerformed(ActionEvent arg0) {
				btnDelete.setEnabled(true);
				btnSortingStart.setEnabled(true);
				try { // �Է°��� �������� �������� ���� �ľ�
					inputValue = Integer.parseInt(textField.getText());
					
					sort.input(inputValue);
					sort.DrawPanel(sort.Arr, 50, 100, true);
					sb.append("INPUT\t\t"+Integer.toString(inputValue)+"\n");
					textArea.setText(sb.toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JPanel(), "INPUT ERROR", "Error", JOptionPane.ERROR_MESSAGE);
					sb.append("ERROR "+e.getMessage()+"\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}
			
			}
		});
		btnInput.setFont(new Font("����", Font.BOLD, 15));
		btnInput.setBounds(249, 355, 97, 85);
		contentPane.add(btnInput);

		btnRandom = new JButton("\uB79C \uB364");
		btnRandom.addActionListener(new ActionListener() { // ����
			public void actionPerformed(ActionEvent e) {
				btnDelete.setEnabled(true);
				btnSortingStart.setEnabled(true);

				try {
					inputValue = Integer.parseInt(textField.getText());
					
					sort.Random(inputValue);
					sort.DrawPanel(sort.Arr, 50, 100, true);
					sb.append("Randem Size\t"+Integer.toString(inputValue)+"\n");
					textArea.setText(sb.toString());
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(new JPanel(), "INPUT ERROR", "Error", JOptionPane.ERROR_MESSAGE);
					sb.append("ERROR "+ee.getMessage()+"\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}
				
			}
		});
		btnRandom.setFont(new Font("����", Font.BOLD, 15));
		btnRandom.setBounds(358, 355, 97, 85);
		contentPane.add(btnRandom);

		btnDelete = new JButton("\uC0AD \uC81C");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ����

				try {
					inputValue = Integer.parseInt(textField.getText());
					
					sort.delete(inputValue);
					sort.DrawPanel(sort.Arr, 50, 100, true);
					sb.append("DELETE INDEX\t"+Integer.toString(inputValue)+"\n");
					textArea.setText(sb.toString());
					if (sort.list.size() == 0) {
						btnDelete.setEnabled(false);
						btnSortingStart.setEnabled(false);
					}
				} catch (Exception eee) {
					JOptionPane.showMessageDialog(new JPanel(), "INPUT ERROR", "Error", JOptionPane.ERROR_MESSAGE);
					sb.append("ERROR "+eee.getMessage()+"\n");
					textArea.setText(sb.toString());
					return;
				} finally {
					textField.setText("");
				}
				
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("����", Font.BOLD, 15));
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

		btnImage = new JButton("\uC774 \uBBF8 \uC9C0 \uC800 \uC7A5");
		btnImage.setFont(new Font("����", Font.BOLD, 15));
		btnImage.setBounds(12, 355, 223, 36);
		contentPane.add(btnImage);

		JLabel lblNewLabel_2 = new JLabel("\uC2E4\uD589 \uC774\uB825");
		lblNewLabel_2.setBounds(848, 16, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		textArea = new JTextArea();
		textArea.setBounds(848, 34, 264, 406);	

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
}
