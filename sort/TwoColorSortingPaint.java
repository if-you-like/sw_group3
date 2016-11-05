package sw_group3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TwoColorSortingPaint extends JPanel {
	int x;
	int y;
	int p, q;
	int size;
	boolean check;
	String pstr, qstr;
	int Arr[];
	
	int stringhigh=180;
	
	TwoColorSortingPaint(int arr[], int x, int y, int p, String pstr, int q, String qstr, boolean b) {
		super();
		Arr = arr;
		this.x = x;
		this.y = y;
		this.p = p;
		this.pstr = pstr;
		this.q = q;
		this.qstr = qstr;
		check = b;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < Arr.length; i++) {
			g.setColor(Color.BLACK);
			if (p == i && p == q) {
				g.setColor(new Color(255,128,64));
				g.fillRect(x + 70 * i, y, 71, 31);
				g.setColor(Color.BLACK);
				g.drawString(pstr + "=" + qstr, x + 70 * i + 35, stringhigh);
			} else if (p == i) {
				g.setColor(new Color(255,100,100));
				g.fillRect(x + 70 * i, y, 71, 31);
				g.setColor(Color.black);
				g.drawString(pstr, x + 70 * i + 35, stringhigh);
			} else if (q == i) {
				g.setColor(new Color(100,100,255));
				g.fillRect(x + 70 * i, y, 71, 31);
				g.setColor(Color.BLACK);
				g.drawString(qstr, x + 70 * i + 35, stringhigh);
			} else {
				g.drawRect(x + 70 * i, y, 70, 30);
			}
			g.setColor(Color.black);
			g.drawString(Integer.toString(Arr[i]), x + 70 * i + 15, y + 20);
		}
		if (check == true) {
			g.setColor(Color.black);
			g.drawString("Swap", x + 70 * p + 60, stringhigh);
		}

		this.setVisible(true);

	}
}
