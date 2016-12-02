


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class drawStack extends JPanel {
	
	private int level = 0;
	private String[] node;
	void setBox(int num, String node[]) {		
		level = num;
		this.node=node;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		int xx = 52;
		int y = 600;
		int height = 50;
		for (int i = 0; i < level; i++) {
			g.setColor(Color.PINK);
			g.drawRect(100, y - (xx * i), 280, height);
			g.setColor(Color.BLUE);
			g.drawString(Integer.toString(i), 70, y+33- (xx * i));
			g.drawString((node[i]), 220 , y+33- (xx * i));
		}
	}
}