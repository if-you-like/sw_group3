import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import javax.swing.JPanel;

class drawTree extends JPanel {

	private int w = 100;
	private int h = 100;
	private int[] x = new int[15];
	private int[] y = new int[15];
	int level = 0;
	String[] TreeDate;
	private int holic[] = new int[15];

	public drawTree() {
		 holic[7] = 0;
		 holic[3] = 1;
		 holic[11] = 2;
		 holic[1] = 3;
		 holic[5] = 4;
		 holic[9] = 5;
		 holic[13] = 6;
		 holic[0] = 7;
		 holic[2] = 8;
		 holic[4] = 9;
		 holic[6] = 10;
		 holic[8] = 11;
		 holic[10] = 12;
		 holic[12] = 13;
		 holic[14] = 14;
	}

	void setbox(String[] date, int level) {
		this.level = level;
		this.TreeDate = date;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		x[0] = 700;
		y[0] = 50;
		x[1] = 350;
		x[2] = 1150;
		y[1] = 250;
		y[2] = 250;
		x[3] = 150;
		x[4] = 550;
		x[5] = 950;
		x[6] = 1350;
		y[3] = 450;
		y[4] = 450;
		y[5] = 450;
		y[6] = 450;
		for (int i = 7; i < 15; i++) {
			x[i] = 50 + (200 * (i - 7));
			y[i] = 650;
		}
		int[][] xarr = { {}, { 750, 400 }, { 750, 1200 }, { 400, 200 }, { 400, 600 }, { 1200, 1000 }, { 1200, 1400 },
				{ 200, 100 }, { 200, 300 }, { 600, 500 }, { 600, 700 }, { 1000, 900 }, { 1000, 1100 }, { 1400, 1300 },
				{ 1400, 1500 } };
		int[][] yarr = { {}, { 150, 250 }, { 150, 250 }, { 350, 450 }, { 350, 450 }, { 350, 450 }, { 350, 450 },
				{ 550, 650 }, { 550, 650 }, { 550, 650 }, { 550, 650 }, { 550, 650 }, { 550, 650 }, { 550, 650 },
				{ 550, 650 } };

		for (int i = 0; i < level; i++) {
			for (int j = 0; j < TreeDate.length; j++) {
				if (TreeDate[j] != null) {
					int temp = holic[j];
					if (temp != 0) {
						if (temp % 2 == 1) {
							g.drawPolyline(xarr[temp], yarr[temp], 2);
						} else {
							g.drawPolyline(xarr[temp], yarr[temp], 2);
						}
					}
					g.drawOval(x[temp], y[temp], w, h);
					g.drawString(TreeDate[j], x[temp]+50-4*(TreeDate[j].length()), y[temp]+50);
				}
			}
		}
	}
}