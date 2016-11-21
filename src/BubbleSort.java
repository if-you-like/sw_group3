

import javax.swing.JButton;
import javax.swing.JPanel;

public class BubbleSort extends Sort {
	BubbleSort(JPanel contentPane, JPanel beginState, JPanel panel, JButton btnsortingStart, JButton btnInput,
			JButton btnDelete, JButton btnRandom) {
		super(contentPane, beginState, panel, btnsortingStart, btnInput, btnDelete, btnRandom);
	}

	void Run(int threadSleepTime) {
		Thread thread = new Thread() {
			public void run() {
				replaceArr();
				try {
					int N = list.size();

					DrawPanel(Arr, 50, 100, true);

					this.sleep((long) threadSleepTime);

					for (int i = 0; i < N - 1; i++) {
						for (int j = 0; j < N - 1 - i; j++) {
							DrawPanel(Arr, 50, 100, j, "j", j + 1, "j+1", false,1);
							this.sleep((long) threadSleepTime);
							if (Arr[j] > Arr[j + 1]) {
								DrawPanel(Arr, 50, 100, j, "j", j + 1, "j+1", true,1);
								this.sleep((long) threadSleepTime);
								DrawPanel(Arr, 50, 100, false);
								this.sleep((long) threadSleepTime);
								DrawPanel(Arr, 50, 100, j, "j", j + 1, "j+1", false,1);
								this.sleep((long) threadSleepTime);
								DrawPanel(Arr, 50, 100, false);
								exch(Arr, j, j + 1);
								DrawPanel(Arr, 50, 100, j, "j", j + 1, "j+1", false,1);
								this.sleep((long) threadSleepTime);
							}
						}
					}
					this.sleep(100);
					DrawPanel(Arr, 50, 100, false);
					replaceList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnEnable();
			}
		};
		thread.start();
	}

}
