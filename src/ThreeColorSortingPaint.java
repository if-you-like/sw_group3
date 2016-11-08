import java.awt.Color;
import java.awt.Graphics;

public class ThreeColorSortingPaint extends ArrayPaint {

	int stringhigh = 180;
	int ci, cmin, cj;
	boolean bool;
	String istr,minstr,jstr;
	ThreeColorSortingPaint(int arr[], int x, int y, int i,String istr, int min, String minstr, int j, String jstr, boolean b) {
		super(arr, x, y);
		ci = i;
		cmin = min;
		cj = j;
		bool = b;
		this.istr=istr;
		this.minstr=minstr;
		this.jstr=jstr;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < Arr.length; i++) {
			g.setColor(Color.BLACK);
			if (ci == cmin && i == ci) {
				g.setColor(new Color(255,128,64));
				g.fillRect(x + 70 * i, y, 70, 31);
				g.drawString(istr+" = "+minstr, x + 70 * i + 35, stringhigh);
			} else if (cj == cmin && cj == i) {
				g.setColor(new Color(255,128,64));
				g.fillRect(x + 70 * i, y, 70, 31);
				g.drawString(jstr+" = "+minstr, x + 70 * i + 35, stringhigh);
			} else if (i == ci) {
				g.setColor(new Color(255,100,100));
				g.fillRect(x + 70 * i, y, 70, 31);
				g.drawString(istr, x + 70 * i + 35, stringhigh);
			} else if (i == cmin) {
				g.setColor(new Color(255,128,64));
				g.fillRect(x + 70 * i, y, 70, 31);
				g.drawString(minstr, x + 70 * i + 35, stringhigh);
			} else if (i == cj) {
				g.setColor(new Color(100,100,255));
				g.fillRect(x + 70 * i, y, 70, 31);
				g.drawString(jstr, x + 70 * i + 35, stringhigh);
			} else {
				g.drawRect(x + 70 * i, y, 70, 30);
			}
			g.setColor(Color.black);
			g.drawString(Integer.toString(Arr[i]), x + 70 * i + 15, y + 20);
		}

		if (bool == true) {
			g.setColor(Color.black);
			g.drawString("Swap", x + 70 * ci + 60, stringhigh);
		}

		this.setVisible(true);

	}
}
