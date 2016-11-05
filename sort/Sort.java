package sw_group3;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Sort {
	static ArrayList list;
	static int Arr[];
	int Maxsize = 10;

	public JPanel beginState;
	public JPanel panel;
	public JButton btnSortingStart;
	public JButton btnInput;
	public JButton btnRandom;
	public JButton btnDelete;
	public JPanel contentPane;

	Sort(JPanel contentPane, JPanel beginState, JPanel panel, JButton btnsortingStart, JButton btnInput,
			JButton btnDelete, JButton btnRandom) {
		list = new ArrayList();
		this.contentPane = contentPane;
		this.beginState = beginState;
		this.panel = panel;
		this.btnSortingStart = btnsortingStart;
		this.btnInput = btnInput;
		this.btnDelete = btnDelete;
		this.btnRandom = btnRandom;
	}

	protected static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	void input(int data) {
		if (list.size() < Maxsize) {
			list.add(data);
			
		} else {
			JOptionPane.showMessageDialog(new JPanel(), "ARRAY IS FULL", "Error", JOptionPane.ERROR_MESSAGE);
		}replaceArr();
	}

	void delete(int k) {

		if (k < 0 || k >= Maxsize) {
			JOptionPane.showMessageDialog(new JPanel(), "OUT OF INDEX", "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			list.remove(k);
			replaceArr();
		}
	}

	void print() {
		System.out.println(list);
	}

	void Random(int k) {
		if (k <= 0 || k > Maxsize) {
			JOptionPane.showMessageDialog(new JPanel(), "OUT OF INDEX", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			list.clear();
			for (int i = 0; i < k; i++)
				list.add((int) (Math.random() * 100 + 1));
			replaceArr();
		}
	}

	void replaceArr() {
		Arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Arr[i] = (int) list.get(i);
		}
	}

	void replaceList() {
		int size = list.size();
		list = new ArrayList();
		for (int i = 0; i < size; i++) {
			list.add(Arr[i]);
		}
	}

	void Run(int threadSleepTime) {

	}

	void btnEnable() {
		btnDelete.setEnabled(true);
		btnInput.setEnabled(true);
		btnRandom.setEnabled(true);
		btnSortingStart.setEnabled(true);
	}

	void DrawPanel(int[] arr, int x, int y, Boolean bool) {

		panel = new ArrayPaint(arr, x, y);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 134, 824, 211);
		contentPane.add(panel);
		panel.updateUI();

		if (bool == true) {
			beginState = new ArrayPaint(arr, 50, 20);
			beginState.setBackground(Color.WHITE);
			beginState.setBounds(12, 34, 824, 65);
			contentPane.add(beginState);
			beginState.updateUI();
		}
	}

	void DrawPanel(int[] arr, int x, int y, int p, String pstr, int q, String qstr, boolean bool) {
		panel = new TwoColorSortingPaint(arr, x, y, p, pstr, q, qstr, bool);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 134, 824, 211);
		contentPane.add(panel);
		panel.updateUI();
	}
}
