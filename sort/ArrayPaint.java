package sw_group3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArrayPaint extends JPanel {
	int x;
	int y;
	int Arr[];

	
	ArrayPaint(int arr[], int x, int y) {
		Arr = arr;
		this.x = x;
		this.y = y;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		for (int i = 0; i < Arr.length; i++) {
			g.drawRect(x + 70 * i, y, 70, 30);
			g.drawString(Integer.toString(Arr[i]), x + 70 * i + 15, y + 20);
		}
		this.setVisible(true);
	}
}
