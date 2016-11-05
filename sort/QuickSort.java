package sw_group3;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class QuickSort extends Sort {

	QuickSort(JPanel contentPane, JPanel beginState, JPanel panel, JButton btnsortingStart, JButton btnInput,
			JButton btnDelete, JButton btnRandom) {
		super(contentPane, beginState, panel, btnsortingStart, btnInput, btnDelete, btnRandom);
	}

	void Run(int threadSleepTime) {

		Thread thread = new Thread() {
			public void run() {
				try {
					DrawPanel(Arr, 50, 100, true);
					this.sleep((long) threadSleepTime);
					sort(Arr, 0, Arr.length - 1, threadSleepTime);
					this.sleep(100);
					DrawPanel(Arr, 50, 100, false);
				} catch (Exception e) {
				}
				btnEnable();
			}
		};
		thread.start();
	}

	int partition(int arr[], int low, int high, int threadSleepTime) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element

		Thread thread = new Thread();

		for (int j = low; j <= high - 1; j++) {
			// If current element is smaller than or
			// equal to pivot
			qDrawPanel(arr, 50, 100, i, high, j, false);
			try {
				thread.sleep((long) threadSleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (arr[j] <= pivot) {
				qDrawPanel(arr, 50, 100, i, high, j, false);
				try {
					thread.sleep((long) threadSleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				qDrawPanel(arr, 50, 100, i, high, j, true);
				try {
					thread.sleep((long) threadSleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// swap arr[i] and arr[j]
				exch(arr, i, j);
				qDrawPanel(arr, 50, 100, i, high, j, false);
				try {
					thread.sleep((long) threadSleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		DrawPanel(arr, 50, 100, i + 1, "i+1", high, "pivot", true);
		try {
			thread.sleep((long) threadSleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exch(arr, i + 1, high);
		DrawPanel(arr, 50, 100, i + 1, "i+1", high, "pivot", false);
		try {
			thread.sleep((long) threadSleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	void sort(int arr[], int low, int high, int threadSleepTime) {
		DrawPanel(Arr, 50, 100, false);
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high, threadSleepTime);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1, threadSleepTime);
			sort(arr, pi + 1, high, threadSleepTime);
		}
		DrawPanel(Arr, 50, 100, false);
		replaceList();
	}

	void qDrawPanel(int[] arr, int x, int y, int i, int min, int j, boolean bool) {
		panel = new ThreeColorSortingPaint(arr, x, y, i, "i", min, "pivot", j, "j", bool);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 134, 824, 211);
		contentPane.add(panel);
		panel.updateUI();
	}
}
