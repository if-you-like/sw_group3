

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class drawQueue extends JPanel {

	private String[] node;
	private boolean state;
	private boolean onoff=false;

	private int level=0;
	private String temp;
	private int head;
	private int tail;	

	void setBox(String node[], boolean state, String temp, int head, int tail) {
		this.node = node;
		this.state = state;
		this.temp = temp;
		this.onoff=true;
		if (this.state) {
			level++;
		} else if (!this.state) {
			level--;
		}
		this.head=head;
		this.tail=tail;
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		if (this.onoff) {
			if (this.state) {
				g.drawRect(770, 50, 75, 75);
				g.drawString("INSERT", 770, 40);
				g.drawString(temp, 810 - 4 * temp.length(), 90);
			} else if (!this.state) {
				g.drawRect(20, 50, 75, 75);
				g.drawString("DELETE", 20, 40);
				g.drawString(temp, 60 - 4 * temp.length(), 90);
			}
			for (int i = 0; i < 11; i++) {
				if (node[i] != null) {
					g.drawString(node[i], (60 + 75 * (i)) - 4 * node[i].length(), 240);					
				}
			}
			int x=300;
			g.drawString("HEAD", (40 + 75 * (head-1)), x);
			if(head==tail+1){
				x+=50;
			}
			g.drawString("TAIL", (40 + 75 * (tail)), x);
		}
		for (int i = 0; i < 11; i++) {
			g.drawRect(20 + (75 * i), 200, 75, 75);
		}
	}
}