import java.awt.Color;
import java.awt.Font;
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
	Color one, two;
	int stringhigh = 180;
	int c;

	TwoColorSortingPaint(int arr[], int x, int y, int p, String pstr, int q, String qstr, boolean b, int c) {
		super();
		Arr = arr;
		this.x = x;
		this.y = y;
		this.p = p;
		this.pstr = pstr;
		this.q = q;
		this.qstr = qstr;
		check = b;
		SelctColor(c);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < Arr.length; i++) {
			g.setColor(Color.BLACK);
			if (p == i && p == q) {
				g.setColor(new Color(255, 128, 64));
				g.fillRect(x + 70 * i, y, 71, 31);
				g.setColor(Color.BLACK);
				g.drawString(pstr + "=" + qstr, x + 70 * i + 35, stringhigh);
			} else if (p == i) {
				g.setColor(one);
				g.fillRect(x + 70 * i, y, 71, 31);
				g.setColor(Color.black);
				g.drawString(pstr, x + 70 * i + 35, stringhigh);
			} else if (q == i) {
				g.setColor(two);
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
			g.setFont(new Font("±¼¸²", Font.BOLD, 30));
			g.drawString("Swap", 350, 30);
			g.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		}

		this.setVisible(true);
	}

	void SelctColor(int c) {
		switch (c) {
		case 1: // »¡°­,ÆÄ¶û
			one = new Color(255, 100, 100);
			two = new Color(100, 100, 255);
			break;
		case 2: // »¡°­, ÁÖÈ²
			one = new Color(255, 100, 100);
			two = new Color(255, 128, 64);
			break;
		case 3: // ÆÄ¶û, ÁÖÈ²
			one = new Color(100, 100, 255);
			two = new Color(255, 128, 64);
			break;
		default:
			System.out.println("Error");
		}
	}

}
