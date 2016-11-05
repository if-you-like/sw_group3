package sw_group3;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InsertSort extends Sort {
	InsertSort(JPanel contentPane, JPanel beginState, JPanel panel, JButton btnsortingStart, JButton btnInput,
			JButton btnDelete, JButton btnRandom) {
		super(contentPane, beginState, panel, btnsortingStart, btnInput, btnDelete, btnRandom);
	}

	void Run(int threadSleepTime) {
		Thread thread = new Thread() {
			public void run() {
				replaceArr();
				int swapCheck = 0;
				try {
					int N = list.size();
					DrawPanel(Arr, 50, 100, true);
					this.sleep((long) threadSleepTime);
					for (int i = 1; i < N; i++) {
						swapCheck = 0;
						for (int j = i; j > 0 && Arr[j] < Arr[j - 1]; j--) {
							swapCheck = j;
							DrawPanel(Arr, 50, 100, j - 1, "j-1", j, "j", false);
							this.sleep((long) threadSleepTime);
							DrawPanel(Arr, 50, 100, false);
							this.sleep((long) threadSleepTime);
							DrawPanel(Arr, 50, 100, j - 1, "j-1", j, "j", true);
							this.sleep((long) threadSleepTime);
							exch(Arr, j, j - 1);
							DrawPanel(Arr, 50, 100, j - 1, "j-1", j, "j", false);
							this.sleep((long) threadSleepTime);
						}
						if (!(swapCheck - 2 < 0)) {
							DrawPanel(Arr, 50, 100, swapCheck - 2, "j-2       <", swapCheck - 1, "j-1", false);
							this.sleep((long) threadSleepTime);
						}
						this.sleep((long) threadSleepTime);
						DrawPanel(Arr, 50, 100, i - 1, "i - 1       <", i, "i", false);
						this.sleep((long) threadSleepTime * 2);

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

}
