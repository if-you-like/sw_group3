
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class drawQueue extends JPanel {

	private int level = 0;
	private String[] node;
	private boolean state;

	void setBox(int num, String node[], boolean state) {
		level = num;
		this.node = node;
		this.state = state;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		int xx = 52;
		int y = 600;
		int height = 50;
		if (level != 0) {
			if (state == true) {
				g.drawRect(770, 50, 75, 75);
				g.drawString("INSERT", 770, 40);
				g.drawString(node[level - 1], 800 - node[level - 1].length(), 90);
			} else {
				g.drawRect(20, 50, 75, 75);
				g.drawString("DELETE", 20, 40);
			}
		}

		for (int i = 0; i < 11; i++) {
			// g.setColor(Color.PINK);
			g.drawRect(20 + (75 * i), 200, 75, 75);

			// g.setColor(Color.BLUE);
			// g.drawString(Integer.toString(i), 70, y+33- (xx * i));
			// g.drawString((node[i]), 220 , y+33- (xx * i));
		}
		for (int i = 0; i < level; i++) {
			g.drawString(node[i], (50 + 75 * i) - node[i].length(), 240);
		}
	}
}