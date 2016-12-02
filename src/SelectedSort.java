
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectedSort extends Sort {
	SelectedSort(JPanel contentPane, JPanel beginState, JPanel panel, JButton btnsortingStart, JButton btnInput,
			JButton btnDelete, JButton btnRandom) {
		super(contentPane, beginState, panel, btnsortingStart, btnInput, btnDelete, btnRandom);
	}

	void Run(int threadSleepTime) {
		Thread thread = new Thread() {

			public void run() {
				replaceArr();
				try {
					int N = list.size();

					DrawPanel(Arr, 50, 100, false);
					this.sleep((long) threadSleepTime);

					for (int i = 0; i < N - 1; i++) {
						int min = i;
						for (int j = i + 1; j < N; j++) {
							sDrawPanel(Arr, 50, 100, i, min, j, false);
							this.sleep((long) threadSleepTime);
							if (Arr[j] < Arr[min]) {
								sDrawPanel(Arr, 50, 100, i, min, j, false);
								this.sleep((long) threadSleepTime);
								min = j;
								sDrawPanel(Arr, 50, 100, i, min, j, false);
								this.sleep((long) threadSleepTime);
							}
							sDrawPanel(Arr, 50, 100, i, min, j, false);
							this.sleep((long) threadSleepTime);
						}
						DrawPanel(Arr, 50, 100, i, "i", min, "min", true,2);
						this.sleep((long) threadSleepTime);
						exch(Arr, i, min);
						DrawPanel(Arr, 50, 100, i, "i", min, "min", false,2);
						this.sleep((long) threadSleepTime);
					}
					this.sleep(100);
					DrawPanel(Arr, 50, 100, false);
					replaceList();

				} catch (Exception e) {
				}
				btnEnable();
			}
		};
		thread.start();
	}

	void sDrawPanel(int[] arr, int x, int y, int i, int min, int j, boolean bool) {
		panel = new ThreeColorSortingPaint(arr, x, y, i, "i", min, "min", j, "j", bool);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 134, 824, 211);
		contentPane.add(panel);
		panel.updateUI();
	}
}
